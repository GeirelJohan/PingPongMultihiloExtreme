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

public class BolaRapida extends Bola {


    public BolaRapida(int x, int y) {

        super(x, y);

        color = Color.YELLOW;

        aumentarVelocidad();

    }



    public BolaRapida(int x, int y, int velocidad) {

        super(x, y, velocidad);

        color = Color.YELLOW;

        aumentarVelocidad();

    }



    @Override
    public String getTipo() {

        return "Bola Rapida";

    }

}