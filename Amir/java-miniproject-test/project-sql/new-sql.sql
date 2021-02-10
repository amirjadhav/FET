create database cybage_learning;
use cybage_learning;

drop table category;
drop table course;
drop table sub_course;
CREATE TABLE `category` (
  `category_id` int NOT NULL,
  `category_name` varchar(30) DEFAULT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `course` (
  `course_id` int NOT NULL,
  `course_name` varchar(20) DEFAULT NULL,
  `course_price` int DEFAULT NULL,
  `course_duration` int DEFAULT NULL,
  `course_author` varchar(20) DEFAULT NULL,
  `course_description` varchar(200) DEFAULT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  `total_sub_course` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `course_category_fk` (`category_id`),
  CONSTRAINT `course_category_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `sub_course` (
  `sub_course_id` int NOT NULL,
  `sub_course_name` varchar(50) DEFAULT NULL,
  `sub_course_duration` int DEFAULT NULL,
  `sub_course_description` varchar(100) DEFAULT NULL,
  `video_url` varchar(200) DEFAULT NULL,
  `video_sequence` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`sub_course_id`),
  UNIQUE KEY `video_sequence` (`video_sequence`),
  KEY `sub_course_course_fk` (`course_id`),
  CONSTRAINT `sub_course_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE,
  CONSTRAINT `sub_course_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


SELECT * FROM cybage_learning.sub_course;



INSERT INTO `cybage_learning`.`category`
(`category_id`,
`category_name`,
`image_url`)
VALUES
(1,' development','https://iadsb.tmgrup.com.tr/ebcb9e/1200/627/0/10/1000/532?u=https://idsb.tmgrup.com.tr/2019/12/24/1577196550559.jpg'
);


INSERT INTO `cybage_learning`.`course`
(`course_id`,
`course_name`,
`course_price`,
`course_duration`,
`course_author`,
`course_description`,
`image_url`,
`total_sub_course`,
`category_id`)
VALUES
(101,'python','500',180,'aaa','askdfjshfkfg','https://iadsb.tmgrup.com.tr/ebcb9e/1200/627/0/10/1000/532?u=https://idsb.tmgrup.com.tr/2019/12/24/1577196550559.jpg',5,1);



INSERT INTO `cybage_learning`.`sub_course`
(`sub_course_id`,
`sub_course_name`,
`sub_course_duration`,
`sub_course_description`,
`video_url`,
`video_sequence`,
`course_id`)
VALUES (501,'introduction to python',60,'asdsfd','videos/1.mp4',1,101);


INSERT INTO `cybage_learning`.`sub_course`
(`sub_course_id`,
`sub_course_name`,
`sub_course_duration`,
`sub_course_description`,
`video_url`,
`video_sequence`,
`course_id`)
VALUES (502,'conditaional statement in python',60,'asdsfd','videos/1.mp4',2,101);


INSERT INTO `cybage_learning`.`sub_course`
(`sub_course_id`,
`sub_course_name`,
`sub_course_duration`,
`sub_course_description`,
`video_url`,
`video_sequence`,
`course_id`)
VALUES (503,'ds in python',60,'asdsfd','videos/1.mp4',3,101);


INSERT INTO `cybage_learning`.`sub_course`
(`sub_course_id`,
`sub_course_name`,
`sub_course_duration`,
`sub_course_description`,
`video_url`,
`video_sequence`,
`course_id`)
VALUES (504,'oop to python',120,'asdsfd','videos/1.mp4',4,101);



INSERT INTO `cybage_learning`.`sub_course`
(`sub_course_id`,
`sub_course_name`,
`sub_course_duration`,
`sub_course_description`,
`video_url`,
`video_sequence`,
`course_id`)
VALUES (505,'networking to python',90,'asdsfd','videos/1.mp4',5,101);




INSERT INTO `cybage_learning`.`user`
(`user_id`,
`full_name`,
`user_name`,
`user_password`,
`user_role`,
`user_security_question`,
`user_security_answer`)
VALUES(1001,'Amir Jadahv','amirjadhav','amir','user','fav color','black');


CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `user_role` varchar(10) DEFAULT 'user',
  `user_security_question` varchar(100) DEFAULT NULL,
  `user_security_answer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


drop table user;
  
INSERT INTO `cybage_learning`.`enrolled_course`
(`enrollment_id`,
`purchase_date`,
`course_price`,
`current_video`,
`course_complete`,
`course_id`,
`user_id`,
`certificate_url`)
VALUES (501,'2021-01-01',500,1,false,101,1001,'sdfhkjlghjh');

CREATE TABLE `enrolled_course` (
  `enrollment_id` int DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  `course_price` int DEFAULT NULL,
  `current_video` int DEFAULT 1,
  `course_complete` tinyint DEFAULT NULL,
  `course_id` int NOT NULL,
  `user_id` int NOT NULL,
  `certificate_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`user_id`),
  KEY `enrolled_course_user_fk` (`user_id`),
  CONSTRAINT `enrolled_course_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE,
  CONSTRAINT `enrolled_course_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `enrolled_course_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `enrolled_course_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




select * from category;

select * from course;

select * from sub_course;

select * from user;