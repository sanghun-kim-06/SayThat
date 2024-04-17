SELECT * FROM USERS;
create table users(
	userid varchar2(255) primary key,
	password varchar2(255),
	name varchar2(20),
	joindate date,
	phone varchar2(11)
);
drop table users;
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