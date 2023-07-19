drop table book;
create table book(
book_id number primary key ,
book_title varchar2(300) not null,
book_author varchar2(90) ,
book_publication_date char(10),
book_price number(*,2) not null,
book_publisher varchar2(90),
book_page_count number not null,
book_genre varchar2(12) not null,

check(regexp_like(book_title,'^[가-힣]{1,100}$')),
check(regexp_like(book_author,'^[가-힣]{1,30}$')),
check(regexp_like(book_publication_date,'^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((02)-(0[1-9]|1[0-9]|2[0-9])))$')),
check(book_price>=0),
check(regexp_like(book_publisher,'^[가-힣]{1,30}$')),
check(book_page_count>=1),
check(book_genre in ('소설','동화','자기개발'))

);
drop sequence book_seq;
create sequence book_seq;

insert into book(book_id, book_title, book_author,
book_publication_date, book_price, book_publisher,
book_page_count,book_genre)
values(book_seq.nextval,'해리포터','위재민','2001-06-26',19.99,'뭔소리야도대체',123,'소설');

SELECT * FROM  BOOK ;
