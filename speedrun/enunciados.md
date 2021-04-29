
Los "speedruns" son clasificaciones donde jugadores de videojuegos suben a sitios Web grabaciones de vídeo de partidas que han jugado, donde intentan terminar o hacer una fase de un juego o un juego completo en el menor tiempo posible, pero intentando cubrir ciertos objetivos. Los jugadores o usuarios quieren aparecer en los puestos más altos de esas competiciones, en unos "rankings" que se publican en los sitios Web mencionados.

El siguiente diagrama UML muestra un modelo parcial de este tipo de sitios.


En el diagrama se puede ver las clases Platform y Game que representan los videojuegos. Nótes que un mismo título, por ejemplo, "Red Redemption 2" se considera un juego diferente por cada plataforma, por ejemplo serían diferentes las versiones del juego para PS4 y para Xbox One.

Los usuarios juegan a los juegos y se registra el tiempo que han tardado en la partida, como se puede ver en la clase Run. En esa clase, queda claro que es mejor partida la que ha tardado menos tiempo, medido en segundos. 

Pero hay dos variantes que modifican ese criterio de qué partida es mejor:
- En RunWithEasterEggs, se valora que en la partida se hayan conseguido ciertos hitos opcionales ("easter eggs") durante la partida, y cada uno se valora en una cantidad de "segundos de descuento" que se restarían a la duración de la partida. 
- En RunWithScore, además de la duración, hay una puntuación (score) normalizada entre 1 y 100,  y se valora tanto la duración como la puntuación. El cálculo de la duración modificada sería: time + (100-score). Así, si no se consigue la máxima puntuación, hay una penalización en segundos que depende de la puntuación. 

Se proporcionan más adelante esqueletos de diferentes clases que se pueden tomar como punto de partida, y se pide lo siguiente.

Implementar las siguientes funcionalidades, incluyendo las asociaciones necesarias:

* Implementar el método equals() en la clase Game, teniendo en cuenta que dos objetos Game son iguales si tienen el mismo nombre y la misma plataforma. (2 puntos)
* Implementar los métodos addUser(), getNthUser() y getLastUser() en la clase LeaderBoard según las indicaciones de los comentarios y el ejemplo de ejecución (3 puntos)
* Implementar en la clase User los métodos addRun() y getBestRun() de acuerdo con las indicaciones (3 puntos)
* Implementar la subclase RunWithEasterEggs (2 puntos)


Implementar las siguientes funcionalidades, incluyendo las asociaciones necesarias:

* Implementar el método equals() en la clase Run() teniendo en cuenta que dos objetos Run son iguales si el juego, el jugador y el tiempo son iguales.
* Implementar los métodos addUser() y print() de la clase LeaderBoard() según las indicaciones de los comentarios y el ejemplo de ejecución (3 puntos).
* Implementar en la clase User los métodos addRun() y printPositionInLeaderBoards() de acuerdo con las indicaciones y la salida del programa principal de ejemplo (3 puntos)
* Implementar la subclase RunWithScore (2 puntos)

Para evaluar la práctica, se proporciona a continuación un programa principal de ejemplo y su salida. Se deben respetar los nombres de los métodos públicos y los parámetros para que se pueda probar el ejercicio presentado por el estudiante. 