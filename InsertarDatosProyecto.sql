INSERT INTO Coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo)
VALUES 
('ABC1234', 'Toyota', 'Corolla', '2020', 150, 8.5),
('XYZ5678', 'Honda', 'Civic', '2019', 140, 9.0),
('LMN9101', 'Ford', 'Focus', '2018', 130, 7.5),
('DEF2345', 'BMW', '320i', '2021', 180, 8.0);


INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp)
VALUES 
(1, 'Turbo', 'Competicion', 20, 0),
(2, 'Frenos', 'Profesional', 0, 2.0),
(3, 'Escape', 'Urbano', 10, 0);


INSERT INTO Circuito (idCircuito, Curvas, Ubicacion, Dificultad)
VALUES 
(1, 15, 'Monaco', 'Alta'),
(2, 10, 'Silverstone', 'Media'),
(3, 20, 'Nurburgring', 'Alta');


INSERT INTO PiezaCoche (Codigo, Matricula)
VALUES 
(1, 'ABC1234'),
(2, 'XYZ5678'),
(3, 'LMN9101');

INSERT INTO Competicion (idCircuito, Vueltas, Fecha, Meteorologia, Hora)
VALUES 
(1, 50, '2023-05-01', 'Soleado', '14:00'),
(2, 60, '2023-06-15', 'Lluvioso', '16:00'),
(3, 45, '2022-12-10', 'Nublado', '13:00');


INSERT INTO Participantes (idCompeticion, Matricula)
VALUES 
(1, 'ABC1234'),
(1, 'XYZ5678'),
(2, 'LMN9101'),
(3, 'DEF2345');

