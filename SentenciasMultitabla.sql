-- 1 Consulta de todas las competiciones con detalles del circuito y numero de coches participantes.
SELECT Competicion.idCompeticion, Circuito.Ubicacion, Circuito.Dificultad, COUNT(Participantes.Matricula) AS NumeroDeCoches
FROM Competicion
JOIN Circuito ON Competicion.idCircuito = Circuito.idCircuito
LEFT JOIN Participantes ON Competicion.idCompeticion = Participantes.idCompeticion
GROUP BY Competicion.idCompeticion, Circuito.Ubicacion, Circuito.Dificultad;

-- 2 Consulta de coches que han participado en al menos una competición:
SELECT Coche.Matricula, Coche.Marca, Coche.Modelo, Coche.Anyo
FROM Coche
WHERE EXISTS (SELECT 1 FROM Participantes WHERE Participantes.Matricula = Coche.Matricula);
-- 
-- 3 Consulta del coche con más caballos en cada marca:
SELECT Marca, Modelo, MAX(Caballos) AS MasCaballos
FROM Coche
GROUP BY Marca, Modelo;

-- 4 Consulta de los coches y las piezas instaladas, junto con las propiedades adicionales de las piezas:
SELECT Coche.Matricula, Coche.Marca, Coche.Modelo, Pieza.Pieza, Pieza.Calidad, Pieza.CaballosProp, Pieza.ManejoProp
FROM Coche
JOIN PiezaCoche ON Coche.Matricula = PiezaCoche.Matricula
JOIN Pieza ON PiezaCoche.Codigo = Pieza.Codigo;

-- 5 Consulta de competiciones con condiciones meteorológicas específicas y detalles de los coches participantes:
SELECT Competicion.Fecha, Competicion.Meteorologia, Coche.Matricula, Coche.Marca, Coche.Modelo
FROM Competicion
JOIN Participantes ON Competicion.idCompeticion = Participantes.idCompeticion
JOIN Coche ON Participantes.Matricula = Coche.Matricula
WHERE Competicion.Meteorologia = 'Soleado';

-- 6 Actualización de la calidad de una pieza basada en un código específico:
UPDATE Pieza
SET Calidad = 'Profesional'
WHERE Codigo = 1;

-- 7 Actualización de los caballos de los coches que tienen una pieza específica instalada:
-- UPDATE Coche
-- SET Caballos = Caballos + (SELECT CaballosProp FROM Pieza WHERE Pieza.Codigo = 1)
-- WHERE Matricula IN (SELECT Matricula FROM PiezaCoche WHERE Codigo = 1);

-- 8 Borrado de las competiciones que ocurrieron antes de una fecha específica:
-- DELETE FROM Competicion
-- WHERE Fecha < '2023-01-01';