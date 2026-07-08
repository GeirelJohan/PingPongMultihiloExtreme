/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Geirel
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class StartDialog extends JDialog{
    
    private JTextField txtJugador1;
    private JTextField txtJugador2;
    private JComboBox<String> cmbDificultad;
    private JButton btnIniciar;

    private boolean iniciar = false;

    public StartDialog(JFrame parent) {
        super(parent, "Nueva Partida", true);

        setSize(350, 220);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel(new GridLayout(6, 1, 5, 5));

        panelCentro.add(new JLabel("Nombre del Jugador 1"));
        txtJugador1 = new JTextField();
        panelCentro.add(txtJugador1);

        panelCentro.add(new JLabel("Nombre del Jugador 2"));
        txtJugador2 = new JTextField();
        panelCentro.add(txtJugador2);

        panelCentro.add(new JLabel("Dificultad"));
        cmbDificultad = new JComboBox<>(new String[]{
            "Fácil",
            "Normal",
            "Difícil",
            "Extremo"
        });

        panelCentro.add(cmbDificultad);
        add(panelCentro, BorderLayout.CENTER);
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(e -> {
            if (txtJugador1.getText().isBlank() ||
                txtJugador2.getText().isBlank()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe ingresar ambos nombres."
                );
                return;
            }
            iniciar = true;
            dispose();
        });
        add(btnIniciar, BorderLayout.SOUTH);
    }
    public boolean isIniciar() {
        return iniciar;
    }
    public String getJugador1() {
        return txtJugador1.getText();
    }
    public String getJugador2() {
        return txtJugador2.getText();
    }
    public String getDificultad() {
        return cmbDificultad.getSelectedItem().toString();
    }
}
