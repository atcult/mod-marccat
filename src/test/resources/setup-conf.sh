#!/usr/bin/env bash
curl -X POST "http://127.0.0.1:8085/_/tenant" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json"
curl -X POST "http://127.0.0.1:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "datasource", "code": "url", "description": "Target JDBC URL", "default": true, "enabled": true, "value": "jdbc:postgresql://192.168.0.158:5432/olidb_sv1" }'
curl -X POST "http://127.0.0.1:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "datasource", "code": "port", "description": "Database listening port", "default": true, "enabled": true, "value": 5432 }'
curl -X POST "http://127.0.0.1:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "datasource", "code": "user", "description": "Database username", "default": true, "enabled": true, "value": "amicus"}'
curl -X POST "http://127.0.0.1:8085/configurations/entries/" -H "x-okapi-tenant: tnx" -H "Content-Type: application/json" -d '{"module": "CATALOGING", "configName": "datasource", "code": "password", "description": "Database password", "default": true, "enabled": true, "value": "oracle"}'
