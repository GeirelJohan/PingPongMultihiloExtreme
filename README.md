# Ping Pong Multihilo Extreme

Proyecto de Programación IV

# Integrantes
Geirel Johan Bermúdez Vargas
Brandon Gamboa
Joseline Fonseca
Kristyn Fernández

# Descripción

Ping Pong Multihilo Extreme es un juego desarrollado en Java utilizando Java Swing en NetBeans
el proyecto consiste en una versión multijugador del clásico juego de Ping Pong
donde dos jugadores compiten controlando sus paletas mientras múltiples bolas se ejecutan de forma concurrente mediante hilos
el desarrollo se realiza de forma colaborativa utilizando Git y GitHub para el control de versiones.

# Tecnologías utilizadas
Java
Java Swing
NetBeans
GitHub

# Estructura del proyecto

Principal: Contiene la clase Main
Vista: Contiene las clases GameFrame, GamePanel, TopPanel, BottomPanel y StartDialog
Controlador: Contiene la clase KeyboardController
Modelo: Contendrá las clases correspondientes a la lógica del juego

# Funcionalidades implementadas por el Integrante 1

Creación de la ventana principal del juego GameFrame
Diseño del área de juego GamePanel
Diseño del panel superior con nombres de los jugadores, puntajes y temporizador TopPanel
Diseño del panel inferior con los botones Iniciar, Pausar y Reiniciar BottomPanel
Desarrollo de la pantalla inicial para ingresar los nombres de los jugadores y seleccionar la dificultad StartDialog
Implementación del controlador del teclado para detectar las teclas W, S, Flecha Arriba y Flecha Abajo KeyboardController
Implementación del GameController para coordinar la comunicación entre la interfaz y el controlador

# Ejecución

Abrir el proyecto en NetBeans
Compilar el proyecto
Ejecutar la clase Main
Ingresar el nombre de ambos jugadores
Seleccionar la dificultad
Presionar el botón Iniciar para comenzar la partida
