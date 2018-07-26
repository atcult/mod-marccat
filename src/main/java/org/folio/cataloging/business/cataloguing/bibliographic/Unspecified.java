package org.folio.cataloging.business.cataloguing.bibliographic;

import org.folio.cataloging.business.common.DataAccessException;
import org.folio.cataloging.dao.DAOSystemNextNumber;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author paulm
 * @since 1.0
 */
public class Unspecified extends PhysicalDescription {

	public Unspecified() {
		super();
		setHeaderType((short) 45);
		setGeneralMaterialDesignationCode('z');
		setSpecificMaterialDesignationCode('u');
	}

	/* (non-Javadoc)
	 * @see FixedField#getDisplayString()
	 */
	public String getDisplayString() {
		String result =
			""
				+ getGeneralMaterialDesignationCode()
				+ getSpecificMaterialDesignationCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see librisuite.business.cataloguing.bibliographic.Tag#generateNewKey()
	 */
	public void generateNewKey() throws DataAccessException {
		DAOSystemNextNumber dao = new DAOSystemNextNumber();
		setKeyNumber(dao.getNextNumber("XD"));
	}

	/* (non-Javadoc)
	 * @see librisuite.business.cataloguing.bibliographic.PhysicalDescription#isUnspecified()
	 */
	public boolean isUnspecified() {
		return true;
	}

	public Element generateModelXmlElementContent(Document xmlDocument) {
		Element content = null;
		if (xmlDocument != null) {
			content = xmlDocument.createElement("content");
			content.setAttribute("generalMaterialDesignationCode", "" + getGeneralMaterialDesignationCode());
			content.setAttribute("specificMaterialDesignationCode", "" + getSpecificMaterialDesignationCode());
		}
		return content;
	}

	public void parseModelXmlElementContent(Element xmlElement) {
		Element content = (Element) xmlElement.getChildNodes().item(0);
		setGeneralMaterialDesignationCode(content.getAttribute("generalMaterialDesignationCode").charAt(0));
		setSpecificMaterialDesignationCode(content.getAttribute("specificMaterialDesignationCode").charAt(0));
	}

}
