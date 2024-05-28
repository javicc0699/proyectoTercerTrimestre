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
    Pieza VARCHAR(45) NOT NULL,
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
    Codigo INT,
    Matricula VARCHAR(7),
    PRIMARY KEY (Codigo, Matricula),
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


INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (1, 'Motor Urbano', 'Urbana', 30, 0);
INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (2, 'Motor Profesional', 'Profesional', 90, 0);
INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (3, 'Motor Competición', 'Competición', 130, 0);

INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (4, 'Escape 1', 'Urbana', 12, 0);
INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (5, 'Escape 2', 'Profesional', 35, 0);
INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (6, 'Escape 3', 'Competición', 43, 0);

INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (7, 'Frenos 1', 'Urbana', 0, 4);
INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (8, 'Frenos 2', 'Profesional', 0, 9);
INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (9, 'Frenos 3', 'Competición', 0, 15);

INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (10, 'Neumaticos 1', 'Urbana', 0, 14);
INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (11, 'Neumaticos 2', 'Profesional', 0, 24);
INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (12, 'Neumaticos 3', 'Competición', 0, 29);

INSERT INTO Coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo)
VALUES ('1000ccc', 'Toyota', 'Corolla', '2020', 150, 8.5)











