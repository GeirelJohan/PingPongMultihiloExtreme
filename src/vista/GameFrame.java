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
        
        add(new GamePanel());
        add(new GamePanel(), BorderLayout.CENTER);
        
        setLayout(new BorderLayout());
        
        add(new TopPanel(jugador1, jugador2), BorderLayout.NORTH);
        add(new GamePanel(), BorderLayout.CENTER);
        
        topPanel = new TopPanel(jugador1, jugador2);
        gamePanel = new GamePanel();
        bottomPanel = new BottomPanel();

        add(topPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}