/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */


package vista;
import modelo.Paleta;
import java.awt.Graphics;
import modelo.Bola;
import javax.swing.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JOptionPane;
import modelo.Dificultad;
import modelo.GeneradorBolas;
import modelo.Jugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;


/**
 *
 * @author Geirel
 */


public class GamePanel extends javax.swing.JPanel {

    private Paleta paletaIzquierda;
    private Paleta paletaDerecha;
    private CopyOnWriteArrayList<Bola> bolas;
    private Timer timer;
    //private Dificultad dificultad;
    private String dificultad;
    private GeneradorBolas generador;
    private Timer timerGenerador;
    private boolean juegoActivo = true;
    
    private Jugador jugador1;
    private Jugador jugador2;
    private TopPanel topPanel;
    private int velocidadPelota;

    /**
     * Creates new form GamePanelñ
     */
    public GamePanel(TopPanel topPanel,String nombre1,String nombre2, String dificultad) {
    this.topPanel=topPanel;
    this.jugador1=new Jugador(nombre1);
    this.jugador2 = new Jugador (nombre2);
    this.dificultad=dificultad;

    initComponents();
    
    switch (dificultad){
        case "Fácil":
            velocidadPelota = 3;
            break;
        case "Medio":
            velocidadPelota = 6;
            break;
        case "Extremo":
            velocidadPelota=10;
            break;
        default:
            velocidadPelota = 5 ;
    }
    int cantidadMaxBolas;
    int tiempoAparicion;
    
    switch (dificultad){
        case "Fácil":
            cantidadMaxBolas= 6;
            tiempoAparicion = 3000;
            break;
        case "Normal":
            cantidadMaxBolas= 10;
            tiempoAparicion = 2000;
            break;
        case "Difícil":
            cantidadMaxBolas= 12;
            tiempoAparicion = 1500;
            break;    
        case "Extremo":
            cantidadMaxBolas= 14;
            tiempoAparicion = 1000;
            break;    
        default :
            cantidadMaxBolas = 8;
            tiempoAparicion =2500;
    }

    jugador1 = new Jugador (nombre1);
    jugador2 = new Jugador (nombre2);
    
    if (topPanel != null){
        topPanel.actualizarJugador1(jugador1.getNombre());
        topPanel.actualizarJugador2(jugador2.getNombre());
    
    }

    setPreferredSize(new java.awt.Dimension(900,470));
    setSize(900,470);


    paletaIzquierda = new Paleta(20,180);
    paletaDerecha = new Paleta(865,180);


bolas = new CopyOnWriteArrayList<>();

generador = new GeneradorBolas();






// Crear las bolas iniciales según la dificultad

for(int i = 0; i < cantidadMaxBolas / 2; i++){

    Bola bola = generador.crearBola(
            440,
            225,
            velocidadPelota
    );

    bola.configurarJuego(
            paletaIzquierda,
            paletaDerecha,
            900,
            470,
            jugador1,
            jugador2,
            this
            
    );

    bolas.add(bola);

    bola.start();

}


    timer = new Timer(15, e -> {

    if(juegoActivo){
        eliminarBolasInactivas();
                repaint();

            }

});
    timer.start();
    
    timerGenerador = new Timer(
        tiempoAparicion,
        e -> {

            if(bolas.size() < cantidadMaxBolas){

                Bola nueva = generador.crearBola(
                        440,
                        225,
                        velocidadPelota
                );

                nueva.configurarJuego(
                        paletaIzquierda,
                        paletaDerecha,
                        900,
                        470,
                        jugador1,
                        jugador2,
                        this
                );

                bolas.add(nueva);

                nueva.start();

            }

        });

    timerGenerador.start();

    setFocusable(true);

}
    
   @Override
protected void paintComponent(Graphics g) {

    super.paintComponent(g);


    paletaIzquierda.dibujar(g);
    paletaDerecha.dibujar(g);
    
    //eliminarBolasInactivas ();


    for(Bola bola : bolas){


        bola.dibujar(g);

    }
    
 

}
public void pausarJuego(){
    juegoActivo = false ;
    for(Bola b:bolas){
        b.pausar();
    }
}
public void reanudarJuego(){
    juegoActivo = true ;
    for(Bola b:bolas){
        b.reanudar();
    }
    this.requestFocusInWindow();
}
public void reiniciarJuego(){
    juegoActivo = true ;
    for(Bola b:bolas){
        b.detener();
    }
    bolas.clear();
    timerGenerador.restart();
    jugador1.reiniciarPuntos();
    jugador2.reiniciarPuntos();
if (topPanel !=null){
    topPanel.actualizarPuntos(0);
    topPanel.actualizarPuntos2(0);
}
this.requestFocusInWindow();
}
public TopPanel getTopPanel(){
    return topPanel;
}
private void aplicarEfectosBolas(){

    for(Bola bola : bolas){


        if(bola.esCongelante()){


            if(bola.getX() < 50 || bola.getX() > 800){


                if(bola.usarCongelante()){


                    if(bola.getX() < 50){

                        paletaDerecha.congelar();

                    }


                    if(bola.getX() > 800){

                        paletaIzquierda.congelar();

                    }


                }


            }


        }


    }


}

    public void eliminarBolasInactivas(){
        boolean eliminadas =bolas.removeIf(bola -> !bola.isActiva());
        if (eliminadas){
            repaint();
        }
    }
        public Jugador getJugador1(){
            return jugador1;
        }
        public Jugador getJugador2(){
            return jugador2;
        }
        public Paleta getPaletaIzquierda(){
        return paletaIzquierda;
    }
    
    public Paleta getPaletaDerecha(){
        return paletaDerecha;
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(java.awt.Color.black);
        setPreferredSize(new java.awt.Dimension(900, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
  
    


