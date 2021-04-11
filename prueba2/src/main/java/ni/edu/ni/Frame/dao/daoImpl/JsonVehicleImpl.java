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
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
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
    private final int SIZE = 850;
    private Gson gson;
    private Vehicle v;
    
    public  JsonVehicleImpl() throws FileNotFoundException
    {
        super(new File("vehicleJson.head"), new File("vehicleJson.dat"));
        gson = new Gson();
    }

    @Override
    public Vehicle findById(int id) throws IOException {
        Vehicle v = null;
        
        if(id<0){
            return null;
        }
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();

//        System.out.println("Tamaño de la lista"+n);
        if(n==0){
            return null;
        }
        //if(id!=0){
//        int pos = randomBinarySearch(getCustomRandom().getRafH(), id, 1, n);
//        
//        
//        if(pos<0){
//            return null;
//        }
        //}
        long posData = (id-1)*SIZE+4;
        if(id==0){
         posData = 4;   
        }
        
        getCustomRandom().getRafD().seek(posData);
        
        v = new Vehicle();
        //v.setId(getCustomRandom().getRafD().readInt());
        v = gson.fromJson(getCustomRandom().getRafD().readUTF(), Vehicle.class);
        System.out.println(v.getPrice());
        return v;
        
    }

    public static int randomBinarySearch(RandomAccessFile raf, int key, int low, int high) throws IOException {
        int index = Integer.MIN_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            long pos = 8 + (mid)*4;
            raf.seek(pos);
            int id = raf.readInt();
            if (id < key) {
                low = mid + 1;
            } else if (id > key) {
                high = mid - 1;
            } else if (id == key) {
                index = (int) pos;
                break;
            }
        }
        return index;
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
        int k = getCustomRandom().getRafH().readInt();
                
        long posD = k*SIZE + 4;        
        getCustomRandom().getRafD().seek(posD);
        System.out.println(k);
        
        getCustomRandom().getRafD().writeInt(++k);//id
        t.setId(k);
        getCustomRandom().getRafD().writeUTF(gson.toJson(t));//Vehicle json
        
        long posH = 8 + (n*8);
        getCustomRandom().getRafH().seek(posH);
        
        getCustomRandom().getRafH().writeInt(k);
        getCustomRandom().getRafH().writeInt(t.getStockNumber());
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(++n);
        getCustomRandom().getRafH().writeInt(k);
        
        close();
    }

    public int update(Vehicle t, int row) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //@Override
    public boolean delete(Vehicle t) throws IOException {
        
        System.out.println(getCustomRandom().getRafH());
        if (t == null)
            return false;
        
        int[] ides = null;
        getCustomRandom().getRafH().seek(0);
        int n =  getCustomRandom().getRafH().readInt();
        int k =  getCustomRandom().getRafH().readInt();
        for(int i = 0; i<n; i++){
            long posHeader = 8+i*4;
             getCustomRandom().getRafH().seek(posHeader);
             
             int key =  getCustomRandom().getRafH().readInt();
             if(key!=t.getId()){
                 ides=add_ids(ides,key);
             }
             
        }
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(--n);
        getCustomRandom().getRafH().writeInt(k);
        
        for (int ide : ides) {
            getCustomRandom().getRafH().writeInt(ide);
        }
        return true;
    }
    
    private int[] add_ids (int[] arreglo,int id){
        if(arreglo== null){
            arreglo=new int[1];
            arreglo[0]=id;
            return arreglo;
        }
        arreglo=Arrays.copyOf(arreglo , arreglo.length +1 );
        arreglo[arreglo.length-1]=id;
        return arreglo;
    }

    @Override
    public Collection<Vehicle> getAll() throws IOException {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = null;
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();        
        
        for(int i = 0; i < n; i++){
            long posH = 8 + (i*8);
            getCustomRandom().getRafH().seek(posH);
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0){
                continue;
            }
            
            long posD = 4 + (id - 1)*SIZE;
            getCustomRandom().getRafD().seek(posD);
            vehicle = gson.fromJson(getCustomRandom().getRafD().readUTF(), Vehicle.class);
            
            vehicles.add(vehicle);            
        }
        
        return vehicles;
    }

    //@Override
    public boolean delete(Vehicle t, int row[]) throws IOException {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println(getCustomRandom().getRafH());
        int[] ides = null;
        getCustomRandom().getRafH().seek(0);
        int n =  getCustomRandom().getRafH().readInt();
        int k =  getCustomRandom().getRafH().readInt();
        for(int i = 0; i<n; i++){
            long posHeader = 8+i*4;
             getCustomRandom().getRafH().seek(posHeader);
             
             int key =  getCustomRandom().getRafH().readInt();
             if(key!=t.getId()){
                 ides=add_ids(ides,key);
             }
             
        }
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(--n);
        getCustomRandom().getRafH().writeInt(k);
        
        for (int ide : ides) {
            getCustomRandom().getRafH().writeInt(ide);
        }
        return true;
    }

    @Override
    public int update(Vehicle t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
