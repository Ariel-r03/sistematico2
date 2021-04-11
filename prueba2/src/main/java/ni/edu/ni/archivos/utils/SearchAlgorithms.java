/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.archivos.utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import ni.edu.ni.Frame.dao.daoImpl.CustomRandom;
import ni.edu.ni.Frame.dao.daoImpl.RandomTemplate;

/**
 *
 * @author Pablo
 */
public class SearchAlgorithms {
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

}
