SELECT * FROM USERS;
SELECT * FROM CONTENTS;
create table users(
	userid varchar2(255) primary key,
	password varchar2(255),
	name varchar2(20),
	joindate date,
	updatedate date,
	phone varchar2(11)
);
drop table users;
drop table contents;
SELECT A.COLUMN_NAME
	 , A.COMMENTS
	 , B.DATA_TYPE || '(' || B.DATA_LENGTH || ')'  AS DATA_TYPE
	 , B.NULLABLE
	 , B.DATA_DEFAULT
FROM   ALL_COL_COMMENTS A, USER_TAB_COLUMNS B
WHERE  A.TABLE_NAME  = 'USERS'
AND    A.TABLE_NAME  = B.TABLE_NAME
AND    A.COLUMN_NAME = B.COLUMN_NAME
ORDER  BY B.COLUMN_ID;
SELECT userid FROM USERS where userid = 'aaa';
SELECT * FROM USERS;

select userid, password from users  where userid in('kshk3367') and password in('k10933kK');

CREATE TABLE CONTENTS (
	CONTENT_ID NUMBER primary key,
	TITLE VARCHAR2(100 char) NOT NULL,
	VOICE VARCHAR2(45 char) NOT NULL,
	PHOTO_1 VARCHAR2(45 char),
	PHOTO_2	VARCHAR2(45 char),
	userid varchar2(255),
	CONSTRAINT FK_CONTENTS KEY(USERID) REFERENCES USERS(USERID)
);



CREATE TABLE CONTENTS (
	CONTENT_ID NUMBER primary key,
	userid varchar2(255),
	TITLE VARCHAR2(100 char) NOT NULL,
	VOICE VARCHAR2(45 char) NOT NULL,
	PHOTO_1 VARCHAR2(45 char),
	PHOTO_2	VARCHAR2(45 char),
	uploaddate date,
	updatedate date,
	CONSTRAINT FK_CONTENTS FOREIGN KEY(USERID) REFERENCES USERS(USERID)
);


CREATE SEQUENCE contentsidplus
START WITH 1
INCREMENT BY 1;