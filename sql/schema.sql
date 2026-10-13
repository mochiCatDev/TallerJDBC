-- Creación de la base de datos
create database tallerjdbc;

-- Creación de la tabla vehiculos
create table vehiculos(
	placa VARCHAR(10) primary key,
	marca VARCHAR(50) not null,
	modelo VARCHAR(50) not null,
	anio INT not null,
	precio DOUBLE precision not null,
	color VARCHAR(30),
	disponible BOOLEAN not null
);
