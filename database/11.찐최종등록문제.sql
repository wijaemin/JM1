drop table book;
<<<<<<< HEAD
create table book(
book_id number primary key ,
book_title varchar2(300) not null,
book_author varchar2(90) ,
book_publication_date char(10),
book_price number(*,2) not null,
book_publisher varchar2(90),
book_page_count number not null,
book_genre varchar2(12) not null,

check(regexp_like(book_author,'[^!@#%]+')),
check(regexp_like(book_publication_date,'^(1[8-9][0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((02)-(0[1-9]|1[0-9]|2[0-9])))$')),
check(book_price>=0),
check(book_page_count>=1),
check(book_genre in ('Fantasy','Classic','Dystopian','Romance','Modernist','Fiction'))

);
drop sequence book_seq;
create sequence book_seq;


insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'Harry Potter 1','J.K. Rowling','2001-06-26',19.99,'Scholastic',320,'Fantasy');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'To Kill a Mockingbird','Harper Lee','1960-07-11',14.99,'Grand Central Publishing',336,'Classic');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'The Great Gatsby','F. Scott Fitzgerald','1925-04-10',12.99,'Scribner',180,'Classic');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'1984','George Orwell','1949-06-08',10.99,'Secker & Warburg',328,'Dystopian');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'Pride and Prejudice','Jane Austen','1813-01-28',9.99,'Penguin Classics',432,'Romance');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'The Hobbit','J.R.R. Tolkien','1937-09-21',15.99,'Houghton Mifflin Harcourt',320,'Fantasy');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'The Catcher in the Rye','J.D. Salinger','1951-07-16',11.99,'Little, Brown and Company',224,'Classic');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'Lord of the Rings','J.R.R. Tolkien','1954-07-29',29.99,'Allen & Unwin',1178,'Fantasy');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'To the Lighthouse','Virginia Woolf','1927-05-05',13.99,'Harcourt, Brace and Company',209,'Modernist');
insert into book(book_id, book_title, book_author,book_publication_date, book_price, book_publisher,book_page_count,book_genre)
values(book_seq.nextval,'The Alchemist','Paulo Coelho','1988-06-01',9.99,'HarperOne',208,'Fiction');


SELECT * FROM  BOOK ;
=======

create table book(
book_id number primary key,
book_title varchar2(300) not null,
book_author varchar2(90)
check(regexp_like(book_author,'[^!@#$]+')),
book_publication_date varchar2(10)
check(regexp_like(book_publication_date,'^(1[89][0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((02)-(0[1-9]|1[0-9]|2[0-9])))$')),
book_price number(*,2) not null check(book_price>=0),
book_publisher varchar2(90),
book_page_count number not null check(book_page_count>=1),
book_genre varchar2(30) not null

);
drop sequence book_seq;

create sequence book_seq;

INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(1, 'Harry Potter 1', 'J.K. Rowling', '2001-06-26', 19.99, 'Scholastic', 320, 'Fantasy');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(2, 'To Kill a Mockingbird', 'Harper Lee', '1960-07-11', 14.99, 'Grand Central Publishing', 336, 'Classic');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(3, 'The Great Gatsby', 'F. Scott Fitzgerald', '1925-04-10', 12.99, 'Scribner', 180, 'Classic');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(4, '1984', 'George Orwell', '1949-06-08', 10.99, 'Secker & Warburg', 328, 'Dystopian');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(5, 'Pride and Prejudice', 'Jane Austen', '1813-01-28', 9.99, 'Penguin Classics', 432, 'Romance');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(6, 'The Hobbit', 'J.R.R. Tolkien', '1937-09-21', 15.99, 'Houghton Mifflin Harcourt', 320, 'Fantasy');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(7, 'The Catcher in the Rye', 'J.D. Salinger', '1951-07-16', 11.99, 'Little, Brown and Company', 224, 'Classic');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(8, 'Lord of the Rings', 'J.R.R. Tolkien', '1954-07-29', 29.99, 'Allen & Unwin', 1178, 'Fantasy');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(9, 'To the Lighthouse', 'Virginia Woolf', '1927-05-05', 13.99, 'Harcourt, Brace and Company', 209, 'Modernist');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(10, 'The Alchemist', 'Paulo Coelho', '1988-06-01', 9.99, 'HarperOne', 208, 'Fiction');

select *from book;
>>>>>>> branch 'main' of https://github.com/wijaemin/JM1.git
