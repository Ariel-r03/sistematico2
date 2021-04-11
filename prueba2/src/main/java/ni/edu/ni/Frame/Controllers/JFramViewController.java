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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import ni.edu.ni.Frame.JIntFrame;
import ni.edu.ni.Frame.panels.JFramView;
import ni.edu.ni.pojo.Vehicle;
/**
 *
 * @author Pablo
 */
public class JFramViewController {
    private PnlVehicleShowInfo pvShowInfo;
    private PnlVehicleShowController pnlVehicleShowController;
    private DefaultTableModel tm;
    private DCreateV dCreate;
    private dialogVehicleController DVehicle_Controller;
    private JsonVehicleImpl jvdao;
    private JIntFrame InternalFrame;
    private JFramView jFramV;
    private List<Vehicle> Vehicles = new ArrayList<Vehicle>();
    public JFramViewController(JFramView jFrameV)
    {
        this.jFramV = jFrameV;
        initComponent();
    }
    public void initComponent()
    {
        tm = (DefaultTableModel) jFramV.getTVehicles().getModel();
        
        jFramV.getBtnDelete().addActionListener((e)->
        {
            try {
                btnDeleteActionListener(e);
            } catch (IOException ex) {
                Logger.getLogger(JFramViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        jFramV.getBtnUpdate().addActionListener((e)->
        {
            try {
                btnViewActionListener(e);
            } catch (IOException ex) {
                Logger.getLogger(JFramViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    private void btnNewActionListener(ActionEvent e) throws FileNotFoundException
    {
        if (dCreate == null)
        {
            dCreate = new DCreateV();
            DVehicle_Controller = new dialogVehicleController(dCreate);
            dCreate.setVisible(true);
        }
    }
    private void btnDeleteActionListener(ActionEvent e) throws IOException
    {
        Vehicle v = new Vehicle();
        
        int id = (int) jFramV.getTVehicles().getValueAt(jFramV.getTVehicles().getSelectedRow(), 0);
        v = jvdao.findById(id);
        
        if (v != null)
        {
            jvdao.delete(v);
            tm.removeRow(jFramV.getTVehicles().getSelectedRow());
        }
        
    }
    public void btnViewActionListener(ActionEvent e) throws IOException
    {
        Vehicles = (List<Vehicle>)jvdao.getAll();
        showAll(Vehicles, jFramV.getTVehicles());
    }
    public void showAll(List<Vehicle> vh, JTable jtable) throws IOException
    {
        //vh = new ArrayList<Vehicle>();
        //vh = (List<Vehicle>)jvdao.getAll();
        while (vh.size() > jFramV.getTVehicles().getRowCount())
                tm.addRow(new Object[]{});
        
        System.out.println(vh.size());
        /*
        for (int i = 0; i < vh.size(); i++) 
        {
            //jFramV.getTVehicles().setValueAt(jtable, i, i);
            jFramV.getTVehicles().setValueAt(vh.get(i).getId(), i, 0);
            jFramV.getTVehicles().setValueAt(vh.get(i).getStockNumber(), i, 1);
            jFramV.getTVehicles().setValueAt(vh.get(i).getYear(), i, 2);
            jFramV.getTVehicles().setValueAt(vh.get(i).getMake(), i, 3);
            jFramV.getTVehicles().setValueAt(vh.get(i).getModel(), i, 4);
            jFramV.getTVehicles().setValueAt(vh.get(i).getStyle(), i, 5);
            jFramV.getTVehicles().setValueAt(vh.get(i).getVin(), i, 6);
            jFramV.getTVehicles().setValueAt(vh.get(i).getExteriorColor(), i, 7);
            jFramV.getTVehicles().setValueAt(vh.get(i).getInteriorColor(), i, 8);
            jFramV.getTVehicles().setValueAt(vh.get(i).getMiles(), i, 9);
            jFramV.getTVehicles().setValueAt(vh.get(i).getPrice(), i, 10);
            jFramV.getTVehicles().setValueAt(vh.get(i).getTransmission().toString(), i, 11);
            jFramV.getTVehicles().setValueAt(vh.get(i).getEngine(), i, 12);
            jFramV.getTVehicles().setValueAt(vh.get(i).getImage(), i, 13);
            jFramV.getTVehicles().setValueAt(vh.get(i).getStatus(), i, 14);
            
            
        }
*/
    }
}
