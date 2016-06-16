DROP TABLE IF EXISTS log_session CASCADE
;
DROP TABLE IF EXISTS direcciones_mascota CASCADE
;
DROP TABLE IF EXISTS mascota CASCADE
;
DROP TABLE IF EXISTS persona CASCADE
;

CREATE TABLE log_session
(
	id_session BIGINT NOT NULL AUTO_INCREMENT,
	id_persona BIGINT NOT NULL,
	token VARCHAR(150) NOT NULL,
	fecha DATE,
	hora TIME,
	estado INTEGER,
	PRIMARY KEY (id_session),
	KEY (id_persona)

) 
;


CREATE TABLE direcciones_mascota
(
	id_direccion BIGINT NOT NULL AUTO_INCREMENT,
	id_mascota BIGINT,
	latitud VARCHAR(150) NOT NULL,
	longitud VARCHAR(150) NOT NULL,
	direccion TEXT,
	comentario TEXT,
	fecha DATETIME NOT NULL,
	imagen TEXT,
	numero_contacto VARCHAR(50),
	usuario VARCHAR(50),
	estado INTEGER,
	PRIMARY KEY (id_direccion),
	KEY (id_mascota)

) 
;


CREATE TABLE mascota
(
	id_mascota BIGINT NOT NULL AUTO_INCREMENT,
	id_persona BIGINT,
	nombre_mascota VARCHAR(150) NOT NULL,
	genero VARCHAR(50) NOT NULL,
	tipo VARCHAR(150) NOT NULL,
	raza VARCHAR(50),
	codigo_mascota VARCHAR(150),
	imagen TEXT,
	color TEXT,
	estado INTEGER,
	PRIMARY KEY (id_mascota),
	KEY (id_persona)

) 
;


CREATE TABLE persona
(
	id_persona BIGINT NOT NULL AUTO_INCREMENT,
	usuario VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	nombre_persona VARCHAR(150) NOT NULL,
	apellido_persona VARCHAR(150) NOT NULL,
	ciudad VARCHAR(50) NOT NULL,
	direccion_persona TEXT,
	latitud VARCHAR(150) NOT NULL,
	longitud VARCHAR(150) NOT NULL,
	estado INTEGER NOT NULL,
	PRIMARY KEY (id_persona),
	UNIQUE UQ_Persona_usuario(usuario)

) 
;





ALTER TABLE log_session ADD CONSTRAINT FK_Session_Persona 
	FOREIGN KEY (id_persona) REFERENCES persona (id_persona)
;

ALTER TABLE direcciones_mascota ADD CONSTRAINT FK_direcciones_mascota_Mascota 
	FOREIGN KEY (id_mascota) REFERENCES mascota (id_mascota)
;

ALTER TABLE mascota ADD CONSTRAINT FK_Mascota_Persona 
	FOREIGN KEY (id_persona) REFERENCES persona (id_persona)
;
