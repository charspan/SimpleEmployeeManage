CREATE TABLE `department` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) DEFAULT NULL,
  `ddesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `joinDate` datetime DEFAULT NULL,
  `eno` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `dno` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FK4722E6AEA3D289E2` (`dno`),
  CONSTRAINT `FK4722E6AEA3D289E2` FOREIGN KEY (`dno`) REFERENCES `department` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
