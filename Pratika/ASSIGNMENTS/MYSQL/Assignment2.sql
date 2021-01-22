create database item_management;
use  item_management;
create table Items (I_Code int primary key, name varchar(20), Category varchar(20), Rate int);
create table bills(BillNo int , Date date , I_Code int , qty int,foreign key(I_Code)references Items(I_Code));

insert into Items values(1001, "Masala Dosa" ,"South Indian", 60);
insert into Items values( 1002, "Vada Sambhar","South Indian", 40 );
insert into Items values(   1003,"Idli Sambhar","South Indian", 40 );
insert into Items values(2001,"Chow Mein" ,"Chinese",80);
insert into Items values( 2002 ,"Dimsum"," Chinese",   60  );
insert into Items values( 2003,"Soup" ,"Chinese",  50  );
insert into Items values(  3001,"Pizza", "Italian", 240 );
insert into Items values( 3002 ,"Pasta","Italian", 125 );


insert into bills values(  1 ,"2010-04-01",   1002 ,    2 );
insert into bills values( 2 ,"2010-04-01",   1001 ,   3 );
insert into bills values(  2 ,"2010-04-01",   1002 ,   1 );
insert into bills values(   2 ,"2010-04-01",   2003 ,    2 );
insert into bills values(   3 ,"2010-04-02",   2002 ,    1 );
insert into bills values( 4 ,"2010-04-02",   2002 ,    4 );
insert into bills values(  4 ,"2010-04-02",   2003 ,    2  );
insert into bills values( 5 ,"2010-04-03", 3001 ,1 );
insert into bills values( 5 ,"2010-04-03", 3002 ,3 );

/* Q11*/
select Category,avg(Rate) from Items where Category="South Indian ";

/* Q12*/
select category,count(I_Code) from Items group by Category;

/* Q13*/
select I_Code, sum(qty) from bills group by I_Code;

/* Q14*/
select I_Code, sum(qty) from bills group by I_Code having sum(qty)>3;

/* Q15*/
 select name,date,qty from bills b join Items i using (I_code);
 
 /* Q16*/
 select name,date,qty from bills b join Items i using (I_code) having name like "% Dosa ";
 
 
  /* Q17*/
  select BillNO ,b.I_Code,date,qty from bills b join Items i using(I_Code) where category='Italian' group by I_code;
  
   /* Q18*/
  select BillNO,sum(qty) from bills group by BillNO;
