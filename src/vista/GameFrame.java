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
    
    public GameFrame() {
        setTitle("Ping Pong Multihilo Extreme");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        add(new GamePanel());
        add(new GamePanel(), BorderLayout.CENTER);
        
        setLayout(new BorderLayout());

        add(new TopPanel(), BorderLayout.NORTH);
        add(new GamePanel(), BorderLayout.CENTER);
        add(new BottomPanel(), BorderLayout.SOUTH);
    }
}