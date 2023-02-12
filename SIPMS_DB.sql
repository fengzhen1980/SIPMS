CREATE DATABASE  IF NOT EXISTS `sipms_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sipms_db`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: sipms_db
-- ------------------------------------------------------
-- Server version	5.7.28-log

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
-- Table structure for table `t_course`
--

DROP TABLE IF EXISTS `t_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_course` (
  `COURSE_NO` varchar(10) CHARACTER SET latin1 NOT NULL,
  `COURSE_TITLE` varchar(50) CHARACTER SET latin1 NOT NULL,
  `COURSE_HOURS` int(11) DEFAULT NULL,
  `TEACHER_USER_ID` varchar(32) CHARACTER SET latin1 NOT NULL,
  `COURSE_DESCRIPTION` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`COURSE_NO`),
  KEY `course_user_idx` (`TEACHER_USER_ID`),
  CONSTRAINT `course_user` FOREIGN KEY (`TEACHER_USER_ID`) REFERENCES `t_user` (`USER_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course`
--

LOCK TABLES `t_course` WRITE;
/*!40000 ALTER TABLE `t_course` DISABLE KEYS */;
INSERT INTO `t_course` VALUES ('1001','aaabbbccc',NULL,'TEACHER006',NULL),('201-911-VA','MATH LOGIC FOR THE SOFTWARE PROFESSION',60,'TEACHER001',NULL),('420-910-VA','PROGRAMMING CONCEPTS 1',105,'TEACHER002',NULL),('420-911-VA','OPERATING SYSTEMS',90,'TEACHER003',NULL),('420-921-VA','DATABASE',105,'TEACHER004',NULL),('420-931-VA','FRONT-END WEB PROGRAMMING',102,'TEACHER005',NULL),('A001-01-01','coding course',NULL,'TEACHER007',NULL);
/*!40000 ALTER TABLE `t_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_grade`
--

DROP TABLE IF EXISTS `t_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_grade` (
  `COURSE_NO` varchar(10) CHARACTER SET latin1 NOT NULL,
  `STUDENT_USER_ID` varchar(32) CHARACTER SET latin1 NOT NULL,
  `GRADE_VALUE` varchar(45) CHARACTER SET latin1 NOT NULL,
  `GRADE_COMMENT` varchar(300) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`COURSE_NO`,`STUDENT_USER_ID`),
  KEY `g_course_student_idx` (`STUDENT_USER_ID`),
  CONSTRAINT `g_course_student` FOREIGN KEY (`STUDENT_USER_ID`) REFERENCES `t_user` (`USER_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `g_course_user` FOREIGN KEY (`COURSE_NO`) REFERENCES `t_course` (`COURSE_NO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_grade`
--

LOCK TABLES `t_grade` WRITE;
/*!40000 ALTER TABLE `t_grade` DISABLE KEYS */;
INSERT INTO `t_grade` VALUES ('201-911-VA','STUDENT001','100','very good'),('201-911-VA','STUDENT002','90','comment001'),('201-911-VA','STUDENT004','59','no good'),('201-911-VA','STUDENT005','78','comment003'),('420-910-VA','STUDENT001','90','good'),('420-910-VA','STUDENT002','69','ok'),('420-911-VA','STUDENT001','59','oh, my god'),('420-921-VA','STUDENT001','60','ok!'),('A001-01-01','STUDENT001','90','comment001');
/*!40000 ALTER TABLE `t_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `USER_Id` varchar(32) CHARACTER SET latin1 NOT NULL,
  `USER_PASSWORD` varchar(16) CHARACTER SET latin1 NOT NULL,
  `USER_CATEGORY` varchar(16) CHARACTER SET latin1 NOT NULL,
  `USER_FIRST_NAME` varchar(20) CHARACTER SET latin1 NOT NULL,
  `USER_LAST_NAME` varchar(20) CHARACTER SET latin1 NOT NULL,
  `USER_AGE` int(11) NOT NULL,
  `USER_GENDER` char(1) CHARACTER SET latin1 NOT NULL,
  `USER_EMAIL` varchar(45) CHARACTER SET latin1 NOT NULL,
  `USER_ADDRESS` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`USER_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES ('STUDENT001','A123456','student','John','Kennedy',18,'M','john@edu.vaniercollege.qc.ca','1515 Chem. Remembrance, Montréal, QC H3H 1A1'),('STUDENT002','A123456','student','Franklin','Roosevelt',19,'M','franklin@edu.vaniercollege.qc.ca','115 Chem. Remembrance, Montréal, QC H3H 1A2'),('STUDENT003','A123456','student','Richard','Nixon',20,'M','richard@edu.vaniercollege.qc.ca','4550 Isabella Ave Apt 507, Montreal, Quebec H3T 2A2'),('STUDENT004','A123456','student','Barack','Obama',21,'M','barack@edu.vaniercollege.qc.ca','17000 Route Transcanadienne, Kirkland, QC H9H 3C1'),('STUDENT005','A123456','student','Margaret','Thatcher',26,'F','margaret@edu.vaniercollege.qc.ca',NULL),('STUDENT006','A123456','student','Hillary','Clinton',27,'F','hillary@edu.vaniercollege.qc.ca',NULL),('STUDENT007','A123456','student','AK','Gun',17,'M','ak47@gmail.com','montreal city'),('STUDENT008','123','student','Fname','Lname',18,'M','fl@vanier.com','montreal 123'),('STUDENT010','123','student','Fname','Lname',12,'M','fl@vanier.com','montreal 123'),('TEACHER001','B123456','teacher','George','Washington',22,'M','george@edu.vaniercollege.qc.ca',NULL),('TEACHER002','B123456','teacher','John','Adams',23,'M','adams@edu.vaniercollege.qc.ca',NULL),('TEACHER003','B123456','teacher','Donald','Trump',24,'M','donald@edu.vaniercollege.qc.ca',NULL),('TEACHER004','B123456','teacher','Joe','Biden',25,'M','biden@edu.vaniercollege.qc.ca',NULL),('TEACHER005','B123456','teacher','Justin','Trudeau',52,'M','Justin@edu.vaniercollege.qc.ca','montreal 123'),('TEACHER006','B123456','teacher','Michael','Jordan',41,'m','Michael@edu.vaniercollege.qc.ca','montreal 123'),('TEACHER007','B123456','teacher','Zhen','Feng',41,'M','tj.fengzhen@hotmail.com','17109 Boul. A');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-12  8:39:21
