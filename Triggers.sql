USE proyecto;
-- Trigger Before. Antes de insertar un coche comprueba si el año de fabricacion esta entre 1887 y el actual.
DELIMITER $$
CREATE TRIGGER BeforeInsertCoche
BEFORE INSERT ON Coche
FOR EACH ROW
BEGIN
    DECLARE currentYear INT;
    SET currentYear = YEAR(CURDATE());
    
    IF NEW.Anyo < 1886 OR NEW.Anyo > currentYear THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El año del coche debe estar entre 1886 y el año actual.';
    END IF;
END $$
DELIMITER ;

-- Insert valido
INSERT INTO Coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo)
VALUES ('JKL6789', 'Mazda', 'CX-5', '2021', 210, 8.2);

-- Insert error
INSERT INTO Coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo)
VALUES ('MNO3456', 'Tesla', 'Model S', '1800', 300, 9.5);


-- Trigger After Este disparador AFTER INSERT incrementa el manejo en 1 si por ejemplo los caballos del coche son mas de 200.
DELIMITER $$
CREATE TRIGGER AfterInsertCoche
AFTER INSERT ON Coche
FOR EACH ROW
BEGIN
    IF NEW.Caballos > 200 THEN
        UPDATE Coche
        SET Manejo = Manejo + 1
        WHERE Matricula = NEW.Matricula;
    END IF;
END $$
DELIMITER ;

INSERT INTO Coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo)
VALUES ('ABC123', 'Toyota', 'Corolla', '2022', 250, 5);

SELECT * FROM Coche WHERE Matricula = 'ABC123';
