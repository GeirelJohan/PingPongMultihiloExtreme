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


public class Bola extends Thread {

    private int x;
    private int y;

    private int diametro;

    protected int velocidadX;
    protected int velocidadY;

    protected Color color;

    private boolean activa;


    private Paleta izquierda;
    private Paleta derecha;

    private int anchoPanel;
    private int altoPanel;

    protected int puntos;

    public Bola(int x, int y) {

        this.x = x;
        this.y = y;

        diametro = 20;

        velocidadX = 4;
        velocidadY = 4;

        color = Color.WHITE;

        puntos = 1;
        
        activa = true;

    }



    public void configurarJuego(
            Paleta izquierda,
            Paleta derecha,
            int anchoPanel,
            int altoPanel) {


        this.izquierda = izquierda;
        this.derecha = derecha;

        this.anchoPanel = anchoPanel;
        this.altoPanel = altoPanel;

    }




    @Override
    public void run() {


        while(activa) {


            mover();


            try {

                Thread.sleep(15);

            } catch (InterruptedException e) {

                System.out.println("Hilo de bola detenido");

            }


        }


    }





    private void mover() {


        x += velocidadX;
        y += velocidadY;



        // Rebote arriba
        if(y <= 0) {

            y = 0;
            velocidadY = Math.abs(velocidadY);

        }



        // Rebote abajo
        if(y >= altoPanel - diametro) {


            y = altoPanel - diametro;
            velocidadY = -Math.abs(velocidadY);

        }





        // Rebote paleta izquierda

        if(izquierda != null &&
           velocidadX < 0 &&
           x <= izquierda.getX() + izquierda.getAncho() &&
           x + diametro >= izquierda.getX() &&
           y + diametro >= izquierda.getY() &&
           y <= izquierda.getY() + izquierda.getAlto()) {



            x = izquierda.getX() + izquierda.getAncho();

            velocidadX = Math.abs(velocidadX);


        }





        // Rebote paleta derecha

        if(derecha != null &&
           velocidadX > 0 &&
           x + diametro >= derecha.getX() &&
           x <= derecha.getX() + derecha.getAncho() &&
           y + diametro >= derecha.getY() &&
           y <= derecha.getY() + derecha.getAlto()) {



            x = derecha.getX() - diametro;

            velocidadX = -Math.abs(velocidadX);


        }





        // Sale por los lados

        if(x < 0 || x > anchoPanel) {

        x = anchoPanel / 2;
        y = altoPanel / 2;

    }



    }






    public void dibujar(Graphics g) {


        g.setColor(color);

        g.fillOval(x, y, diametro, diametro);


    }

    public int getPuntos(){

    return puntos;

    }
    
    public String getTipo(){

    return "Normal";

    }
 public void aumentarVelocidad(){

    velocidadX *= 2;
    velocidadY *= 2;

}


public boolean esFantasma(){

    return false;

}


public boolean esCongelante(){

    return false;

}
}