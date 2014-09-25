CREATE DATABASE  IF NOT EXISTS `elevatordb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `elevatordb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: elevatordb
-- ------------------------------------------------------
-- Server version	5.5.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `activityID` int(11) NOT NULL AUTO_INCREMENT,
  `current_hours` int(11) NOT NULL,
  `involvement` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `prev_hours` int(11) NOT NULL,
  `time_changed` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `eventActivity_eventsActivitiesID` int(11) DEFAULT NULL,
  `collat` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`activityID`),
  KEY `FK_b50ei6as5s0p212gheu3soill` (`eventActivity_eventsActivitiesID`),
  CONSTRAINT `FK_b50ei6as5s0p212gheu3soill` FOREIGN KEY (`eventActivity_eventsActivitiesID`) REFERENCES `eventsactivities` (`eventsActivitiesID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `analysis`
--

DROP TABLE IF EXISTS `analysis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `analysis` (
  `analysisID` int(11) NOT NULL AUTO_INCREMENT,
  `follow_notes` varchar(255) DEFAULT NULL,
  `follow_up` varchar(255) DEFAULT NULL,
  `gds_result` varchar(255) DEFAULT NULL,
  `hads_result` varchar(255) DEFAULT NULL,
  `letter` text,
  `mmse_result` varchar(255) DEFAULT NULL,
  `moca_result` varchar(255) DEFAULT NULL,
  `notes` text,
  `form_FormID` int(11) DEFAULT NULL,
  PRIMARY KEY (`analysisID`),
  KEY `FK_nf94uf2ty0af2655f3kugl308` (`form_FormID`),
  CONSTRAINT `FK_nf94uf2ty0af2655f3kugl308` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `clinic`
--

DROP TABLE IF EXISTS `clinic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinic` (
  `ClinicID` varchar(255) NOT NULL,
  `hashedPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ClinicID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `clinician`
--

DROP TABLE IF EXISTS `clinician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinician` (
  `clinicianID` varchar(255) NOT NULL,
  `lastLogin` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `clinic_ClinicID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`clinicianID`),
  KEY `FK_6d8ucybe31xy11guoahf7yjtn` (`clinic_ClinicID`),
  CONSTRAINT `FK_6d8ucybe31xy11guoahf7yjtn` FOREIGN KEY (`clinic_ClinicID`) REFERENCES `clinic` (`ClinicID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `concerns`
--

DROP TABLE IF EXISTS `concerns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concerns` (
  `concernsID` int(11) NOT NULL AUTO_INCREMENT,
  `anxiety_check` tinyint(1) NOT NULL,
  `anxiety_check_collat` tinyint(1) NOT NULL,
  `anxiety_freq` varchar(255) DEFAULT NULL,
  `anxiety_freq_collat` varchar(255) DEFAULT NULL,
  `anxiety_notes` text,
  `anxiety_notes_collat` text,
  `anxiety_severity` text,
  `anxiety_severity_collat` text,
  `anxiety_time` varchar(255) DEFAULT NULL,
  `anxiety_time_collat` varchar(255) DEFAULT NULL,
  `anxiety_worsening` text,
  `anxiety_worsening_collat` text,
  `calculations_check` tinyint(1) NOT NULL,
  `calculations_check_collat` tinyint(1) NOT NULL,
  `calculations_freq` varchar(255) DEFAULT NULL,
  `calculations_freq_collat` varchar(255) DEFAULT NULL,
  `calculations_notes` text,
  `calculations_notes_collat` text,
  `calculations_severity` text,
  `calculations_severity_collat` text,
  `calculations_time` varchar(255) DEFAULT NULL,
  `calculations_time_collat` varchar(255) DEFAULT NULL,
  `calculations_worsening` text,
  `calculations_worsening_collat` text,
  `comments_check` tinyint(1) NOT NULL,
  `comments_check_collat` tinyint(1) NOT NULL,
  `comments_freq` varchar(255) DEFAULT NULL,
  `comments_freq_collat` varchar(255) DEFAULT NULL,
  `comments_notes` text,
  `comments_notes_collat` text,
  `comments_severity` text,
  `comments_severity_collat` text,
  `comments_time` varchar(255) DEFAULT NULL,
  `comments_time_collat` varchar(255) DEFAULT NULL,
  `comments_worsening` text,
  `comments_worsening_collat` text,
  `decisions_check` tinyint(1) NOT NULL,
  `decisions_check_collat` tinyint(1) NOT NULL,
  `decisions_freq` varchar(255) DEFAULT NULL,
  `decisions_freq_collat` varchar(255) DEFAULT NULL,
  `decisions_notes` text,
  `decisions_notes_collat` text,
  `decisions_severity` text,
  `decisions_severity_collat` text,
  `decisions_time` varchar(255) DEFAULT NULL,
  `decisions_time_collat` varchar(255) DEFAULT NULL,
  `decisions_worsening` text,
  `decisions_worsening_collat` text,
  `faces_check` tinyint(1) NOT NULL,
  `faces_check_collat` tinyint(1) NOT NULL,
  `faces_freq` varchar(255) DEFAULT NULL,
  `faces_freq_collat` varchar(255) DEFAULT NULL,
  `faces_notes` text,
  `faces_notes_collat` text,
  `faces_severity` text,
  `faces_severity_collat` text,
  `faces_time` varchar(255) DEFAULT NULL,
  `faces_time_collat` varchar(255) DEFAULT NULL,
  `faces_worsening` text,
  `faces_worsening_collat` text,
  `follow_conv_check` tinyint(1) NOT NULL,
  `follow_conv_check_collat` tinyint(1) NOT NULL,
  `follow_conv_freq` varchar(255) DEFAULT NULL,
  `follow_conv_freq_collat` varchar(255) DEFAULT NULL,
  `follow_conv_notes` text,
  `follow_conv_notes_collat` text,
  `follow_conv_severity` text,
  `follow_conv_severity_collat` text,
  `follow_conv_time` varchar(255) DEFAULT NULL,
  `follow_conv_time_collat` varchar(255) DEFAULT NULL,
  `follow_conv_worsening` text,
  `follow_conv_worsening_collat` text,
  `losing_things_check` tinyint(1) NOT NULL,
  `losing_things_check_collat` tinyint(1) NOT NULL,
  `losing_things_freq` varchar(255) DEFAULT NULL,
  `losing_things_freq_collat` varchar(255) DEFAULT NULL,
  `losing_things_notes` text,
  `losing_things_notes_collat` text,
  `losing_things_severity` text,
  `losing_things_severity_collat` text,
  `losing_things_time` varchar(255) DEFAULT NULL,
  `losing_things_time_collat` varchar(255) DEFAULT NULL,
  `losing_things_worsening` text,
  `losing_things_worsening_collat` text,
  `names_check` tinyint(1) NOT NULL,
  `names_check_collat` tinyint(1) NOT NULL,
  `names_freq` varchar(255) DEFAULT NULL,
  `names_freq_collat` varchar(255) DEFAULT NULL,
  `names_notes` text,
  `names_notes_collat` text,
  `names_severity` text,
  `names_severity_collat` text,
  `names_time` varchar(255) DEFAULT NULL,
  `names_time_collat` varchar(255) DEFAULT NULL,
  `names_worsening` text,
  `names_worsening_collat` text,
  `prospective_check` tinyint(1) NOT NULL,
  `prospective_check_collat` tinyint(1) NOT NULL,
  `prospective_freq` varchar(255) DEFAULT NULL,
  `prospective_freq_collat` varchar(255) DEFAULT NULL,
  `prospective_notes` text,
  `prospective_notes_collat` text,
  `prospective_severity` text,
  `prospective_severity_collat` text,
  `prospective_time` varchar(255) DEFAULT NULL,
  `prospective_time_collat` varchar(255) DEFAULT NULL,
  `prospective_worsening` text,
  `prospective_worsening_collat` text,
  `rec_events_check` tinyint(1) NOT NULL,
  `rec_events_check_collat` tinyint(1) NOT NULL,
  `rec_events_freq` varchar(255) DEFAULT NULL,
  `rec_events_freq_collat` varchar(255) DEFAULT NULL,
  `rec_events_notes` text,
  `rec_events_notes_collat` text,
  `rec_events_severity` text,
  `rec_events_severity_collat` text,
  `rec_events_time` varchar(255) DEFAULT NULL,
  `rec_events_time_collat` varchar(255) DEFAULT NULL,
  `rec_events_worsening` text,
  `rec_events_worsening_collat` text,
  `right_words_check` tinyint(1) NOT NULL,
  `right_words_check_collat` tinyint(1) NOT NULL,
  `right_words_freq` varchar(255) DEFAULT NULL,
  `right_words_freq_collat` varchar(255) DEFAULT NULL,
  `right_words_notes` text,
  `right_words_notes_collat` text,
  `right_words_severity` text,
  `right_words_severity_collat` text,
  `right_words_time` varchar(255) DEFAULT NULL,
  `right_words_time_collat` varchar(255) DEFAULT NULL,
  `right_words_worsening` text,
  `right_words_worsening_collat` text,
  `wants_memory_investigation` varchar(255) DEFAULT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  `most_impactful_concern` varchar(255) DEFAULT NULL,
  `most_impactful_concern_collat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`concernsID`),
  KEY `FK_6p62befimnhrye2xxu9s9rxw4` (`form_FormID`),
  CONSTRAINT `FK_6p62befimnhrye2xxu9s9rxw4` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `drughistory`
--

DROP TABLE IF EXISTS `drughistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drughistory` (
  `drugHistoryID` int(11) NOT NULL AUTO_INCREMENT,
  `benzo_med` varchar(255) DEFAULT NULL,
  `drug` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `sleep_med` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `pHistory_historyID` int(11) DEFAULT NULL,
  `collat` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`drugHistoryID`),
  KEY `FK_89g4txvgp194srs1q8r1ynafh` (`pHistory_historyID`),
  CONSTRAINT `FK_89g4txvgp194srs1q8r1ynafh` FOREIGN KEY (`pHistory_historyID`) REFERENCES `patienthistory` (`historyID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `eventsactivities`
--

DROP TABLE IF EXISTS `eventsactivities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventsactivities` (
  `eventsActivitiesID` int(11) NOT NULL AUTO_INCREMENT,
  `bereavement_check` tinyint(1) NOT NULL,
  `bereavement_collat_check` tinyint(1) NOT NULL,
  `bereavement_collat_notes` text,
  `bereavement_collat_time` varchar(255) DEFAULT NULL,
  `bereavement_notes` text,
  `bereavement_time` varchar(255) DEFAULT NULL,
  `concentration_yn` varchar(255) DEFAULT NULL,
  `death_yn` varchar(255) DEFAULT NULL,
  `depression_yn` varchar(255) DEFAULT NULL,
  `divorce_check` tinyint(1) NOT NULL,
  `divorce_collat_check` tinyint(1) NOT NULL,
  `divorce_collat_notes` text,
  `divorce_collat_time` varchar(255) DEFAULT NULL,
  `divorce_notes` text,
  `divorce_time` varchar(255) DEFAULT NULL,
  `family_disharmony_check` tinyint(1) NOT NULL,
  `family_disharmony_collat_check` tinyint(1) NOT NULL,
  `family_disharmony_collat_notes` text,
  `family_disharmony_collat_time` varchar(255) DEFAULT NULL,
  `family_disharmony_notes` text,
  `family_disharmony_time` varchar(255) DEFAULT NULL,
  `financial_check` tinyint(1) NOT NULL,
  `financial_collat_check` tinyint(1) NOT NULL,
  `financial_collat_notes` text,
  `financial_collat_time` varchar(255) DEFAULT NULL,
  `financial_notes` text,
  `financial_time` varchar(255) DEFAULT NULL,
  `job_stress_check` tinyint(1) NOT NULL,
  `job_stress_collat_check` tinyint(1) NOT NULL,
  `job_stress_collat_notes` text,
  `job_stress_collat_time` varchar(255) DEFAULT NULL,
  `job_stress_notes` text,
  `job_stress_time` varchar(255) DEFAULT NULL,
  `moving_house_check` tinyint(1) NOT NULL,
  `moving_house_collat_check` tinyint(1) NOT NULL,
  `moving_house_collat_notes` text,
  `moving_house_collat_time` varchar(255) DEFAULT NULL,
  `moving_house_notes` text,
  `moving_house_time` varchar(255) DEFAULT NULL,
  `other_text` varchar(255) DEFAULT NULL,
  `other_collat_text` varchar(255) DEFAULT NULL,
  `other_collat_notes` text,
  `other_collat_time` varchar(255) DEFAULT NULL,
  `other_disharmony_check` tinyint(1) NOT NULL,
  `other_disharmony_collat_check` tinyint(1) NOT NULL,
  `other_disharmony_collat_notes` text,
  `other_disharmony_collat_time` varchar(255) DEFAULT NULL,
  `other_disharmony_notes` text,
  `other_disharmony_time` varchar(255) DEFAULT NULL,
  `other_notes` text,
  `other_time` varchar(255) DEFAULT NULL,
  `pleasure_yn` varchar(255) DEFAULT NULL,
  `redundancy_check` tinyint(1) NOT NULL,
  `redundancy_collat_check_check` tinyint(1) NOT NULL,
  `redundancy_collat_notes` text,
  `redundancy_collat_time` varchar(255) DEFAULT NULL,
  `redundancy_notes` text,
  `redundancy_time` varchar(255) DEFAULT NULL,
  `retirement_check` tinyint(1) NOT NULL,
  `retirement_collat_check` tinyint(1) NOT NULL,
  `retirement_collat_notes` text,
  `retirement_collat_time` varchar(255) DEFAULT NULL,
  `retirement_notes` text,
  `retirement_time` varchar(255) DEFAULT NULL,
  `worthless_yn` varchar(255) DEFAULT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  `social_notes` text,
  `social_notes_collat` text,
  PRIMARY KEY (`eventsActivitiesID`),
  KEY `FK_wqpmnuxlx4yxh8r25duayr93` (`form_FormID`),
  CONSTRAINT `FK_wqpmnuxlx4yxh8r25duayr93` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form` (
  `FormID` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime DEFAULT NULL,
  `patient_patientID` int(11) DEFAULT NULL,
  `case_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FormID`),
  KEY `FK_cx6066kcr6txb58nxahe2xkwg` (`patient_patientID`),
  CONSTRAINT `FK_cx6066kcr6txb58nxahe2xkwg` FOREIGN KEY (`patient_patientID`) REFERENCES `patient` (`patientID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `gp_info`
--

DROP TABLE IF EXISTS `gp_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gp_info` (
  `gpInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `b12_test` float NOT NULL,
  `b12_time` varchar(255) DEFAULT NULL,
  `calc_test` float NOT NULL,
  `calc_time` varchar(255) DEFAULT NULL,
  `cholest_hdl` float NOT NULL,
  `cholest_ldl` float NOT NULL,
  `cholest_test` float NOT NULL,
  `cholest_time` varchar(255) DEFAULT NULL,
  `diastolic` float NOT NULL,
  `diastolic_time` varchar(255) DEFAULT NULL,
  `gp_meds` varchar(255) DEFAULT NULL,
  `gp_notes` varchar(255) DEFAULT NULL,
  `gp_results` varchar(255) DEFAULT NULL,
  `gp_talked` tinyint(1) NOT NULL,
  `hdl_time` varchar(255) DEFAULT NULL,
  `iron_test` float NOT NULL,
  `iron_time` varchar(255) DEFAULT NULL,
  `kin_notes` varchar(255) DEFAULT NULL,
  `kin_response` varchar(255) DEFAULT NULL,
  `ldl_time` varchar(255) DEFAULT NULL,
  `med_test_notes` varchar(255) DEFAULT NULL,
  `response_time` varchar(255) DEFAULT NULL,
  `sodium_test` float NOT NULL,
  `sodium_time` varchar(255) DEFAULT NULL,
  `systolic` float NOT NULL,
  `systolic_time` varchar(255) DEFAULT NULL,
  `thyroid` float NOT NULL,
  `thyroid_time` varchar(255) DEFAULT NULL,
  `weight_test` float NOT NULL,
  `weight_time` varchar(255) DEFAULT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  `discussed_with_gp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gpInfoID`),
  KEY `FK_fv5v86pb6owuew65qrv9km6kt` (`form_FormID`),
  CONSTRAINT `FK_fv5v86pb6owuew65qrv9km6kt` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `impression`
--

DROP TABLE IF EXISTS `impression`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impression` (
  `impressionID` int(11) NOT NULL AUTO_INCREMENT,
  `impression` varchar(255) DEFAULT NULL,
  `impression_notes` text,
  `analysis_analysisID` int(11) DEFAULT NULL,
  PRIMARY KEY (`impressionID`),
  KEY `FK_f0b4qyssp6n0i5e3oj3u715ii` (`analysis_analysisID`),
  CONSTRAINT `FK_f0b4qyssp6n0i5e3oj3u715ii` FOREIGN KEY (`analysis_analysisID`) REFERENCES `analysis` (`analysisID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lifestyle`
--

DROP TABLE IF EXISTS `lifestyle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lifestyle` (
  `lifestyleID` int(11) NOT NULL AUTO_INCREMENT,
  `alcohol` varchar(255) DEFAULT NULL,
  `alcohol_collat` varchar(255) DEFAULT NULL,
  `alcohol_notes` text,
  `alcohol_notes_collat` text,
  `alcohol_reduce_interest` tinyint(1) NOT NULL,
  `alcohol_reduce_interest_collat` tinyint(1) NOT NULL,
  `beer_bottle_units` float NOT NULL,
  `beer_bottle_units_collat` float NOT NULL,
  `beer_pint_units` float NOT NULL,
  `beer_pint_units_collat` float NOT NULL,
  `breakfast` varchar(255) DEFAULT NULL,
  `breakfast_collat` varchar(255) DEFAULT NULL,
  `cakes` tinyint(1) NOT NULL,
  `cakes_collat` tinyint(1) NOT NULL,
  `cakes_freq` varchar(255) DEFAULT NULL,
  `cakes_freq_collat` varchar(255) DEFAULT NULL,
  `collat_diet` varchar(255) DEFAULT NULL,
  `collat_drug` varchar(255) DEFAULT NULL,
  `collat_exercise` varchar(255) DEFAULT NULL,
  `collat_sleep` varchar(255) DEFAULT NULL,
  `diet_notes` text,
  `diet_notes_collat` text,
  `difficulty_freq` varchar(255) DEFAULT NULL,
  `difficulty_freq_collat` varchar(255) DEFAULT NULL,
  `difficulty_freq_notes` text,
  `difficulty_freq_notes_collat` text,
  `difficulty_reason` varchar(255) DEFAULT NULL,
  `difficulty_reason_collat` varchar(255) DEFAULT NULL,
  `difficulty_reason_notes` text,
  `difficulty_reason_notes_collat` text,
  `difficulty_sleep` tinyint(1) NOT NULL,
  `difficulty_sleep_collat` tinyint(1) NOT NULL,
  `difficulty_sleep_notes` text,
  `difficulty_sleep_notes_collat` text,
  `difficulty_time` varchar(255) DEFAULT NULL,
  `difficulty_time_collat` varchar(255) DEFAULT NULL,
  `difficulty_time_notes` text,
  `difficulty_time_notes_collat` text,
  `dinner` varchar(255) DEFAULT NULL,
  `dinner_collat` varchar(255) DEFAULT NULL,
  `drugs` tinyint(1) NOT NULL,
  `drugs_collat` varchar(255) DEFAULT NULL,
  `drugs_notes` text,
  `drugs_notes_collat` text,
  `early_waking` tinyint(1) NOT NULL,
  `early_waking_collat` tinyint(1) NOT NULL,
  `early_waking_freq` varchar(255) DEFAULT NULL,
  `early_waking_freq_collat` varchar(255) DEFAULT NULL,
  `early_waking_freq_notes` text,
  `early_waking_freq_notes_collat` text,
  `early_waking_notes` text,
  `early_waking_notes_collat` text,
  `early_waking_reason` varchar(255) DEFAULT NULL,
  `early_waking_reason_collat` varchar(255) DEFAULT NULL,
  `early_waking_reason_notes` text,
  `early_waking_reason_notes_collat` text,
  `early_waking_time` varchar(255) DEFAULT NULL,
  `early_waking_time_collat` varchar(255) DEFAULT NULL,
  `early_waking_time_notes` text,
  `early_waking_time_notes_collat` text,
  `exercise_yn` varchar(255) DEFAULT NULL,
  `fried` tinyint(1) NOT NULL,
  `fried_collat` tinyint(1) NOT NULL,
  `fried_freq` varchar(255) DEFAULT NULL,
  `fried_freq_collat` varchar(255) DEFAULT NULL,
  `fruit_veg_amount` varchar(255) DEFAULT NULL,
  `fruit_veg_amount_collat` varchar(255) DEFAULT NULL,
  `lunch` varchar(255) DEFAULT NULL,
  `lunch_collat` varchar(255) DEFAULT NULL,
  `meds_check` tinyint(1) NOT NULL,
  `meds_check_collat` tinyint(1) NOT NULL,
  `miss_meals` tinyint(1) NOT NULL,
  `miss_meals_collat` tinyint(1) NOT NULL,
  `miss_meals_freq` varchar(255) DEFAULT NULL,
  `miss_meals_freq_collat` varchar(255) DEFAULT NULL,
  `nap_check` tinyint(1) NOT NULL,
  `nap_check_collat` tinyint(1) NOT NULL,
  `nap_length` varchar(255) DEFAULT NULL,
  `nap_length_collat` varchar(255) DEFAULT NULL,
  `nap_notes` text,
  `nap_notes_collat` text,
  `nap_time` varchar(255) DEFAULT NULL,
  `nap_time_collat` varchar(255) DEFAULT NULL,
  `night_waking` tinyint(1) NOT NULL,
  `night_waking_collat` tinyint(1) NOT NULL,
  `night_waking_freq` varchar(255) DEFAULT NULL,
  `night_waking_freq_collat` varchar(255) DEFAULT NULL,
  `night_waking_freq_notes` text,
  `night_waking_freq_notes_collat` text,
  `night_waking_notes` text,
  `night_waking_notes_collat` text,
  `night_waking_reason` varchar(255) DEFAULT NULL,
  `night_waking_reason_collat` varchar(255) DEFAULT NULL,
  `night_waking_reason_notes` text,
  `night_waking_reason_notes_collat` text,
  `night_waking_time` varchar(255) DEFAULT NULL,
  `night_waking_time_collat` varchar(255) DEFAULT NULL,
  `night_waking_time_notes` text,
  `night_waking_time_notes_collat` text,
  `packets` varchar(255) DEFAULT NULL,
  `packets_collat` varchar(255) DEFAULT NULL,
  `pop_units` float NOT NULL,
  `pop_units_collat` float NOT NULL,
  `sleep_length` varchar(255) DEFAULT NULL,
  `sleep_length_collat` varchar(255) DEFAULT NULL,
  `sleep_med_notes` text,
  `sleep_med_notes_collat` text,
  `sleep_meds` varchar(255) DEFAULT NULL,
  `sleep_meds_collat` varchar(255) DEFAULT NULL,
  `smoking` varchar(255) DEFAULT NULL,
  `smoking_collat` varchar(255) DEFAULT NULL,
  `smoking_notes` text,
  `smoking_notes_Collat` text,
  `smoking_reduce_interest` tinyint(1) NOT NULL,
  `smoking_reduce_interest_collat` tinyint(1) NOT NULL,
  `spirits_units` float NOT NULL,
  `spirits_units_collat` float NOT NULL,
  `sweets` tinyint(1) NOT NULL,
  `sweets_collat` tinyint(1) NOT NULL,
  `sweets_freq` varchar(255) DEFAULT NULL,
  `sweets_freq_collat` varchar(255) DEFAULT NULL,
  `takeaway` tinyint(1) NOT NULL,
  `takeaway_collat` tinyint(1) NOT NULL,
  `takeaway_freq` varchar(255) DEFAULT NULL,
  `takeaway_freq_collat` varchar(255) DEFAULT NULL,
  `total_units` float NOT NULL,
  `total_units_collat` float NOT NULL,
  `weight` tinyint(1) NOT NULL,
  `weight_collat` tinyint(1) NOT NULL,
  `weight_interest` tinyint(1) NOT NULL,
  `weight_interest_collat` tinyint(1) NOT NULL,
  `weight_time` varchar(255) DEFAULT NULL,
  `weight_time_collat` varchar(255) DEFAULT NULL,
  `wine_glass_units` float NOT NULL,
  `wine_glass_units_collat` float NOT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  `exercise_notes` text,
  `exercise_yn_collat` varchar(255) DEFAULT NULL,
  `exercise_notes_collat` text,
  `alcohol_collat_yn` varchar(45) DEFAULT NULL,
  `smoking_collat_yn` varchar(45) DEFAULT NULL,
  `drug_collat` varchar(255) DEFAULT NULL,
  `sleep_difficulty` varchar(45) DEFAULT NULL,
  `sleep_difficulty_collat` varchar(45) DEFAULT NULL,
  `waking_during_night` varchar(45) DEFAULT NULL,
  `waking_during_night_collat` varchar(45) DEFAULT NULL,
  `waking_early` varchar(45) DEFAULT NULL,
  `waking_early_collat` varchar(45) DEFAULT NULL,
  `taking_sleep_meds` varchar(45) DEFAULT NULL,
  `taking_sleep_meds_collat` varchar(45) DEFAULT NULL,
  `takes_naps` varchar(45) DEFAULT NULL,
  `takes_naps_collat` varchar(45) DEFAULT NULL,
  `missing_meals` varchar(45) DEFAULT NULL,
  `missing_meals_collat` varchar(45) DEFAULT NULL,
  `sweet_tooth` varchar(45) DEFAULT NULL,
  `sweet_tooth_collat` varchar(45) DEFAULT NULL,
  `fried_food` varchar(45) DEFAULT NULL,
  `fried_food_collat` varchar(45) DEFAULT NULL,
  `takeaways` varchar(45) DEFAULT NULL,
  `takeaways_collat` varchar(45) DEFAULT NULL,
  `cakes_biscuits` varchar(45) DEFAULT NULL,
  `cakes_biscuits_collat` varchar(45) DEFAULT NULL,
  `weight_suggestion` varchar(45) DEFAULT NULL,
  `weight_suggestion_collat` varchar(45) DEFAULT NULL,
  `illicit_substance` varchar(45) DEFAULT NULL,
  `illicit_substance_collat` varchar(45) DEFAULT NULL,
  `interested_in_reducing_alcohol` varchar(45) DEFAULT NULL,
  `interested_in_reducing_alcohol_collat` varchar(45) DEFAULT NULL,
  `interested_in_reducing_aclohol_collat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lifestyleID`),
  KEY `FK_rqstoramy54qbg66d7aif6h64` (`form_FormID`),
  CONSTRAINT `FK_rqstoramy54qbg66d7aif6h64` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lifestyleactivity`
--

DROP TABLE IF EXISTS `lifestyleactivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lifestyleactivity` (
  `lifestyleActivityID` int(11) NOT NULL AUTO_INCREMENT,
  `current_hours` int(11) NOT NULL,
  `involvement` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `prev_hours` int(11) NOT NULL,
  `time_changed` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `lifestyle_lifestyleID` int(11) DEFAULT NULL,
  `collat` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`lifestyleActivityID`),
  KEY `FK_jfomnlt42u5tv3si8lnemdcy7` (`lifestyle_lifestyleID`),
  CONSTRAINT `FK_jfomnlt42u5tv3si8lnemdcy7` FOREIGN KEY (`lifestyle_lifestyleID`) REFERENCES `lifestyle` (`lifestyleID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `livingsit`
--

DROP TABLE IF EXISTS `livingsit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livingsit` (
  `livingSitID` int(11) NOT NULL AUTO_INCREMENT,
  `bill_help_notes` text,
  `bill_help_notes_collat` text,
  `bill_method_notes` text,
  `bill_method_notes_collat` text,
  `bill_problem_notes` text,
  `bill_problem_notes_collat` text,
  `bill_problems` varchar(255) DEFAULT NULL,
  `bill_problems_collat` varchar(255) DEFAULT NULL,
  `bill_problems_notes_collat` text,
  `bills_collat` tinyint(1) NOT NULL,
  `bills_help` varchar(255) DEFAULT NULL,
  `bills_help_collat` varchar(255) DEFAULT NULL,
  `bills_help_notes_collat` text,
  `bills_method` varchar(255) DEFAULT NULL,
  `bills_method_collat` varchar(255) DEFAULT NULL,
  `bills_method_notes_collat` varchar(255) DEFAULT NULL,
  `burnt_food` tinyint(1) NOT NULL,
  `burnt_food_collat` tinyint(1) NOT NULL,
  `burnt_food_freq` varchar(255) DEFAULT NULL,
  `burnt_food_freq_collat` varchar(255) DEFAULT NULL,
  `burnt_food_notes` text,
  `burnt_food_notes_collat` text,
  `carer` tinyint(1) NOT NULL,
  `carer_collat` tinyint(1) NOT NULL,
  `carer_note` text,
  `carer_note_collat` text,
  `cook` varchar(255) DEFAULT NULL,
  `cook_help` varchar(255) DEFAULT NULL,
  `cook_help_collat` varchar(255) DEFAULT NULL,
  `cook_help_notes` text,
  `cook_help_notes_collat` text,
  `cooking_collat` varchar(255) DEFAULT NULL,
  `cooking_not_collat` tinyint(1) NOT NULL,
  `day_drive` tinyint(1) NOT NULL,
  `day_drive_collat` tinyint(1) NOT NULL,
  `day_drive_notes` text,
  `day_drive_notes_collat` text,
  `day_drive_success` varchar(255) DEFAULT NULL,
  `day_drive_success_collat` varchar(255) DEFAULT NULL,
  `drive` varchar(255) DEFAULT NULL,
  `drive_collat` varchar(255) DEFAULT NULL,
  `dry_run` tinyint(1) NOT NULL,
  `dry_run_collat` tinyint(1) NOT NULL,
  `dry_run_notes` text,
  `dry_run_notes_collat` text,
  `dry_run_success` varchar(255) DEFAULT NULL,
  `dry_run_success_collat` varchar(255) DEFAULT NULL,
  `forgot_cooking` tinyint(1) NOT NULL,
  `forgot_cooking_collat` tinyint(1) NOT NULL,
  `forgot_cooking_freq` varchar(255) DEFAULT NULL,
  `forgot_cooking_freq_collat` varchar(255) DEFAULT NULL,
  `forgot_cooking_notes` text,
  `forgot_cooking_notes_collat` text,
  `get_help` tinyint(1) NOT NULL,
  `get_help_collat` tinyint(1) NOT NULL,
  `get_help_notes` text,
  `get_help_notes_collat` text,
  `get_help_success` varchar(255) DEFAULT NULL,
  `get_help_success_collat` varchar(255) DEFAULT NULL,
  `go_out` tinyint(1) NOT NULL,
  `go_out_collat` tinyint(1) NOT NULL,
  `go_out_notes` text,
  `go_out_notes_collat` text,
  `go_out_success` varchar(255) DEFAULT NULL,
  `go_out_success_collat` varchar(255) DEFAULT NULL,
  `home_help` tinyint(1) NOT NULL,
  `home_help_collat` tinyint(1) NOT NULL,
  `home_help_note` text,
  `home_help_note_collat` text,
  `house_location` varchar(255) DEFAULT NULL,
  `house_location_collat` varchar(255) DEFAULT NULL,
  `house_location_note` text,
  `house_location_note_collat` text,
  `house_type` varchar(255) DEFAULT NULL,
  `house_type_collat` varchar(255) DEFAULT NULL,
  `house_type_note` text,
  `house_type_note_collat` text,
  `housemates` varchar(255) DEFAULT NULL,
  `housemates_collat` varchar(255) DEFAULT NULL,
  `housemates_note` text,
  `housemates_note_collat` text,
  `known_places` tinyint(1) NOT NULL,
  `known_places_collat` tinyint(1) NOT NULL,
  `known_places_notes` text,
  `known_places_notes_collat` text,
  `known_places_success` varchar(255) DEFAULT NULL,
  `known_places_success_collat` varchar(255) DEFAULT NULL,
  `life_collat` tinyint(1) NOT NULL,
  `list_check` tinyint(1) NOT NULL,
  `list_check_collat` tinyint(1) NOT NULL,
  `list_notes` text,
  `list_notes_collat` text,
  `list_success` varchar(255) DEFAULT NULL,
  `list_success_collat` varchar(255) DEFAULT NULL,
  `lost` tinyint(1) NOT NULL,
  `lost_collat` tinyint(1) NOT NULL,
  `lost_freq` varchar(255) DEFAULT NULL,
  `lost_freq_collat` varchar(255) DEFAULT NULL,
  `lost_notes` text,
  `lost_notes_collat` text,
  `lost_severity` varchar(255) DEFAULT NULL,
  `lost_severity_collat` varchar(255) DEFAULT NULL,
  `map` tinyint(1) NOT NULL,
  `map_collat` tinyint(1) NOT NULL,
  `map_notes` text,
  `map_notes_collat` text,
  `map_success` varchar(255) DEFAULT NULL,
  `map_success_collat` varchar(255) DEFAULT NULL,
  `park_big` tinyint(1) NOT NULL,
  `park_big_collat` tinyint(1) NOT NULL,
  `park_big_notes` text,
  `park_big_notes_collat` text,
  `park_big_success` varchar(255) DEFAULT NULL,
  `park_big_success_collat` varchar(255) DEFAULT NULL,
  `reminders` tinyint(1) NOT NULL,
  `reminders_collat` tinyint(1) NOT NULL,
  `reminders_notes` text,
  `reminders_notes_collat` text,
  `reminders_success` varchar(255) DEFAULT NULL,
  `reminders_success_collat` varchar(255) DEFAULT NULL,
  `salad` tinyint(1) NOT NULL,
  `salad_collat` tinyint(1) NOT NULL,
  `salad_notes` text,
  `salad_notes_collat` text,
  `salad_success` varchar(255) DEFAULT NULL,
  `salad_success_collat` varchar(255) DEFAULT NULL,
  `shop` varchar(255) DEFAULT NULL,
  `shop_help` varchar(255) DEFAULT NULL,
  `shop_help_collat` varchar(255) DEFAULT NULL,
  `shop_help_notes` text,
  `shop_help_notes_collat` text,
  `shop_help_time` varchar(255) DEFAULT NULL,
  `shop_help_time_collat` varchar(255) DEFAULT NULL,
  `shop_time_notes` text,
  `shop_time_notes_collat` text,
  `shop_tough_notes` text,
  `shop_tough_notes_collat` text,
  `shopping_collat` varchar(255) DEFAULT NULL,
  `shopping_not_collat` tinyint(1) NOT NULL,
  `shopping_tougher` varchar(255) DEFAULT NULL,
  `shopping_tougher_collat` varchar(255) DEFAULT NULL,
  `simple_cooking` tinyint(1) NOT NULL,
  `simple_cooking_collat` tinyint(1) NOT NULL,
  `simple_cooking_notes` text,
  `simple_cooking_notes_collat` text,
  `simple_cooking_success` varchar(255) DEFAULT NULL,
  `simple_cooking_success_collat` varchar(255) DEFAULT NULL,
  `small_shop_check` tinyint(1) NOT NULL,
  `small_shop_check_collat` tinyint(1) NOT NULL,
  `small_shop_notes` text,
  `small_shop_notes_collat` text,
  `small_shop_success` varchar(255) DEFAULT NULL,
  `small_shop_success_collat` varchar(255) DEFAULT NULL,
  `smoke_alarm` tinyint(1) NOT NULL,
  `smoke_alarm_collat` tinyint(1) NOT NULL,
  `smoke_alarm_freq` varchar(255) DEFAULT NULL,
  `smoke_alarm_freq_collat` varchar(255) DEFAULT NULL,
  `smoke_alarm_notes` text,
  `smoke_alarm_notes_collat` text,
  `started_fire` tinyint(1) NOT NULL,
  `started_fire_collat` tinyint(1) NOT NULL,
  `started_fire_freq` varchar(255) DEFAULT NULL,
  `started_fire_freq_collat` varchar(255) DEFAULT NULL,
  `started_fire_notes` text,
  `started_fire_notes_collat` text,
  `take_friend` tinyint(1) NOT NULL,
  `take_friend_collat` tinyint(1) NOT NULL,
  `take_friend_notes` text,
  `take_friend_notes_collat` text,
  `take_friend_success` varchar(255) DEFAULT NULL,
  `take_friend_success_collat` varchar(255) DEFAULT NULL,
  `take_phone` tinyint(1) NOT NULL,
  `take_phone_collat` tinyint(1) NOT NULL,
  `take_phone_notes` text,
  `take_phone_notes_collat` text,
  `take_phone_success` varchar(255) DEFAULT NULL,
  `take_phone_success_collat` varchar(255) DEFAULT NULL,
  `timer` tinyint(1) NOT NULL,
  `timer_collat` tinyint(1) NOT NULL,
  `timer_notes` text,
  `timer_notes_collat` text,
  `timer_success` varchar(255) DEFAULT NULL,
  `timer_success_collat` varchar(255) DEFAULT NULL,
  `tips` tinyint(1) NOT NULL,
  `tips_collat` tinyint(1) NOT NULL,
  `tips_freq` varchar(255) DEFAULT NULL,
  `tips_freq_collat` varchar(255) DEFAULT NULL,
  `tips_notes` text,
  `tips_notes_collat` text,
  `tips_severity` varchar(255) DEFAULT NULL,
  `tips_severity_collat` varchar(255) DEFAULT NULL,
  `undercooked` tinyint(1) NOT NULL,
  `undercooked_collat` tinyint(1) NOT NULL,
  `undercooked_freq` varchar(255) DEFAULT NULL,
  `undercooked_freq_collat` varchar(255) DEFAULT NULL,
  `undercooked_notes` text,
  `undercooked_notes_collat` text,
  `unknown_arrival` tinyint(1) NOT NULL,
  `unknown_arrival_collat` tinyint(1) NOT NULL,
  `unknown_arrival_freq` varchar(255) DEFAULT NULL,
  `unknown_arrival_freq_collat` varchar(255) DEFAULT NULL,
  `unknown_arrival_notes` text,
  `unknown_arrival_notes_collat` text,
  `unknown_arrival_severity` varchar(255) DEFAULT NULL,
  `unkown_arrival_severity_collat` varchar(255) DEFAULT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  `driving_notes` text,
  `driving_notes_collat` text,
  `collat_drive` varchar(45) DEFAULT NULL,
  `collat_shop` varchar(45) DEFAULT NULL,
  `collat_cook` varchar(45) DEFAULT NULL,
  `collat_bills` varchar(45) DEFAULT NULL,
  `collat_homelife` varchar(45) DEFAULT NULL,
  `collat_cooking_other_freq` text,
  `collat_cooking_other_incident` text,
  `collat_cooking_other_notes` text,
  `collat_driving_other_freq` text,
  `collat_driving_other_incident` text,
  `collat_driving_other_notes` text,
  `cooking_other_notes` text,
  `driving_other_notes` text,
  `collat_driving_other_severity` varchar(45) DEFAULT NULL,
  `driving_other_incident` text,
  `driving_other_severity` varchar(45) DEFAULT NULL,
  `driving_other_freq` text,
  `cooking_other_incident` text,
  `cooking_other_freq` text,
  `is_carer` text,
  `collat_is_carer` text,
  `getting_homehelp` text,
  `collat_getting_homehelp` text,
  PRIMARY KEY (`livingSitID`),
  KEY `FK_nkaywhusqcepuo2ga83poyv6a` (`form_FormID`),
  CONSTRAINT `FK_nkaywhusqcepuo2ga83poyv6a` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medhistory`
--

DROP TABLE IF EXISTS `medhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medhistory` (
  `medHistoryID` int(11) NOT NULL AUTO_INCREMENT,
  `ailment` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `pHistory_historyID` int(11) DEFAULT NULL,
  `collat` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`medHistoryID`),
  KEY `FK_rw47mvutq6ausalth790yw6sn` (`pHistory_historyID`),
  CONSTRAINT `FK_rw47mvutq6ausalth790yw6sn` FOREIGN KEY (`pHistory_historyID`) REFERENCES `patienthistory` (`historyID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `neurohistory`
--

DROP TABLE IF EXISTS `neurohistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `neurohistory` (
  `neuroHistoryID` int(11) NOT NULL AUTO_INCREMENT,
  `blackout_check` tinyint(1) NOT NULL,
  `blackout_check_collat` tinyint(1) NOT NULL,
  `blackout_freq` varchar(255) DEFAULT NULL,
  `blackout_freq_collat` varchar(255) DEFAULT NULL,
  `blackout_investigated` varchar(255) DEFAULT NULL,
  `blackout_investigated_collat` varchar(255) DEFAULT NULL,
  `blackout_notes` text,
  `blackout_notes_collat` text,
  `blackout_time` varchar(255) DEFAULT NULL,
  `blackout_time_collat` varchar(255) DEFAULT NULL,
  `blanks_check` tinyint(1) NOT NULL,
  `blanks_check_collat` tinyint(1) NOT NULL,
  `blanks_freq` varchar(255) DEFAULT NULL,
  `blanks_freq_collat` varchar(255) DEFAULT NULL,
  `blanks_investigated` varchar(255) DEFAULT NULL,
  `blanks_investigated_collat` varchar(255) DEFAULT NULL,
  `blanks_notes` text,
  `blanks_notes_collat` text,
  `blanks_time` varchar(255) DEFAULT NULL,
  `blanks_time_collat` varchar(255) DEFAULT NULL,
  `blurred_vision_check` tinyint(1) NOT NULL,
  `blurred_vision_check_collat` tinyint(1) NOT NULL,
  `blurred_vision_freq` varchar(255) DEFAULT NULL,
  `blurred_vision_freq_collat` varchar(255) DEFAULT NULL,
  `blurred_vision_investigated` varchar(255) DEFAULT NULL,
  `blurred_vision_investigated_collat` varchar(255) DEFAULT NULL,
  `blurred_vision_notes` text,
  `blurred_vision_notes_collat` text,
  `blurred_vision_time` varchar(255) DEFAULT NULL,
  `blurred_vision_time_collat` varchar(255) DEFAULT NULL,
  `dexterity_check` tinyint(1) NOT NULL,
  `dexterity_check_collat` tinyint(1) NOT NULL,
  `dexterity_freq` varchar(255) DEFAULT NULL,
  `dexterity_freq_collat` varchar(255) DEFAULT NULL,
  `dexterity_investigated` varchar(255) DEFAULT NULL,
  `dexterity_investigated_collat` varchar(255) DEFAULT NULL,
  `dexterity_notes` text,
  `dexterity_notes_collat` text,
  `dexterity_time` varchar(255) DEFAULT NULL,
  `dexterity_time_collat` varchar(255) DEFAULT NULL,
  `dizziness_check` tinyint(1) NOT NULL,
  `dizziness_check_collat` tinyint(1) NOT NULL,
  `dizziness_freq` varchar(255) DEFAULT NULL,
  `dizziness_freq_collat` varchar(255) DEFAULT NULL,
  `dizziness_investigated` varchar(255) DEFAULT NULL,
  `dizziness_investigated_collat` varchar(255) DEFAULT NULL,
  `dizziness_notes` text,
  `dizziness_notes_collat` text,
  `dizziness_time` varchar(255) DEFAULT NULL,
  `dizziness_time_collat` varchar(255) DEFAULT NULL,
  `fainting_check` tinyint(1) NOT NULL,
  `fainting_check_collat` tinyint(1) NOT NULL,
  `fainting_freq` varchar(255) DEFAULT NULL,
  `fainting_freq_collat` varchar(255) DEFAULT NULL,
  `fainting_investigated` varchar(255) DEFAULT NULL,
  `fainting_investigated_collat` varchar(255) DEFAULT NULL,
  `fainting_notes` text,
  `fainting_notes_collat` text,
  `fainting_time` varchar(255) DEFAULT NULL,
  `fainting_time_collat` varchar(255) DEFAULT NULL,
  `falling_check` tinyint(1) NOT NULL,
  `falling_check_collat` tinyint(1) NOT NULL,
  `falling_freq` varchar(255) DEFAULT NULL,
  `falling_freq_collat` varchar(255) DEFAULT NULL,
  `falling_investigated` varchar(255) DEFAULT NULL,
  `falling_investigated_collat` varchar(255) DEFAULT NULL,
  `falling_notes` text,
  `falling_notes_collat` text,
  `falling_time` varchar(255) DEFAULT NULL,
  `falling_time_collat` varchar(255) DEFAULT NULL,
  `headaches_check` tinyint(1) NOT NULL,
  `headaches_check_collat` tinyint(1) NOT NULL,
  `headaches_freq` varchar(255) DEFAULT NULL,
  `headaches_freq_collat` varchar(255) DEFAULT NULL,
  `headaches_investigated` varchar(255) DEFAULT NULL,
  `headaches_investigated_collat` varchar(255) DEFAULT NULL,
  `headaches_notes` text,
  `headaches_notes_collat` text,
  `headaches_time` varchar(255) DEFAULT NULL,
  `headaches_time_collat` varchar(255) DEFAULT NULL,
  `seizures_check` tinyint(1) NOT NULL,
  `seizures_check_collat` tinyint(1) NOT NULL,
  `seizures_freq` varchar(255) DEFAULT NULL,
  `seizures_freq_collat` varchar(255) DEFAULT NULL,
  `seizures_investigated` varchar(255) DEFAULT NULL,
  `seizures_investigated_collat` varchar(255) DEFAULT NULL,
  `seizures_notes` text,
  `seizures_notes_collat` text,
  `seizures_time` varchar(255) DEFAULT NULL,
  `seizures_time_collat` varchar(255) DEFAULT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  PRIMARY KEY (`neuroHistoryID`),
  KEY `FK_lnd8cjpeoyqyrl2q5bkjpc8o5` (`form_FormID`),
  CONSTRAINT `FK_lnd8cjpeoyqyrl2q5bkjpc8o5` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `outcome`
--

DROP TABLE IF EXISTS `outcome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outcome` (
  `outcomeID` int(11) NOT NULL AUTO_INCREMENT,
  `outcome` varchar(255) DEFAULT NULL,
  `outcome_notes` text,
  `analysis_analysisID` int(11) DEFAULT NULL,
  PRIMARY KEY (`outcomeID`),
  KEY `FK_ay4yol2xvkkfotrp8ynd8i15s` (`analysis_analysisID`),
  CONSTRAINT `FK_ay4yol2xvkkfotrp8ynd8i15s` FOREIGN KEY (`analysis_analysisID`) REFERENCES `analysis` (`analysisID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `patientID` int(11) NOT NULL,
  `clinic_ClinicID` varchar(255) DEFAULT NULL,
  `clinician_clinicianID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patientID`),
  KEY `FK_1k465bsrngt8tji7cpfin5703` (`clinic_ClinicID`),
  KEY `FK_al0m78o5p4ew8cjeor1y0fsl6` (`clinician_clinicianID`),
  CONSTRAINT `FK_1k465bsrngt8tji7cpfin5703` FOREIGN KEY (`clinic_ClinicID`) REFERENCES `clinic` (`ClinicID`),
  CONSTRAINT `FK_al0m78o5p4ew8cjeor1y0fsl6` FOREIGN KEY (`clinician_clinicianID`) REFERENCES `clinician` (`clinicianID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patienthistory`
--

DROP TABLE IF EXISTS `patienthistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patienthistory` (
  `historyID` int(11) NOT NULL AUTO_INCREMENT,
  `collat_current_therapy_check` varchar(255) DEFAULT NULL,
  `collat_past_therapy_check` varchar(255) DEFAULT NULL,
  `current_therapy_check` varchar(255) DEFAULT NULL,
  `past_therapy_check` varchar(255) DEFAULT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  PRIMARY KEY (`historyID`),
  KEY `FK_cohy7btjp60owrswhjropcdqo` (`form_FormID`),
  CONSTRAINT `FK_cohy7btjp60owrswhjropcdqo` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `personaldetails`
--

DROP TABLE IF EXISTS `personaldetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personaldetails` (
  `detailsID` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `age_left` int(11) NOT NULL,
  `county` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `family_present` tinyint(1) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `gp_county` varchar(255) DEFAULT NULL,
  `junior_check` tinyint(1) NOT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `senior_check` tinyint(1) NOT NULL,
  `study_topic` varchar(255) DEFAULT NULL,
  `testing_reason` varchar(255) DEFAULT NULL,
  `third_check` tinyint(1) NOT NULL,
  `who_present` varchar(255) DEFAULT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  `wants_assessment` tinyint(1) NOT NULL,
  `wants_information` tinyint(1) NOT NULL,
  `wants_reassurance` tinyint(1) NOT NULL,
  `junior_cert_education` varchar(45) DEFAULT NULL,
  `senior_cert_education` varchar(45) DEFAULT NULL,
  `third_level_education` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`detailsID`),
  KEY `FK_f9glo4hmnj1xydr5s5r6sbdu0` (`form_FormID`),
  CONSTRAINT `FK_f9glo4hmnj1xydr5s5r6sbdu0` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `psychhistory`
--

DROP TABLE IF EXISTS `psychhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `psychhistory` (
  `psychHistoryID` int(11) NOT NULL AUTO_INCREMENT,
  `notes` varchar(255) DEFAULT NULL,
  `psych` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `pHistory_historyID` int(11) DEFAULT NULL,
  `collat` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`psychHistoryID`),
  KEY `FK_fr064x1rjop3nks97xbtsohb0` (`pHistory_historyID`),
  CONSTRAINT `FK_fr064x1rjop3nks97xbtsohb0` FOREIGN KEY (`pHistory_historyID`) REFERENCES `patienthistory` (`historyID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `testbattery`
--

DROP TABLE IF EXISTS `testbattery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testbattery` (
  `testBatteryID` int(11) NOT NULL AUTO_INCREMENT,
  `MMSE_Upload` varchar(255) DEFAULT NULL,
  `MOCA_Upload` varchar(255) DEFAULT NULL,
  `b_MOCA_Upload` varchar(255) DEFAULT NULL,
  `b_abstract` varchar(255) DEFAULT NULL,
  `b_attention` varchar(255) DEFAULT NULL,
  `b_language` varchar(255) DEFAULT NULL,
  `b_moca_total` varchar(255) DEFAULT NULL,
  `b_orientation` varchar(255) DEFAULT NULL,
  `b_recall` varchar(255) DEFAULT NULL,
  `gds_afraid` varchar(255) DEFAULT NULL,
  `gds_alive` varchar(255) DEFAULT NULL,
  `gds_better_off` varchar(255) DEFAULT NULL,
  `gds_blue` varchar(255) DEFAULT NULL,
  `gds_bored` varchar(255) DEFAULT NULL,
  `gds_clear_mind` varchar(255) DEFAULT NULL,
  `gds_concentrating` varchar(255) DEFAULT NULL,
  `gds_crying` varchar(255) DEFAULT NULL,
  `gds_decisions` varchar(255) DEFAULT NULL,
  `gds_dropping_interests` varchar(255) DEFAULT NULL,
  `gds_energy` varchar(255) DEFAULT NULL,
  `gds_exciting` varchar(255) DEFAULT NULL,
  `gds_fidgety` varchar(255) DEFAULT NULL,
  `gds_future` varchar(255) DEFAULT NULL,
  `gds_future_worry` varchar(255) DEFAULT NULL,
  `gds_happy` varchar(255) DEFAULT NULL,
  `gds_helpless` varchar(255) DEFAULT NULL,
  `gds_hopeless` varchar(255) DEFAULT NULL,
  `gds_life_empty` varchar(255) DEFAULT NULL,
  `gds_little_things` varchar(255) DEFAULT NULL,
  `gds_mem_problems` varchar(255) DEFAULT NULL,
  `gds_morning` varchar(255) DEFAULT NULL,
  `gds_new_projects` varchar(255) DEFAULT NULL,
  `gds_satisfied` varchar(255) DEFAULT NULL,
  `gds_social_occasions` varchar(255) DEFAULT NULL,
  `gds_spirits` varchar(255) DEFAULT NULL,
  `gds_stay_home` varchar(255) DEFAULT NULL,
  `gds_thoughts` varchar(255) DEFAULT NULL,
  `gds_total` varchar(255) DEFAULT NULL,
  `gds_worthless` varchar(255) DEFAULT NULL,
  `hads_appearance` varchar(255) DEFAULT NULL,
  `hads_butterflies` varchar(255) DEFAULT NULL,
  `hads_cheerful` varchar(255) DEFAULT NULL,
  `hads_enjoy` varchar(255) DEFAULT NULL,
  `hads_enjoyment` varchar(255) DEFAULT NULL,
  `hads_frightened` varchar(255) DEFAULT NULL,
  `hads_funny` varchar(255) DEFAULT NULL,
  `hads_panic` varchar(255) DEFAULT NULL,
  `hads_pasttime` varchar(255) DEFAULT NULL,
  `hads_relaxed` varchar(255) DEFAULT NULL,
  `hads_restless` varchar(255) DEFAULT NULL,
  `hads_slowed` varchar(255) DEFAULT NULL,
  `hads_total` varchar(255) DEFAULT NULL,
  `hads_worry` varchar(255) DEFAULT NULL,
  `hads_wound_up` varchar(255) DEFAULT NULL,
  `mmse_attention` varchar(255) DEFAULT NULL,
  `mmse_copying` varchar(255) DEFAULT NULL,
  `mmse_language` varchar(255) DEFAULT NULL,
  `mmse_orientation` varchar(255) DEFAULT NULL,
  `mmse_recall` varchar(255) DEFAULT NULL,
  `mmse_registration` varchar(255) DEFAULT NULL,
  `mmse_total` varchar(255) DEFAULT NULL,
  `moca_abstraction` varchar(255) DEFAULT NULL,
  `moca_attention` varchar(255) DEFAULT NULL,
  `moca_language` varchar(255) DEFAULT NULL,
  `moca_naming` varchar(255) DEFAULT NULL,
  `moca_orientation` varchar(255) DEFAULT NULL,
  `moca_recall` varchar(255) DEFAULT NULL,
  `moca_total` varchar(255) DEFAULT NULL,
  `moca_visuo` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `form_FormID` int(11) DEFAULT NULL,
  PRIMARY KEY (`testBatteryID`),
  KEY `FK_1jfe3gsdie90lthf8y296taaw` (`form_FormID`),
  CONSTRAINT `FK_1jfe3gsdie90lthf8y296taaw` FOREIGN KEY (`form_FormID`) REFERENCES `form` (`FormID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-25 12:11:20
