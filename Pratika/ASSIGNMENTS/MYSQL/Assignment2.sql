create database item_management;
use  item_management;
create table Items (I_Code int primary key, name varchar(20), Category varchar(20), Rate int);
create table bills(BillNo int , Date date , I_Code int , qty int,foreign key(I_Code)references Items(I_Code));

insert into Items values(1001, " Masala Dosa " ,"South Indian ", 60);
insert into Items values( 1002, "Vada Sambhar"," South Indian", 40 );
insert into Items values(  );
insert into Items values(   1003,"Idli Sambhar"," South Indian ", 40 );
insert into Items values(2001,"Chow Mein" ,"Chinese",80);