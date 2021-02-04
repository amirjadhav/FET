use practice;
create table enrollment(enrollid int,purchasedate date,price int ,currentvideo int,complete boolean,courseid int, userid int ,  primary key(courseid, userid), foreign key (courseid) references courses(courseid), foreign key (userid) references user(id));
desc enrollment;
insert into enrollment values(501,'2021-01-21',450,2,false,51,101)
