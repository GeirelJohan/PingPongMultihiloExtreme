/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Paleta;
import vista.GamePanel;
        
/**
 *
 * @author Geirel
 */


public class KeyboardController implements KeyListener{
    
    
    private GamePanel gamePanel;
    
    public KeyboardController(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    //Metodo que se ejecuta cada vez que presiono una tecla 
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    //Obtiene el codigo de la tecla presionada
    @Override
    public void keyPressed(KeyEvent e) {
        
        System.out.println("Tecla: " + e.getKeyCode());
        
        Paleta izquierda = gamePanel.getPaletaIzquierda();
        Paleta derecha = gamePanel.getPletaDerecha();
        
        
        switch (e.getKeyCode()) {
            
            //Tecla W: movimiento hacia arriba del jugador 1
            case KeyEvent.VK_W:
                izquierda.subir();
                break;
            
            //Tecla S: movimiento hacia abajo del jugador 1
            case KeyEvent.VK_S:
                izquierda.bajar(gamePanel.getHeight());
                break;
                
            //Flecha arriba: movimiento hacia arriba del jugador 2
            case KeyEvent.VK_UP:
                derecha.subir();
                break;
                
            //Flecha abajo: movimiento hacia abajo del jugador 2
            case KeyEvent.VK_DOWN:
                derecha.bajar(gamePanel.getHeight());
                break;
        }
        
        gamePanel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
