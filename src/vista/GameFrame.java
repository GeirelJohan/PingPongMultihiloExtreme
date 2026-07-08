/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Geirel
 */
import javax.swing.JFrame;
import java.awt.BorderLayout;
import controlador.KeyboardController;

public class GameFrame extends JFrame{
    
    private BottomPanel bottomPanel;
    private TopPanel topPanel;
    private GamePanel gamePanel;
    
    public GameFrame(String jugador1, String jugador2) {
        setTitle("Ping Pong Multihilo Extreme");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        
        //Creacion de los paneles principales
        topPanel = new TopPanel(jugador1, jugador2);
        gamePanel = new GamePanel();
        bottomPanel = new BottomPanel();

        //Agrega los paneles en sus respectivas posiciones
        add(topPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        KeyboardController keyboardController = new KeyboardController();

        addKeyListener(keyboardController);

        setFocusable(true);
        requestFocusInWindow();
        
        //Evento del boton Iniciar
        bottomPanel.addIniciarListener(e -> {
            System.out.println("Boton Iniciar presionado");
        });
        //Evento del boton Pausar
        bottomPanel.addPausarListener(e -> {
            System.out.println("Boton Pausar presionado");
        });
        //Evento del boton Reiniciar
        bottomPanel.addReiniciarListener(e -> {
            System.out.println("Boton Reiniciar presionado");
        });
    }
}