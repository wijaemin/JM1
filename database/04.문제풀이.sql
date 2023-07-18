DROP TABLE score;
CREATE TABLE score(
grade NUMBER(1),
class NUMBER(1),
name varchar(15),
korean NUMBER(3),
english NUMBER(3),
math NUMBER(3)
);

INSERT INTO SCORE (grade,class,name,korean,english,math)
values(1,1,'마리오',50,60,50);
INSERT INTO SCORE (grade,class,name,korean,english,math)
values(1,1,'루이지',60,90,50);
INSERT INTO SCORE (grade,class,name,korean,english,math)
values(1,2,'쿠파',70,70,80);
INSERT INTO SCORE (grade,class,name,korean,english,math)
values(1,2,'요시',80,85,35);


SELECT * FROM score;

DROP TABLE account;
CREATE TABLE account(
name varchar(21),
YEAR number,
count number,
pay number,
balance NUMBER
);

INSERT INTO account(name,YEAR,count,pay,balance)
values('유재석',3,15,1000000,15000000);
INSERT INTO account(name,YEAR,count,pay,balance)
values('강호동',2,5,500000,2500000);
INSERT INTO account(name,YEAR,count,pay,balance)
values('신동엽',2,8,800000,10000000);

SELECT * FROM  account;
