use practice;
create table courses(courseid int primary key, coursename varchar(20),price int, duration int,author varchar(20),categoryid int , foreign key (categoryid) references category(categoryid));
insert into courses values(51,'python',450,180,'kaustubh',1);
select * from courses;