CREATE USER pd24 PASSWORD '1234' SUPERUSER;

CREATE DATABASE mario OWNER pd24;

CREATE TABLE marios (
      id integer NOT NULL,
      name character varying(255),
      email character varying(32),
      CONSTRAINT star_pk PRIMARY KEY (id)
);

SELECT * FROm marios;




DROP TABLE marios;


CREATE TABLE marios (
        name character varying(255),
        email character varying(32),
        INHERITS (marios)
;

SELECT * FROM marios;