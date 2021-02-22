-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: fooddelievery
-- ------------------------------------------------------
-- Server version	8.0.22

--
-- Create or drop database and use the database 
--


drop database fooddelievery;
create database fooddelievery;
use fooddelievery;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS address;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE address (
  id int NOT NULL AUTO_INCREMENT,
  userid int DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  longitude double DEFAULT NULL,
  latitude double DEFAULT NULL,
  PRIMARY KEY (id),
  KEY userid_idx (userid),
  CONSTRAINT userid FOREIGN KEY (userid) REFERENCES `user` (userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


insert into address values(11,1001,"Home","SaiNagari Society Sarita Vihar Phase 2, Dattawadi, Pune, Maharashtra 411030",18.548540239703822, 73.89867110716138);
insert into address values(12,1002,"Home","Fortaleza Co-operative Housing Society Central Ave, Opp Gold Big Cinemas, Prathamesh Society, Kalyani Nagar, Pune, Maharashtra 411006",18.543673836060997, 73.90481273572782);
insert into address values(13,1003,"Home","Societyhive  First Floor, Ganga Commerce, Lane 5, N Main Rd, Koregaon Park, Pune, Maharashtra 411001",18.53959248370099, 73.89612754172073);
insert into address values(14,1004,"Home","Amrapalishree Society ,Aga Khan Palace Park, near, Palace View Society, Kalyani Nagar, Pune, Maharashtra 411006",18.55366320064216, 73.90382099828598);
insert into address values(15,1005,"Home","Samrat Housing Society ,212/NO 7, Lane Number 7, Samrat Cooperative Housing Society, Princeton Town Society, Nilanjali Society, Kalyani Nagar, Pune, Maharashtra 411006,",18.546098803066364, 73.90384521668048);

--
-- Dumping data for table `address`
--


--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS category;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE category (
  cid int NOT NULL AUTO_INCREMENT,
  cname varchar(100) DEFAULT NULL,
  PRIMARY KEY (cid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


insert into category values(10, 'Starters');
insert into category values(11, 'Breakfast');
insert into category values(12, 'Main Course');
insert into category values(13, 'Desserts');
insert into category values(14, 'Beverages');

--
-- Dumping data for table `category`
--


--
-- Table structure for table `deliveryperson`
--

DROP TABLE IF EXISTS deliveryperson;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE deliveryperson (
  did int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  contact bigint DEFAULT NULL,
  vehicleno varchar(50) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  rating float DEFAULT NULL,
  PRIMARY KEY (did)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


insert into deliveryperson values (501,'Mark',9876543217,'MH27AB7899','klayani Nagar Pune','Mark@123','mark@gmail.com',5);
insert into deliveryperson values (502,'Axel',9876343211,'MH27AB7999','Rathi Nagar Amravati','Axel@123','axel@gmail.com',4);
insert into deliveryperson values (503,'Robin',9876543245,'MH27AB5899','Malagi Nagar Nagpur','Robin@123','robin@gmail.com',3);
insert into deliveryperson values (504,'Midoria',9876543234,'MH27AB7399','Viman Nagar Pune','Midoria@123','midoria@gmail.com',2);
insert into deliveryperson values (505,'Bakugo',9876543207,'MH27AB5799','Galge Nagar Amravati','Bakugo@123','bakugo@gmail.com',1);


--
-- Dumping data for table `deliveryperson`
--


--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS menu;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE menu (
  mid int NOT NULL AUTO_INCREMENT,
  cid int DEFAULT NULL,
  restid int DEFAULT NULL,
  itemname varchar(50) DEFAULT NULL,
  price double DEFAULT NULL,
  foodtype enum('Veg','Non-Veg') DEFAULT NULL,
  image varchar(255) DEFAULT NULL,
  PRIMARY KEY (mid),
  KEY cid_idx (cid),
  KEY restid_idx (restid),
  CONSTRAINT cid FOREIGN KEY (cid) REFERENCES category (cid),
  CONSTRAINT restid FOREIGN KEY (restid) REFERENCES restaurant (rid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


insert into menu values(50001,12,103,"Paneer Tikka Masala",205,"Veg","");
insert into menu values(50002,10,103,"Crispy Veg",120,"Veg","");
insert into menu values(50003,13,103,"Custard Faluda",150,"Veg","");
insert into menu values(50004,14,103,"Cold Coffee",70,"Veg","");

insert into menu values(50005,11,102,"Ghee Masala Dosa",100,"Veg","");
insert into menu values(50006,11,102,"Veg cutlet",80,"Veg","");
insert into menu values(50007,13,102,"Fresh Fruit Salad",110,"Veg","");
insert into menu values(50008,14,102,"Cold Coffee",70,"Veg","");

insert into menu values(50009,12,104,"Chicken Kebab Burger",200,"Non-Veg","");
insert into menu values(50010,12,104,"McSaver American Cheese Supreme",246,"Veg","");
insert into menu values(50011,13,104,"Soft Serve Hot Fudge",82.86,"Veg","");
insert into menu values(50012,14,104,"Cappuccino",137,"Veg","");

--
-- Dumping data for table `menu`
--


--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS orderitems;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE orderitems (
  srno int NOT NULL AUTO_INCREMENT,
  oid int DEFAULT NULL,
  mid int DEFAULT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (srno),
  KEY oid_idx (oid),
  KEY mid_idx (mid),
  CONSTRAINT mid FOREIGN KEY (mid) REFERENCES menu (mid),
  CONSTRAINT oid FOREIGN KEY (oid) REFERENCES orders (oid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO orderitems VALUES (1,10005,50001,2);
--
-- Dumping data for table `orderitems`
--


--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS orders;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE orders (
  oid int NOT NULL AUTO_INCREMENT,
  uid int DEFAULT NULL,
  rid int DEFAULT NULL,
  did int DEFAULT NULL,
  ordertime varchar(10) DEFAULT NULL,
  orderdate date DEFAULT NULL,
  price float DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  longitude double DEFAULT NULL,
  latitude double DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  rrating int DEFAULT NULL,
  drating int DEFAULT NULL,
  otp bigint DEFAULT NULL,
  PRIMARY KEY (oid),
  KEY userid_idx (uid),
  KEY rid_idx (rid),
  KEY did_idx (did),
  CONSTRAINT did FOREIGN KEY (did) REFERENCES deliveryperson (did),
  CONSTRAINT rid FOREIGN KEY (rid) REFERENCES restaurant (rid),
  CONSTRAINT uid FOREIGN KEY (uid) REFERENCES `user` (userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO orders VALUES (10000,1001,101,501,'1200','2020-02-03',100,'SaiNagari Society Sarita Vihar Phase 2, Dattawadi, Pune, Maharashtra 411030',18.548540239703822,73.89867110716138,'Delivered',4,5,1234),(10001,1002,101,501,'1200','2020-02-03',100,'SaiNagari Society Sarita Vihar Phase 2, Dattawadi, Pune, Maharashtra 411030',18.548540239703822,73.89867110716138,'Cart',4,5,5678),(10004,1001,101,501,'1200','2020-02-03',100,'SaiNagari Society Sarita Vihar Phase 2, Dattawadi, Pune, Maharashtra 411030',18.548540239703826,73.89867110716138,'Delivered',4,5,1234),(10005,1001,101,501,'1200','2020-02-03',100,'SaiNagari Society Sarita Vihar Phase 2, Dattawadi, Pune, Maharashtra 411030',18.548540239703826,73.89867110716138,'Delivered',4,5,1234);
--
-- Dumping data for table `orders`
--


--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS restaurant;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE restaurant (
  rid int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  foodtype enum('Veg','Veg/Non-Veg') DEFAULT NULL,
  contact bigint DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  longitude double DEFAULT NULL,
  latitude double DEFAULT NULL,
  starttime varchar(10) DEFAULT NULL,
  endtime varchar(10) DEFAULT NULL,
  rating float DEFAULT NULL,
  image varchar(255) DEFAULT NULL,
  perperson int DEFAULT NULL,
  PRIMARY KEY (rid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


insert into restaurant values(101,"The Urban Foundry","1, Balewadi High St, next to Cummins India Office, Laxman Nagar, Balewadi, Pune, Maharashtra 411045","Veg/Non-Veg",8983001155,"The Urban Foundry is a multifunctional restaurant .It acts as a co working space, a meeting place, a restaurant and a high tea joint in a day,",73.774532,18.569292,"1200","0100",3,"https://b.zmtcdn.com/data/pictures/0/18688440/504f50955bb01bd4c0940666356eb51a.jpg",400);
insert into restaurant values(102,"Vaishali","Fergusson College Rd, Rage Path, Ganeshwadi, Shivajinagar, Pune, Maharashtra 411004","Veg",25531244,"Being a legend in serving South-Indian food.",73.84118631947064,18.521057325093537,"0700","2300" ,2, "https://b.zmtcdn.com/data/pictures/5/10125/757370688da5d44f4bedaedaa83f880e.jpg",200);
insert into restaurant values(103,"Kalyani Veg Restaurant","Fortaleza Complex, 5, Central Ave, Princeton Town Society, Prathamesh Society, Kalyani Nagar, Pune, Maharashtra 411006","Veg",64004965,"Variety of Vegetarian delicacies",73.90560786361056,18.545872886091242,"0800","2300",4,"https://b.zmtcdn.com/data/reviews_photos/210/77ff839f26e1f868e5feae5710180210_1536395032.jpg",250);
insert into restaurant values(104,"McDonald's","Marigold Complex, Sy No 15, Gr floor, Kalyani Nagar - Wadgaon Sheri Rd, Pune, Maharashtra 411015","Veg/Non-Veg",8928304027,"Classic,long-running fast-food chain ",73.90631036854177,18.545834792860852,"1000","2200",1,"/assets/images/McDonalds.jpg",200);
insert into restaurant values(105,"Burger King","S 25, 2nd Flr, Phoenix Market City Mall, Viman Nagar Rd, Pune, Maharashtra 411013","Veg/Non-Veg",2048624150,"chain serving grilled burgers, fries & shakes, plus breakfast.",73.91687694340567,18.562320325794715,"1000","2300",3,"/assets/images/BurgerKing.jpg",150);
insert into restaurant values(106,"Wadeshwar","Landmark Garden, Sr No 16/1, Mulik Nagar, Opposite, Society, Kalyani Nagar, Pune, Maharashtra 411006","Veg",9607008956,"Informal venue for quick serve Indian snacks ",73.90614605504875,18.549163759725843,"0730","2300",4, "https://b.zmtcdn.com/data/pictures/8/10128/8055c1d35e1838fb2d4a84936ea53e9b.jpg", 150);
insert into restaurant values(107,"RamKrishna Restaurant","6, Moledina Road, Opposite Westend Theatre, Camp, Pune, Maharashtra 411001","Veg",9607008956,"Dishes from across India are prepared with the absence of meat", 73.87862792698594,18.519730768515373,"1100","2200",2,"https://content3.jdmagicbox.com/comp/pune/94/020p5081594/catalogue/rama-krishna-restaurant-camp-pune-north-indian-restaurants-44mf8j4.jpg",250);
insert into restaurant values(108,"Shreemant Veg NonVeg Family Restaurant","R Pathare Galaxy, Kharadi Magarpatta Bypass Rd Sainathnagar Chowk, Kharadi, next to Columbia Asia hospital, Pune, Maharashtra 411014","Veg/Non-Veg",9707008756,"A trusted place to savor the authentic food delicacies",73.9338807865372,18.54369396078154,"0700","2300",4,"https://content3.jdmagicbox.com/comp/def_content/restaurants/default-restaurants-12.jpg",300);


--
-- Dumping data for table `restaurant`
--


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS user;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  userid int NOT NULL AUTO_INCREMENT,
  username varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  phone bigint DEFAULT NULL,
  image varchar(100) DEFAULT NULL,
  PRIMARY KEY (userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


insert into user values(1001,'Rishav Singh','rsingh676@gmail.com','Rishav@123',9599377747,'');
insert into user values(1002,'Hemant Kumar Singh','hemantgtx950@gmail.com','Hemant@123',9350104991,'');
insert into user values(1003,'Mayank Singh','mk123@gmail.com','Mayank@123',9818455760,'');
insert into user values(1004,'Rajat Tiwari','rjt123@gmail.com','Rajat@123',9871780655,'');
insert into user values(1005,'Dhruv Rawat','dhrt123@gmail.com','Dhruv@123',9993337777,'');

--
-- Dumping data for table `user`
--


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
