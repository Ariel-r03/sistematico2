/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.Frame;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import ni.edu.ni.Frame.Controllers.PnlVehicleController;
import ni.edu.ni.Frame.panels.PnlVehicle;

/**
 *
 * @author JADPA18
 */
public class JVehicleApp extends javax.swing.JFrame {
    private PnlVehicle pnlVehicle;
    private PnlVehicleController pnlVehicleController;

    /**
     * Creates new form j
     */
    public JVehicleApp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mtNew = new javax.swing.JMenuItem();
        mtView = new javax.swing.JMenuItem();
        mtExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout deskPaneLayout = new javax.swing.GroupLayout(deskPane);
        deskPane.setLayout(deskPaneLayout);
        deskPaneLayout.setHorizontalGroup(
            deskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        deskPaneLayout.setVerticalGroup(
            deskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        getContentPane().add(deskPane, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Options");

        mtNew.setText("New");
        mtNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtNewActionPerformed(evt);
            }
        });
        jMenu1.add(mtNew);

        mtView.setText("View");
        jMenu1.add(mtView);

        mtExit.setText("Exit");
        jMenu1.add(mtExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mtNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtNewActionPerformed
        if(pnlVehicle == null){
            pnlVehicle = new PnlVehicle();
            try {
                pnlVehicleController = new PnlVehicleController(pnlVehicle);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JVehicleApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pnlVehicle.setVisible(true);
//        addComponent(pnlVehicle);
    }//GEN-LAST:event_mtNewActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JVehicleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JVehicleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JVehicleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JVehicleApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JVehicleApp().setVisible(true);
            }
        });
    }
    
    private void addComponent(JDesktopPane component) {
        deskPane.removeAll();        
        deskPane.add(component, BorderLayout.CENTER);
        validate();
        repaint();
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mtExit;
    private javax.swing.JMenuItem mtNew;
    private javax.swing.JMenuItem mtView;
    // End of variables declaration//GEN-END:variables
}
