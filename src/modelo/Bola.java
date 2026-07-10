/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Bgamb
 */
import java.awt.Color;
import java.awt.Graphics;

public class Bola {

    private int x;
    private int y;

    private int diametro;
    private int velocidadX;
    private int velocidadY;

    private Color color;


    public Bola(int x, int y) {

        this.x = x;
        this.y = y;

        diametro = 20;

        velocidadX = 4;
        velocidadY = 4;

        color = Color.WHITE;
    }


public void mover(Paleta izquierda, Paleta derecha, int anchoPanel, int altoPanel) {

    // Movimiento
    x += velocidadX;
    y += velocidadY;


    // Rebote arriba
    if (y <= 0) {

        y = 0;
        velocidadY = Math.abs(velocidadY);

    }


    // Rebote abajo
    if (y >= altoPanel - diametro) {

        y = altoPanel - diametro;
        velocidadY = -Math.abs(velocidadY);

    }



    // Rebote con paleta izquierda
    if (velocidadX < 0 &&
            x <= izquierda.getX() + izquierda.getAncho() &&
            x + diametro >= izquierda.getX() &&
            y + diametro >= izquierda.getY() &&
            y <= izquierda.getY() + izquierda.getAlto()) {


        x = izquierda.getX() + izquierda.getAncho();
        velocidadX = Math.abs(velocidadX);

    }



    // Rebote con paleta derecha
    if (velocidadX > 0 &&
            x + diametro >= derecha.getX() &&
            x <= derecha.getX() + derecha.getAncho() &&
            y + diametro >= derecha.getY() &&
            y <= derecha.getY() + derecha.getAlto()) {


        x = derecha.getX() - diametro;
        velocidadX = -Math.abs(velocidadX);

    }



    // Si sale por los lados reinicia
    if (x < 0 || x > anchoPanel) {

        x = anchoPanel / 2;
        y = altoPanel / 2;

    }

}



    public void dibujar(Graphics g) {

        g.setColor(color);
        g.fillOval(x, y, diametro, diametro);

    }

}