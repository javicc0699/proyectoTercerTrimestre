DROP DATABASE IF EXISTS proyecto;
CREATE DATABASE proyecto CHARSET utf8mb4;
USE proyecto;

CREATE TABLE Coche (
    Matricula VARCHAR(7) PRIMARY KEY,
    Marca VARCHAR(45) NOT NULL,
    Modelo VARCHAR(45) NOT NULL,
    Anyo VARCHAR(4) NOT NULL,
    Caballos DOUBLE NOT NULL,
    Manejo DOUBLE NOT NULL
);

CREATE TABLE TipoPieza (
    Pieza VARCHAR(15) PRIMARY KEY,
    CaballosPorc DOUBLE,
    ManejoPorc DOUBLE
);

-- Crear tabla Circuito
CREATE TABLE Circuito (
    idCircuito INT PRIMARY KEY,
    Curvas INT NOT NULL,
    Ubicacion VARCHAR(45),
    Dificultad VARCHAR(15) NOT NULL
);


CREATE TABLE PiezasCoche (
    Matricula VARCHAR(7),
    Pieza VARCHAR(15),
    Calidad VARCHAR(45),
    CaballosPieza DOUBLE,
    ManejoPieza DOUBLE,
    PRIMARY KEY (Matricula, Pieza),
    FOREIGN KEY (Matricula) REFERENCES Coche(Matricula),
    FOREIGN KEY (Pieza) REFERENCES TipoPieza(Pieza)
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


INSERT INTO Coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo)
VALUES ('ABC1234', 'Nissan', 'GTR', '2020', 500, 70);

INSERT INTO TipoPieza (Pieza, CaballosPorc, ManejoPorc)
VALUES ('Motor', 140, 0);

INSERT INTO Circuito (idCircuito, Curvas, Ubicacion, Dificultad)
VALUES (1, 154, 'Alemania', 'Alta');
