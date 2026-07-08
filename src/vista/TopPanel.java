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
    
    //Atributos
    private JLabel lblJugador1;
    private JLabel lblPuntos1;
    private JLabel lblTiempo;
    private JLabel lblJugador2;
    private JLabel lblPuntos2;
    
    //Constructor
    public TopPanel(String jugador1, String jugador2) {

        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(900, 70));
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 20));

        Font fuente = new Font("Arial", Font.BOLD, 16);

        //Nombre del jugador 1
        lblJugador1 = new JLabel(jugador1);
        lblJugador1.setForeground(Color.WHITE);
        lblJugador1.setFont(fuente);
        //Puntaje del juagdor 2
        lblPuntos1 = new JLabel("Puntos: 0");
        lblPuntos1.setForeground(Color.WHITE);
        lblPuntos1.setFont(fuente);
        //Tiempo restante del juego
        lblTiempo = new JLabel("Tiempo: 60");
        lblTiempo.setForeground(Color.YELLOW);
        lblTiempo.setFont(fuente);
        //Nombre del jugador 2
        lblJugador2 = new JLabel(jugador2);
        lblJugador2.setForeground(Color.WHITE);
        lblJugador2.setFont(fuente);
        //Puntaje del juagdor 1
        lblPuntos2 = new JLabel("Puntos: 0");
        lblPuntos2.setForeground(Color.WHITE);
        lblPuntos2.setFont(fuente);

        //Agrega las etiquetas al panel
        add(lblJugador1);
        add(lblPuntos1);
        add(lblTiempo);
        add(lblJugador2);
        add(lblPuntos2);
    }
    //Actualizar los puntos de cada jugador ademas del tiempo restante
    public void actualizarPuntosJugador1(int puntos) {
    lblPuntos1.setText("Puntos: " + puntos);
    }
    public void actualizarPuntosJugador2(int puntos) {
        lblPuntos2.setText("Puntos: " + puntos);
    }
    public void actualizarTiempo(int tiempo) {
        lblTiempo.setText("Tiempo: " + tiempo);
    }
}
