/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Geirel
 */
import java.awt.Color; //Colores
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel{
    
    //Declaro los botones
    private JButton btnIniciar;
    private JButton btnPausar;
    private JButton btnReiniciar;

    //Constructor, todo lo que es la apariencia y añade los botones
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
    
    //Evento que se ejecutara al presionar el boton
    public void addIniciarListener(ActionListener listener) {
    btnIniciar.addActionListener(listener);
    }
    //Evento que se ejecutara al presionar el boton
    public void addPausarListener(ActionListener listener) {
        btnPausar.addActionListener(listener);
    }
    //Evento que se ejecutara al presionar el boton
    public void addReiniciarListener(ActionListener listener) {
        btnReiniciar.addActionListener(listener);
    }
}
