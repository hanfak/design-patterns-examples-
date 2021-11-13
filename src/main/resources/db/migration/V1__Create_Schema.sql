CREATE SCHEMA IF NOT EXISTS records;

CREATE SEQUENCE characters_sequence START 1;
-- Could use serial type for id
CREATE TABLE records.characters(
   ID             integer       DEFAULT nextval('characters_sequence'::regclass) NOT NULL UNIQUE,
   PERSON_ID      integer       NOT NULL UNIQUE PRIMARY KEY,
   PERSON_NAME    varchar(50)   NOT NULL,
   CREATED_AT     TIMESTAMP     DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('1', 'Luke Skywalker');
INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('2', 'C-3PO');
INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('4', 'Darth Vader');
INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('5', 'Leia Organa');
INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('13', 'Chewbacca');
INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('14', 'Han Solo');
INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('16', 'Jabba');
INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('20', 'Yoda');
INSERT INTO records.characters (PERSON_ID, PERSON_NAME) VALUES ('22', 'Boba Fett');

create or replace function test()
RETURNS setof records.characters
language sql
as $$
select * from records.characters;
$$;
