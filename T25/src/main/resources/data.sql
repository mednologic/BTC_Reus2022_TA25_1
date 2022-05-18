DROP TABLE IF EXISTS `videos`;
DROP table IF EXISTS cliente;


CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `apellido` varchar(250) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(250) DEFAULT NULL,
  `director` varchar(250) DEFAULT NULL,
  `cli_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `videos_fk` FOREIGN KEY (`cli_id`) REFERENCES `cliente` (`id`)
);


insert into cliente (nombre, apellido,direccion,dni,fecha)values('Jose','Marin','calle imaginaria 1',123456789, NOW());
insert into cliente (nombre, apellido,direccion,dni,fecha)values('Juan','Lopez','calle imaginaria 2',122222222, NOW());
insert into cliente (nombre, apellido,direccion,dni,fecha)values('Pedro','Guillem','calle imaginaria 3',123333333, NOW());
insert into cliente (nombre, apellido,direccion,dni,fecha)values('Jordi','Martin','calle imaginaria 4',123444444, NOW());
insert into cliente (nombre, apellido,direccion,dni,fecha)values('Jonatan','Vicente','calle imaginaria 5',123455555, NOW());

insert into videos (title, director,cli_id) values ('Titulo 01','Director 01',1);
insert into videos (title, director,cli_id) values ('Titulo 02','Director 02',1);
insert into videos (title, director,cli_id) values ('Titulo 03','Director 03',2);
insert into videos (title, director,cli_id) values ('Titulo 04','Director 04',2);

