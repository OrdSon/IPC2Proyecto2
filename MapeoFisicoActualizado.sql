CREATE DATABASE revistas;
USE revistas1;

CREATE TABLE usuario(
	codigo INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(150),
	email VARCHAR(150),
	nombre_usuario VARCHAR(45),
	tipo INT,
	contraseña VARCHAR(45),
	CONSTRAINT pk_usuario PRIMARY KEY (codigo)
);

CREATE TABLE info_pago(
	codigo INT NOT NULL AUTO_INCREMENT,
	tarjeta VARCHAR(19),
	cuenta_bancaria VARCHAR(45),
	vencimiento DATE,
	usuario_codigo INT,
	CONSTRAINT pk_info_pago PRIMARY KEY (codigo),
	CONSTRAINT fk_info_pago_usuario FOREIGN KEY (usuario_codigo) REFERENCES usuario(codigo)
);

CREATE TABLE perfil(
	codigo INT NOT NULL AUTO_INCREMENT,
    foto MEDIUMBLOB,
    hobbies TEXT(500),
    descripcion TEXT(500),
    usuario_codigo INT,
    CONSTRAINT pk_perfil PRIMARY KEY (codigo),
    CONSTRAINT fk_perfil_usuario FOREIGN KEY (usuario_codigo) REFERENCES usuario(codigo)
);

CREATE TABLE categoria(
	codigo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50),
    CONSTRAINT pk_categoria PRIMARY KEY (codigo)
);

CREATE TABLE revista(
	codigo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion TEXT(1000),
    fecha DATE,
    autor INT,
    precio DOUBLE,
    CONSTRAINT pk_revista PRIMARY KEY(codigo),
    CONSTRAINT fk_usuario_revista FOREIGN KEY (autor) REFERENCES usuario(codigo)
);

CREATE TABLE relacion(
	codigo INT NOT NULL AUTO_INCREMENT,
    codigo_revista INT,
    codigo_categoria INT,
    CONSTRAINT pk_relacion PRIMARY KEY(codigo),
    CONSTRAINT fk_relacion_revista FOREIGN KEY(codigo_revista) REFERENCES revista(codigo),
    CONSTRAINT fk_relacion_categoria FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
);

CREATE TABLE preferencia(
	codigo INT NOT NULL AUTO_INCREMENT,
    usuario_codigo INT,
    categoria_codigo INT,
    CONSTRAINT pk_preferencia PRIMARY KEY (codigo),
    CONSTRAINT fk_preferencia_usuario FOREIGN KEY (usuario_codigo) REFERENCES usuario(codigo),
    CONSTRAINT fk_preferencia_categoria FOREIGN KEY (categoria_codigo) REFERENCES categoria(codigo)
);

CREATE TABLE suscripcion (
    codigo INT NOT NULL AUTO_INCREMENT,
	usuario_codigo INT,
    revista_codigo INT,
    fecha DATE,
    CONSTRAINT pk_suscripcion PRIMARY KEY (codigo),
    CONSTRAINT fk_suscripcion_usuario FOREIGN KEY (usuario_codigo)
        REFERENCES usuario(codigo),
	CONSTRAINT fk_suscripcion_revista FOREIGN KEY (revista_codigo)
        REFERENCES revista(codigo)
);

CREATE TABLE pago(
	codigo INT NOT NULL AUTO_INCREMENT,
    fecha DATE,
    monto DOUBLE,
    suscripcion_codigo INT,
    usuario_codigo INT,
    CONSTRAINT pk_pago PRIMARY KEY(codigo),
    CONSTRAINT fk_pago_suscripcion FOREIGN KEY(suscripcion_codigo)
    REFERENCES suscripcion(codigo),
    CONSTRAINT fk_pago_usuario FOREIGN KEY(usuario_codigo)
    REFERENCES usuario(codigo)
);

CREATE TABLE tag(
	codigo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45),
    CONSTRAINT pk_tag PRIMARY KEY(codigo)
);

CREATE TABLE anunciante(
	codigo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    CONSTRAINT pk_anunciante PRIMARY KEY(codigo)
);

CREATE TABLE numero(
	codigo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion TEXT(1000),
    fecha_publicacion DATE,
    numero INT,
    likes INT,
    revista_codigo INT,
    archivo mediumblob,
    CONSTRAINT pk_numero PRIMARY KEY(codigo),
    CONSTRAINT fk_numero_revista FOREIGN KEY (revista_codigo)
    REFERENCES revista(codigo)
);

CREATE TABLE referencia(
    numero_codigo INT,
    tag_codigo INT,
    CONSTRAINT fk_referencia_numero FOREIGN KEY (numero_codigo)
    REFERENCES numero(codigo),
    CONSTRAINT fk_referencia_tag FOREIGN KEY (tag_codigo)
    REFERENCES tag(codigo)
);

CREATE TABLE anuncio(
	codigo INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(45),
    cantidad_horas INT,
    archivo MEDIUMBLOB,
    anunciante_codigo INT,
    CONSTRAINT pk_anuncio PRIMARY KEY(codigo),
    CONSTRAINT fk_anuncio_anunciante FOREIGN KEY(anunciante_codigo)
    REFERENCES anunciante(codigo)
);

CREATE TABLE publico(
	anuncio_codigo INT,
    tag_codigo INT,
    CONSTRAINT fk_publico_anuncio FOREIGN KEY (anuncio_codigo)
    REFERENCES anuncio(codigo),
    CONSTRAINT fk_publico_tag FOREIGN KEY (tag_codigo)
    REFERENCES tag(codigo)
);

CREATE TABLE review(
	codigo INT NOT NULL AUTO_INCREMENT,
	likes TINYINT,
    comentario TEXT(1000),
    usuario_codigo INT,
    numero_codigo INT,
    CONSTRAINT pk_review PRIMARY KEY(codigo),
    CONSTRAINT fk_review_usuario FOREIGN KEY (usuario_codigo) REFERENCES usuario(codigo),
	CONSTRAINT fk_review_numero FOREIGN KEY (numero_codigo) REFERENCES numero(codigo)
);

CREATE TABLE settings(
	codigo INT NOT NULL AUTO_INCREMENT,
    porcentaje_cobro DOUBLE,
    cuota_diaria DOUBLE,
    precio_hora_anuncio DOUBLE,
    CONSTRAINT pk_settings PRIMARY KEY(codigo)
);

CREATE TABLE cuota_diaria(
	codigo INT NOT NULL AUTO_INCREMENT,
    monto DOUBLE,
    fecha DATE,
    revista_codigo INT,
    CONSTRAINT pk_cuota_diaria PRIMARY KEY(codigo),
    CONSTRAINT fk_cuota_diaria_revista FOREIGN KEY (revista_codigo) REFERENCES revista(codigo)
);

CREATE TABLE cobro(
	codigo INT NOT NULL AUTO_INCREMENT,
    anuncio_codigo INT,
    pago_codigo INT,
    cuota_diaria_codigo INT,
    monto DOUBLE,
    fecha DATE,
    CONSTRAINT pk_cobro PRIMARY KEY (codigo),
    CONSTRAINT fk_cobro_anuncio FOREIGN KEY (anuncio_codigo) REFERENCES anuncio(codigo),
    CONSTRAINT fk_cobro_pago FOREIGN KEY (pago_codigo) REFERENCES pago(codigo),
    CONSTRAINT fk_cobro_cuota FOREIGN KEY (cuota_diaria_codigo) REFERENCES cuota_diaria(codigo)
);

CREATE TABLE caja(
	codigo INT NOT NULL AUTO_INCREMENT,
    capital DOUBLE,
    CONSTRAINT pk_caja PRIMARY KEY(codigo)
);

alter table suscripcion add estado varchar(5);
alter table suscripcion add pagos INT;
alter table suscripcion add proximoPago DATE;

alter table numero add estado_reviews varchar(5);
alter table revista add estado_suscripciones varchar(5);
alter table review add fecha DATE;

alter table anuncio add veces INT;
alter table anuncio add fecha DATE;
alter table anuncio add final DATE;

INSERT INTO settings(porcentaje_cobro, cuota_diaria, precio_hora_anuncio) VALUES (20, 30, 40);

CREATE USER 'revistero'@'localhost' IDENTIFIED BY 'PassW123.';
ALTER USER 'revistero'@'localhost' IDENTIFIED WITH mysql_native_password BY 'PassW123.';
GRANT ALL PRIVILEGES ON revistas . * TO 'revistero'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
