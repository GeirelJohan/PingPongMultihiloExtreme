/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Geirel
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener{
    
    //Metodo que se ejecuta cada vez que presiono una tecla 
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    //Obtiene el codigo de la tecla presionada
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            
            //Tecla W: movimiento hacia arriba del jugador 1
            case KeyEvent.VK_W:
                System.out.println("Jugador 1 - Arriba");
                break;
            
            //Tecla S: movimiento hacia abajo del jugador 1
            case KeyEvent.VK_S:
                System.out.println("Jugador 1 - Abajo");
                break;
                
            //Flecha arriba: movimiento hacia arriba del jugador 2
            case KeyEvent.VK_UP:
                System.out.println("Jugador 2 - Arriba");
                break;
                
            //Flecha abajo: movimiento hacia abajo del jugador 2
            case KeyEvent.VK_DOWN:
                System.out.println("Jugador 2 - Abajo");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
