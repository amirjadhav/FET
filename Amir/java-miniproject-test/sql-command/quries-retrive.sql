# get enrolled courses of given user
select course_name from course where course_id = (select course_id from enrolled_course where user_id = 1002);
select course_name from course where user_id = ;
select * from course left join enrolled_course on course.course_id = enrolled_course.course_id;