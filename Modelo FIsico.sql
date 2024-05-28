DROP DATABASE IF EXISTS proyecto;
CREATE DATABASE proyecto CHARSET utf8mb4;
USE proyecto;
SET SQL_SAFE_UPDATES = 0;
CREATE TABLE Coche (
    Matricula VARCHAR(7) PRIMARY KEY,
    Marca VARCHAR(45) NOT NULL,
    Modelo VARCHAR(45) NOT NULL,
    Anyo VARCHAR(4) NOT NULL,
    Caballos DOUBLE NOT NULL,
    Manejo DOUBLE NOT NULL
);

CREATE TABLE Pieza (
    Codigo INT PRIMARY KEY,
    Pieza VARCHAR(15) NOT NULL,
    Calidad VARCHAR(45),
    CaballosProp DOUBLE,
    ManejoProp DOUBLE
);

CREATE TABLE Circuito (
    idCircuito INT PRIMARY KEY,
    Curvas INT NOT NULL,
    Ubicacion VARCHAR(45),
    Dificultad VARCHAR(15) NOT NULL
);

CREATE TABLE PiezaCoche (
	Codigo INT PRIMARY KEY,
    Matricula VARCHAR(7),
    FOREIGN KEY (Matricula) REFERENCES Coche(Matricula),
    FOREIGN KEY (Codigo) REFERENCES Pieza(Codigo)
);

CREATE TABLE Competicion (
    idCompeticion INT PRIMARY KEY AUTO_INCREMENT,
    idCircuito INT,
    Vueltas INT NOT NULL,
    Fecha DATE NOT NULL,
    Meteorologia VARCHAR(45) NOT NULL,
    Hora VARCHAR(45) NOT NULL,
    FOREIGN KEY (idCircuito) REFERENCES Circuito(idCircuito)
);

CREATE TABLE Participantes (
    idCompeticion INT,
    Matricula VARCHAR(7),
    PRIMARY KEY (idCompeticion, Matricula),
    FOREIGN KEY (idCompeticion) REFERENCES Competicion(idCompeticion),
    FOREIGN KEY (Matricula) REFERENCES Coche(Matricula)
);












