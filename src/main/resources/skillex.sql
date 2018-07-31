-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 31 juil. 2018 à 15:27
-- Version du serveur :  10.1.34-MariaDB
-- Version de PHP :  7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `skillex`
--

-- --------------------------------------------------------

--
-- Structure de la table `branche`
--

CREATE TABLE `branche` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(50) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `branche_parente_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `branche`
--

INSERT INTO `branche` (`id`, `description`, `libelle`, `nom`, `branche_parente_id`) VALUES
(1, NULL, 'Compétences métiers', NULL, NULL),
(2, 'Branche Métier : Gestion des projets', 'Gestion de projets', 'Gestion de projets', 1),
(3, 'Branche métier : Développement', 'Développement', 'Développement', 1),
(4, 'Branche Métier : Infrastucture', 'Infrastucture', 'Infrastucture', 1),
(5, 'Branche Métier : Conseil / AMOA', 'Conseil / AMOA', 'Conseil / AMOA', 1),
(6, 'Branche Métier : Validation', 'Validation', 'Validation', 1),
(7, 'Branche Métier : Certification', 'Certification', 'Certification', 1),
(8, 'Branche Métier : Gestion des projets > Méthodologie', 'Méthodologie', 'Méthodologie', 2),
(9, 'Branche Métier : Développement > Langages', 'Langages', 'Langages', 3),
(10, 'Branche Métier : Développement > Framework et Bibliothèque', 'Framework et Bibliothèque', 'Framework et Bibliothèque', 3),
(11, 'Branche Métier : Développement > Modélisation', 'Modélisation', 'Modélisation', 3),
(12, 'Branche Métier : Développement > Intégration continue', 'Intégration continue', 'Intégration continue', 3),
(13, 'Branche Métier : Développement > Versionning', 'Versionning', 'Versionning', 3),
(14, 'Branche Métier : Développement > Environnement de développement', 'Environnement de développement', 'Environnement de développement', 3),
(15, 'Branche Métier : Développement > Outils', 'Outils', 'Outils', 3),
(16, 'Branche Métier : Infrastucture > Serveurs d\'applications', 'Serveurs d\'applications', 'Serveurs d\'applications', 4),
(17, 'Branche Métier : Infrastucture > SGDB', 'SGDB', 'SGDB', 4),
(18, 'Branche Métier : Infrastucture > Système d\'exploitation', 'Système d\'exploitation', 'Système d\'exploitation', 4),
(19, 'Branche Métier : Infrastucture > Réseau', 'Réseau', 'Réseau', 4),
(20, 'Branche Métier : Infrastucture > Outils', 'Outils', 'Outils', 4),
(21, 'Branche Métier : Conseil / AMOA > Livrables', 'Livrables', 'Livrables', 5),
(22, 'Branche Métier : Validation > Livrables', 'Livrables', 'Livrables', 6),
(23, 'Branche Métier : Validation > Outils', 'Outils', 'Outils', 6),
(24, 'Branche Métier : Développement > Modélisation > Méthodologie', 'Méthodologie', 'Méthodologie', 11),
(25, 'Branche Métier : Infrastucture > Système d\'exploitation > Serveur', 'Serveur', 'Serveur', 18),
(26, 'Branche Métier : Infrastucture > Système d\'exploitation > Poste de travail', 'Poste de travail', 'Poste de travail', 18),
(27, 'Branche Métier : Infrastucture > Réseau > Protocoles', 'Protocoles', 'Protocoles', 19),
(28, 'Branche Métier : Validation > Outils > BugTrackers', 'BugTrackers', 'BugTrackers', 23),
(29, 'Branche Métier : Validation > Outils > Tests unitaires', 'Tests unitaires', 'Tests unitaires', 23),
(30, 'Branche Métier : Validation > Outils > Tests d\'intégration / Homologation technique', 'Tests d\'intégration / Homologation technique', 'Tests d\'intégration / Homologation technique', 23),
(31, 'Branche Métier : Validation > Outils > Management des tests', 'Management des tests', 'Management des tests', 23);

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

CREATE TABLE `competence` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(50) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `branche_parente_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `competence`
--

INSERT INTO `competence` (`id`, `description`, `libelle`, `nom`, `branche_parente_id`) VALUES
(1, 'Compétence : Gestion des projets > Planification / Pilotage', 'Planification / Pilotage', NULL, 2),
(2, 'Compétence : Gestion des projets > Evaluation / Gestion des risques', 'Evaluation / Gestion des risques', NULL, 2),
(3, 'Compétence : Gestion des projets > Management', 'Management', NULL, 2),
(4, 'Compétence : Gestion des projets > Communications', 'Communications', NULL, 2),
(5, 'Compétence : Gestion des projets > Suivi budgétaire', 'Suivi budgétaire', NULL, 2),
(6, 'Compétence : Gestion des projets > Méthodologie > En cascade (classique)', 'En cascade (classique)', NULL, 8),
(7, 'Compétence : Gestion des projets > Méthodologie > Scrum', 'Scrum', NULL, 8),
(8, 'Compétence : Gestion des projets > Méthodologie > PERT (Gantt)', 'PERT (Gantt)', NULL, 8),
(9, 'Compétence : Gestion des projets > Méthodologie > Extreme programming (XP)', 'Extreme programming (XP)', NULL, 8),
(10, 'Compétence : Gestion des projets > Méthodologie > Devops', 'Devops', NULL, 8),
(11, 'Compétence : Gestion des projets > Méthodologie > Prince2', 'Prince2', NULL, 8),
(12, 'Compétence : Développement > Langages > C / C++', 'C / C++', NULL, 9),
(13, 'Compétence : Développement > Langages > Ada', 'Ada', NULL, 9),
(14, 'Compétence : Développement > Langages > ASP.NET', 'ASP.NET', NULL, 9),
(15, 'Compétence : Développement > Langages > Basic', 'Basic', NULL, 9),
(16, 'Compétence : Développement > Langages > Cobol', 'Cobol', NULL, 9),
(17, 'Compétence : Développement > Langages > CSS', 'CSS', NULL, 9),
(18, 'Compétence : Développement > Langages > Delphi', 'Delphi', NULL, 9),
(19, 'Compétence : Développement > Langages > Fortran', 'Fortran', NULL, 9),
(20, 'Compétence : Développement > Langages > HTML', 'HTML', NULL, 9),
(21, 'Compétence : Développement > Langages > Java JEE', 'Java JEE', NULL, 9),
(22, 'Compétence : Développement > Langages > Java JME', 'Java JME', NULL, 9),
(23, 'Compétence : Développement > Langages > Java JSE', 'Java JSE', NULL, 9),
(24, 'Compétence : Développement > Langages > Javascript', 'Javascript', NULL, 9),
(25, 'Compétence : Développement > Langages > LiferayUI', 'LiferayUI', NULL, 9),
(26, 'Compétence : Développement > Langages > Lisp', 'Lisp', NULL, 9),
(27, 'Compétence : Développement > Langages > Pascal', 'Pascal', NULL, 9),
(28, 'Compétence : Développement > Langages > Perl', 'Perl', NULL, 9),
(29, 'Compétence : Développement > Langages > PHP', 'PHP', NULL, 9),
(30, 'Compétence : Développement > Langages > PL/SQL', 'PL/SQL', NULL, 9),
(31, 'Compétence : Développement > Langages > Pro*C', 'Pro*C', NULL, 9),
(32, 'Compétence : Développement > Langages > Prolog', 'Prolog', NULL, 9),
(33, 'Compétence : Développement > Langages > Python', 'Python', NULL, 9),
(34, 'Compétence : Développement > Langages > Ruby', 'Ruby', NULL, 9),
(35, 'Compétence : Développement > Langages > Shell Unix', 'Shell Unix', NULL, 9),
(36, 'Compétence : Développement > Langages > SQL', 'SQL', NULL, 9),
(37, 'Compétence : Développement > Langages > Swift', 'SOAP', NULL, 9),
(38, 'Compétence : Développement > Langages > VB.NET', 'Swift', NULL, 9),
(39, 'Compétence : Développement > Langages > Visual Basic', 'VB.NET', NULL, 9),
(40, 'Compétence : Développement > Langages > Wlangage', 'Visual Basic', NULL, 9),
(41, 'Compétence : Développement > Langages > JSON', 'Wlangage', NULL, 9),
(42, 'Compétence : Développement > Langages > XSD', 'XSD', NULL, 9),
(43, 'Compétence : Développement > Langages > WSDL', 'XML', NULL, 9),
(44, 'Compétence : Développement > Framework et Bibliothèque > Angular JS', 'Angular JS', NULL, 10),
(45, 'Compétence : Développement > Framework et Bibliothèque > Apache Struts', 'Apache Struts', NULL, 10),
(46, 'Compétence : Développement > Framework et Bibliothèque > Bootstrap', 'Bootstrap', NULL, 10),
(47, 'Compétence : Développement > Framework et Bibliothèque > CakePHP', 'CakePHP', NULL, 10),
(48, 'Compétence : Développement > Framework et Bibliothèque > Codelgniter', 'Codelgniter', NULL, 10),
(49, 'Compétence : Développement > Framework et Bibliothèque > Doctrine', 'Doctrine', NULL, 10),
(50, 'Compétence : Développement > Framework et Bibliothèque > Dojo Toolkit', 'Dojo Toolkit', NULL, 10),
(51, 'Compétence : Développement > Framework et Bibliothèque > eDirectory', 'eDirectory', NULL, 10),
(52, 'Compétence : Développement > Framework et Bibliothèque > Ember.js', 'Ember.js', NULL, 10),
(53, 'Compétence : Développement > Framework et Bibliothèque > Essential Object', 'Essential Object', NULL, 10),
(54, 'Compétence : Développement > Framework et Bibliothèque > FuelPHP', 'FuelPHP', NULL, 10),
(55, 'Compétence : Développement > Framework et Bibliothèque > Google Guava', 'Google Guava', NULL, 10),
(56, 'Compétence : Développement > Framework et Bibliothèque > Grails', 'Grails', NULL, 10),
(57, 'Compétence : Développement > Framework et Bibliothèque > Hibernate', 'Hibernate', NULL, 10),
(58, 'Compétence : Développement > Framework et Bibliothèque > JDBC', 'JDBC', NULL, 10),
(59, 'Compétence : Développement > Framework et Bibliothèque > Jquery', 'Jquery', NULL, 10),
(60, 'Compétence : Développement > Framework et Bibliothèque > Jquery UI', 'Jquery UI', NULL, 10),
(61, 'Compétence : Développement > Framework et Bibliothèque > Junit', 'Junit', NULL, 10),
(62, 'Compétence : Développement > Framework et Bibliothèque > Laravel', 'Laravel', NULL, 10),
(63, 'Compétence : Développement > Framework et Bibliothèque > Materialize', 'Materialize', NULL, 10),
(64, 'Compétence : Développement > Framework et Bibliothèque > OpenLDAP', 'OpenLDAP', NULL, 10),
(65, 'Compétence : Développement > Framework et Bibliothèque > OpenSSL', 'OpenSSL', NULL, 10),
(66, 'Compétence : Développement > Framework et Bibliothèque > Pixi.js', 'Pixi.js', NULL, 10),
(67, 'Compétence : Développement > Framework et Bibliothèque > Semantic UI', 'Semantic UI', NULL, 10),
(68, 'Compétence : Développement > Framework et Bibliothèque > Skeleton', 'Skeleton', NULL, 10),
(69, 'Compétence : Développement > Framework et Bibliothèque > Spring', 'Spring', NULL, 10),
(70, 'Compétence : Développement > Framework et Bibliothèque > Spring Boot', 'Spring Boot', NULL, 10),
(71, 'Compétence : Développement > Framework et Bibliothèque > Symfony', 'Symfony', NULL, 10),
(72, 'Compétence : Développement > Framework et Bibliothèque > Zend Framework', 'Zend Framework', NULL, 10),
(73, 'Compétence : Développement > Modélisation > Diagramme de classe', 'Diagramme de classe', NULL, 11),
(74, 'Compétence : Développement > Modélisation > Diagramme de cas d\'utilisation', 'Diagramme de cas d\'utilisation', NULL, 11),
(75, 'Compétence : Développement > Modélisation > Diagramme d\'objets', 'Diagramme d\'objets', NULL, 11),
(76, 'Compétence : Développement > Modélisation > Diagramme de séquence', 'Diagramme de séquence', NULL, 11),
(77, 'Compétence : Développement > Modélisation > Diagramme d\'activité', 'Diagramme d\'activité', NULL, 11),
(78, 'Compétence : Développement > Modélisation > Méthodologie > UML', 'UML', NULL, 24),
(79, 'Compétence : Développement > Modélisation > Méthodologie > Merise', 'Merise', NULL, 24),
(80, 'Compétence : Développement > Intégration continue > Ant', 'Ant', NULL, 12),
(81, 'Compétence : Développement > Intégration continue > Composer', 'Composer', NULL, 12),
(82, 'Compétence : Développement > Intégration continue > Graddle', 'Graddle', NULL, 12),
(83, 'Compétence : Développement > Intégration continue > Jenkins', 'Jenkins', NULL, 12),
(84, 'Compétence : Développement > Intégration continue > Maven', 'Maven', NULL, 12),
(85, 'Compétence : Développement > Versionning > CVS', 'CVS', NULL, 13),
(86, 'Compétence : Développement > Versionning > GIT', 'GIT', NULL, 13),
(87, 'Compétence : Développement > Versionning > Subversion', 'Subversion', NULL, 13),
(88, 'Compétence : Développement > Environnement de développement > Eclipse', 'Eclipse', NULL, 14),
(89, 'Compétence : Développement > Environnement de développement > InstallShield', 'InstallShield', NULL, 14),
(90, 'Compétence : Développement > Environnement de développement > IntelliJ IDEA', 'IntelliJ IDEA', NULL, 14),
(91, 'Compétence : Développement > Environnement de développement > Liferay Developer Studio', 'Liferay Developer Studio', NULL, 14),
(92, 'Compétence : Développement > Environnement de développement > NetBeans', 'NetBeans', NULL, 14),
(93, 'Compétence : Développement > Environnement de développement > PhpStorm', 'PhpStorm', NULL, 14),
(94, 'Compétence : Développement > Environnement de développement > Pkgbuild', 'Pkgbuild', NULL, 14),
(95, 'Compétence : Développement > Environnement de développement > QT Creator', 'QT Creator', NULL, 14),
(96, 'Compétence : Développement > Environnement de développement > RPM', 'RPM', NULL, 14),
(97, 'Compétence : Développement > Environnement de développement > Visual Studio', 'Visual Studio', NULL, 14),
(98, 'Compétence : Développement > Environnement de développement > Xcode', 'Xcode', NULL, 14),
(99, 'Compétence : Développement > Outils > Enterprise Architect', 'Enterprise Architect', NULL, 15),
(100, 'Compétence : Développement > Outils > PowerDesigner (PowerAMC)', 'PowerDesigner (PowerAMC)', NULL, 15),
(101, 'Compétence : Développement > Outils > VisualParadigm', 'VisualParadigm', NULL, 15),
(102, 'Compétence : Infrastucture > Serveurs d\'applications > Weblogic', 'Weblogic', NULL, 16),
(103, 'Compétence : Infrastucture > Serveurs d\'applications > Apache', 'Apache', NULL, 16),
(104, 'Compétence : Infrastucture > Serveurs d\'applications > Jetty', 'Jetty', NULL, 16),
(105, 'Compétence : Infrastucture > Serveurs d\'applications > Liferay', 'Liferay', NULL, 16),
(106, 'Compétence : Infrastucture > Serveurs d\'applications > Tomcat', 'Tomcat', NULL, 16),
(107, 'Compétence : Infrastucture > SGDB > Derby', 'Derby', NULL, 17),
(108, 'Compétence : Infrastucture > SGDB > MariaDB', 'MariaDB', NULL, 17),
(109, 'Compétence : Infrastucture > SGDB > Microsoft SQL Server', 'Microsoft SQL Server', NULL, 17),
(110, 'Compétence : Infrastucture > SGDB > MongoDB', 'MongoDB', NULL, 17),
(111, 'Compétence : Infrastucture > SGDB > MySQL', 'MySQL', NULL, 17),
(112, 'Compétence : Infrastucture > SGDB > Oracle Database', 'Oracle Database', NULL, 17),
(113, 'Compétence : Infrastucture > SGDB > PostgreSQL', 'PostgreSQL', NULL, 17),
(114, 'Compétence : Infrastucture > SGDB > SQLite', 'SQLite', NULL, 17),
(115, 'Compétence : Infrastucture > Système d\'exploitation > Serveur > AIX', 'AIX', NULL, 25),
(116, 'Compétence : Infrastucture > Système d\'exploitation > Serveur > Linux', 'Linux', NULL, 25),
(117, 'Compétence : Infrastucture > Système d\'exploitation > Serveur > Unix', 'Unix', NULL, 25),
(118, 'Compétence : Infrastucture > Système d\'exploitation > Poste de travail > Windows', 'Windows', NULL, 26),
(119, 'Compétence : Infrastucture > Système d\'exploitation > Poste de travail > Android', 'Android', NULL, 26),
(120, 'Compétence : Infrastucture > Système d\'exploitation > Poste de travail > IOS', 'IOS', NULL, 26),
(121, 'Compétence : Infrastucture > Système d\'exploitation > Poste de travail > Linux', 'Linux', NULL, 26),
(122, 'Compétence : Infrastucture > Système d\'exploitation > Poste de travail > Mac OS', 'Mac OS', NULL, 26),
(123, 'Compétence : Infrastucture > Système d\'exploitation > Poste de travail > Server TSE/Citrix', 'Server TSE/Citrix', NULL, 26),
(124, 'Compétence : Infrastucture > Système d\'exploitation > Poste de travail > Windows Desktop', 'Windows Desktop', NULL, 26),
(125, 'Compétence : Infrastucture > Réseau > Reverse Proxy', 'Reverse Proxy', NULL, 19),
(126, 'Compétence : Infrastucture > Réseau > Firewall', 'Firewall', NULL, 19),
(127, 'Compétence : Infrastucture > Réseau > Load Balancer', 'Load Balancer', NULL, 19),
(128, 'Compétence : Infrastucture > Réseau > Protocoles > HTTP(s)', 'HTTP(s)', NULL, 27),
(129, 'Compétence : Infrastucture > Réseau > Protocoles > REST, JSON', 'REST, JSON', NULL, 27),
(130, 'Compétence : Infrastucture > Réseau > Protocoles > S/MIME', 'S/MIME', NULL, 27),
(131, 'Compétence : Infrastucture > Réseau > Protocoles > SMTP', 'SMTP', NULL, 27),
(132, 'Compétence : Infrastucture > Réseau > Protocoles > SOAP, WSDL', 'SOAP, WSDL', NULL, 27),
(133, 'Compétence : Infrastucture > Réseau > Protocoles > TCP/IP', 'TCP/IP', NULL, 27),
(134, 'Compétence : Infrastucture > Outils > PhpMyAdmin', 'PhpMyAdmin', NULL, 20),
(135, 'Compétence : Infrastucture > Outils > MySQL-Front', 'MySQL-Front', NULL, 20),
(136, 'Compétence : Infrastucture > Outils > Oracle SQL Developer', 'Oracle SQL Developer', NULL, 20),
(137, 'Compétence : Infrastucture > Outils > PhpPgAdmin', 'PhpPgAdmin', NULL, 20),
(138, 'Compétence : Infrastucture > Outils > Workbench', 'Workbench', NULL, 20),
(139, 'Compétence : Conseil / AMOA > Analyse / Besoins client', 'Analyse / Besoins client', NULL, 5),
(140, 'Compétence : Conseil / AMOA > Communications', 'Communications', NULL, 5),
(141, 'Compétence : Conseil / AMOA > Livrables > Cahier des charges / Expression de besoin', 'Cahier des charges / Expression de besoin', NULL, 21),
(142, 'Compétence : Conseil / AMOA > Livrables > Spécifications fonctionnelles', 'Spécifications fonctionnelles', NULL, 21),
(143, 'Compétence : Conseil / AMOA > Livrables > Spécifications détaillées', 'Spécifications détaillées', NULL, 21),
(144, 'Compétence : Conseil / AMOA > Livrables > Rapport d\'audit', 'Rapport d\'audit', NULL, 21),
(145, 'Compétence : Validation > Livrables > Bilan de validation', 'Bilan de validation', NULL, 22),
(146, 'Compétence : Validation > Livrables > Cahier de tests techniques', 'Cahier de tests techniques', NULL, 22),
(147, 'Compétence : Validation > Livrables > Cahier de tests fonctionnels', 'Cahier de tests fonctionnels', NULL, 22),
(148, 'Compétence : Validation > Outils > BugTrackers > Bugzilla', 'Bugzilla', NULL, 28),
(149, 'Compétence : Validation > Outils > BugTrackers > JIRA', 'JIRA', NULL, 28),
(150, 'Compétence : Validation > Outils > BugTrackers > Mantis', 'Mantis', NULL, 28),
(151, 'Compétence : Validation > Outils > BugTrackers > Redmine', 'Redmine', NULL, 28),
(152, 'Compétence : Validation > Outils > Tests unitaires > Junit', 'Junit', NULL, 29),
(153, 'Compétence : Validation > Outils > Tests unitaires > SoapUI', 'SoapUI', NULL, 29),
(154, 'Compétence : Validation > Outils > Tests d\'intégration / Homologation technique > Jmeter', 'Jmeter', NULL, 30),
(155, 'Compétence : Validation > Outils > Tests d\'intégration / Homologation technique > HP ALM (Quality Center)', 'HP ALM (Quality Center)', NULL, 30),
(156, 'Compétence : Validation > Outils > Tests d\'intégration / Homologation technique > SonarQube', 'SonarQube', NULL, 30),
(157, 'Compétence : Validation > Outils > Management des tests > Test Link', 'Test Link', NULL, 31),
(158, 'Compétence : Validation > Outils > Management des tests > HP QuickTest Pro', 'HP QuickTest Pro', NULL, 31),
(159, 'Compétence : Validation > Outils > Management des tests > LoadRunner', 'LoadRunner', NULL, 31),
(160, 'Compétence : Validation > Outils > Management des tests > SAHI', 'SAHI', NULL, 31),
(161, 'Compétence : Validation > Outils > Management des tests > Selenium', 'Selenium', NULL, 31),
(162, 'Compétence : Validation > Outils > Management des tests > Sikuli', 'Sikuli', NULL, 31),
(163, 'Compétence : Validation > Outils > Management des tests > Squash TA', 'Squash TA', NULL, 31),
(164, 'Compétence : Validation > Outils > Management des tests > Squash TM', 'Squash TM', NULL, 31),
(165, 'Compétence : Certification > ITIL 2011', 'ITIL 2011', NULL, 7),
(166, 'Compétence : Certification > AgilePM', 'AgilePM', NULL, 7),
(167, 'Compétence : Certification > BigData', 'BigData', NULL, 7),
(168, 'Compétence : Certification > Business Analysis', 'Business Analysis', NULL, 7),
(169, 'Compétence : Certification > CCSA', 'CCSA', NULL, 7),
(170, 'Compétence : Certification > CCSE', 'CCSE', NULL, 7),
(171, 'Compétence : Certification > CGEIT', 'CGEIT', NULL, 7),
(172, 'Compétence : Certification > CISA', 'CISA', NULL, 7),
(173, 'Compétence : Certification > Cisco', 'Cisco', NULL, 7),
(174, 'Compétence : Certification > CISM', 'CISM', NULL, 7),
(175, 'Compétence : Certification > CISSO', 'CISSO', NULL, 7),
(176, 'Compétence : Certification > CISSP', 'CISSP', NULL, 7),
(177, 'Compétence : Certification > CLFE', 'CLFE', NULL, 7),
(178, 'Compétence : Certification > Cloud Computing', 'Cloud Computing', NULL, 7),
(179, 'Compétence : Certification > CMMI', 'CMMI', NULL, 7),
(180, 'Compétence : Certification > COBIT', 'COBIT', NULL, 7),
(181, 'Compétence : Certification > CTA (Cloud Technology Associate)', 'CTA (Cloud Technology Associate)', NULL, 7),
(182, 'Compétence : Certification > Cybersécurité ISO 27032', 'Cybersécurité ISO 27032', NULL, 7),
(183, 'Compétence : Certification > Data Protection Officer', 'Data Protection Officer', NULL, 7),
(184, 'Compétence : Certification > DevOps', 'DevOps', NULL, 7),
(185, 'Compétence : Certification > EBIOS 2010', 'EBIOS 2010', NULL, 7),
(186, 'Compétence : Certification > Fourniture de services SI', 'Fourniture de services SI', NULL, 7),
(187, 'Compétence : Certification > IREB', 'IREB', NULL, 7),
(188, 'Compétence : Certification > ISO 20000', 'ISO 20000', NULL, 7),
(189, 'Compétence : Certification > ISO 22301', 'ISO 22301', NULL, 7),
(190, 'Compétence : Certification > ISO 27001', 'ISO 27001', NULL, 7),
(191, 'Compétence : Certification > ISO 27005', 'ISO 27005', NULL, 7),
(192, 'Compétence : Certification > ISO 27034', 'ISO 27034', NULL, 7),
(193, 'Compétence : Certification > ISQI CMAP', 'ISQI CMAP', NULL, 7),
(194, 'Compétence : Certification > ISTQB', 'ISTQB', NULL, 7),
(195, 'Compétence : Certification > Lean IT', 'Lean IT', NULL, 7),
(196, 'Compétence : Certification > Lean Six Sigma', 'Lean Six Sigma', NULL, 7),
(197, 'Compétence : Certification > Mehari Risk Manager', 'Mehari Risk Manager', NULL, 7),
(198, 'Compétence : Certification > Microsoft', 'Microsoft', NULL, 7),
(199, 'Compétence : Certification > OMG Certified UML', 'OMG Certified UML', NULL, 7),
(200, 'Compétence : Certification > PCA (Professional Cloud Administrator)', 'PCA (Professional Cloud Administrator)', NULL, 7),
(201, 'Compétence : Certification > PCD (Professional Cloud Developer)', 'PCD (Professional Cloud Developer)', NULL, 7),
(202, 'Compétence : Certification > PCIE', 'PCIE', NULL, 7),
(203, 'Compétence : Certification > PCS (Professional Cloud Security Manager)', 'PCS (Professional Cloud Security Manager)', NULL, 7),
(204, 'Compétence : Certification > PCSA (Professional Cloud Solution Architect)', 'PCSA (Professional Cloud Solution Architect)', NULL, 7),
(205, 'Compétence : Certification > PCSM (Professional Cloud Service Manager)', 'PCSM (Professional Cloud Service Manager)', NULL, 7),
(206, 'Compétence : Certification > PHP Zend', 'PHP Zend', NULL, 7),
(207, 'Compétence : Certification > Prince2', 'Prince2', NULL, 7),
(208, 'Compétence : Certification > Référentiels PMP', 'Référentiels PMP', NULL, 7),
(209, 'Compétence : Certification > Risk Management', 'Risk Management', NULL, 7),
(210, 'Compétence : Certification > Scrum', 'Scrum', NULL, 7),
(211, 'Compétence : Certification > TMMi', 'TMMi', NULL, 7),
(212, 'Compétence : Certification > TOSA', 'TOSA', NULL, 7);

-- --------------------------------------------------------

--
-- Structure de la table `competence_acquise`
--

CREATE TABLE `competence_acquise` (
  `id` bigint(20) NOT NULL,
  `collaborateur_id` bigint(20) NOT NULL,
  `note` int(11) NOT NULL,
  `competence_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `competence_acquise`
--

INSERT INTO `competence_acquise` (`id`, `collaborateur_id`, `note`, `competence_id`) VALUES
(2, 7, 1, 166),
(3, 7, 1, 167),
(4, 7, 1, 168),
(5, 7, 1, 141),
(6, 7, 1, 144),
(7, 7, 1, 143),
(8, 7, 1, 142),
(9, 7, 1, 88),
(10, 7, 1, 90),
(11, 7, 1, 92),
(12, 7, 1, 45),
(13, 7, 1, 48),
(14, 7, 1, 80),
(15, 7, 1, 82),
(16, 7, 1, 14),
(17, 7, 1, 18),
(18, 7, 1, 79),
(19, 7, 1, 78),
(20, 7, 1, 74),
(21, 7, 1, 86),
(22, 7, 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `competence_requise`
--

CREATE TABLE `competence_requise` (
  `id` bigint(20) NOT NULL,
  `equipe_id` bigint(20) NOT NULL,
  `note` int(11) NOT NULL,
  `competence_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `competence_requise`
--

INSERT INTO `competence_requise` (`id`, `equipe_id`, `note`, `competence_id`) VALUES
(1, 6, 1, 166),
(13, 6, 1, 143),
(16, 6, 1, 90),
(18, 6, 1, 47),
(26, 6, 1, 171),
(27, 6, 1, 177),
(28, 6, 1, 181),
(29, 6, 1, 176),
(30, 6, 1, 44),
(31, 6, 1, 45),
(32, 6, 1, 46),
(33, 6, 1, 81);

-- --------------------------------------------------------

--
-- Structure de la table `databasechangelog`
--

CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `databasechangelog`
--

INSERT INTO `databasechangelog` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`, `DEPLOYMENT_ID`) VALUES
('insert_branche_1', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 1, 'EXECUTED', '7:faa5738c2c2a7ea2a3755458430756cf', 'insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_2', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 2, 'EXECUTED', '7:ee18be5407c1b44cc862f59e6baad99b', 'insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_3', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 3, 'EXECUTED', '7:9a5b460454f2c05a9b2703bcefd0ba6e', 'insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_4', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 4, 'EXECUTED', '7:34deb02a2b82804eb69a863e0c0672ca', 'insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_5', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 5, 'EXECUTED', '7:1f1e585b6f2421a43156dc0011dc7061', 'insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_6', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 6, 'EXECUTED', '7:e313288e3cb57327b8a943985203c4fa', 'insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_7', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 7, 'EXECUTED', '7:e24a08264abb723f32f797a3c36c1d8e', 'insert tableName=branche; insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_8', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 8, 'EXECUTED', '7:60d14cac68e81a35b1874d27626a2878', 'insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_9', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 9, 'EXECUTED', '7:bf3972e54b9d987b0d33453adf2c9bbd', 'insert tableName=branche; insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_10', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:20', 10, 'EXECUTED', '7:c957f01f94acd6b5a5a795fc58d1a2d2', 'insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_branche_11', 'pycoignard (generated)', 'classpath:/liquibase/data/add_branche.xml', '2018-07-19 13:45:21', 11, 'EXECUTED', '7:cb9ca4da27eb1df49011867b76da38f7', 'insert tableName=branche; insert tableName=branche; insert tableName=branche; insert tableName=branche', '', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_1', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 12, 'EXECUTED', '7:73bd0b9fb21d4487e62b26e9334bc752', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_2', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 13, 'EXECUTED', '7:2ea5cf01e53afe9bdceefea3bfe9f0e3', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_3', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 14, 'EXECUTED', '7:86ece6a55b746af9a71fa7ea321e72d2', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_4', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 15, 'EXECUTED', '7:b28273217189a3233dcf1af0af93b03b', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_5', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 16, 'EXECUTED', '7:e87e28a0e6c7baf010cd9528c1964927', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_6', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 17, 'EXECUTED', '7:4caec64d610c9c1d0049c40276faad15', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_7', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 18, 'EXECUTED', '7:c9ef9a61b08ece0b37b946c69409998a', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_8', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 19, 'EXECUTED', '7:f62715e80e24c1175577ff918d79992f', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_9', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 20, 'EXECUTED', '7:a2d45696649a8e4d16a7d84a4427725f', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_10', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 21, 'EXECUTED', '7:32d76b02e10c92fc91ac7a9effa845cf', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_11', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 22, 'EXECUTED', '7:df7bfbf818f39a49932cd5b5647a045a', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_12', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 23, 'EXECUTED', '7:a7b254510f806e68ded9d7600f4442a9', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_13', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 24, 'EXECUTED', '7:7f0bec2c0fcb2c77e7bf1a55e1ece6a8', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_14', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 25, 'EXECUTED', '7:607c876f8de6409ef7cf48c37844e8e2', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_15', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 26, 'EXECUTED', '7:f443d4805ef7889f479d71b8ed9d6a2a', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_16', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 27, 'EXECUTED', '7:12b6fc728bd8ae875b7e6032e9673e80', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_17', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 28, 'EXECUTED', '7:65fa2db80d605cdfbbb75ea9dc4b6033', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_18', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 29, 'EXECUTED', '7:d8ed92f9446c1b21a256493a11ca59df', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_19', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 30, 'EXECUTED', '7:e8c3733ae4629e77fae55adff589a94d', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_20', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 31, 'EXECUTED', '7:38349ce1cd455783ce214465dc2a3a49', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_21', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 32, 'EXECUTED', '7:8435b70dc0d56bfa2071bceab9896c62', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_22', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 33, 'EXECUTED', '7:975c80403e1699832e87b9ffe174342a', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_23', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 34, 'EXECUTED', '7:7c7c3ce217f5a760e4b60616792fbacc', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_24', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 35, 'EXECUTED', '7:9e74c5d24529ae8d995ac710c06d94ac', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877'),
('insert_competences_25', 'pycoignard (generated)', 'classpath:/liquibase/data/add_competence.xml', '2018-07-19 13:45:21', 36, 'EXECUTED', '7:937371eb94db2cca709745adadf4582a', 'sql', 'insert queries', NULL, '3.5.4', NULL, NULL, '2000720877');

-- --------------------------------------------------------

--
-- Structure de la table `databasechangeloglock`
--

CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `databasechangeloglock`
--

INSERT INTO `databasechangeloglock` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `branche`
--
ALTER TABLE `branche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKclqs6v3ta1go6q21ac2dolx07` (`branche_parente_id`);

--
-- Index pour la table `competence`
--
ALTER TABLE `competence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbfa522n5s7eqc1l0ybs5jwn6l` (`branche_parente_id`);

--
-- Index pour la table `competence_acquise`
--
ALTER TABLE `competence_acquise`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3dafkimekxk75lkf6puchc34o` (`competence_id`);

--
-- Index pour la table `competence_requise`
--
ALTER TABLE `competence_requise`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlawsd9hh4n234sh0j141lw18d` (`competence_id`);

--
-- Index pour la table `databasechangeloglock`
--
ALTER TABLE `databasechangeloglock`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `branche`
--
ALTER TABLE `branche`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT pour la table `competence`
--
ALTER TABLE `competence`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=213;

--
-- AUTO_INCREMENT pour la table `competence_acquise`
--
ALTER TABLE `competence_acquise`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `competence_requise`
--
ALTER TABLE `competence_requise`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `branche`
--
ALTER TABLE `branche`
  ADD CONSTRAINT `FKclqs6v3ta1go6q21ac2dolx07` FOREIGN KEY (`branche_parente_id`) REFERENCES `branche` (`id`);

--
-- Contraintes pour la table `competence`
--
ALTER TABLE `competence`
  ADD CONSTRAINT `FKbfa522n5s7eqc1l0ybs5jwn6l` FOREIGN KEY (`branche_parente_id`) REFERENCES `branche` (`id`);

--
-- Contraintes pour la table `competence_acquise`
--
ALTER TABLE `competence_acquise`
  ADD CONSTRAINT `FK3dafkimekxk75lkf6puchc34o` FOREIGN KEY (`competence_id`) REFERENCES `competence` (`id`);

--
-- Contraintes pour la table `competence_requise`
--
ALTER TABLE `competence_requise`
  ADD CONSTRAINT `FKlawsd9hh4n234sh0j141lw18d` FOREIGN KEY (`competence_id`) REFERENCES `competence` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
