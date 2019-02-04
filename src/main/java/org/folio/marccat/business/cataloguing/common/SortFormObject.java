package org.folio.marccat.business.cataloguing.common;

import org.folio.marccat.business.common.SortFormException;

public interface SortFormObject {
  void calculateAndSetSortForm() throws SortFormException;
}
