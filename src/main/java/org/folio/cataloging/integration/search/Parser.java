package org.folio.cataloging.integration.search;

import net.sf.hibernate.Session;
import org.folio.cataloging.business.common.DataAccessException;
import org.folio.cataloging.dao.DAOIndexList;
import org.folio.cataloging.dao.persistence.IndexList;
import org.folio.cataloging.log.Log;
import org.folio.cataloging.log.MessageCatalog;
import org.folio.cataloging.business.common.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Query Parser.
 *
 * @author paulm
 * @author agazzarini
 * @author carment
 * @since 1.0
 */
public class Parser {
  private static final Log logger = new Log(Parser.class);
  private static IndexList defaultIndex;
  private final Locale locale;
  private final int mainLibraryId;
  private final int searchingView;
  private final Session session;
  private final DAOIndexList dao = new DAOIndexList();
  private LinkedList <Token> tokens;
  private Token lookahead;

  /**
   * Builds a new parser with the given data.
   *
   * @param locale        the current locale.
   * @param mainLibraryId the main library identifier.
   * @param searchingView the current search view.
   */
  public Parser(final Locale locale, final int mainLibraryId, final int searchingView, final Session session) {
    this.locale = locale;
    this.mainLibraryId = mainLibraryId;
    this.searchingView = searchingView;
    this.session = session;
  }

  /**
   * Parses the incoming CCL query, sort and page the results
   *
   * @param ccl the CCL query.
   * @param firstRecord the first record.
   * @param lastRecord the last record.
   * @param attributes the attributes of the search index.
   * @param directions the directions asc or desc.
   * @return the parsed string.
   * @throws CclParserException in case of parsing failure.
   */
  public String parse(final String ccl, final int firstRecord, final int lastRecord, final String[] attributes,  String[] directions) throws CclParserException {
    final Tokenizer tokenizer = new Tokenizer().tokenize(ccl);
    final ExpressionNode n = parse(tokenizer.getTokens());
    final int limitSize = (lastRecord - firstRecord) + 1;
    final int offsetSize = firstRecord - 1;
    final String orderByClause = buildOrderByClause(attributes, directions);
    final String columnSortForm = getSortFormByAtributes(attributes);
    final String columnItemNumber = searchingView == -1 ? "aut_nbr" : "bib_itm_nbr";
    final String query = "select res."+ columnItemNumber +
                         " from (select distinct "+ columnSortForm +" smtc."+ columnItemNumber +" from ((" + n.getValue() + ")) smtc " +
                         orderByClause +  ") res"+
                         " limit "+ limitSize +" offset "+ offsetSize;
    logger.debug(
      MessageCatalog._00020_SE_QUERY,
      ccl, query);

    return query;
  }

  /**
   * Parses the a list of tokens.
   *
   * @param tokens the tokens list.
   * @return the expression node..
   * @throws CclParserException in case of parsing failure.
   */
  public ExpressionNode parse(final List <Token> tokens) throws CclParserException {
    this.tokens = new LinkedList <>(tokens);
    this.lookahead = this.tokens.getFirst();
    return searchGroup();
  }

  /**
   * Advance to the next token.
   */
  private void nextToken() {
    tokens.poll();
    lookahead =
      tokens.isEmpty()
        ? new Token(Tokenizer.TokenType.EOL, "")
        : tokens.getFirst();
  }

  private ExpressionNode searchGroup() throws CclParserException {
    // ( <searchGroup> )
    if (lookahead.token == Tokenizer.TokenType.LP) {
      nextToken();

      final ExpressionNode expr = searchGroup();
      if (lookahead.token != Tokenizer.TokenType.RP) {
        throw new CclParserException("Mismatched parentheses");
      }

      return expr;
    } else {
      // <searchExpression> <BOOL> <searchGroup>
      final ExpressionNode expr = searchExpression();
      if (lookahead.token == Tokenizer.TokenType.BOOL) {
        final BooleanExpressionNode op = new BooleanExpressionNode();
        op.setLeft(expr);
        op.setOp(lookahead.sequence);

        nextToken();

        op.setRight(searchGroup());

        return op;
      } else {
        return expr;
      }
    }
  }

  private ExpressionNode searchExpression() throws CclParserException {
    final TermExpressionNode expr = new TermExpressionNode(session, locale, mainLibraryId, searchingView);
    if (lookahead.token == Tokenizer.TokenType.WORD) {
      if (lookahead.sequence.length() <= 3) {
        IndexList i;
        try {
          i = dao.getIndexByLocalAbbreviation(session, lookahead.sequence, locale);
        } catch (DataAccessException e) {
          throw new RuntimeException(e);
        }
        if (i != null) {
          expr.setIndex(i);
          lookahead.token = Tokenizer.TokenType.INDEX;
        } else {
          expr.setIndex(getDefaultIndex());
          return term(expr);
        }
      } else {
        expr.setIndex(getDefaultIndex());
        return term(expr);
      }
    }
    if (lookahead.token == Tokenizer.TokenType.INDEX) {
      // <INDEX> [<REL>] <term>
      nextToken();
      if (lookahead.token == Tokenizer.TokenType.REL) {
        expr.setRelation(lookahead.sequence);
        nextToken();
      }
      return term(expr);
    } else {
      // <term>
      return term(expr);
    }
  }

  private IndexList getDefaultIndex() {
    if (defaultIndex == null) {
      try {
        defaultIndex = dao.getIndexByLocalAbbreviation(session, "AW", Locale.ENGLISH);
      } catch (DataAccessException e) {
        throw new RuntimeException(e);
      }
    }
    return defaultIndex;
  }

  private ExpressionNode term(TermExpressionNode expr) throws CclParserException {
    if (lookahead.token == Tokenizer.TokenType.WORD) {
      // <WORD> <wordlist>
      expr.appendToTerm(lookahead.sequence + " ");
      nextToken();
      return wordlist(expr);
    } else {
      return quotedString(expr);
    }
  }

  private ExpressionNode wordlist(TermExpressionNode expr) throws CclParserException {
    if (lookahead.token == Tokenizer.TokenType.PROX) {
      expr.setProximityOperator(lookahead.sequence);
      nextToken();
      if (lookahead.token != Tokenizer.TokenType.WORD) {
        throw new CclParserException("proximity operator has invalid arguments");
      } else {
        expr.setRight(lookahead.sequence);
        nextToken();
        return expr;
      }
    }
    if (lookahead.token == Tokenizer.TokenType.WORD) {
      expr.appendToTerm(lookahead.sequence + " ");
      nextToken();
      return wordlist(expr);
    } else {
      // EOL
      return expr;
    }
  }

  private ExpressionNode quotedString(TermExpressionNode expr) {
    if (lookahead.token == Tokenizer.TokenType.QUOTEDSTRING) {
      String noQuotes = lookahead.sequence.replace("\"", "");
      expr.appendToTerm(noQuotes);
      nextToken();
      return quotedString(expr);
    } else {
      // EOL
      return expr;
    }
  }

  /**
   * Builds the ordering clause through the attributes and the directions.
   *
   * @param attributes the attributes of the search index.
   * @param directions the directions asc or desc.
   * @return the ordering clause
   */
  private String buildOrderByClause(
    final String[] attributes,
    final String[] directions) {
    final String columnItemNumber = (searchingView == -1) ? "aut_nbr " : "bib_itm_nbr ";
    final String sort = (directions != null && directions[0].equals("0")) ? "asc" : "desc";
    final String columnSortForm = getSortFormByAtributes(attributes);
    String orderByItemNumber =  String.format(" order by smtc."+ columnItemNumber +" %s ", sort);
    String orderBySortForm = String.format(" order by "+columnSortForm.replace(",","")+" %s, smtc."+ columnItemNumber, sort);
    String orderByClause = orderByItemNumber;
    for (String attribute : attributes) {
      switch (Integer.parseInt(attribute)) {
        case 4:
          orderByClause = (searchingView == -1) ? SQLCommand.TITLE_AUT_JOIN : SQLCommand.TITLE_JOIN;
          orderByClause += viewClause() + orderBySortForm;
          break;
        case 1003:
          orderByClause = (searchingView == -1) ? SQLCommand.NME_AUT_JOIN : SQLCommand.NAME_JOIN;
          orderByClause += viewClause() + orderBySortForm;
          break;
        case 2096:
          orderByClause = SQLCommand.UNIFORM_TITLE_JOIN + viewClause() + orderBySortForm;
          break;
        case 54:
          orderByClause = orderByItemNumber;
          break;
        case 21:
          orderByClause = SQLCommand.SUBJECT_AUT_JOIN + viewClause() + orderBySortForm;
          break;
        }

    }
    return orderByClause;
  }

  /**
   * Return the column of the sort form for the ordering clause.
   *
   * @param attributes the attributes of the search index.
   * @return the column of the sort form
   */
  private String getSortFormByAtributes( final String[] attributes) {
    String sortForm = "";
    for (final String attribute : attributes) {
      switch (Integer.parseInt(attribute)) {
        case 4:
        case 2096:
          sortForm = "t2.ttl_hdg_srt_form,";
          break;
        case 1003:
          sortForm = "t2.nme_hdg_srt_form,";
          break;
        case 21:
          sortForm = "t2.sbjct_hdg_srt_form,";
          break;
      }
    }
    return sortForm;
  }

  /**
   * Return the view clause.
   *
   * @return the view clause
   */
  private String viewClause() {
    return (searchingView != 0 && searchingView !=-1) ? String.format(" AND (t1.usr_vw_ind = '%s')",View.makeSingleViewString(this.searchingView)) : "";
  }

}
