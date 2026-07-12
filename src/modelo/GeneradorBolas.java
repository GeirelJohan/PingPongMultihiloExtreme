/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author Bgamb
 */
import java.util.Random;


public class GeneradorBolas {


    private Random random;


    public GeneradorBolas(){

        random = new Random();

    }



    public Bola crearBola(int x, int y,int velocidad){

        int tipo = random.nextInt(6);

        switch(tipo){


            case 0:

                return new BolaNormal(
                        x,
                        y,
                        velocidad
                );



            case 1:

                return new BolaNegativa(
                        x,
                        y,
                        velocidad
                );



            case 2:

                return new BolaBonus(
                        x,
                        y,
                        velocidad
                );



            case 3:

                return new BolaRapida(
                        x,
                        y,
                        velocidad
                );



            case 4:

                return new BolaFantasma(
                        x,
                        y,
                        velocidad
                );



            default:

                return new BolaCongelante(
                        x,
                        y,
                        velocidad
                );


        }


    }



}