/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.views;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import ni.edu.ni.Frame.Controllers.PnlVehicleController;
import ni.edu.ni.Frame.panels.PnlVehicle;


/**
 *
 * @author Pablo
 */
public class IFCreate extends javax.swing.JInternalFrame {
    private PnlVehicle pnlVehicle;
    private PnlVehicleController pnlVehicleController;
    /**
     * Creates new form IFCreate
     */
    public IFCreate() {
        initComponents();
    }
    private void init() throws FileNotFoundException
    {
        PrinPnl.removeAll();
        if (pnlVehicle == null)
        {
            pnlVehicle = new PnlVehicle();
            pnlVehicleController = new PnlVehicleController(pnlVehicle);
        }
        // Vos venis, le pedis el tamanio al panel y se lo seteas al otro prix ta duro
        PrinPnl.setSize(pnlVehicle.getSize());
        PrinPnl.add(pnlVehicle, BorderLayout.CENTER);
        validate();
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrinPnl = new javax.swing.JPanel();

        PrinPnl.setLayout(new java.awt.BorderLayout());
        getContentPane().add(PrinPnl, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrinPnl;
    // End of variables declaration//GEN-END:variables
}