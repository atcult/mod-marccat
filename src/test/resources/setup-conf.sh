#!/usr/bin/env bash
curl -X POST "http://192.168.0.158:8085/_/tenant" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json"
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "datasource", "code": "url", "description": "Target JDBC URL", "default": true, "enabled": true, "value": "jdbc:postgresql://192.168.0.158:5433/olidb_sv3" }'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "datasource", "code": "port", "description": "Database listening port", "default": true, "enabled": true, "value": 5433 }'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "datasource", "code": "user", "description": "Database username", "default": true, "enabled": true, "value": "amicus"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "datasource", "code": "password", "description": "Database password", "default": true, "enabled": true, "value": "oracle"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "authority", "code": "authority.cataloguingSourceStringText", "description": "Authority cataloging source", "default": true, "enabled": true, "value": "\u001FaPS"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "authority", "code": "authority.classification.type", "description": "Classification type", "default": true, "enabled": true, "value": "12"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "authority", "code": "authority.classification.function", "description": "Classification function", "default": true, "enabled": true, "value": "34"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "authority", "code": "authority.reference.specialRelationship", "description": " Print constant cross-reference", "default": true, "enabled": true, "value": "n"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "authority", "code": "authorityNote.noteType", "description": "Authority note type", "default": true, "enabled": true, "value": "26"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "authority", "code": "authority.verificationLevel", "description": "Authority verification level", "default": true, "enabled": true, "value": "1"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicItem.cataloguingSourceStringText", "description": "Bibliographic cataloging source", "default": true, "enabled": true, "value": "\u001FaItFiC"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicItem.languageCode", "description": "Bibliographic language code", "default": true, "enabled": true, "value": "ita"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicItem.languageOfCataloguing", "description": "Bibligraphic language of cataloguing", "default": true, "enabled": true, "value": "it"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicItem.recordCataloguingSourceCode", "description": "Bibligraphic record cataloguing source code", "default": true, "enabled": true, "value": "r"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicItem.marcCountryCode", "description": "Bibliographic marc country code", "default": true, "enabled": true, "value": "enk"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicItem.itemDateTypeCode", "description": "Bibliographic date type code", "default": true, "enabled": true, "value": "s"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicItem.verificationLevel", "description": "Bibliographic verification level", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicNote.noteType", "description": "Bibliographic note type", "default": true, "enabled": true, "value": "50"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicRelationship.relationTypeCode", "description": "Bibliographic relation type", "default": true, "enabled": true, "value": "35"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographicRelationship.relationPrintNoteCode", "description": "Bibliographic relation print note code", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "bibliographic", "code": "bibliographic.shelflist.type", "description": "Bibliographic shelflist type", "default": true, "enabled": true, "value": "@"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "browse", "code": "browse.termsPerPage", "description": "Terms to page", "default": true, "enabled": true, "value": "10"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "browse", "code": "tooltip.max.length", "description": "Text heading length", "default": true, "enabled": true, "value": "200"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.bookBiographyCode", "description": "Book biography code", "default": true, "enabled": true, "value": " "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.bookFestschrift", "description": "Book festschrift", "default": true, "enabled": true, "value": "0"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.bookIllustrationCode", "description": "Book illustration code", "default": true, "enabled": true, "value": "    "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.bookIndexAvailabilityCode", "description": "Book index availability code", "default": true, "enabled": true, "value": "0"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.bookLiteraryFormTypeCode", "description": "Book literary form type code", "default": true, "enabled": true, "value": "u"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.cartographicFormatCode", "description": "Book format code", "default": true, "enabled": true, "value": "  "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.cartographicMaterial", "description": "Cartographic material", "default": true, "enabled": true, "value": "u"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.cartographicProjectionCode", "description": "Cartographic projection code", "default": true, "enabled": true, "value": "  "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.cartographicReliefCode", "description": "Cartographic relief code", "default": true, "enabled": true, "value": "    "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.computerFileTypeCode", "description": "Computer File Type Code", "default": true, "enabled": true, "value": "u"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.computerFileFormCode", "description": "Computer File Form code", "default": true, "enabled": true, "value": " "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.conferencePublicationCode", "description": "Conference publication code", "default": true, "enabled": true, "value": "0"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.formOfItemCode", "description": "Computer File Form Code", "default": true, "enabled": true, "value": " "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.governmentPublicationCode", "description": "Government publication code", "default": true, "enabled": true, "value": " "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.musicFormOfCompositionCode", "description": "Music form of composition code", "default": true, "enabled": true, "value": "uu"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.musicFormatCode", "description": "Music format code", "default": true, "enabled": true, "value": "u"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.musicLiteraryTextCode", "description": "Music literary text code", "default": true, "enabled": true, "value": "  "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.musicTextualMaterialCode", "description": "Music textual material code", "default": true, "enabled": true, "value": " "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.musicPartsCode", "description": "Music parts code", "default": true, "enabled": true, "value": "u"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.musicTranspositionArrangementCode", "description": "Music transposition arrangement code", "default": true, "enabled": true, "value": "u   "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.natureOfContentsCode", "description": "Nature of contents code", "default": true, "enabled": true, "value": "    "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.serialFrequencyCode", "description": "Serial frequency code", "default": true, "enabled": true, "value": "u"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.serialOriginalAlphabetOfTitleCode", "description": "Serial original alphabet of title Code", "default": true, "enabled": true, "value": " "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.serialRegularityCode", "description": "Serial regularity code", "default": true, "enabled": true, "value": "u"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.serialSuccessiveLatestCode", "description": "Serial successive latest code", "default": true, "enabled": true, "value": "0"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.serialTypeCode", "description": "Serial type code", "default": true, "enabled": true, "value": " "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.targetAudienceCode", "description": "Target audience code", "default": true, "enabled": true, "value": " "}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.visualMaterialTypeCode=", "description": "Visual material type code", "default": true, "enabled": true, "value": "z"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.visualRunningTime", "description": "Target audience code", "default": true, "enabled": true, "value": "---"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "material", "code": "material.visualTechniqueCode=", "description": "Visual material type code", "default": true, "enabled": true, "value": "u"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "name", "code": "name.accessPointLanguage", "description": "Name access point language", "default": true, "enabled": true, "value": "124"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "name", "code": "name.copyToSubjectIndicator", "description": "Name copy to subject indicator", "default": true, "enabled": true, "value": "0"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "name", "code": "name.subTypeCode", "description": "Name sub type code", "default": true, "enabled": true, "value": "3"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "name", "code": "name.typeCode", "description": "Name type code", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "name", "code": "name.verificationLevel", "description": "Name verification level", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "name", "code": "name.functionCode", "description": "Name function code", "default": true, "enabled": true, "value": "7"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "title", "code": "title.copyToSubjectIndicator", "description": "Title copy to subject indicator", "default": true, "enabled": true, "value": "0"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "title", "code": "title.accessPointLanguage", "description": "Title copy access point language", "default": true, "enabled": true, "value": "124"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "title", "code": "title.skipInFiling", "description": "Title skip in filing", "default": true, "enabled": true, "value": "0"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "title", "code": "title.indexingLanguage", "description": "Title indexing language", "default": true, "enabled": true, "value": "255"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "title", "code": "title.functionCode", "description": "Title function code", "default": true, "enabled": true, "value": "1"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "title", "code": "title.secondaryFunctionCode", "description": "Title secondary function code", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "title", "code": "title.verificationLevel", "description": "Title verification level", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "publisher", "code": "publisher.accessPointLanguage", "description": "Publisher access point", "default": true, "enabled": true, "value": "124"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "publisher", "code": "publisher.name", "description": "Publisher name", "default": true, "enabled": true, "value": "[s.n.]"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "publisher", "code": "publisher.place", "description": "Publisher place", "default": true, "enabled": true, "value": "[S.l.]"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "publisher", "code": "publisher.verificationLevel", "description": "Publisher verification level", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "publisher", "code": "publisherAccessPoint.functionCode", "description": "Publisher function code", "default": true, "enabled": true, "value": "24"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "subject", "code": "subject.accessPointLanguage", "description": "Subject access point", "default": true, "enabled": true, "value": "255"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "subject", "code": "subject.scriptingLanguage", "description": "Subject scripting language", "default": true, "enabled": true, "value": "und"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "subject", "code": "subject.sourceCode", "description": "Subject source code", "default": true, "enabled": true, "value": "6"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "subject", "code": "subject.typeCode", "description": "Subject type code", "default": true, "enabled": true, "value": "19"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "subject", "code": "subjectAccessPoint.functionCode", "description": "Subject function code", "default": true, "enabled": true, "value": "3"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "subject", "code": "subjectAccessPoint.verificationLevel", "description": "Subject verification level", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "classification", "code": "classification.typeCode", "description": "Classification type code", "default": true, "enabled": true, "value": "13"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "classification", "code": "classificationAccessPoint.functionCode", "description": "Classification function code", "default": true, "enabled": true, "value": "61"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "classification", "code": "classification.verificationLevel", "description": "Classification verification level", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "controlNumber", "code": "controlNumber.typeCode", "description": "Control number type code", "default": true, "enabled": true, "value": "9"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "controlNumber", "code": "controlNumberAccessPoint.functionCode", "description": "Control function code", "default": true, "enabled": true, "value": "8"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "controlNumber", "code": "controlNumber.verificationLevel", "description": "Control number verification level", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "controlNumber", "code": "control.number.browse.index", "description": "Control number browse index", "default": true, "enabled": true, "value": "16P30"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "nameTitle", "code": "nameTitleAccessPoint.functionCode", "description": "Name title function code", "default": true, "enabled": true, "value": "6"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "nameTitle", "code": "nameTitleAccessPoint.secondaryFunctionCode", "description": "Name title secondary function code", "default": true, "enabled": true, "value": "2"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "inventory", "code": "inventory.defaultCurrency", "description": "Inventory default currency", "default": true, "enabled": true, "value": "122"}'
curl -X POST "http://192.168.0.158:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "library", "code": "tag.850.enabled", "description": "Holding institution", "default": true, "enabled": true, "value": "1"}'