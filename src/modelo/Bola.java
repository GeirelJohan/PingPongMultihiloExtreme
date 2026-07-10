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

    public void mover() {

        x += velocidadX;
        y += velocidadY;

    }

    public void dibujar(Graphics g) {

        g.setColor(color);
        g.fillOval(x, y, diametro, diametro);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiametro() {
        return diametro;
    }

    public int getVelocidadX() {
        return velocidadX;
    }

    public int getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadX(int velocidadX) {
        this.velocidadX = velocidadX;
    }

    public void setVelocidadY(int velocidadY) {
        this.velocidadY = velocidadY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}