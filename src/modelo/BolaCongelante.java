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

public class BolaCongelante extends Bola {


    public BolaCongelante(int x, int y) {

        super(x, y);

        color = Color.CYAN;

    }


    @Override
    public boolean esCongelante() {

        return true;

    }


    @Override
    public String getTipo() {

        return "Bola Congelante";

    }

}