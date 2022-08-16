DROP TABLE tableName;
CREATE TABLE HOTELAVAILABILITY
(
    HOTEL_ID     INT  NOT NULL GENERATED ALWAYS AS IDENTITY,
    BOOKING_DATE DATE NOT NULL,
    ROOMS_TAKEN  INT DEFAULT 0,
    PRIMARY KEY (HOTEL_ID, BOOKING_DATE)
);
-- the table-level primary key definition allows you to
-- include two columns in the primary key definition

-- assign an identity column attribute to an INTEGER
-- column, and also define a primary key constraint
-- on the column
CREATE TABLE PEOPLE
(
    PERSON_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY
        CONSTRAINT PEOPLE_PK PRIMARY KEY,
    PERSON    VARCHAR(26)
);
-- assign an identity column attribute to a SMALLINT
-- column with an initial value of 5 and an increment value
-- of 5 and with cycle option.
CREATE TABLE GROUPS
(
    GROUP_ID SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 5, INCREMENT BY 5),
    ADDRESS  VARCHAR(100),
    PHONE    VARCHAR(15)
);
