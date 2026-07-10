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
import java.util.Random;

public class Bola extends Thread {

    protected int x;
    protected int y;

    protected int diametro;

    protected int velocidadX;
    protected int velocidadY;

    protected Color color;

    protected boolean activa;

    protected Paleta izquierda;
    protected Paleta derecha;

    protected int anchoPanel;
    protected int altoPanel;

    protected int puntos;

    protected boolean fantasmaUsado;
    protected boolean congelanteUsado;
    private Random random;
    private boolean atravesandoFantasma = false;

    public Bola(int x, int y) {

        this.x = x;
        this.y = y;

        diametro = 20;

        velocidadX = 4;
        velocidadY = 4;

        random = new Random();

        if(random.nextBoolean()){
            velocidadX *= -1;
        }

        if(random.nextBoolean()){
            velocidadY *= -1;
        }

        color = Color.WHITE;

        puntos = 1;

        activa = true;

        fantasmaUsado = false;
        congelanteUsado = false;
    }


    public Bola(int x, int y, int velocidad) {

        this.x = x;
        this.y = y;

        diametro = 20;

        velocidadX = velocidad;
        velocidadY = velocidad;

        random = new Random();

        if(random.nextBoolean()){
            velocidadX *= -1;
        }

        if(random.nextBoolean()){
            velocidadY *= -1;
        }

        color = Color.WHITE;

        puntos = 1;

        activa = true;

        fantasmaUsado = false;

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
    public void run(){

        while(activa){

            mover();

            try{

                Thread.sleep(15);

            }catch(InterruptedException e){

                activa = false;

            }

        }

    }




    protected void mover(){

        x += velocidadX;
        y += velocidadY;



        // Rebote superior

        if(y <= 0){

            y = 0;
            velocidadY = Math.abs(velocidadY);

        }



        // Rebote inferior

        if(y + diametro >= altoPanel){

            y = altoPanel - diametro;
            velocidadY = -Math.abs(velocidadY);

        }




        // Colisión izquierda

       if(izquierda != null &&
        !atravesandoFantasma &&
        velocidadX < 0 &&
        x <= izquierda.getX()+izquierda.getAncho() &&
        x+diametro >= izquierda.getX() &&
        y+diametro >= izquierda.getY() &&
        y <= izquierda.getY()+izquierda.getAlto()){


   if(esFantasma() && !fantasmaUsado){

    fantasmaUsado = true;

    atravesandoFantasma = true;

    new Thread(() -> {

        try {
            Thread.sleep(300);
        } catch(Exception e){

        }

        atravesandoFantasma = false;

    }).start();


}else{


        x = izquierda.getX()+izquierda.getAncho();


        if(esCongelante() && usarCongelante()){

            derecha.congelar();

        }


        velocidadX = Math.abs(velocidadX);


    }

}





        // Colisión derecha

        if(derecha != null &&
        !atravesandoFantasma &&       
        velocidadX > 0 &&
        x+diametro >= derecha.getX() &&
        x <= derecha.getX()+derecha.getAncho() &&
        y+diametro >= derecha.getY() &&
        y <= derecha.getY()+derecha.getAlto()){


    if(esFantasma() && !fantasmaUsado){

    fantasmaUsado = true;

    atravesandoFantasma = true;

    new Thread(() -> {

        try {
            Thread.sleep(300);
        } catch(Exception e){

        }

        atravesandoFantasma = false;

    }).start();


}else{


        x = derecha.getX()-diametro;


        if(esCongelante() && usarCongelante()){

            izquierda.congelar();

        }


        velocidadX = -Math.abs(velocidadX);


    }

}





        // Sale por izquierda o derecha

        if(x < 0 || x > anchoPanel){

    activa = false;

    }

    }





    public void dibujar(Graphics g){

        g.setColor(color);

        g.fillOval(x,y,diametro,diametro);

    }





    public void aumentarVelocidad(){

        velocidadX *= 2;
        velocidadY *= 2;

    }




    public int getPuntos(){

        return puntos;

    }



    public String getTipo(){

        return "Normal";

    }




    public boolean esFantasma(){

        return false;

    }



    public boolean esCongelante(){

        return false;

    }




    public void detener(){

        activa = false;

    }



    public int getX(){

        return x;

    }


    public int getY(){

        return y;

    }
    
    public boolean usarCongelante(){

    if(!congelanteUsado){

        congelanteUsado = true;

        return true;

    }


    return false;

    }
}
