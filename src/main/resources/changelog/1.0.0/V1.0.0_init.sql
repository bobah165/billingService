--DROP SCHEMA IF EXISTS general CASCADE;

CREATE SCHEMA IF NOT EXISTS general;

--UTILS SCHEMA

CREATE TABLE general.billing
(
    id varchar NOT NULL,
    sum bigint NOT NULL,
    CONSTRAINT pk_billing
        PRIMARY KEY (id)
);

CREATE TABLE general.order
(
    id varchar NOT NULL,
    name varchar NOT NULL,
    price bigint NOT NULL,
    user_id varchar NOT NULL,
    CONSTRAINT pk_order
        PRIMARY KEY (id)
);


