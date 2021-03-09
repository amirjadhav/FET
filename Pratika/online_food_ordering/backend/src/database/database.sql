-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: fooddelievery
-- ------------------------------------------------------
-- Server version	8.0.22

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

INSERT INTO address VALUES (1,1001,'Home','Viman Nagar',NULL,NULL),(2,1002,'Home','Bhugaon',NULL,NULL),(3,1003,'Home','Kharadi',NULL,NULL),(4,1004,'Office','Cybage',NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

INSERT INTO category VALUES (10,'Starters'),(11,'Breakfast'),(12,'Main Course'),(13,'Breads'),(14,'Desserts'),(15,'Beverages');

--
-- Table structure for table `deliveryperson`
--

DROP TABLE IF EXISTS deliveryperson;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE deliveryperson (
  did int NOT NULL AUTO_INCREMENT,
  username varchar(50) DEFAULT NULL,
  contact bigint DEFAULT NULL,
  vehicleno varchar(50) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  rating float DEFAULT NULL,
  PRIMARY KEY (did)
) ENGINE=InnoDB AUTO_INCREMENT=504 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveryperson`
--

INSERT INTO deliveryperson VALUES (501,'Tony S',9876598765,'MH12TS3000','A-507, Fortaleza, Kalyani Nagar, Pune - 411013','$2b$10$9C9bJmZj465uFbIkuTi.7.vOwzzNA2b8pI5vLuzWPro9qcbQYU6xS','tony@gmail.com',4),(502,'Amit Pandey',9876598765,'MH12AS1234','Vishrantwadi','$2b$10$nIbkeneG3RKhNSpFndkOnOLkomTxLUbru2Y9ZHYRveuw7b2wgVXRy','amit@gmail.com',3),(503,'Raj Chopra',9876598765,'MH12GH4567','Aundh','$2b$10$X5IrdtOffs.kMSMLH274o.UZijgyK4ZSvJQPy6w.LQ6FenrQT/nma','raj@gmail.com',5);

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
) ENGINE=InnoDB AUTO_INCREMENT=50159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

INSERT INTO menu VALUES (50001,12,103,'Paneer Tikka Masala',205,'Veg',''),(50002,10,103,'Crispy Veg',120,'Veg',''),(50003,14,103,'Custard Faluda',150,'Veg',''),(50004,15,103,'Cold Coffee',70,'Veg',''),(50005,11,102,'Ghee Masala Dosa',100,'Veg',''),(50006,10,102,'Veg cutlet',80,'Veg',''),(50007,14,102,'Fresh Fruit Salad',110,'Veg',''),(50008,15,102,'Cold Coffee',70,'Veg',''),(50009,12,104,'Chicken Kebab Burger',200,'Non-Veg',''),(50010,12,104,'McSaver American Cheese Supreme',246,'Veg',''),(50011,14,104,'Soft Serve Hot Fudge',82.86,'Veg',''),(50012,15,104,'Cappuccino',137,'Veg',''),(50013,10,103,'Veg Lollipop',150,'Veg',''),(50014,10,103,'Veg Spring Roll',155,'Veg',''),(50015,10,103,'Paneer 65',170,'Veg',''),(50016,10,103,'Finger Chips',70,'Veg',''),(50017,10,103,'Hara Bhara Kebab',130,'Veg',''),(50018,11,103,'Plain Uttappa',70,'Veg',''),(50019,11,103,'Onion Uttappa',75,'Veg',''),(50020,11,103,'Sada Dosa',70,'Veg',''),(50021,11,103,'Masala Dosa',80,'Veg',''),(50022,11,103,'Idli Sambar',70,'Veg',''),(50023,12,103,'Dal Makhani',170,'Veg',''),(50024,12,103,'Gobi Manchurian',175,'Veg',''),(50025,12,103,'Palak Paneer',160,'Veg',''),(50026,12,103,'Mushroom Masala',155,'Veg',''),(50027,12,103,'Peas Pulav',140,'Veg',''),(50028,12,103,'Tawa Pulav',145,'Veg',''),(50029,13,103,'Roti',15,'Veg',''),(50030,13,103,'Butter Roti',20,'Veg',''),(50031,13,103,'Naan',25,'Veg',''),(50032,13,103,'Butter Naan',30,'Veg',''),(50033,13,103,'Kulcha',40,'Veg',''),(50034,14,103,'Banana Split',150,'Veg',''),(50035,14,103,'Jelly with IceCream',120,'Veg',''),(50036,14,103,'Gulab Jamun',100,'Veg',''),(50037,14,103,'Butterscotch Ribbon',145,'Veg',''),(50038,14,103,'Strawberry Milkshake',110,'Veg',''),(50039,15,103,'Pinacolada',115,'Veg',''),(50040,15,103,'Fruit Punch',100,'Veg',''),(50041,15,103,'Mosambi Juice',70,'Veg',''),(50042,10,102,'Sabudana Vada',80,'Veg',''),(50043,10,102,'Sev Puri',85,'Veg',''),(50044,10,102,'Bhel',85,'Veg',''),(50045,11,102,'Mysore Sada Dosa',110,'Veg',''),(50046,11,102,'Cheese Dosa',105,'Veg',''),(50047,11,102,'Tomato Uttappa',120,'Veg',''),(50048,11,102,'Idli Chutney',100,'Veg',''),(50049,12,102,'Veg Burger',90,'Veg',''),(50050,12,102,'Cheese Burger',95,'Veg',''),(50051,12,102,'Mushroom Pizza',140,'Veg',''),(50052,12,102,'Cheese Chilli Toast',120,'Veg',''),(50053,13,102,'Pav',20,'Veg',''),(50054,14,102,'Jelly',45,'Veg',''),(50055,15,102,'Tea',35,'Veg',''),(50056,15,102,'Green Tea',40,'Veg',''),(50057,15,102,'Hot Chocolate',50,'Veg',''),(50058,15,102,'Lime Juice',55,'Veg',''),(50059,10,104,'Fries',80,'Veg',''),(50060,10,104,'Wedges',90,'Veg',''),(50061,10,104,'Chicken Nuggets',120,'Non-Veg',''),(50062,11,104,'Hash Brown',130,'Veg',''),(50063,11,104,'McEgg',115,'Non-Veg',''),(50064,11,104,'McMuffin',145,'Veg',''),(50065,12,104,'McChicken Burger',85,'Non-Veg',''),(50066,12,104,'McSpicy Chicken Burger',160,'Non-Veg',''),(50067,13,104,'Wheat Bun',35,'Veg',''),(50068,14,104,'Chocolate Chip Muffin',113,'Veg',''),(50069,15,104,'Fountain Coke',75,'Veg',''),(50070,15,104,'Mango Smoothie',200,'Veg',''),(50071,10,101,'Chicken 65',325,'Non-Veg',''),(50072,10,101,'Chicken Tikka',425,'Non-Veg',''),(50073,10,101,'Spinach Cheese Pops',275,'Veg',''),(50074,10,101,'Malai Broccoli',295,'Veg',''),(50075,12,101,'Veg Thai Curry',325,'Veg',''),(50076,12,101,'Ghee Roast Chole',350,'Veg',''),(50077,12,101,'Shahi Paneer Biryani',395,'Veg',''),(50078,12,101,'Butter Chicken',395,'Non-Veg',''),(50079,12,101,'Prawns Biryani',475,'Non-Veg',''),(50080,13,101,'Roti',50,'Veg',''),(50081,13,101,'Butter Roti',55,'Veg',''),(50082,13,101,'Naan',60,'Veg',''),(50083,13,101,'Butter Naan',70,'Veg',''),(50084,14,101,'Cheesecake',215,'Veg',''),(50085,14,101,'Sitaphal Rabri',175,'Veg',''),(50086,15,101,'Red Bull',200,'Veg',''),(50087,15,101,'Ginger Ale',100,'Veg',''),(50088,10,105,'Veggie Strips',49,'Veg',''),(50089,10,105,'Chicken Fries',79,'Non-Veg',''),(50090,12,105,'Veg Whopper',149,'Veg',''),(50091,12,105,'Chicken Whopper',149,'Non-Veg',''),(50092,12,105,'Crispy Chicken Burger',120,'Non-Veg',''),(50093,11,105,'King Egg Burger',59,'Non-Veg',''),(50094,14,105,'Brownie',49,'Veg',''),(50095,15,105,'Pepsi can',57,'Veg',''),(50096,15,105,'Latte',99,'Veg',''),(50097,10,106,'Pav Bhaji',120,'Veg',''),(50098,10,106,'Pani Puri',100,'Veg',''),(50099,11,106,'Set Dosa',110,'Veg',''),(50100,11,106,'Onion Chilli Dosa',130,'Veg',''),(50101,12,106,'Paratha Bhaji',120,'Veg',''),(50102,13,106,'Pav',20,'Veg',''),(50103,13,106,'Masala Pav',30,'Veg',''),(50104,14,106,'Kulfi',50,'Veg',''),(50105,14,106,'Walnut Brownie',170,'Veg',''),(50106,15,106,'Sweet Lassi',90,'Veg',''),(50107,15,106,'Buttermilk',60,'Veg',''),(50108,10,107,'Masala Papad',50,'Veg',''),(50109,10,107,'Mushroom 65',120,'Veg',''),(50110,11,107,'Rava Sada Dosa',90,'Veg',''),(50111,11,107,'Rava Masala Dosa',95,'Veg',''),(50112,12,107,'Paneer Kadai',130,'Veg',''),(50113,12,107,'Veg Banjara',140,'Veg',''),(50114,12,107,'Paneer Kofta',155,'Veg',''),(50115,13,107,'Paratha',20,'Veg',''),(50116,13,107,'Garlic Naan',35,'Veg',''),(50117,13,107,'Roti',20,'Veg',''),(50118,14,107,'Gulab Jamun',45,'Veg',''),(50119,15,107,'Fresh Lime Soda',30,'Veg',''),(50120,15,107,'Rose Lassi',50,'Veg',''),(50121,10,108,'Paneer Chilli',150,'Veg',''),(50122,10,108,'Veg Reshmi Kebab',220,'Veg',''),(50123,10,108,'Chicken Lollipop',250,'Non-Veg',''),(50124,11,108,'Anda Thali',180,'Non-Veg',''),(50125,11,108,'Shreemant Thali',200,'Veg',''),(50126,12,108,'Matar Paneer',170,'Veg',''),(50127,12,108,'Bhindi Fry',100,'Veg',''),(50128,12,108,'Chicken Sagoti',250,'Non-Veg',''),(50129,13,108,'Roti',30,'Veg',''),(50130,13,108,'Butter Roti',35,'Veg',''),(50131,14,108,'Puran Poli',70,'Veg',''),(50132,14,108,'Gajar Halwa',80,'Veg',''),(50133,15,108,'Tea',30,'Veg',''),(50134,15,108,'Coffee',30,'Veg',''),(50135,10,109,'Chicken DimSum',230,'Non-Veg',''),(50136,10,109,'Shrimp Popcorn',300,'Non-Veg',''),(50137,10,109,'Cheese Samosas',200,'Veg',''),(50138,11,109,'Pancakes',270,'Veg',''),(50139,11,109,'Irani Omelette',190,'Non-Veg',''),(50140,12,109,'Khao Suey',300,'Non-Veg',''),(50141,12,109,'BBQ Pork Ribs',390,'Non-Veg',''),(50142,12,109,'Veg Triple Schezwan',310,'Veg',''),(50143,13,109,'Pita Bread',150,'Veg',''),(50144,14,109,'Layer Cake',190,'Veg',''),(50145,14,109,'Blueberry Cheesecake',250,'Veg',''),(50146,15,109,'Kit Kat Shake',195,'Veg',''),(50147,15,109,'Cafe Mocha',120,'Veg',''),(50148,10,110,'Sesame Toast',179,'Veg',''),(50149,10,110,'Hakka Chicken',229,'Non-Veg',''),(50150,11,110,'Foo Young',129,'Non-Veg',''),(50151,12,110,'Wonton Noodles',219,'Veg',''),(50152,12,110,'Schezwan Noodles',229,'Veg',''),(50153,12,110,'Chicken Chowmein',249,'Non-Veg',''),(50154,12,110,'Peking Chicken',249,'Non-Veg',''),(50155,14,110,'Caramel Custard',175,'Veg',''),(50156,14,110,'Honey Noodles w IceCream',200,'Veg',''),(50157,15,110,'Coke',60,'Veg',''),(50158,15,110,'Lime Soda',70,'Veg','');

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

INSERT INTO orderitems VALUES (1,10001,50065,1),(2,10001,50068,1),(3,10001,50012,1),(4,10003,50099,1),(5,10003,50104,1),(6,10005,50112,1),(7,10005,50115,1),(9,10007,50130,1),(10,10007,50126,1),(11,10006,50013,1),(12,10006,50021,1),(13,10006,50028,1),(14,10004,50154,1),(15,10004,50155,1),(16,10004,50148,1),(17,10008,50112,1),(18,10008,50116,1),(19,10008,50118,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=10013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

INSERT INTO orders VALUES (10001,1001,104,501,'09:16 AM','2021-03-03',401.75,'Viman Nagar',NULL,NULL,'Delivered',4,4,87445),(10002,1001,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cart',NULL,NULL,NULL),(10003,1002,106,503,'09:18 AM','2021-03-03',218,'Bhugaon',NULL,NULL,'Delivered',4,5,67734),(10004,1002,110,502,'09:48 AM','2021-03-03',683.15,'Bhugaon',NULL,NULL,'Accepted',NULL,NULL,72651),(10005,1003,107,502,'09:20 AM','2021-03-03',207.5,'Kharadi',NULL,NULL,'Delivered',3,3,69425),(10006,1003,103,NULL,'09:47 AM','2021-03-03',443.75,'Kharadi',NULL,NULL,'Ordered',NULL,NULL,NULL),(10007,1004,108,501,'09:22 AM','2021-03-03',265.25,'Cybage',NULL,NULL,'Delivered',5,4,95826),(10008,1004,107,NULL,'09:49 AM','2021-03-03',270.5,'Cybage',NULL,NULL,'Ordered',NULL,NULL,NULL),(10010,1003,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cart',NULL,NULL,NULL),(10011,1002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cart',NULL,NULL,NULL),(10012,1004,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cart',NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

INSERT INTO restaurant VALUES (101,'The Urban Foundry','1, Balewadi High St, next to Cummins India Office, Laxman Nagar, Balewadi, Pune, Maharashtra 411045','Veg/Non-Veg',8983001155,'The Urban Foundry is a multifunctional restaurant .It acts as a co working space, a meeting place, a restaurant and a high tea joint in a day,',73.774532,18.569292,'1300','0100',3,'https://b.zmtcdn.com/data/pictures/0/18688440/504f50955bb01bd4c0940666356eb51a.jpg',400),(102,'Vaishali','Fergusson College Rd, Rage Path, Ganeshwadi, Shivajinagar, Pune, Maharashtra 411004','Veg',25531244,'Being a legend in serving South-Indian food.',73.84118631947064,18.521057325093537,'0700','2300',2,'https://b.zmtcdn.com/data/pictures/5/10125/757370688da5d44f4bedaedaa83f880e.jpg',200),(103,'Kalyani Veg Restaurant','Fortaleza Complex, 5, Central Ave, Princeton Town Society, Prathamesh Society, Kalyani Nagar, Pune, Maharashtra 411006','Veg',64004965,'Variety of Vegetarian delicacies',73.90560786361056,18.545872886091242,'0800','2300',4,'https://b.zmtcdn.com/data/reviews_photos/210/77ff839f26e1f868e5feae5710180210_1536395032.jpg',250),(104,'McDonald\'s','Marigold Complex, Sy No 15, Gr floor, Kalyani Nagar - Wadgaon Sheri Rd, Pune, Maharashtra 411015','Veg/Non-Veg',8928304027,'Classic,long-running fast-food chain ',73.90631036854177,18.545834792860852,'0800','2200',4,'/assets/images/McDonalds.jpg',200),(105,'Burger King','S 25, 2nd Flr, Phoenix Market City Mall, Viman Nagar Rd, Pune, Maharashtra 411013','Veg/Non-Veg',2048624150,'chain serving grilled burgers, fries & shakes, plus breakfast.',73.91687694340567,18.562320325794715,'1000','2300',3,'/assets/images/BurgerKing.jpg',150),(106,'Wadeshwar','Landmark Garden, Sr No 16/1, Mulik Nagar, Opposite, Society, Kalyani Nagar, Pune, Maharashtra 411006','Veg',9607008956,'Informal venue for quick serve Indian snacks ',73.90614605504875,18.549163759725843,'0730','2300',4,'https://b.zmtcdn.com/data/pictures/8/10128/8055c1d35e1838fb2d4a84936ea53e9b.jpg',150),(107,'RamKrishna Restaurant','6, Moledina Road, Opposite Westend Theatre, Camp, Pune, Maharashtra 411001','Veg',9607008956,'Dishes from across India are prepared with the absence of meat',73.87862792698594,18.519730768515373,'0800','2200',3,'https://content3.jdmagicbox.com/comp/pune/94/020p5081594/catalogue/rama-krishna-restaurant-camp-pune-north-indian-restaurants-44mf8j4.jpg',250),(108,'Shreemant Veg NonVeg Family Restaurant','R Pathare Galaxy, Kharadi Magarpatta Bypass Rd Sainathnagar Chowk, Kharadi, next to Columbia Asia hospital, Pune, Maharashtra 411014','Veg/Non-Veg',9707008756,'A trusted place to savor the authentic food delicacies',73.9338807865372,18.54369396078154,'0700','2300',5,'https://content3.jdmagicbox.com/comp/def_content/restaurants/default-restaurants-12.jpg',300),(109,'Social','3rd Floor, Phoenix Marketcity, Viman Nagar Road, Viman Nagar, Pune, Maharashtra, 411014','Veg/Non-Veg',9707008788,'A go-to place for the people young or old, bright and bold',73.91685304562533,18.562560702455396,'1800','0200',4.2,'https://www.socialoffline.in/img/viman-nagar-social-05.jpg',500),(110,'Chang\'s','Kashmiri Sounf Rd, Clover Park, Viman Nagar, Pune, Maharashtra 411014','Veg/Non-Veg',9722008788,'A go-to place for the people young or old, bright and bold',73.91399447342882,18.56533328491266,'0800','2330',3.5,'https://cdn.vox-cdn.com/thumbor/waNVPs6KNPrmptb8-nuurZZrsN4=/42x0:956x686/1200x900/filters:focal(42x0:956x686)/cdn.vox-cdn.com/uploads/chorus_image/image/52453689/shutterstock_446808100.0.0.jpeg',450);

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
  `password` varchar(500) DEFAULT NULL,
  phone bigint DEFAULT NULL,
  image varchar(100) DEFAULT NULL,
  PRIMARY KEY (userid)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

INSERT INTO user VALUES (1001,'Anahita Dinesh','anahitad@cybage.com','$2b$10$eJwWhU02b0jHpGxNE6LXB./smRJw7Cvj443Hiqz9kdpw7Yn2GU7f.',9876598765,NULL),(1002,'Atharva Devasthali','atharvadev@cybage.com','$2b$10$Tov06XRDCk79aL4qJBKpz.J9b.IG5Omfv/cjGTs9DNPqenx9vn9.C',9876598765,NULL),(1003,'Pratika Girme','pratikagi@cybage.com','$2b$10$lLCHKWa5.OilMLJXU20q8euCJzFKo/uydrPHxdpbUSeBOHMgTg5ay',9876598765,NULL),(1004,'Varad Bhagwat','varadb@cybage.com','$2b$10$hbb/u3jpHQKVmyecHihKM.fK1q9BLZ5RBDw3Qh9xhP83Z5/Etj6i.',9876598765,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
