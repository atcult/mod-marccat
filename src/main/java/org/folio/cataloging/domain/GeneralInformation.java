package org.folio.cataloging.domain;

/**
 * Class related to 008 - Fixed-Length Data Elements
 * Contains only methods of logic to create tag 008
 * default value.
 */

import org.apache.commons.lang.StringUtils;
import org.folio.cataloging.Global;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;

public class GeneralInformation
{

	private short headerType;
	private String enteredOnFileDateYYMMDD;
	private String itemDateTypeCode;
	private String itemDateFirstPublication;
	private String itemDateLastPublication;
	private String recordModifiedCode;
	private String recordCataloguingSourceCode;
	private String materialTypeCode;
	private String materialDescription008Indicator;
	private String bookIllustrationCode;
	private String targetAudienceCode;
	private String formOfItemCode;
	private String natureOfContentsCode;
	private String governmentPublicationCode;
	private String conferencePublicationCode;
	private String bookFestschrift;
	private String bookIndexAvailabilityCode;
	private String bookLiteraryFormTypeCode;

	private String bookBiographyCode;
	private String bookMainEntryCode;
	private String cartographicReliefCode;
	private String cartographicProjectionCode;
	private String cartographicMeridianCode;
	private String cartographicNarrativeTextCode;
	private String cartographicIndexAvailabilityCode;
	private String cartographicFormatCode;
	private String computerTargetAudienceCode;
	private String computerFileTypeCode;
	private String computerFileFormCode;

	private String visualRunningTime;
	private String visualTargetAudienceCode;
	private String visualAccompanyingMaterialCode;
	private String visualMaterialTypeCode;
	private String visualTechniqueCode ;
	private String serialFrequencyCode;
	private String serialRegularityCode;
	private String serialISDSCenterCode;
	private String serialTypeCode;
	private String serialFormOriginalItemCode;
	private String serialCumulativeIndexCode;
	private String serialOriginalAlphabetOfTitleCode;
	private String serialSuccessiveLatestCode;
	private String serialTitlePageExistenceCode;
	private String serialIndexAvailabilityCode;
	private String musicFormOfCompositionCode;
	private String musicFormatCode;
	private String musicTextualMaterialCode;
	private String musicLiteraryTextCode;
	
	private String musicPartsCode;
	private String musicTranspositionArrangementCode;

	private String cartographicMaterial;
	private String visualOriginalHolding;
	private String formOfMaterial;
	
	private String marcCountryCode;
	private String languageCode;

	public String getMusicPartsCode() {
		return musicPartsCode;
	}

	public void setMusicPartsCode(final String musicPartsCode) {
		this.musicPartsCode = musicPartsCode;
	}

	public String getMusicTranspositionArrangementCode() {
		return musicTranspositionArrangementCode;
	}

	public void setMusicTranspositionArrangementCode(final String musicTranspositionArrangementCode) {
		this.musicTranspositionArrangementCode = musicTranspositionArrangementCode;
	}

	public String getComputerFileFormCode() {
		return computerFileFormCode;
	}

	public void setComputerFileFormCode(final String computerFileFormCode) {
		this.computerFileFormCode = computerFileFormCode;
	}

	public String getMarcCountryCode() {
		return marcCountryCode;
	}

	public void setMarcCountryCode(final String marcCountryCode) { this.marcCountryCode = marcCountryCode; }

	public String getItemDateTypeCode() {
		return itemDateTypeCode;
	}

	public void setItemDateTypeCode(final String itemDateTypeCode) {
		this.itemDateTypeCode = itemDateTypeCode;
	}
	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(final String languageCode) {
		this.languageCode = languageCode;
	}

	public GeneralInformation() {
	}

	/*
	 * Squeeze all non-blank Strings to the left side of the string and
	 * retain the original length by padding with blanks on the right
	 */
	private String leftJustify(final String s) {
		return ofNullable(stream(s.split("")).filter(Stringacter -> !" ".equals(Stringacter)).collect(joining()))
				.map(result -> {
					return StringUtils.leftPad(result, s.length()-result.length(), ' ');
				}).orElse(null);
	}

	/**
	 * Sets default value for "book" type
	 * @param configuration the map that contains configuration values to set.
	 *
	 */
	public void setDefaultValuesForBook(final Map<String, String> configuration){

		setDefaultValues(configuration);

		setBookIllustrationCode(configuration.get("material.bookIllustrationCode"));
		setTargetAudienceCode(configuration.get("material.targetAudienceCode"));
		setFormOfItemCode(configuration.get("material.formOfItemCode"));
		setNatureOfContentsCode(configuration.get("material.natureOfContentsCode"));
		setGovernmentPublicationCode(configuration.get("material.governmentPublicationCode"));
		setConferencePublicationCode(configuration.get("material.conferencePublicationCode"));
		setBookFestschrift(configuration.get("material.bookFestschrift"));
		setBookIndexAvailabilityCode(configuration.get("material.bookIndexAvailabilityCode"));
		setBookLiteraryFormTypeCode(configuration.get("material.bookLiteraryFormTypeCode"));
		setBookBiographyCode(configuration.get("material.bookBiographyCode"));
	}

	/**
	 * Sets the form-specific values to their default
	 * 
	 * @since 1.0
	 */
	public void setDefaultValues(final Map<String, String> configuration) {
        setRecordModifiedCode(" ");
        setRecordCataloguingSourceCode(configuration.get("bibliographicItem.recordCataloguingSourceCode"));
        setItemDateTypeCode(configuration.get("bibliographicItem.itemDateTypeCode"));
        setLanguageCode(configuration.get("bibliographicItem.languageCode"));
        setItemDateFirstPublication(Global.itemDateFirstPublication);
        setItemDateLastPublication(Global.itemDateLastPublication);
        setMarcCountryCode(configuration.get("bibliographicItem.marcCountryCode"));
    }

    public void setDefaultValuesForCartographic(final Map<String, String> configuration) {
        setDefaultValues(configuration);
        setCartographicReliefCode(configuration.get("material.cartographicReliefCode"));
        setCartographicProjectionCode(configuration.get("material.cartographicProjectionCode"));
        setCartographicMaterial(configuration.get("material.cartographicMaterial"));
        setCartographicFormatCode(configuration.get("material.cartographicFormatCode"));
    }

    public void setDefaultValuesForComputerFile(final Map<String, String> configuration) {
        setDefaultValues(configuration);
        setComputerTargetAudienceCode(configuration.get("material.targetAudienceCode"));
        setComputerFileTypeCode(configuration.get("material.computerFileTypeCode"));
        setComputerFileFormCode(configuration.get("material.computerFileFormCode"));
    }

    public void setDefaultValuesForVisualMaterial(final Map<String, String> configuration) {
        setDefaultValues(configuration);

        setVisualRunningTime(configuration.get("material.visualRunningTime"));
        setVisualTargetAudienceCode(configuration.get("material.targetAudienceCode"));
        setVisualMaterialTypeCode(configuration.get("material.visualMaterialTypeCode"));
        setVisualTechniqueCode(configuration.get("material.visualTechniqueCode"));
    }

    public void setDefaultValuesForSerial(final Map<String, String> configuration) {
        setDefaultValues(configuration);

        setSerialFrequencyCode(configuration.get("material.serialFrequencyCode"));
        setSerialRegularityCode(configuration.get("material.serialRegularityCode"));
        setSerialTypeCode(configuration.get("material.serialTypeCode"));
        setSerialFormOriginalItemCode(configuration.get("material.formOfItemCode"));
        setSerialOriginalAlphabetOfTitleCode(configuration.get("material.serialOriginalAlphabetOfTitleCode"));
        setSerialSuccessiveLatestCode(configuration.get("material.serialSuccessiveLatestCode"));
    }

    public void setDefaultValuesForMusic(final Map<String, String> configuration) {
        setDefaultValues(configuration);

        setMusicFormOfCompositionCode(configuration.get("material.musicFormOfCompositionCode"));
		setMusicFormatCode(configuration.get("material.musicFormatCode"));
		setMusicTextualMaterialCode(configuration.get("material.musicTextualMaterialCode"));
		setMusicLiteraryTextCode(configuration.get("material.musicLiteraryTextCode"));
		setMusicPartsCode(configuration.get("material.musicPartsCode"));
		setMusicTranspositionArrangementCode(configuration.get("material.musicTranspositionArrangementCode"));
	}

	public String getValueString()
	{
		final StringBuilder sb = new StringBuilder();
		if (getMaterialDescription008Indicator().equals("1")) {
			sb.append(getEnteredOnFileDateYYMMDD())
				.append(getItemDateTypeCode())
				.append(getItemDateFirstPublication())
				.append(getItemDateLastPublication())
				.append(getMarcCountryCode());
		} else {
			sb.append(getMaterialTypeCode());
		}

		if (isBook()) {
			sb.append(bookDisplayString());
		} else if (isComputerFile()) {
			sb.append(computerFileDisplayString());
		} else if (isMap()) {
			sb.append(mapDisplayString());
		} else if (isMixedMaterial()) {
			sb.append(mixedMaterialDisplayString());
		} else if (isMusic()) {
			sb.append(musicDisplayString());
		} else if (isSerial()) {
			sb.append(serialDisplayString());
		} else if (isVisualMaterial()) {
			sb.append(visualMaterialDisplayString());
		}

		if (getMaterialDescription008Indicator().equals("1")) {
			sb.append( getLanguageCode())
				.append(getRecordModifiedCode())
					.append(getRecordCataloguingSourceCode());
		}

		return sb.toString();
	}


	public boolean isBook() {
		return getFormOfMaterial().equals("bk");
	}
	public boolean isMap() {
		return getFormOfMaterial().equals("cm");
	}
	public boolean isComputerFile() {
		return getFormOfMaterial().equals("cf");
	}
	public boolean isMixedMaterial() {
		return getFormOfMaterial().equals("mm");
	}
	public boolean isMusic() {
		return getFormOfMaterial().equals("msr");
	}
	public boolean isSerial() {
		return getFormOfMaterial().equals("se");
	}
	public boolean isVisualMaterial() {
		return getFormOfMaterial().equals("vm");
	}

	/**
	 * return the displayString segment for book material
	 * @author paulm
	 * @since 1.0
	 */
	public String bookDisplayString() 
	{
		return getBookIllustrationCode()
			+ getTargetAudienceCode()
			+ getFormOfItemCode()
			+ getNatureOfContentsCode()
			+ getGovernmentPublicationCode()
			+ getConferencePublicationCode()
			+ getBookFestschrift()
			+ getBookIndexAvailabilityCode()
			+ " " //undefined position (formerly main entry indicator)
			+ getBookLiteraryFormTypeCode() + getBookBiographyCode();
		}

	/**
	 * return the displayString segment for map material
	 * @author paulm
	 * @since 1.0
	 */
	public String mapDisplayString() {
		return getCartographicReliefCode()
			+ getCartographicProjectionCode()
			+ " " //undefined
		+ getCartographicMaterial() + "  " // two undefined
		+ getGovernmentPublicationCode() + getFormOfItemCode() + " "
		// undefined
		+ getCartographicIndexAvailabilityCode() + " " //undefined position
		+ getCartographicFormatCode();
	}

	/**
	 * return the displayString segment for computer file material
	 * @author paulm
	 * @since 1.0
	 */
	public String computerFileDisplayString() 
	{
		StringBuilder builder = new StringBuilder(); 
		builder.append("    ")								/*18-21 - Undefined             */
			   .append(getComputerTargetAudienceCode())		/*22    - Target audience       */
			   .append(getComputerFileFormCode())			/*23    - Form of item          */
			   .append("  ")								/*24-25 - Undefined             */ 
			   .append(getComputerFileTypeCode())			/*26    - Type of computer file */ 
			   .append(" ")									/*27    - Undefined             */
			   .append(getGovernmentPublicationCode())		/*28    - Government publication*/ 
			   .append("      ");							/*29-34 - Undefined             */
		
		return builder.toString();
	}

	/**
	 * return the displayString segment for mixed material material
	 * @author paulm
	 * @since 1.0
	 */
	public String mixedMaterialDisplayString() 
	{
		// five undefined + 11 undefined positions
		return "     " + getFormOfItemCode() + "           ";
	}

	/**
	 * return the displayString segment for music material
	 * @author paulm
	 * @since 1.0
	 */
	public String musicDisplayString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append(getMusicFormOfCompositionCode()) 		/* 18-19 - Form of composition */
				.append(getMusicFormatCode())					/* 20 - Format of music */
				.append(getMusicPartsCode())					/* 21 - Music parts  */
				.append(getTargetAudienceCode())				/* 22 - Target audience */
				.append(getFormOfItemCode())					/* 23 - Form of item */
				.append(getMusicTextualMaterialCode())			/* 24-29 - Accompanying matter */
				.append(getMusicLiteraryTextCode())				/* 30-31 - Literary text for sound recordings */
				.append(" ")									/* 32 - Undefined */
				.append(getMusicTranspositionArrangementCode())	/* 33 - Transposition and arrangement */
				.append(" ");									/* 34 - Undefined  */
		
		return builder.toString();
	}

	/**
	 * return the displayString segment for visual material
	 * @author paulm
	 * @since 1.0
	 */
	public String visualMaterialDisplayString() {
		return getVisualRunningTime() + " " // undefined position
		+getVisualTargetAudienceCode() + "     " // five undefined
		+getGovernmentPublicationCode() + getFormOfItemCode() + "   "
		// three undefined
		+getVisualMaterialTypeCode() + getVisualTechniqueCode();
	}

	/**
	 * return the displayString segment for serial (continuing resources) material
	 * @author paulm
	 * @since 1.0
	 */
	public String serialDisplayString() 
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("")
			   .append(getSerialFrequencyCode())				/* 18 - Frequency */
			   .append(getSerialRegularityCode())				/* 19 - Regularity */
			   .append(" ")										/* 20 - Undefined */
			   .append(getSerialTypeCode())						/* 21 - Type of continuing resource */
			   .append(getSerialFormOriginalItemCode())			/* 22 - Form of original item */
			   .append(getFormOfItemCode())						/* 23 - Form of item */
			   .append(getNatureOfContentsCode())				/* 24 - Nature of entire work 25-27 - Nature of contents */
			   .append(getGovernmentPublicationCode())			/* 28 - Government publication */
			   .append(getConferencePublicationCode())			/* 29 - Conference publication */
			   .append("   ")									/* 30-32 - Undefined  */
			   .append(getSerialOriginalAlphabetOfTitleCode())  /* 33 - Original alphabet or script of title */
			   .append(getSerialSuccessiveLatestCode());		/* 34 - Entry convention */
		
		return builder.toString();
	}

	/** * GETTERS AND SETTERS * **/

	public String getBookBiographyCode() {
		return bookBiographyCode;
	}
	public String getBookFestschrift() {
		return bookFestschrift;
	}

	public String getBookIllustrationCode() {
		return bookIllustrationCode;
	}

	public String getBookIndexAvailabilityCode() {
		return bookIndexAvailabilityCode;
	}

	public String getBookLiteraryFormTypeCode() {
		return bookLiteraryFormTypeCode;
	}

	public String getBookMainEntryCode() {
		return bookMainEntryCode;
	}

	public String getCartographicFormatCode() {
		return cartographicFormatCode;
	}

	public String getCartographicIndexAvailabilityCode() {
		return cartographicIndexAvailabilityCode;
	}

	public String getCartographicMaterial() {
		return cartographicMaterial;
	}

	public String getCartographicMeridianCode() {
		return cartographicMeridianCode;
	}

	public String getCartographicNarrativeTextCode() {
		return cartographicNarrativeTextCode;
	}

	public String getCartographicProjectionCode() {
		return cartographicProjectionCode;
	}

	public String getCartographicReliefCode() {
		return cartographicReliefCode;
	}

	public String getComputerFileTypeCode() {
		return computerFileTypeCode;
	}

	public String getComputerTargetAudienceCode() {
		return computerTargetAudienceCode;
	}

	public String getConferencePublicationCode() {
		return conferencePublicationCode;
	}

	public String getFormOfItemCode() {
		return formOfItemCode;
	}

	public String getGovernmentPublicationCode() {
		return governmentPublicationCode;
	}

	public String getMaterialDescription008Indicator() {
		return materialDescription008Indicator;
	}

	public String getRecordCataloguingSourceCode() {
		return recordCataloguingSourceCode;
	}

	public void setRecordCataloguingSourceCode(String recordCataloguingSourceCode) {
		this.recordCataloguingSourceCode = recordCataloguingSourceCode;
	}

	public String getMaterialTypeCode() {
		return materialTypeCode;
	}

	public String getMusicFormatCode() {
		return musicFormatCode;
	}

	public String getMusicFormOfCompositionCode() {
		return musicFormOfCompositionCode;
	}

	public String getMusicLiteraryTextCode() {
		return musicLiteraryTextCode;
	}

	public String getMusicTextualMaterialCode() {
		return musicTextualMaterialCode;
	}

	public String getNatureOfContentsCode() {
		return natureOfContentsCode;
	}

	public String getSerialCumulativeIndexCode() {
		return serialCumulativeIndexCode;
	}

	public String getSerialFormOriginalItemCode() {
		return serialFormOriginalItemCode;
	}

	public String getSerialFrequencyCode() {
		return serialFrequencyCode;
	}

	public String getSerialIndexAvailabilityCode() {
		return serialIndexAvailabilityCode;
	}

	public String getSerialISDSCenterCode() {
		return serialISDSCenterCode;
	}

	public String getSerialRegularityCode() {
		return serialRegularityCode;
	}

	public String getSerialSuccessiveLatestCode() {
		return serialSuccessiveLatestCode;
	}

	public String getSerialOriginalAlphabetOfTitleCode() {
		return serialOriginalAlphabetOfTitleCode;
	}

	public String getSerialTitlePageExistenceCode() {
		return serialTitlePageExistenceCode;
	}

	public String getSerialTypeCode() {
		return serialTypeCode;
	}

	public String getTargetAudienceCode() {
		return targetAudienceCode;
	}

	public String getVisualAccompanyingMaterialCode() {
		return visualAccompanyingMaterialCode;
	}

	public String getVisualMaterialTypeCode() {
		return visualMaterialTypeCode;
	}

	public String getVisualOriginalHolding() {
		return visualOriginalHolding;
	}

	public String getVisualRunningTime() {
		return visualRunningTime;
	}

	public String getVisualTargetAudienceCode() {
		return visualTargetAudienceCode;
	}

	public String getVisualTechniqueCode() {
		return visualTechniqueCode;
	}

	public void setBookIllustrationCode(String string) {
		bookIllustrationCode = leftJustify(string);
	}

	public void setCartographicFormatCode(String s) {
		cartographicFormatCode = s;
	}

	public void setCartographicMaterial(String c) {
		cartographicMaterial = c;
	}

	public void setCartographicMeridianCode(String string) {
		cartographicMeridianCode = string;
	}

	public void setCartographicProjectionCode(String string) {
		cartographicProjectionCode = string;
	}

	public void setCartographicReliefCode(String s) {
		cartographicReliefCode = s;
	}

	public void setMaterialDescription008Indicator(String c) {
		materialDescription008Indicator = c;
	}

	public void setMusicFormOfCompositionCode(String string) {
		musicFormOfCompositionCode = string;
	}

	public void setMusicLiteraryTextCode(String string) {
		musicLiteraryTextCode = string;
	}

	public void setMusicTextualMaterialCode(String string) {
		musicTextualMaterialCode = string;
	}

	public void setNatureOfContentsCode(String string) {
		natureOfContentsCode = leftJustify(string);
	}

	public void setVisualAccompanyingMaterialCode(String string) {
		visualAccompanyingMaterialCode = string;
	}

	public void setVisualRunningTime(String string) {
		visualRunningTime = string;
	}



	/**
	 * 
	 * @since 1.0
	 */
	public String getFormOfMaterial() {
		return formOfMaterial;
	}

	/**
	 * 
	 * @since 1.0
	 */
	public void setFormOfMaterial(String string) {
		formOfMaterial = string;
	}

	/* (non-Javadoc)
	 * @see FixedField#setBibItm(BIB_ITM)
	 */

	//TODO: maybe the method needs in recordTemplate
	/*public void setItemEntity(ItemEntity item) {

		 * we override this item to establish the new values for bibHeader 
		 * whenever the bibItm data changes (including new instances)
		 * bib_header is an artificial (non-persistent) stringValue for material description
		 * that must be derived from other mtrl_dsc and bib_itm data (as coded below).

		super.setItemEntity(item);
		if (getMaterialDescription008Indicator() == '1') {
			DAORecordTypeMaterial dao = new DAORecordTypeMaterial();
			RecordTypeMaterial rtm;
			rtm =
				dao.get008HeaderCode(
					getItemRecordTypeCode(),
					getItemBibliographicLevelCode());
			if(rtm!=null){
			setHeaderType(rtm.getBibHeader008());
			setFormOfMaterial(rtm.getAmicusMaterialTypeCode());
			}
		} else {

			 * although the 006 values are not affected by bib_item values, we
			 * need to establish the correct bib_header stringValue for loaded items

			DAORecordTypeMaterial dao = new DAORecordTypeMaterial();
			RecordTypeMaterial rtm;
			rtm = dao.get006HeaderCode(getMaterialTypeCode());
			if(rtm!=null){
			setHeaderType(rtm.getBibHeader006());
			}

		}
	}*/


	public short getHeaderType() {
		return headerType;
	}

	public void setHeaderType(short s) {
		this.headerType = s;
	}

	public String getEnteredOnFileDateYYMMDD() {
		return enteredOnFileDateYYMMDD;
	}

	public void setEnteredOnFileDateYYMMDD(String enteredOnFileDateYYMMDD) {
		this.enteredOnFileDateYYMMDD = enteredOnFileDateYYMMDD;
	}

	public String getItemDateFirstPublication() {return itemDateFirstPublication;}
	public String getItemDateLastPublication() {
		return itemDateLastPublication;
	}

	public void setItemDateFirstPublication(String dateFirstPublication)
	{
		itemDateFirstPublication = dateFirstPublication;
	}

	public String getRecordModifiedCode() {
		return recordModifiedCode;
	}

	public void setRecordModifiedCode(String recordModifiedCode) {
		this.recordModifiedCode = recordModifiedCode;
	}

	public void setItemDateLastPublication(String dateLastPublication)
	{
		itemDateLastPublication = dateLastPublication;
	}

	public void setMaterialTypeCode(String materialTypeCode) {
		this.materialTypeCode = materialTypeCode;
	}

	public void setTargetAudienceCode(String targetAudienceCode) {
		this.targetAudienceCode = targetAudienceCode;
	}

	public void setFormOfItemCode(String formOfItemCode) {
		this.formOfItemCode = formOfItemCode;
	}

	public void setGovernmentPublicationCode(String governmentPublicationCode) {
		this.governmentPublicationCode = governmentPublicationCode;
	}

	public void setConferencePublicationCode(String conferencePublicationCode) {
		this.conferencePublicationCode = conferencePublicationCode;
	}

	public void setBookFestschrift(String bookFestschrift) {
		this.bookFestschrift = bookFestschrift;
	}

	public void setBookIndexAvailabilityCode(String bookIndexAvailabilityCode) {
		this.bookIndexAvailabilityCode = bookIndexAvailabilityCode;
	}

	public void setBookLiteraryFormTypeCode(String bookLiteraryFormTypeCode) {
		this.bookLiteraryFormTypeCode = bookLiteraryFormTypeCode;
	}

	public void setBookBiographyCode(String bookBiographyCode) {
		this.bookBiographyCode = bookBiographyCode;
	}

	public void setBookMainEntryCode(String bookMainEntryCode) {
		this.bookMainEntryCode = bookMainEntryCode;
	}

	public void setCartographicNarrativeTextCode(String cartographicNarrativeTextCode) {
		this.cartographicNarrativeTextCode = cartographicNarrativeTextCode;
	}

	public void setCartographicIndexAvailabilityCode(String cartographicIndexAvailabilityCode) {
		this.cartographicIndexAvailabilityCode = cartographicIndexAvailabilityCode;
	}

	public void setComputerTargetAudienceCode(String computerTargetAudienceCode) {
		this.computerTargetAudienceCode = computerTargetAudienceCode;
	}

	public void setComputerFileTypeCode(String computerFileTypeCode) {
		this.computerFileTypeCode = computerFileTypeCode;
	}

	public void setVisualTargetAudienceCode(String visualTargetAudienceCode) {
		this.visualTargetAudienceCode = visualTargetAudienceCode;
	}

	public void setVisualMaterialTypeCode(String visualMaterialTypeCode) {
		this.visualMaterialTypeCode = visualMaterialTypeCode;
	}

	public void setVisualTechniqueCode(String visualTechniqueCode) {
		this.visualTechniqueCode = visualTechniqueCode;
	}

	public void setSerialFrequencyCode(String serialFrequencyCode) {
		this.serialFrequencyCode = serialFrequencyCode;
	}

	public void setSerialRegularityCode(String serialRegularityCode) {
		this.serialRegularityCode = serialRegularityCode;
	}

	public void setSerialISDSCenterCode(String serialISDSCenterCode) {
		this.serialISDSCenterCode = serialISDSCenterCode;
	}

	public void setSerialTypeCode(String serialTypeCode) {
		this.serialTypeCode = serialTypeCode;
	}

	public void setSerialFormOriginalItemCode(String serialFormOriginalItemCode) {
		this.serialFormOriginalItemCode = serialFormOriginalItemCode;
	}

	public void setSerialCumulativeIndexCode(String serialCumulativeIndexCode) {
		this.serialCumulativeIndexCode = serialCumulativeIndexCode;
	}

	public void setSerialOriginalAlphabetOfTitleCode(String serialOriginalAlphabetOfTitleCode) {
		this.serialOriginalAlphabetOfTitleCode = serialOriginalAlphabetOfTitleCode;
	}

	public void setSerialSuccessiveLatestCode(String serialSuccessiveLatestCode) {
		this.serialSuccessiveLatestCode = serialSuccessiveLatestCode;
	}

	public void setSerialTitlePageExistenceCode(String serialTitlePageExistenceCode) {
		this.serialTitlePageExistenceCode = serialTitlePageExistenceCode;
	}

	public void setSerialIndexAvailabilityCode(String serialIndexAvailabilityCode) {
		this.serialIndexAvailabilityCode = serialIndexAvailabilityCode;
	}

	public void setMusicFormatCode(String musicFormatCode) {
		this.musicFormatCode = musicFormatCode;
	}

	public void setVisualOriginalHolding(String visualOriginalHolding) {
		this.visualOriginalHolding = visualOriginalHolding;
	}

}