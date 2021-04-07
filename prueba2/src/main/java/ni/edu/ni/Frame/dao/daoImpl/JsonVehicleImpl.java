/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.Frame.dao.daoImpl;
// implementar dependencias de google
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.edu.ni.Frame.dao.VehicleDao;
import ni.edu.ni.Frame.dao.daoImpl.RandomTemplate;
import ni.edu.ni.pojo.Vehicle;
/**
 *
 * @author Pablo
 */
public class JsonVehicleImpl extends RandomTemplate implements VehicleDao {
    private final int SIZE = 800;
    private Gson gson;
    
    public  JsonVehicleImpl() throws FileNotFoundException
    {
        super(new File("vehicleJson.head"), new File("vehicleJson.dat"));
        gson = new Gson();
    }

    @Override
    public Vehicle findById(int id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vehicle> findByStatus(String status) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Vehicle t) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        getCustomRandom().getRafH().seek(0);
        
        int n = getCustomRandom().getRafH().readInt();
        int k = getCustomRandom().getRafD().readInt();
        
        long posD = k * SIZE;
        getCustomRandom().getRafD().writeInt(++k);
        getCustomRandom().getRafH().writeUTF(gson.toJson(t));
    }

    public int update(Vehicle t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Vehicle t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Vehicle> getAll() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
