

CREATE TABLE `tb_register` (
  `uid` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` char(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='simulate register demo by servlet jsp ';


INSERT INTO simulate.tb_register (uid,user_name,password,email,name,sex,birthday) VALUES 
('347ba2e0-427a-4626-b239-12b8f60141f8','si.li','lisi','si.li@gmail.com','李四','male','2018-01-01')
,('4511398a-a599-4d40-a7ed-3891b0c7ca0a','asdf','','asdf@test.com','asf','female','1997-01-01')
,('64b6af2d-edc3-4c36-843c-1c41ae8dc592','wu.wang','wangwu','wu.wang@outlook.com','王五','female','2018-01-01')
,('b27084a6-8a93-4f36-839c-df3d3a162e0e','san.zhang','zhangsan','san.zhang@gmail.com','張三','female','1997-01-01')
;