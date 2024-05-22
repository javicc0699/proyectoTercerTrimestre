DROP DATABASE IF EXISTS proyecto;
CREATE DATABASE proyecto CHARSET utf8mb4;
USE proyecto;

CREATE TABLE coche (

    Matricula VARCHAR(7) PRIMARY KEY,
    Marca VARCHAR(45) NOT NULL,
    Modelo VARCHAR(45) NOT NULL,
    Anyo VARCHAR(4) NOT NULL,
    Caballos DOUBLE NOT NULL,
    Manejo DOUBLE NOT NULL

);

CREATE TABLE Pieza (

    Pieza VARCHAR(15) PRIMARY KEY,
    Caballosprop DOUBLE,
    Pmanejo DOUBLE

);

CREATE TABLE Circuito (

    idCircuito INT PRIMARY KEY,
    Curvas INT NOT NULL,
    Ubicacion VARCHAR(45),
    Dificultad ENUM('Baja', 'Media', 'Alta') NOT NULL

);

CREATE TABLE Modificar (

    Matricula VARCHAR(7),
    Pieza VARCHAR(15),
    Marca VARCHAR(45),
    Calidad ENUM('Fabrica' , 'Urbana' , 'Profesional' , 'Competicion'),
    PRIMARY KEY (Matricula, Pieza),
    FOREIGN KEY (Matricula) REFERENCES Coche(Matricula),
    FOREIGN KEY (Pieza) REFERENCES Pieza(Pieza)
);

CREATE TABLE Competicion (
    idCompeticion INT PRIMARY KEY AUTO_INCREMENT,
    idCircuito INT,
    Vueltas INT NOT NULL,
    Fecha DATE NOT NULL,
    Meteorologia ENUM('Soleado', 'Lluvioso', 'Niebla') NOT NULL,
    Hora ENUM('Amanecer', 'Dia', 'Noche') NOT NULL,
    FOREIGN KEY (idCircuito) REFERENCES Circuito(idCircuito)
    
);

CREATE TABLE Participantes (
	idCompeticion INT PRIMARY KEY auto_increment,
    idMatricula VARCHAR(7),
    FOREIGN KEY (idCompeticion) REFERENCES Competicion(idCompeticion),
    FOREIGN KEY (Matricula) REFERENCES Coche(Matricula)

);

INSERT INTO coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo)
VALUES ('ABC1234', 'Nissan', 'GTR', '2020', 500, 70);
INSERT INTO Pieza (Pieza, Caballosprop, Pmanejo)
VALUES ('Motor', 140, 0);
INSERT INTO Circuito (idCircuito, Curvas, Ubicacion, Dificultad)
VALUES (1, 154, 'Alemania', 'Alta');




