/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.entity.storagesort;

import by.bsuir.bocharenko.rms.entity.Storage;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class SortStorageByReceiptDate implements Comparator<Storage>{

    @Override
    public int compare(Storage o1, Storage o2) {
        return o1.getReceiptDate().compareTo(o2.getReceiptDate());
    }
    
}
