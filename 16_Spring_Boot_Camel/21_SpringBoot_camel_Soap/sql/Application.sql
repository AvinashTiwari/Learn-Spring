CREATE TABLE COUNTRIES(
    COUNTRY_I SERIAL,
    NAME TEXT,
    COUNTRY_CODE TEXT,
    CRTE_TS TIMESTAMPZ NULL default current_timestamp
)
;