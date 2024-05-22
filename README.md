En esta aplicacion se van a almacenar coches, piezas y circuitos. 
Los coches tienen matricula, marca, modelo, año, caballos y manejo.
Los circuitos tienen un id, numero de curvas, ubicacion y dificultad
Las piezas tienen un identificador "pieza", los caballos que proporcionan y los puntos de manejo
que se suman a las estadisticas del coche.
En la tabla intermedia Modificar (Coche + Pieza) tenemos las dos Primary Key que son Matricula (de coche) y Pieza (identificador de Pieza), marca y calidad.
En la tabla competicion ( tenemos idCompeticion, idCircuito (de la tabla Circuito), numero de vueltas, la fecha, la meteorologia y la hora de la Competicion
En la tabla Participantes (Coche + Competicion) tenemos idCompeticion y Matricula. En esta tabla se recogen los participantes
de una competicion en concreto.

La aplicacion consiste en crear coches, piezas y circuitos. Los coches se pueden modificar añadiendole piezas ya creadas para mejorar los atributos del coche que elijamos.
Despues, se puede crear una competicion en un circuito que hayamos creado y añadir participantes. El ganador dependera de las estadisticas de cada coche dependiendo del numero de curvas que tenga.
Al añadir una pieza a un coche se actualizaran los atributos Caballos y Manejo del coche seleccionado.
Una vez instalada una pieza, se podra modificar la marca de la misma. Por ejemplo, instalamos unos neumaticos Michelin en un coche pero queremos cambiarlos a Pirelli.
Se podra consultar la informacion de un coche, circuito o competicion, asi como sus participantes.
