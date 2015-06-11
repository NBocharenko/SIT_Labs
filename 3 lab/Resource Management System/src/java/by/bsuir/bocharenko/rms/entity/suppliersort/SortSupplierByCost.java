/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.entity.suppliersort;

import by.bsuir.bocharenko.rms.entity.Supplier;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class SortSupplierByCost implements Comparator<Supplier>{

    @Override
    public int compare(Supplier o1, Supplier o2) {
        if(o1.getResourceUnitPrice() > o2.getResourceUnitPrice())
            return 1;
        if(o1.getResourceUnitPrice() < o2.getResourceUnitPrice())
            return -1;
        return 0;
    }
}
