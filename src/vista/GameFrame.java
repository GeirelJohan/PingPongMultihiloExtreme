/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package vista;

/**
 *
 * @author Geirel
 */
import controlador.KeyboardController;
import vista.GamePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modelo.Jugador;

public class GameFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GameFrame.class.getName());
    /**
     * Creates new form GameFrame
     */
    private TopPanel topPanel;
    private GamePanel gamePanel;
    private BottomPanel bottomPanel;
    private Timer timer;
    private int tiempoRestante = 60;
    private StartDialog startDialog;
    private int rondaActual = 1;
    private int rondasJugador1=0;
    private int rondasJugador2=0;
    private final int TOTAL_RONDAS =3;
    private java.util.List<Integer> puntosJugador1PorRonda = new java.util.ArrayList<>();
      private java.util.List<Integer> puntosJugador2PorRonda = new java.util.ArrayList<>();
    
    public GameFrame(String nombre1,String nombre2, String dificultad) {
        initComponents();
        
        //StartDialog startDialog = new StartDialog(this,true);
       // startDialog.setVisible(true);
        
       // String dificultad = startDialog.getDificultad();
        
        topPanel = new TopPanel();
        gamePanel = new GamePanel(topPanel,nombre1,nombre2,dificultad);
        bottomPanel = new BottomPanel(gamePanel);
        //startDialog = new StartDialog(this,true);
        
        topContainer.setLayout(new BorderLayout());
        gameContainer.setLayout(new BorderLayout());
        bottomContainer.setLayout(new BorderLayout());

        topContainer.add(topPanel);
        gameContainer.add(gamePanel);
        bottomContainer.add(bottomPanel);
        
        iniciarCronometro();
        setLocationRelativeTo(null);
        
        KeyboardController keyboardController = new KeyboardController(gamePanel);

        gamePanel.addKeyListener(keyboardController);

        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        setLocationRelativeTo(null);
    } 
    
    private void iniciarCronometro(){
        timer = new Timer (1000, new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                tiempoRestante--;
                topPanel.actualizarTiempo(tiempoRestante);
                if (tiempoRestante <= 0){
                    timer.stop();
                    mostrarGanador();
                }
            }
            
        });
        timer.start();
    }
    private void  reiniciarRonda(){
        tiempoRestante = 60;
        topPanel.actualizarTiempo(tiempoRestante);
        gamePanel.reiniciarJuego();
        timer.start();
        JOptionPane.showMessageDialog( this, "Comienza la ronda "+rondaActual+ "!");
    }
            
            
    private void mostrarGanador(){
        int puntos1 = gamePanel.getJugador1().getPuntos();
        int puntos2 = gamePanel.getJugador2().getPuntos();
        
        puntosJugador1PorRonda.add(puntos1);
        puntosJugador2PorRonda.add(puntos2);
            
        String mensaje;
        
        if (puntos1 > puntos2){
            rondasJugador1++;
            mensaje = "!Ronda¡ "+ rondaActual + "ganada por"+ gamePanel.getJugador1().getNombre();
        }else if (puntos2 > puntos1){
            rondasJugador2++;
            mensaje = "¡Ronda! "+ rondaActual + "ganada por"+gamePanel.getJugador2().getNombre()+"!";
            
        }else{
            mensaje = "¡Ronda! "+ rondaActual +"¡Empate!";
        }
        
        mensaje += "\n\nPuntos Obtenidos : \n"+
                gamePanel.getJugador1().getNombre()+":"+puntos1 + "\n"+
                gamePanel.getJugador2().getNombre()+":"+puntos2 + "\n";
        
        JOptionPane.showMessageDialog(this, mensaje);
      
        if (rondaActual < TOTAL_RONDAS && rondasJugador1 < 2 && rondasJugador2<2){
            rondaActual++;
            reiniciarRonda();
            
        }else {

            mostrarResultadosFinales ();
        }

        
    }
    private void mostrarResultadosFinales (){
        String ganadorPartida;
        
        if (rondasJugador1 >rondasJugador2){
            ganadorPartida = gamePanel.getJugador1().getNombre();
           
        }else if (rondasJugador2 > rondasJugador1){
            ganadorPartida = gamePanel.getJugador2().getNombre();
        }else 
            ganadorPartida = "Empate";
    
        
        StringBuilder resumen = new StringBuilder ("Partida finalizada\n\n") ;
        resumen.append ("Ganador de la partida :").append (ganadorPartida).append("\n");
        resumen.append("Rondas ganadas:")
                .append(gamePanel.getJugador1().getNombre()).append("(")
                .append(rondasJugador1).append(")  |   ")
                .append(gamePanel.getJugador2().getNombre()).append("(").append(rondasJugador2).append(")\n\n");
        resumen.append("Puntos por ronda: \n");
        for ( int i = 0; i < puntosJugador1PorRonda.size(); i++){
            resumen.append("Ronda  ").append(i+1).append(":").append(gamePanel.getJugador1().getNombre()).append("").append(puntosJugador1PorRonda.get(i)).append("  |  ").append(gamePanel.getJugador2().getNombre()).append("").append(puntosJugador2PorRonda.get(i)).append("\n");
        }
  
                //"Ganador de la partida:" + ganadorPartida + "\n" + 
               // "Rondas ganadas:" + gamePanel.getJugador1().getNombre() + "("+rondasJugador1 +")| "+        gamePanel.getJugador2().getNombre()+ "("+rondasJugador2 +")";
        
        
        int opcion = JOptionPane.showOptionDialog(this, resumen +"\n\n¿Quieres intentarlo de nuevo?", "Resultados finales",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new Object []{
            "Volver a jugar","Salir"}, "Volver a jugar"
        );
        
        if (opcion == JOptionPane.YES_OPTION){
            rondaActual = 1;
            rondasJugador1 = 0;
            rondasJugador2 = 0;
            puntosJugador1PorRonda.clear();
            puntosJugador2PorRonda.clear();
            tiempoRestante = 60;
            topPanel.actualizarTiempo(tiempoRestante);
            gamePanel.reiniciarJuego();
            timer.start();
            
                    JOptionPane.showMessageDialog (this,"!Nueva partida iniciada¡");
            
        }else {
        
        dispose ();

    }
    }
    
    
    public TopPanel getTopPanel() {
    return topPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }
    
   
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topContainer = new javax.swing.JPanel();
        bottomContainer = new javax.swing.JPanel();
        gameContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ping Pong Multihilo Extreme");
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        topContainer.setForeground(java.awt.Color.yellow);
        topContainer.setPreferredSize(new java.awt.Dimension(900, 70));

        javax.swing.GroupLayout topContainerLayout = new javax.swing.GroupLayout(topContainer);
        topContainer.setLayout(topContainerLayout);
        topContainerLayout.setHorizontalGroup(
            topContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        topContainerLayout.setVerticalGroup(
            topContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(topContainer, java.awt.BorderLayout.PAGE_START);

        bottomContainer.setForeground(java.awt.Color.gray);
        bottomContainer.setMinimumSize(new java.awt.Dimension(900, 60));

        javax.swing.GroupLayout bottomContainerLayout = new javax.swing.GroupLayout(bottomContainer);
        bottomContainer.setLayout(bottomContainerLayout);
        bottomContainerLayout.setHorizontalGroup(
            bottomContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        bottomContainerLayout.setVerticalGroup(
            bottomContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(bottomContainer, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout gameContainerLayout = new javax.swing.GroupLayout(gameContainer);
        gameContainer.setLayout(gameContainerLayout);
        gameContainerLayout.setHorizontalGroup(
            gameContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        gameContainerLayout.setVerticalGroup(
            gameContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        getContentPane().add(gameContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GameFrame("Jugador 1","Jugador 2", "dificultad").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomContainer;
    private javax.swing.JPanel gameContainer;
    private javax.swing.JPanel topContainer;
    // End of variables declaration//GEN-END:variables
}
