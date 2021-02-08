create database e_learning;
use e_learning;

create table user(user_id int primary key, full_name varchar(20),user_name varchar(20) unique, user_password varchar(20), user_role varchar(10), user_security_question varchar(100), user_security_answer varchar(100));

desc user;
insert into user values(1001,'amir jadahv','amirjadhav','amir@123','user','fav color?','black');
insert into user values(1002,'vijay sharma','vijaybhau','vijay123','user','fav sport','tennis');
insert into user values(1003,'neeraj nehera','neerajnehra','neerajnehra123','user','fav book','clean code');
select * from user;