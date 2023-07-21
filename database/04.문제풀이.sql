DROP TABLE score;
CREATE TABLE score(
grade NUMBER(1),
class NUMBER(1),
name varchar2(15),
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
account_owner varchar2(21),
account_period number,
account_count number,
account_payment number,
account_balance NUMBER
);

INSERT INTO account(account_owner,account_period,account_count,account_payment,account_balance)
values('유재석',3,15,1000000,15000000);
INSERT INTO account(account_owner,account_period,account_count,account_payment,account_balance)
values('강호동',2,5,500000,2500000);
INSERT INTO account(account_owner,account_period,account_count,account_payment,account_balance)
values('신동엽',2,8,800000,10000000);

SELECT * FROM  account;
