/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package modelo;

import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author fiore
 */
public class Jugador {
    private String nombre; 
    private AtomicInteger puntos;
    private int rondasGanadas;
    
    
    public Jugador (String nombre) {
        this.nombre = nombre;
        this.puntos = new AtomicInteger(0);
        this.rondasGanadas = 0;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getPuntos (){
        return puntos.get();
    }
    
    public int getRondasGanadas (){
        return rondasGanadas;
    }
    
    public void sumarPuntos (int p){
        puntos.addAndGet(p);
    }
    
    public void reiniciarPuntos(){
        puntos.set(0);
    }
    
    public void ganarRonda(){
        rondasGanadas ++;
    }
    public boolean ganoPartida(){
        return rondasGanadas >= 2;
    }
    public void reiniciarRondas(){
        rondasGanadas = 0;
    }
    
}
