
create  database emp_management;
  use emp_management;
  
  
/*table empdept*/

  create table employee(empid int primary key,empname varchar(100), department varchar(50),contactno bigint, emaildid varchar(100), empheadid int) 
 ;
 insert into employee values (101,"isha","E-101",
 1234567890,"isha@gmail.com",105);
  insert into employee values (102,"Priya","E-104",
 1234567890,"priya@gmail.com",103);
  insert into employee values (103,"Neha","E-101",
 1234567890,"neha@gmail.com",101);
  insert into employee values (104,"Rahul","E-102",
 1234567890,"rahul@gmail.com",105);
  insert into employee values (105,"Abhishek","E-101",
 1234567890,"abhishek@gmail.com",102);
 
 

/*table empdept*/


create table empdept(deptid varchar(50) primary key,deptname varchar(100), dept_off varchar(100), depthead int ,foreign key(depthead) references employee(empid)) ;
insert into empdept values ("E-101","HR","Monday",105);
insert into empdept values ("E-102","Development","Tuesday",101);
insert into empdept values ("E-103","House Keeping","Saturday",103);
insert into empdept values ("E-104","Sales","Sunday",104);
insert into empdept values ("E-105","Purchage","Tuesday",104);


create table empsalary(empid int , salary bigint, ispermanent varchar(3),foreign key(empid) references employee(empid)) ;
insert into empsalary values (101,2000,"yes");	
insert into empsalary values (102,10000,"yes");
insert into empsalary values (103,5000,"No");		
insert into empsalary values (104,19000,"Yes");	
insert into empsalary values (105,23000,"Yes");	    


/*table project*/
  create table project(projectid varchar(50) primary key, duration int); 
insert into project values ("p-1",23);	 
insert into project values ("p-2",15);
insert into project values ("p-3",45);
insert into project values ("p-4",2);
insert into project values ("p-5",30);


/*table country*/
create table country(cid varchar(50) primary key, cname varchar(100)) ;
insert into country values ("C-1","India");
insert into country values ("C-2","USA");
insert into country values ("C-3","China");
insert into country values ("C-4","Pakistan");
insert into country values ("C-5","Russia");


/*table clienttable*/

create table clienttable(clientid varchar(50) primary key, clientname varchar(100), cid varchar(50) , foreign key(cid) references country(cid)); 
  insert into clienttable values ("cl-1","ABC Group","c-1");
  insert into clienttable values ("cl-2","PQR Group","c-1");
  insert into clienttable values ("cl-3","XYZ Pvt Ltd","c-2");
insert into clienttable values ("cl-4","Alt technologies","c-3");
  insert into clienttable values ("cl-5","MNP tech","c-5");  
  
  /*table empproject*/
  create table empproject(empid int , projectid varchar(50) , clientid varchar(50) ,startyear int, endyear int, foreign key(empid) references employee(empid),foreign key(projectid) references project(projectid),foreign key (clientid)references clienttable(clientid));
    insert into empproject values (101,"p-1","cl-1",2010,2010);
        insert into empproject values (102,"p-2","cl-2",2011,2013);
            insert into empproject values (103,"p-1","cl-3",2014,2015);
                insert into empproject values (104,"p-4","cl-1",2015,2015);
                    insert into empproject values (105,"p-4","cl-5",2018,2010);
 
 
 /*  Queries*/
 select * from employee where empname like 'p%';
 select count(salary) as count from empsalary where ispermanent='yes' and salary>5000;
 select * from employee where emaildid like '%@gmail.com';
 select * from employee where department='E-102' or department='E-104';
 select deptname from empdept where deptid ='E-102';
 select sum(salary) as salary from empsalary where ispermanent='yes';
 
  select * from employee where empname like '%a';
select count(empid) as employee, projectid from empproject group by projectid;
  select count(projectid) as project from empproject where startyear=2010;
  select count(projectid) as project from empproject where startyear=endyear;
  select * from employee where empname like '__h%';
  
  
  /* joins*/
  select * from employee e ,empsalary s where e.empid=s.empid and ispermanent='yes';
 select e.empname,d.deptname from employee e,empdept d where empheadid=depthead;
 insert into empsalary values (102,NULL,"Yes");	 
 
  select * from employee e ,empsalary s where e.empid=s.empid  and salary IS NULL;


/* Stored procedure*/ 


/* insert*/ 
 DELIMITER //
 CREATE PROCEDURE insert2 (IN empid int,IN empname varchar(50),IN department varchar(50),IN contact bigint,IN empldid varchar(50),IN empheadid int)
BEGIN
  insert into employee values (empid,empname,department,contact,empldid,empheadid);
END//

   CALL insert2 (106,"Abhishek","E-101",
 1234567890,"abhishek@gmail.com",102);//
 

/*max salary*/ 
 delimiter //
 create procedure maxsal4()
 begin 
select  max(s.salary),e.empid,e.empname,e.contactno,e.emaildid from employee e left join empsalary s on e.empid=s.empid;
end
//
            
    call maxsal4();//
 
 