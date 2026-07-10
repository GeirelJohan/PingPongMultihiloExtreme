/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fiore
 */
public class Partida {
    
    private Jugador jugador1;
    private Jugador jugador2;
    private Ronda ronda;
    
    
    public Partida(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ronda = new Ronda();
    }
    
    public Jugador getJugador1(){
        return jugador1;
    }
    
    public Jugador getJugador2(){
        return jugador2;
    }
    
    public Ronda getRonda(){
        return ronda;
    }
    
    public void finalizarRonda(){
        if(jugador1.getPuntos() > jugador2.getPuntos()) {
            jugador1.ganarRonda();
        }
        else 
            if(jugador2.getPuntos() > jugador1.getPuntos()){
                jugador2.ganarRonda();
        }
        jugador1.reiniciarPuntos();
        jugador2.reiniciarPuntos();
        
        if(!ronda.partidaTerminada()){
            ronda.siguienteRonda();
        }
    }
    
    public Jugador obtenerGanador(){
        
        if(jugador1.getRondasGanadas() > jugador2.getRondasGanadas()){
            return jugador1;
        }
        else 
            if(jugador2.getRondasGanadas() > jugador1.getRondasGanadas()){
                return jugador2;
            }
        return null;
    }
}
