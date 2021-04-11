/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.Frame.Controllers;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import ni.edu.ni.Frame.Controllers.PnlVehicleShowController;
import ni.edu.ni.Frame.Controllers.dialogVehicleController;
import ni.edu.ni.Frame.dao.daoImpl.JsonVehicleImpl;
import ni.edu.ni.Frame.panels.DCreateV;
import ni.edu.ni.Frame.panels.PnlVehicleShowInfo;

import ni.edu.ni.Frame.dao.daoImpl.RandomTemplate;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;
import ni.edu.ni.Frame.JIntFrame;
import ni.edu.ni.pojo.Vehicle;
/**
 *
 * @author Pablo
 */
public class JintFrameController {
    private PnlVehicleShowInfo pVShowInfo;
    private PnlVehicleShowController pnlVehicleShowController;
    private DefaultTableModel tm;
    private DCreateV dCreate;
    private dialogVehicleController DVehicle_Controller;
    private JsonVehicleImpl jvdao;
    private JIntFrame InternalFrame;
    
    public JintFrameController(JIntFrame InternalFrm) throws IOException {
        this.InternalFrame = InternalFrm;
        initComponent();
    }
    public void initComponent() throws IOException
    {
        //tm = (DefaultTableModel) InternalFrame.getjPanelViews().gett
        InternalFrame.getjPanelViews().removeAll();
        
        if (pVShowInfo == null)
        {
            pVShowInfo = new PnlVehicleShowInfo();
            
            pnlVehicleShowController = new PnlVehicleShowController(pVShowInfo);
        }
        InternalFrame.getjPanelViews().removeAll();
        
        InternalFrame.getBtnUpdate().addActionListener((e)->
        {
            //btnViewActionListener(e);
        });
        InternalFrame.getBtnDelete().addActionListener((e)->
        {
            try {
                btnDeleteActionListener(e);
            } catch (IOException ex) {
                Logger.getLogger(JintFrameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    private void btnNewActionListener(ActionEvent e) throws FileNotFoundException
    {
        if (dCreate == null)
        {
            dCreate = new DCreateV(null, true);
            DVehicle_Controller = new dialogVehicleController(dCreate);
            dCreate.setVisible(true);
        }
    }
    
    private void btnDeleteActionListener(ActionEvent e) throws IOException
    {
        Vehicle v = new Vehicle();
        int id = (int) tm.getValueAt(pVShowInfo.getTableInfo().getSelectedRow(), 0);
        
        v = jvdao.findById(id);
        
        if (v != null)
        {
            jvdao.delete(v);
            tm.removeRow(pVShowInfo.getTableInfo().getSelectedRow());
        }
    }
    
}
