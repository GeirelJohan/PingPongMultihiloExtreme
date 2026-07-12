/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package modelo;

/**
 *
 * @author Bgamb
 */
public class Dificultad {
    
private int velocidadBola;
    private int cantidadMaxBolas;
    private int tiempoAparicion;


    public Dificultad(String nivel){


        switch(nivel){


            case "Facil":

                velocidadBola = 2;
                cantidadMaxBolas = 2;
                tiempoAparicion = 10000;

                break;



            case "Normal":

                velocidadBola = 4;
                cantidadMaxBolas = 4;
                tiempoAparicion = 7000;

                break;



            case "Dificil":

                velocidadBola = 6;
                cantidadMaxBolas = 6;
                tiempoAparicion = 5000;

                break;



            case "Extremo":

                velocidadBola = 8;
                cantidadMaxBolas = 10;
                tiempoAparicion = 3000;

                break;



            default:

                velocidadBola = 4;
                cantidadMaxBolas = 4;
                tiempoAparicion = 7000;

                break;

        }


    }



    public int getVelocidadBola(){

        return velocidadBola;

    }



    public int getCantidadMaxBolas(){

        return cantidadMaxBolas;

    }



    public int getTiempoAparicion(){

        return tiempoAparicion;

    }


}
