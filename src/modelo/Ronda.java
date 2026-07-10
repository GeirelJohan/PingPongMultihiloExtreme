/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fiore
 */
public class Ronda {
    
    private int rondaActual;
    private final int totalRondas;
    private final int tiempoPorRonda;
    
    
    public Ronda(){
       rondaActual = 1;
       totalRondas = 3;
       tiempoPorRonda = 60;
    }
    
    public int getRondaActual (){
        return rondaActual;
    }
    
    public int getTiempoPorRonda(){
        return tiempoPorRonda;
    }
    
    public void siguienteRonda(){
        if(rondaActual < totalRondas){
            rondaActual ++;
        }
    }
    
    public boolean partidaTerminada(){
        return rondaActual >= totalRondas;
    }
    
    public int getTotalRondas(){
        return totalRondas;
    }
        
}
