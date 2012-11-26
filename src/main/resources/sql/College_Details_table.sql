--college details table

CREATE TABLE COLLEGE_DETAILS(
SNO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
COLLEGE_ID VARCHAR(10) NOT NULL, 
COLLEGE_NAME VARCHAR(100), 
COLLEGE_ADDRESS VARCHAR(500), 
COLLEGE_PHONE VARCHAR(12), 
NO_OF_PARTICIPANTS INT, 
COLLEGE_POINTS FLOAT NOT NULL DEFAULT 0.0,
STATUS BOOLEAN NOT NULL DEFAULT TRUE,
PRIMARY KEY (COLLEGE_ID));