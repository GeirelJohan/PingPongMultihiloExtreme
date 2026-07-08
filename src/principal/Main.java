/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

/**
 *
 * @author Geirel
 */
import javax.swing.SwingUtilities;
import vista.GameFrame;
import vista.StartDialog;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartDialog dialog = new StartDialog(null); //Ventana de inicio
            dialog.setVisible(true); //Hace visible el dialogo
            if (dialog.isIniciar()) { //Comprueba si se cerro la ventana o se presiono el boton
                GameFrame frame = new GameFrame( //Crea la ventana del juego
                        dialog.getJugador1(),
                        dialog.getJugador2() //Y agrega los nombres
                );
                frame.setVisible(true);
            }
        });
    }
}