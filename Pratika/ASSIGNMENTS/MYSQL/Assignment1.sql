create database student_management;
use student_management;
create table student (AdmNO int primary key, name varchar(10), class int ,sec set('A','B','C'),RNO int unique,Address varchar(50),phone int(10));
create table sports(AdmNO int , game varchar(20),grade enum('A','B','C','D'), foreign key(AdmNO) references student(AdmNO));


insert into student values(1271,"Utkarsh",12,"C",1," C-32,Punjabi Bagh ", 4356154);
insert into student values(1324,"Naresh", 10,"A",2,"31 Mohan Nagar", 435654);
insert into student values(1325,"Yusuf",  10,"A" , 3," 12/21,Chand Nagar", 145654 );
insert into student values(1328,"Sumedha",  10 ,"B", 23," 59,Moti Nagar" ,4135654   );
insert into student values(1364,"Subya",  11 ,"B", 13 ," 12,Janak Puri ",NULL  );


alter table  sports add CoachName varchar(20);
desc sports;
insert into sports values (1324,"Cricket","A" ,"Narendra");
insert into sports values (1364 ,"Volleball","A","M.P.Singh");
insert into sports values (1271 ,"Volleball ","B","M.P.Singh");
insert into sports values (1328 ,"Basket Ball","B","I.Malhotra");
insert into sports values (1271,"Cricket","B" ,"Narendra");

/*Q1*/
select max(class) as "heightest" ,min(class) as  "lowest" from student;

/*Q2*/
select class,count(class) as "Count of student" from student group by class;

/*Q3*/
select class ,count(class) from student where class=11;

/*Q4*/
select * from student s, sports sp where  sp.game="cricket" and s.AdmNO=sp.AdmNO;

/*Q5*/
select s.AdmNO,name,class,sec,RNO,grade from student s,sports sp where sp.grade="A";

/*Q6*/
select name,phone from student join sports using(AdmNO) where class=12 and game is not null;

/*Q7*/
select CoachName,count(AdmNO) from sports group by  CoachName;

/*Q8*/
select phone,name from student join sports using(AdmNO) where grade="A" and CoachName="Narendra"

 /*Q9
 AdmNO is foreign  key is present in both table student and sports */
 


