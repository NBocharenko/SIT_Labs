/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.entity.ordersort;

import by.bsuir.bocharenko.rms.entity.Orderr;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class SortOrderByExecDate implements Comparator<Orderr>{

    @Override
    public int compare(Orderr o1, Orderr o2) {
        return o1.getExecDate().compareTo(o2.getExecDate());
    }
    
}
