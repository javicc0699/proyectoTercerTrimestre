-- Vistas

-- Esta vista muestra los coches y las piezas que tiene instaladas y las estadisticas que le proporciona
DROP VIEW IF EXISTS VistaCochePiezas;
CREATE VIEW VistaCochePiezas AS
SELECT Coche.Matricula, Coche.Marca, Coche.Modelo, Pieza.Pieza, Pieza.Calidad, Pieza.CaballosProp, Pieza.ManejoProp
FROM Coche
JOIN PiezaCoche ON Coche.Matricula = PiezaCoche.Matricula
JOIN Pieza ON PiezaCoche.Codigo = Pieza.Codigo;

SELECT * FROM VistaCochePiezas;
-- Una vista que muestra detalles de las competiciones, incluyendo el identificador de la competicion, 
-- la ubicación y dificultad del circuito y el numero de coches participantes en cada competicion.
DROP VIEW IF EXISTS VistaCompeticionDetalles;
CREATE VIEW VistaCompeticionDetalles AS
SELECT Competicion.idCompeticion, Circuito.Ubicacion, Circuito.Dificultad, COUNT(Participantes.Matricula) AS NumCoches
FROM Competicion
JOIN Circuito ON Competicion.idCircuito = Circuito.idCircuito
LEFT JOIN Participantes ON Competicion.idCompeticion = Participantes.idCompeticion
GROUP BY Competicion.idCompeticion, Circuito.Ubicacion, Circuito.Dificultad;

SELECT * FROM VistaCompeticionDetalles;