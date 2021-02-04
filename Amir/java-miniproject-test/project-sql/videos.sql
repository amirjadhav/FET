use practice;
create table videos(videoid int primary key,videopath varchar(100),courseid int, foreign key (courseid) references courses(courseid));
insert into videos values(201,"./videos/development/python/1.mp4",51);
