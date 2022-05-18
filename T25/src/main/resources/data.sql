DROP TABLE IF EXISTS fabricantes;
DROP TABLE IF EXISTS articulos;

CREATE TABLE fabricantes (
	id int auto_increment PRIMARY KEY,
	nombre nvarchar(100)
);

CREATE TABLE articulos (
	id int auto_increment PRIMARY KEY,
	nombre nvarchar(100),
	precio int,
	fabricante_id int,
	CONSTRAINT fabricante_fk FOREIGN KEY (fabricante_id) REFERENCES fabricantes (id)
);

INSERT INTO fabricantes (nombre) VALUES(('ToyGun'));
INSERT INTO fabricantes (nombre) VALUES(('DreamToys'));
INSERT INTO fabricantes (nombre) VALUES(('ToyRun'));

INSERT INTO articulos (nombre,precio,fabricante_id) VALUES ('Dungeons and dragons',40, 1);
INSERT INTO articulos (nombre,precio,fabricante_id) VALUES ('Magic the Gathering',55, 2);
INSERT INTO articulos (nombre,precio,fabricante_id) VALUES ('Enrique Master of tabique',100, 3);
INSERT INTO articulos (nombre,precio,fabricante_id) VALUES ('Master of Orion',15, 2);

