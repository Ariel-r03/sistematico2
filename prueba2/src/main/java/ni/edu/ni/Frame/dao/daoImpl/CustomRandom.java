/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.Frame.dao.daoImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author Pablo
 */
public class CustomRandom {
    
   // rafH cabecera, rafD es donde se guardara todo
    private RandomAccessFile rafH;
    private RandomAccessFile rafD;
    
    // constructor
    public CustomRandom(File fileHead, File fileData) throws FileNotFoundException, IOException
    {
        rafH = new RandomAccessFile(fileHead, "rw");
        rafD = new RandomAccessFile(fileData, "rw");

        if (fileHead.length() == 0) {
            rafH.writeInt(0);
            rafH.writeInt(0);
        }
    }
    
    // cerrar flujos
    public void close() throws IOException
    {
        if (rafH != null)
            rafH.close();
        
        if (rafD != null)
            rafD.close();
    }
    
    public RandomAccessFile getRafH() 
    {
        return rafH;
    }

    public RandomAccessFile getRafD() 
    {
        return rafD;
    }
}
