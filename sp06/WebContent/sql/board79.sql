/* board79.sql */

 create table board99(
  board_no number(15) primary key
  ,board_name varchar2(30) not null
  ,board_title varchar2(150) not null
  ,board_pwd varchar2(20) not null
  ,board_cont varchar2(4000) not null
  ,board_hit number(15) default 0
  ,board_ref number(15)
  ,board_step number(15)
  ,board_level number(15)
  ,board_date date
 );
 
 create sequence board99_no_seq
 increment by 1 start with 1 nocache;
 
 select * from board99 order by board_no desc;
 
 delete from board99;
 
 