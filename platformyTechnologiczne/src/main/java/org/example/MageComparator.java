package org.example;
import java.util.Comparator;
import java.util.Objects;

public class MageComparator implements Comparator<Mage>{
    @Override
    public int compare(Mage mage1, Mage mage2){
        if(mage1.getLevel() != mage2.getLevel()) return Integer.compare(mage1.getLevel(), mage2.getLevel());
        if(!Objects.equals(mage1.getName(), mage2.getName())) return mage1.getName().compareTo(mage2.getName());
        return Double.compare(mage2.getPower(), mage1.getPower());
    }
}
