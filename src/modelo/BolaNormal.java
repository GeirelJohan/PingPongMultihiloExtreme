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

public class BolaNormal extends Bola {


    public BolaNormal(int x, int y) {

        super(x, y);

        color = Color.WHITE;
        puntos = 1;

    }



    public BolaNormal(int x, int y, int velocidad) {

        super(x, y, velocidad);

        color = Color.WHITE;
        puntos = 1;

    }



    @Override
    public String getTipo() {

        return "Bola Normal";

    }

}