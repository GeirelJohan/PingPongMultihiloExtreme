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
            GameFrame frame = new GameFrame();
            StartDialog dialog = new StartDialog(frame);
            dialog.setVisible(true);
            if(dialog.isIniciar()){
                frame.setVisible(true);
            }
        });
    }

}