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

--student deatils table

CREATE TABLE STUDENTS_DETAILS(
SNO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
COLLEGE_ID VARCHAR(10) NOT NULL, 
STUDENT_ID VARCHAR(10) NOT NULL,
STUDENT_NAME VARCHAR(150),
STUDENT_GENDER CHAR(1),
STUDENT_PHONE VARCHAR(12),
STUDENT_POINT FLOAT NOT NULL DEFAULT 0.0,
STATUS BOOLEAN NOT NULL DEFAULT TRUE,
ACCOMMODATION BOOLEAN  DEFAULT FALSE,
PRIMARY KEY(STUDENT_ID),
FOREIGN KEY (COLLEGE_ID) REFERENCES COLLEGE_DETAILS(COLLEGE_ID) ON DELETE CASCADE  
);

--event details table

CREATE TABLE EVENT_DETAILS (
SNO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
STUDENT_ID VARCHAR(10) NOT NULL REFERENCES STUDENTS_DETAILS(STUDENT_ID) ON DELETE CASCADE ,
GROUP_ID VARCHAR(10),
EVENT_ID VARCHAR(15),
COLLEGE_ID VARCHAR(10) NOT NULL REFERENCES COLLEGE_DETAILS(COLLEGE_ID) ON DELETE CASCADE,  
PRIMARY KEY(STUDENT_ID,EVENT_ID),
FOREIGN KEY(EVENT_ID) REFERENCES EVENTS(EVENT_ID) ON DELETE CASCADE 
);

--result table

CREATE TABLE RESULTS(
SNO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
COLLEGE_ID VARCHAR(10) NOT NULL ,
STUDENT_ID VARCHAR(10) NOT NULL REFERENCES STUDENTS_DETAILS(STUDENT_ID) ON DELETE CASCADE ,
EVENT_ID VARCHAR(15) NOT NULL REFERENCES EVENTS(EVENT_ID)ON DELETE CASCADE ,
RESULT_STATUS VARCHAR(15) NOT NULL,
GROUP_ID VARCHAR(10),
MARK FLOAT NOT NULL DEFAULT -999999,
PRIMARY KEY(STUDENT_ID,EVENT_ID,RESULT_STATUS),
FOREIGN KEY(COLLEGE_ID) REFERENCES COLLEGE_DETAILS(COLLEGE_ID) ON DELETE CASCADE 	
);


--winner table 
CREATE TABLE WINNERS(
SNO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
COLLEGE_ID VARCHAR(10) NOT NULL ,
STUDENT_ID VARCHAR(10) NOT NULL REFERENCES STUDENTS_DETAILS(STUDENT_ID) ON DELETE CASCADE ,
EVENT_ID VARCHAR(15) NOT NULL REFERENCES EVENTS(EVENT_ID)ON DELETE CASCADE ,
WINNER_STATUS VARCHAR(15) NOT NULL,
GROUP_ID VARCHAR(10),
MARK FLOAT NOT NULL DEFAULT -999999,
PRIMARY KEY(STUDENT_ID,EVENT_ID,WINNER_STATUS),
FOREIGN KEY(COLLEGE_ID) REFERENCES COLLEGE_DETAILS(COLLEGE_ID) ON DELETE CASCADE 	
);


--seminar table not done yet

CREATE TABLE SEMINAR_DETAILS(
SNO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NAME VARCHAR(100) NOT NULL, 
COURSE VARCHAR(100) ,
COLLEGE_NAME VARCHAR(150),
ADDRESS VARCHAR(500),
PHONE VARCHAR(12),
EMAIL VARCHAR(100),
DUTY_CERTIFICATE BOOLEAN NOT NULL DEFAULT FALSE
);


-- time sheet table

CREATE TABLE TIMESHEET(
SNO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
EVENT_ID VARCHAR(15),
START_TIME VARCHAR(20),
END_TIME VARCHAR(20),
EVENT_STAGE VARCHAR(20),
VENUE  VARCHAR(200) ,
DAY DATE
);

