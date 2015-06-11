/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.entity.materialsort;

import by.bsuir.bocharenko.rms.entity.Material;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class SortMaterialByUnitCost implements Comparator<Material>{

    @Override
    public int compare(Material o1, Material o2) {
        if(o1.getUnitStorageCost() > o2.getUnitStorageCost()){
            return 1;
        }
        if(o1.getUnitStorageCost() < o2.getUnitStorageCost()){
            return -1;
        }
        return 0;
    }
    
}