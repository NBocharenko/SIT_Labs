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
public class SortOrderByTotalVolume implements Comparator<Orderr>{

    @Override
    public int compare(Orderr o1, Orderr o2) {
        if(o1.getTotalVolume() > o2.getTotalVolume())
            return 1;
        if(o1.getTotalVolume() < o2.getTotalVolume())
            return -1;
        return 0;
    }
}
