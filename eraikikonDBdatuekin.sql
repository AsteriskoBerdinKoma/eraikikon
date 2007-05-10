DROP DATABASE IF EXISTS `eraikikon`;
CREATE DATABASE `eraikikon` /*!40100 DEFAULT CHARACTER SET latin1 */;


DROP TABLE IF EXISTS `eraikikon`.`profilak`;
CREATE TABLE  `eraikikon`.`profilak` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `mota` varchar(45) NOT NULL,
  `deskribapena` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `eraikikon`.`erabiltzaileak`;
CREATE TABLE  `eraikikon`.`erabiltzaileak` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `izena` varchar(45) NOT NULL,
  `pasahitza` varchar(45) NOT NULL,
  `profId` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `profId` (`profId`),
  CONSTRAINT `profId` FOREIGN KEY (`profId`) REFERENCES `profilak` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `eraikikon`.`txartelak`;
CREATE TABLE  `eraikikon`.`txartelak` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `gaituData` datetime default NULL,
  `desgaituData` datetime default NULL,
  `erabId` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `erabId` (`erabId`),
  CONSTRAINT `erabId` FOREIGN KEY (`erabId`) REFERENCES `erabiltzaileak` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `eraikikon`.`guneak`;
CREATE TABLE  `eraikikon`.`guneak` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `izena` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `eraikikon`.`ateak`;
CREATE TABLE  `eraikikon`.`ateak` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `egoera` varchar(45) NOT NULL default 'itxita',
  `nagusia` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `eraikikon`.`txartelirakurgailuak`;
CREATE TABLE  `eraikikon`.`txartelirakurgailuak` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `guneId` int(10) unsigned NOT NULL,
  `ateId` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `guneId` (`guneId`),
  KEY `ateId` (`ateId`),
  CONSTRAINT `guneId` FOREIGN KEY (`guneId`) REFERENCES `guneak` (`id`),
  CONSTRAINT `ateId` FOREIGN KEY (`ateId`) REFERENCES `ateak` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `eraikikon`.`sarbideeskaerak`;
CREATE TABLE  `eraikikon`.`sarbideeskaerak` (
  `data` datetime NOT NULL,
  `baimenduta` tinyint(1) NOT NULL,
  `ukapenarenArrazoia` varchar(200) default NULL,
  `txId` int(10) unsigned NOT NULL,
  `txIrakurId` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`data`,`txIrakurId`),
  KEY `txId` (`txId`),
  KEY `txIrakurId` (`txIrakurId`),
  CONSTRAINT `txId` FOREIGN KEY (`txId`) REFERENCES `txartelak` (`id`),
  CONSTRAINT `txIrakurId` FOREIGN KEY (`txIrakurId`) REFERENCES `txartelirakurgailuak` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `eraikikon`.`intzidentziak`;
CREATE TABLE  `eraikikon`.`intzidentziak` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `data` datetime NOT NULL,
  `larritasuna` varchar(45) default NULL,
  `mota` varchar(200) NOT NULL,
  `deskribapena` varchar(200) default NULL,
  `idTxartela` int(10) unsigned NOT NULL,
  `idAtea` int(10) unsigned default NULL,
  `idTxartelIrakurgailua` int(10) unsigned default NULL,
  `gaituta` tinyint(1) NOT NULL,
  `noiztikNora` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `eraikikon`.`fakultatea`;
CREATE TABLE  `eraikikon`.`fakultatea` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `erId` int(10) unsigned NOT NULL,
  `guId` int(10) unsigned NOT NULL,
  `inId` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY(`erId`),
  KEY(`guId`),
  KEY(`inId`),
  CONSTRAINT `erId` FOREIGN KEY (`erId`) REFERENCES `erabiltzaileak` (`id`),
  CONSTRAINT `guId` FOREIGN KEY (`guId`) REFERENCES `guneak` (`id`),
  CONSTRAINT `inId` FOREIGN KEY (`inId`) REFERENCES `intzidentziak` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `eraikikon`.`ordutegia`;
CREATE TABLE `eraikikon`.`ordutegia` (
  `jaiEguna` TINYINT(1) NOT NULL DEFAULT '0',
  `haiseraOrdua` TIME NOT NULL,
  `bukaeraOrdua` TIME NOT NULL,
  `proId` INTEGER UNSIGNED NOT NULL,
  `gunId` INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY USING BTREE (`haiseraOrdua`, `proId`, `gunId`),
  KEY `proId` (`proId`),
  KEY `gunId` (`gunId`),
  CONSTRAINT `proId` FOREIGN KEY `proId` (`proId`)
    REFERENCES `profilak` (`id`),
  CONSTRAINT `gunId` FOREIGN KEY `gunId` (`gunId`)
    REFERENCES `guneak` (`id`)
)
ENGINE = InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `eraikikon`.`profilak` (mota,deskribapena) VALUES ("Irakaslea","irakasleen buleagoak");
INSERT INTO `eraikikon`.`profilak` (mota,deskribapena) VALUES ("Ikaslea","ikasleen gelak");
INSERT INTO `eraikikon`.`profilak` (mota,deskribapena) VALUES ("Arduraduna","laborategiak");

INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("pepe","sareak2", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Jon","sistemaEragileak", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Arantxa","programazioa", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Jon", "DEA", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Itziar","estadistika", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Xabier","programazio2", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Juanan","software", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Txelo","elektronika", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Patxi","analisis", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Luis","fisika", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Inaki","sistemenkud", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Alex","sareak", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Josune","analisi", 1);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Aitziber","iza", 2);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Benat","lizarazu", 2);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Inko","perurena", 2);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Idoia","lertxundi", 2);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Dani","Campos", 2);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Amagoia","Agirre", 2);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Janire","lasheras", 2);
INSERT INTO `eraikikon`.`erabiltzaileak` (izena,pasahitza,profId) VALUES ("Garazi","nirea", 3);


INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2006-07-30 13:00:45',1);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2007-01-20 12:13:59',2);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2005-01-17 12:13:59',3);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2004-01-08 12:13:59',4);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2007-03-20 12:13:59',5);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2004-12-19 12:13:59',6);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2006-02-12 12:13:59',7);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2007-02-10 12:13:59',8);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2005-01-28 12:13:59',9);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2004-09-30 12:13:59',10);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2004-10-27 12:13:59',11);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2005-01-20 12:13:59',12);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2006-11-22 12:13:59',13);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2007-01-16 12:13:59',14);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2005-08-02 12:13:59',15);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2007-02-15 12:13:59',16);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2006-12-04 12:13:59',17);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2006-03-12 12:13:59',18);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2004-05-25 12:13:59',19);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2006-01-24 12:13:59',20);
INSERT INTO `eraikikon`.`txartelak` (gaituData,erabId) VALUES ('2007-01-20 12:13:59',21);

INSERT INTO `eraikikon`.`ateak` (nagusia) VALUES (true);  #Kalea eta Gune1 lotzen dituen atea
INSERT INTO `eraikikon`.`ateak` () VALUES ();  #Gune1 eta Gune2 lotzen dituen atea
INSERT INTO `eraikikon`.`ateak` () VALUES ();  #Gune2 eta Gune3 lotzen dituen atea
INSERT INTO `eraikikon`.`ateak` () VALUES ();  #Gune1 eta Gune4 lotzen dituen atea
INSERT INTO `eraikikon`.`ateak` () VALUES ();  #Gune3 eta Gune6 lotzen dituen atea
INSERT INTO `eraikikon`.`ateak` () VALUES ();  #Gune4 eta Gune5 lotzen dituen atea
INSERT INTO `eraikikon`.`ateak` () VALUES ();  #Gune5 eta Gune6 lotzen dituen atea

INSERT INTO `eraikikon`.`guneak` (izena) VALUES ("KALEA");
INSERT INTO `eraikikon`.`guneak` (izena) VALUES ("hall");
INSERT INTO `eraikikon`.`guneak` (izena) VALUES ("lab1");
INSERT INTO `eraikikon`.`guneak` (izena) VALUES ("lab2");
INSERT INTO `eraikikon`.`guneak` (izena) VALUES ("lab3");
INSERT INTO `eraikikon`.`guneak` (izena) VALUES ("lab4");
INSERT INTO `eraikikon`.`guneak` (izena) VALUES ("lab5");


INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (1,1);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (2,1);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (2,2);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (2,4);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (3,2);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (3,3);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (4,3);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (4,5);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (5,4);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (5,6);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (6,6);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (6,7);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (7,5);
INSERT INTO `eraikikon`.`txartelirakurgailuak` (guneId,ateId) VALUES (7,7);

INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-08-30 13:00:07' ,true,null,1,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-25 13:22:07' ,false,"Baimenik ez",2,4);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-01-04 20:00:07' ,true,null,1,9);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-09-30 21:54:07' ,false,"errore ezezaguna",3,5);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-07-30 13:21:07' ,true,null,4,5);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-13 03:00:07' ,false,"Baimenik ez",5,5);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-07-21 09:00:07' ,false,"Atea puxkatuta",6,8);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-12-18 08:00:07' ,true,null,7,7);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-05 11:00:07' ,false,"Baimenik ez",7,9);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-15 12:00:07' ,true,null,8,6);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-05-23 17:00:07' ,false,"errore ezezaguna",9,8);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-11-17 18:00:07' ,false,"Baimenik ez",10,4);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-12-12 19:00:07' ,false,"Atea puxkatuta",11,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-01 15:00:07' ,false,"errore ezezaguna",12,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-01-30 14:00:07' ,true,null,12,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-12-23 16:00:07' ,false,"Baimenik ez",13,2);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-19 10:00:07' ,true,null,14,1);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-05 10:34:07' ,false,"errore ezezaguna",14,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-08-26 09:22:07' ,true,null,15,1);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-16 08:12:07' ,false,"Baimenik ez",15,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-10 12:25:07' ,false,"errore ezezaguna",13,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-05 13:56:07' ,false,"Baimenik ez",13,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-07 20:06:07' ,false,"Baimenik ez",13,2);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-12 11:04:07' ,false,"Baimenik ez",13,6);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-01-30 12:37:07' ,false,"Atea puxkatuta",17,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-09-24 15:34:07' ,true,null,18,6);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-01 16:53:07' ,false,"Atea puxkatuta",16,10);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-04-22 14:42:07' ,true,null,11,9);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-01-30 17:29:07' ,false,"errore ezezaguna",1,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-14 17:38:07' ,false,"Baimenik ez",2,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-15 18:49:07' ,true,null,8,8);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-07-14 19:22:07' ,true,null,7,8);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-04 14:11:07' ,false,"Baimenik ez",8,5);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-09-19 16:23:07' ,false,"Atea puxkatuta",10,6);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-05-20 11:11:07' ,false,"errore ezezaguna",9,9);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-10 12:12:07' ,false,"errore ezezaguna",2,8);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-08-28 13:01:07' ,false,"Atea puxkatuta",3,7);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-12-17 14:56:07' ,true,null,4,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-28 18:08:07' ,false,"errore ezezaguna",5,2);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-09 12:02:07' ,false,"errore ezezaguna",5,4);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-01-30 22:22:07' ,false,"Atea puxkatuta",13,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-05-30 09:33:07' ,false,"Atea puxkatuta",6,4);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-11-22 08:44:07' ,true,null,7,5);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-05-21 07:22:07' ,true,null,3,1);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-10-30 22:05:07' ,false,"Baimenik ez",1,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-04 08:08:07' ,false,"Baimenik ez",8,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-01-08 23:02:07' ,false,"errore ezezaguna",13,2);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-03-25 09:09:07' ,false,"Atea puxkatuta",11,2);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-07-23 09:07:07' ,false,"Baimenik ez",3,1);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-02-27 08:05:07' ,false,"Atea puxkatuta",5,3);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-06-30 21:03:07' ,true,null,4,4);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-09-24 12:16:07' ,false,"Baimenik ez",1,4);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-07-30 15:22:07' ,false,"Atea puxkatuta",6,5);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-09-24 17:55:07' ,false,"errore ezezaguna",9,5);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-03-08 13:51:07' ,false,"Atea puxkatuta",8,6);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2004-11-30 16:47:07' ,false,"errore ezezaguna",11,7);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-12-15 12:34:07' ,true,null,13,7);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2006-12-22 16:50:07' ,false,"Baimenik ez",11,8);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2005-01-30 12:40:07' ,false,"Atea puxkatuta",10,9);
INSERT INTO `eraikikon`.`sarbideeskaerak` (data,baimenduta,ukapenarenArrazoia,txId,txIrakurId) VALUES ('2007-01-30 13:20:07' ,false,"Atea puxkatuta",1,10);

INSERT INTO `eraikikon`.`intzidentziak` (data,larritasuna,mota,deskribapena,idTxartela,idAtea,idTxartelIrakurgailua,gaituta) VALUES ('2005-07-30 15:22:07',"larria","sarbide eskaera ukatua","Atea puxkatuta",6,4,5,true);
INSERT INTO `eraikikon`.`intzidentziak` (data,larritasuna,mota,deskribapena,idTxartela,idAtea,idTxartelIrakurgailua,gaituta) VALUES ('2007-03-04 14:11:07',"oso larria","sarbide eskaera ukatua","baimenik ez",8,4,5,true);
INSERT INTO `eraikikon`.`intzidentziak` (data,larritasuna,mota,deskribapena,idTxartela,idAtea,idTxartelIrakurgailua,gaituta) VALUES ('2004-11-30 16:47:07',"larria","sarbide eskaera ukatua","errore ezezaguna",11,4,7,true);