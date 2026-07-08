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
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class BottomPanel extends JPanel{
    
    private JButton btnIniciar;
    private JButton btnPausar;
    private JButton btnReiniciar;

    public BottomPanel() {

        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(900, 60));
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));

        btnIniciar = new JButton("Iniciar");
        btnPausar = new JButton("Pausar");
        btnReiniciar = new JButton("Reiniciar");

        add(btnIniciar);
        add(btnPausar);
        add(btnReiniciar);
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }
    public JButton getBtnPausar() {
        return btnPausar;
    }
    public JButton getBtnReiniciar() {
        return btnReiniciar;
    }
}
