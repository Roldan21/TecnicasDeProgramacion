
package juegocartas;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;


public class FrmJuego extends javax.swing.JFrame {

    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();

    public FrmJuego() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRepartir = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        tpJugadores = new javax.swing.JTabbedPane();
        pnlJugador1 = new javax.swing.JPanel();
        pnlJugador2 = new javax.swing.JPanel();
        txtPuntaje = new javax.swing.JTextField();
        lblPuntaje = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego de Cartas");

        btnRepartir.setText("Repartir");
        btnRepartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepartirActionPerformed(evt);
            }
        });

        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        tpJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpJugadoresMouseClicked(evt);
            }
        });

        pnlJugador1.setBackground(new java.awt.Color(102, 255, 51));

        javax.swing.GroupLayout pnlJugador1Layout = new javax.swing.GroupLayout(pnlJugador1);
        pnlJugador1.setLayout(pnlJugador1Layout);
        pnlJugador1Layout.setHorizontalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        pnlJugador1Layout.setVerticalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );

        tpJugadores.addTab("Valentina Roldan", pnlJugador1);

        pnlJugador2.setBackground(new java.awt.Color(102, 255, 204));

        javax.swing.GroupLayout pnlJugador2Layout = new javax.swing.GroupLayout(pnlJugador2);
        pnlJugador2.setLayout(pnlJugador2Layout);
        pnlJugador2Layout.setHorizontalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        pnlJugador2Layout.setVerticalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );

        tpJugadores.addTab("Raúl Vidal", pnlJugador2);

        txtPuntaje.setEditable(false);
        txtPuntaje.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N

        lblPuntaje.setText("PUNTAJE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpJugadores)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnRepartir)
                .addGap(18, 18, 18)
                .addComponent(btnVerificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRepartir)
                    .addComponent(btnVerificar)
                    .addComponent(txtPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuntaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpJugadores))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRepartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepartirActionPerformed
String mensaje = "";
int pestaña = tpJugadores.getSelectedIndex();

jugador1.repartir();
jugador2.repartir();

jugador1.mostrar(pnlJugador1);
jugador2.mostrar(pnlJugador2);

switch (pestaña) {
    case 0:
        jugador1.calcularPuntaje();
        List<String> escaleras1 = jugador1.obtenerEscaleras();
        for (String escaleraInfo : escaleras1) {
            mensaje += escaleraInfo + "\n"; // Concatenar cada cadena en el mensaje final
        }
        int puntaje1 = jugador1.calcularPuntaje();
        // Mostrar el mensaje en un JLabel
        lblMensaje.setText(mensaje);
        // Mostrar el puntaje en el TextField
        txtPuntaje.setText(String.valueOf(puntaje1));
        break;

    case 1:
        jugador2.calcularPuntaje();
        List<String> escaleras2 = jugador2.obtenerEscaleras();
        for (String escaleraInfo : escaleras2) {
            mensaje += escaleraInfo + "\n"; // Concatenar cada cadena en el mensaje final
        }
        int puntaje2 = jugador2.calcularPuntaje();
        // Mostrar el mensaje en un JLabel
        lblMensaje.setText(mensaje);
        // Mostrar el puntaje en el TextField
        txtPuntaje.setText(String.valueOf(puntaje2));
        break;
}


    }//GEN-LAST:event_btnRepartirActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        int pestaña = tpJugadores.getSelectedIndex();
        String mensaje = "";
        switch (pestaña) {
            case 0:
                mensaje=jugador1.getGrupos();
               
                break;
            case 1:
                mensaje=jugador2.getGrupos();
                break;
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void tpJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpJugadoresMouseClicked
  int indicePestaña = tpJugadores.getSelectedIndex();

    // Limpiar el mensaje de la escalera
    lblMensaje.setText("");

    // Actualizar el puntaje según el jugador seleccionado
    int puntaje;
    if (indicePestaña == 0) {
        puntaje = jugador1.calcularPuntaje();
        // Obtener y mostrar la escalera del jugador 1 si existe
        List<String> escaleras1 = jugador1.obtenerEscaleras();
        if (!escaleras1.isEmpty()) {
            StringBuilder mensajeEscaleras = new StringBuilder();
            for (String escaleraInfo : escaleras1) {
                mensajeEscaleras.append(escaleraInfo).append("\n");
            }
            lblMensaje.setText(mensajeEscaleras.toString());
        }
    } else {
        puntaje = jugador2.calcularPuntaje();
        // Obtener y mostrar la escalera del jugador 2 si existe
        List<String> escaleras2 = jugador2.obtenerEscaleras();
        if (!escaleras2.isEmpty()) {
            StringBuilder mensajeEscaleras = new StringBuilder();
            for (String escaleraInfo : escaleras2) {
                mensajeEscaleras.append(escaleraInfo).append("\n");
            }
            lblMensaje.setText(mensajeEscaleras.toString());
        }
    }

    // Mostrar el puntaje en el TextField
    txtPuntaje.setText(String.valueOf(puntaje));
    }//GEN-LAST:event_tpJugadoresMouseClicked

    // Agregar un ChangeListener al JTabbedPane

    
    /**
     * 
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRepartir;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JPanel pnlJugador1;
    private javax.swing.JPanel pnlJugador2;
    private javax.swing.JTabbedPane tpJugadores;
    private javax.swing.JTextField txtPuntaje;
    // End of variables declaration//GEN-END:variables
}
