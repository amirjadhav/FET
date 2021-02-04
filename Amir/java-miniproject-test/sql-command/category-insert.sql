desc category;
alter table category modify column category_name varchar(30);
insert into category values(1,'Development','https://s.udemycdn.com/home/top-categories/lohp-category-development.jpg');
insert into category values(2,'Music','https://s.udemycdn.com/home/top-categories/lohp-category-music.jpg');
insert into category values(3,'Personality Development','https://s.udemycdn.com/home/top-categories/lohp-category-business.jpg');
select * from category;