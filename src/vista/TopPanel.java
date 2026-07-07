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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel{
    
    private JLabel lblJugador1;
    private JLabel lblPuntos1;
    private JLabel lblTiempo;
    private JLabel lblJugador2;
    private JLabel lblPuntos2;
    
    public TopPanel() {

        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(900, 70));
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 20));

        Font fuente = new Font("Arial", Font.BOLD, 16);

        lblJugador1 = new JLabel("Jugador 1");
        lblJugador1.setForeground(Color.WHITE);
        lblJugador1.setFont(fuente);

        lblPuntos1 = new JLabel("Puntos: 0");
        lblPuntos1.setForeground(Color.WHITE);
        lblPuntos1.setFont(fuente);

        lblTiempo = new JLabel("Tiempo: 60");
        lblTiempo.setForeground(Color.YELLOW);
        lblTiempo.setFont(fuente);

        lblJugador2 = new JLabel("Jugador 2");
        lblJugador2.setForeground(Color.WHITE);
        lblJugador2.setFont(fuente);

        lblPuntos2 = new JLabel("Puntos: 0");
        lblPuntos2.setForeground(Color.WHITE);
        lblPuntos2.setFont(fuente);

        add(lblJugador1);
        add(lblPuntos1);
        add(lblTiempo);
        add(lblJugador2);
        add(lblPuntos2);
    }
}
