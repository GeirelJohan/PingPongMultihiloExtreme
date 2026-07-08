/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Geirel
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    //Constructor, establece el color de fondo del area de juego
    public GamePanel() {
        setBackground(Color.BLACK);
    }

    //Metodo encargado de dibujar los elementos graficos del panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}