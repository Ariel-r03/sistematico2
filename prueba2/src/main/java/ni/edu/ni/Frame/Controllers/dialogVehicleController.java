/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.Frame.Controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import ni.edu.ni.Frame.dao.daoImpl.JsonVehicleImpl;
import ni.edu.ni.Frame.panels.dialogVehicle;
import ni.edu.ni.pojo.Vehicle;
import ni.edu.ni.pojo.VehicleSubModel;
import ni.edu.ni.Frame.panels.DCreateV;
/**
 *
 * @author JADPA03
 */
public class dialogVehicleController {
    private Gson gson;
    private dialogVehicle DVehicle;
    private JsonVehicleImpl jvdao;
    private List<VehicleSubModel> vehicleSubModels;
    private DefaultComboBoxModel cmbModelMake;
    private DefaultComboBoxModel cmbModelModel;
    private DefaultComboBoxModel cmbModelYear;
    private DefaultComboBoxModel cmbModelEColor;
    private DefaultComboBoxModel cmbModelIColor;
    private DefaultComboBoxModel cmbStatus;
    private JFileChooser fileChooser;
    private Border stockBorder;

    private DCreateV dCreate;
    
    public dialogVehicleController(DCreateV DVehicle) throws FileNotFoundException {
        this.dCreate = DVehicle;
        initComponent();
    }
    
    private void initComponent() throws FileNotFoundException
    {
        jvdao = new JsonVehicleImpl();
        gson = new Gson();
        
        JsonReader jreader = new JsonReader(
                new BufferedReader(new InputStreamReader
                (
                        getClass().getResourceAsStream("/jsons/vehicleData.json")
                ))
        );
        
        Type listType = new TypeToken<ArrayList<VehicleSubModel>>(){}.getType();
        
        vehicleSubModels = gson.fromJson(jreader, listType);
        
        Set<String> makes = vehicleSubModels.stream()
                .map(VehicleSubModel::getMake).sorted().collect(Collectors.toSet());
        Set<String> models = vehicleSubModels.stream()
                .map(VehicleSubModel::getModel).sorted().collect(Collectors.toSet());
        Set<String> colors = vehicleSubModels.stream()
                .map(VehicleSubModel::getColor).sorted().collect(Collectors.toSet());
        Set<String> years = vehicleSubModels.stream()
                .map(VehicleSubModel::getYear).sorted().collect(Collectors.toSet());
        Set<String> status = vehicleSubModels.stream()
                .map(VehicleSubModel::getStatus).sorted().collect(Collectors.toSet());
        
        cmbModelMake = new DefaultComboBoxModel(makes.toArray());
        cmbModelModel = new DefaultComboBoxModel(models.toArray());
        cmbModelYear = new DefaultComboBoxModel(years.toArray());
        cmbModelEColor = new DefaultComboBoxModel(colors.toArray());
        cmbModelIColor = new DefaultComboBoxModel(colors.toArray());
        cmbStatus = new DefaultComboBoxModel(status.toArray());
        
        dCreate.getCmbMake().setModel(cmbModelMake);
        dCreate.getCmbModel().setModel(cmbModelModel);
        dCreate.getCmbYear().setModel(cmbModelYear);
        dCreate.getCmbEColor().setModel(cmbModelEColor);
        dCreate.getCmbIColor().setModel(cmbModelIColor);
        dCreate.getCmbStatus().setModel(cmbStatus);
        
        
        dCreate.getBtnSave().addActionListener((e)->
        {
            try
            {
                btnSaveActionListener(e);
            } catch (Exception ex)
            {
                Logger.getLogger(PnlVehicleController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se puede");
            }
        }
        );
    }
    
    
    private void btnSaveActionListener(ActionEvent e) throws Exception
    {
        int stock, year;
        String make, model, style, vin, eColor, iColor, miles, engine, image, status;
        float price;
        Vehicle.Transmission transmission = Vehicle.Transmission.AUTOMATIC;
        
        if (dCreate.getTxtStock().getText().isEmpty())
        {
            // joption de esto 
            return;
        }
        
        stock = Integer.parseInt(dCreate.getTxtStock().getText());
        year = Integer.parseInt(dCreate.getCmbYear().getSelectedItem().toString());
        make = dCreate.getCmbMake().getSelectedItem().toString();
        model = dCreate.getCmbModel().getSelectedItem().toString();
        style = dCreate.getTxtStyle().getText();
        vin = dCreate.getFmtVIN().getText();  
        eColor = dCreate.getCmbEColor().getSelectedItem().toString();
        iColor = dCreate.getCmbIColor().getSelectedItem().toString();
        miles = dCreate.getSpnMiles().getModel().getValue().toString();
        price = Float.parseFloat(dCreate.getSpnPrice().getModel().getValue().toString());
        engine = dCreate.getTxtEngine().getText();
        image = dCreate.getTxtImage().getText();
        status = dCreate.getCmbStatus().getSelectedItem().toString();
        transmission = dCreate.getRbtnAut().isSelected() ? transmission : Vehicle.Transmission.MANUAL;
        
        System.out.println(eColor);
        
        Vehicle v = new Vehicle(stock, year, make, model, 
                style, vin, eColor, iColor, miles, price, transmission, engine, image, status);
        
        jvdao.create(v);
        JOptionPane.showMessageDialog(null, "Vehicle saved successfully.", "Information message", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
