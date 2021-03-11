-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cybage_learning
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS category;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE category (
  category_id int NOT NULL AUTO_INCREMENT,
  category_name varchar(255) DEFAULT NULL,
  image_url varchar(500) DEFAULT NULL,
  PRIMARY KEY (category_id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES category WRITE;
/*!40000 ALTER TABLE category DISABLE KEYS */;
INSERT INTO category VALUES (1,'development','xyz'),(2,'music','xyz');
/*!40000 ALTER TABLE category ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS comment;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  commentid int NOT NULL AUTO_INCREMENT,
  comment_description varchar(1000) DEFAULT NULL,
  course_id int NOT NULL,
  sub_courseid int NOT NULL,
  userid int NOT NULL,
  PRIMARY KEY (commentid),
  KEY FKdsub2q6m6519rpas8b075fr7m (course_id),
  KEY FK7au2w6o52cfrdkhe27du6yvhk (sub_courseid),
  KEY FKe7pshbkin4984x23q4wboi5ka (userid),
  CONSTRAINT FK7au2w6o52cfrdkhe27du6yvhk FOREIGN KEY (sub_courseid) REFERENCES sub_course (sub_course_id) ON DELETE CASCADE,
  CONSTRAINT FKdsub2q6m6519rpas8b075fr7m FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE,
  CONSTRAINT FKe7pshbkin4984x23q4wboi5ka FOREIGN KEY (userid) REFERENCES `user` (user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES comment WRITE;
/*!40000 ALTER TABLE comment DISABLE KEYS */;
/*!40000 ALTER TABLE comment ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS course;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE course (
  course_id int NOT NULL AUTO_INCREMENT,
  course_author varchar(255) DEFAULT NULL,
  course_description varchar(500) DEFAULT NULL,
  course_duration int NOT NULL,
  course_name varchar(255) DEFAULT NULL,
  course_price double NOT NULL,
  image_url varchar(500) DEFAULT NULL,
  likes int NOT NULL,
  total_marks int NOT NULL,
  total_sub_course int NOT NULL,
  category_id int NOT NULL,
  PRIMARY KEY (course_id),
  KEY FKkyes7515s3ypoovxrput029bh (category_id),
  CONSTRAINT FKkyes7515s3ypoovxrput029bh FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES course WRITE;
/*!40000 ALTER TABLE course DISABLE KEYS */;
INSERT INTO course VALUES (101,'amir jadhav','sdl;hj.klkdjglnjlkmnlvjggj',3,'python',349,'dlkhklgjhgi',23,10,5,1),(102,'pratika','gjlnd;ltihjlkbjlkbjljl',4,'java',678,'jglkjkldsghkl',56,10,6,1);
/*!40000 ALTER TABLE course ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrolled_course`
--

DROP TABLE IF EXISTS enrolled_course;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE enrolled_course (
  certificate_url varchar(1000) DEFAULT NULL,
  current_video int NOT NULL,
  enrollment_id int NOT NULL,
  is_completed bit(1) NOT NULL,
  purchase_date date DEFAULT NULL,
  purchase_price int NOT NULL,
  userid int NOT NULL,
  course_id int NOT NULL,
  PRIMARY KEY (userid,course_id),
  UNIQUE KEY UK_koscf1nahlqproxh24x8j1g5f (userid),
  UNIQUE KEY UK_ovkkoxso9ofprvhoo4n58ww2 (course_id),
  CONSTRAINT FK7ymxj31qf504o3u6sxmrx8mw1 FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE,
  CONSTRAINT FKel8yr1hhd0ub8x5b8po8bho2k FOREIGN KEY (userid) REFERENCES `user` (user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrolled_course`
--

LOCK TABLES enrolled_course WRITE;
/*!40000 ALTER TABLE enrolled_course DISABLE KEYS */;
/*!40000 ALTER TABLE enrolled_course ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS feedback;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE feedback (
  feedback_description varchar(1000) DEFAULT NULL,
  feedbackid int NOT NULL,
  rating int DEFAULT NULL,
  userid int NOT NULL,
  course_id int NOT NULL,
  PRIMARY KEY (userid,course_id),
  UNIQUE KEY UK_oqwyjt3aohc0mthu8a4io6xog (userid),
  UNIQUE KEY UK_kfo61hxchiey9l61y8mdit9fr (course_id),
  CONSTRAINT FK8ovbalatnni3umwdguuw66d6r FOREIGN KEY (userid) REFERENCES `user` (user_id) ON DELETE CASCADE,
  CONSTRAINT FKko7f08v61t5y67teh5jxxwrea FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES feedback WRITE;
/*!40000 ALTER TABLE feedback DISABLE KEYS */;
/*!40000 ALTER TABLE feedback ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS question;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE question (
  question_id int NOT NULL AUTO_INCREMENT,
  answer int NOT NULL,
  option1 varchar(255) DEFAULT NULL,
  option2 varchar(255) DEFAULT NULL,
  option3 varchar(255) DEFAULT NULL,
  option4 varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  course_id int NOT NULL,
  PRIMARY KEY (question_id),
  KEY FKnbqlwvoi94mkynn6c3r5h8dlg (course_id),
  CONSTRAINT FKnbqlwvoi94mkynn6c3r5h8dlg FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES question WRITE;
/*!40000 ALTER TABLE question DISABLE KEYS */;
/*!40000 ALTER TABLE question ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS result;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE result (
  marks int NOT NULL,
  result_id int NOT NULL,
  userid int NOT NULL,
  course_id int NOT NULL,
  PRIMARY KEY (userid,course_id),
  UNIQUE KEY UK_sybc76vfjh6t8s7fenjkdcyvd (userid),
  UNIQUE KEY UK_fws1lo1pc1nl4w2jhj9c0y0gl (course_id),
  CONSTRAINT FKiaivms53vxdysiuul3btaux9c FOREIGN KEY (userid) REFERENCES `user` (user_id) ON DELETE CASCADE,
  CONSTRAINT FKmi3c9lk3q0l0h44birpp0j0ld FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES result WRITE;
/*!40000 ALTER TABLE result DISABLE KEYS */;
/*!40000 ALTER TABLE result ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_course`
--

DROP TABLE IF EXISTS sub_course;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE sub_course (
  sub_course_id int NOT NULL AUTO_INCREMENT,
  sub_course_description varchar(500) DEFAULT NULL,
  sub_course_name varchar(255) DEFAULT NULL,
  video_sequence int NOT NULL,
  video_url varchar(500) DEFAULT NULL,
  courseid int NOT NULL,
  PRIMARY KEY (sub_course_id),
  KEY FKb4m2wb9yux8huoa0oeigndwxq (courseid),
  CONSTRAINT FKb4m2wb9yux8huoa0oeigndwxq FOREIGN KEY (courseid) REFERENCES course (course_id) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_course`
--

LOCK TABLES sub_course WRITE;
/*!40000 ALTER TABLE sub_course DISABLE KEYS */;
INSERT INTO sub_course VALUES (501,'BASIC OF JAVA','introduction to java',1,'sjghkhg',102);
/*!40000 ALTER TABLE sub_course ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS user;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  user_id int NOT NULL AUTO_INCREMENT,
  is_locked bit(1) NOT NULL,
  is_prime bit(1) NOT NULL,
  is_req_unlock bit(1) NOT NULL,
  login_attempt int NOT NULL,
  opt int DEFAULT NULL,
  user_email varchar(255) DEFAULT NULL,
  user_name varchar(255) DEFAULT NULL,
  user_password varchar(255) DEFAULT NULL,
  user_role varchar(255) DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES user WRITE;
/*!40000 ALTER TABLE user DISABLE KEYS */;
/*!40000 ALTER TABLE user ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS user_profile;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE user_profile (
  user_profile_id int NOT NULL AUTO_INCREMENT,
  address varchar(500) DEFAULT NULL,
  dob date DEFAULT NULL,
  education varchar(255) DEFAULT NULL,
  full_name varchar(255) DEFAULT NULL,
  image_url varchar(500) DEFAULT NULL,
  userid int NOT NULL,
  PRIMARY KEY (user_profile_id),
  UNIQUE KEY UK_kcoq7jicvcj9akokmq0kxe4ik (userid),
  CONSTRAINT FKjxrg56bgx3rr6jew2duc7u65x FOREIGN KEY (userid) REFERENCES `user` (user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES user_profile WRITE;
/*!40000 ALTER TABLE user_profile DISABLE KEYS */;
/*!40000 ALTER TABLE user_profile ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
