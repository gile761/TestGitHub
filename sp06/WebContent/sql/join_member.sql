/* join_member.sql */

 create table join_member(
  join_id varchar2(20) primary key
  ,join_pwd varchar2(20) not null
  ,join_name varchar2(20) not null
  ,phone01 varchar2(6)
  ,phone02 varchar2(10) 
  ,phone03 varchar2(10)
  ,join_addr varchar2(100) not null
  ,join_date date
 );
 
 select * from join_member;