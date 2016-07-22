-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: 192.168.99.100    Database: minitwit_schema
-- ------------------------------------------------------
-- Server version	5.7.13

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  password varchar(200) NOT NULL,
  nickname varchar(50) NOT NULL,
  register_time timestamp NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY user_id_UNIQUE (user_id),
  UNIQUE KEY email_UNIQUE (email)
);

-- Dump completed on 2016-07-22 16:07:54
