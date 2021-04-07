/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.Frame.dao.daoImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Pablo
 */
public class RandomTemplate {
    private File fileHead;
    private File fileData;
    private CustomRandom customRandom;
    
    public RandomTemplate(File fileHead, File fileData)
    {
        this.fileData = fileData;
        this.fileHead = fileHead;
    }
    
    protected CustomRandom getCustomRandom() throws FileNotFoundException, IOException
    {
        if (customRandom == null)
        {
            customRandom = new CustomRandom(fileHead, fileData);
            return customRandom;
        }
        
        return customRandom;
    }
    
    protected void close() throws IOException
    {
        customRandom.close();
        customRandom = null;
    }
}
