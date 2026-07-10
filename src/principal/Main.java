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
            StartDialog dialog = new StartDialog(null, true);
            dialog.setVisible(true);
            if (dialog.isIniciar()) {
                GameFrame frame = new GameFrame();
                frame.setVisible(true);
            }
        });
    }
}