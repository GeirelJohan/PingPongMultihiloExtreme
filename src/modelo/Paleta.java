/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author fiore
 */
import java.awt.Color;
import java.awt.Graphics;


public class Paleta {

    private int x;
    private int y;

    private int ancho = 15;
    private int alto = 90;

    private int velocidad = 10;

    private int velocidadNormal = 10;

    private boolean congelada;



    public Paleta(int x, int y){

        this.x = x;
        this.y = y;

        congelada = false;

    }



    public void subir(){

        if(congelada){
            return;
        }


        y -= velocidad;


        if(y < 0){

            y = 0;

        }

    }





    public void bajar(int altoPanel){

        if(congelada){
            return;
        }


        y += velocidad;


        if(y + alto > altoPanel){

            y = altoPanel - alto;

        }

    }





    public void congelar(){

        if(congelada){
            return;
        }


        congelada = true;


        Thread efecto = new Thread(() -> {

            try{

                Thread.sleep(3000);

            }catch(InterruptedException e){

            }


            congelada = false;


        });


        efecto.start();

    }





    public boolean estaCongelada(){

        return congelada;

    }





    public void dibujar(Graphics g){

        if(congelada){

            g.setColor(Color.CYAN);

        }else{

            g.setColor(Color.WHITE);

        }


        g.fillRect(x,y,ancho,alto);

    }





    public int getX(){

        return x;

    }



    public int getY(){

        return y;

    }



    public int getAncho(){

        return ancho;

    }



    public int getAlto(){

        return alto;

    }


}