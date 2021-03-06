--Table creation script for derby Database
--events table

CREATE TABLE EVENTS(
SNO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
EVENT_ID VARCHAR(15) NOT NULL,
EVENT_NAME VARCHAR(20) NOT NULL,
MAX_NO_OF_PARTICIPANTS INT NOT NULL,
EVENT_POINT INT NOT NULL DEFAULT 5,
PRIMARY KEY (EVENT_ID)
);
 