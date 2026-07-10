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


public class BolaFantasma extends Bola {


    public BolaFantasma(int x,int y){

        super(x,y);

        color = Color.MAGENTA;

    }



    public BolaFantasma(int x,int y,int velocidad){

        super(x,y,velocidad);

        color = Color.MAGENTA;

    }




    @Override
    public boolean esFantasma(){

        return true;

    }




    @Override
    public String getTipo(){

        return "Bola Fantasma";

    }


}