-- Procedimientos
-- Este procedimiento sirve para crear un coche.
USE proyecto;

USE proyecto;

DELIMITER $$
DROP PROCEDURE IF EXISTS crearCoche;
CREATE PROCEDURE crearCoche(
    IN pMatricula VARCHAR(7), 
    IN pMarca VARCHAR(45), 
    IN pModelo VARCHAR(45), 
    IN pAnyo VARCHAR(4), 
    IN pCaballos DOUBLE, 
    IN pManejo DOUBLE
)
BEGIN
    INSERT INTO Coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo)
    VALUES (pMatricula, pMarca, pModelo, pAnyo, pCaballos, pManejo);
END $$
DELIMITER ;

-- Llamada
CALL crearCoche('GHI3456', 'Audi', 'A4', '2022', 200, 8.7);

-- Este procedimiento actualiza los caballos del coche que tenga instalada una pieza por ID.
DELIMITER $$
DROP PROCEDURE IF EXISTS actualizarCaballosCochePieza;
CREATE PROCEDURE actualizarCaballosCochePieza(IN pCodigo INT)
BEGIN
    UPDATE Coche
    SET Caballos = Caballos + (SELECT CaballosProp FROM Pieza WHERE Pieza.Codigo = pCodigo)
    WHERE Matricula IN (SELECT Matricula FROM PiezaCoche WHERE Codigo = pCodigo);
END $$

DELIMITER ;

-- Llamada
CALL actualizarCaballosCochePieza(1);

-- Esta funcion devuelve la media de caballos por marca pasandole una marca.
DELIMITER $$
DROP FUNCTION IF EXISTS PromedioCaballosPorMarca;
CREATE FUNCTION PromedioCaballosPorMarca(pMarca VARCHAR(45))
RETURNS DOUBLE
READS SQL DATA
BEGIN
    DECLARE promedio DOUBLE;
    
    SELECT AVG(Caballos) INTO promedio
    FROM Coche
    WHERE Marca = pMarca;
    
    RETURN promedio;
END $$
DELIMITER ;

SELECT PromedioCaballosPorMarca('Toyota') AS PromedioCaballos;
