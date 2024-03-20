package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String mode = args[0];

        Set<Mage> mageSet = switch (args[0]) {
            case "natural" -> new TreeSet<>();
            case "none" -> new HashSet<>();
            case "alternative" -> new TreeSet<>(new MageComparator());
            default -> throw new IllegalArgumentException("Nieprawidłowy argument startowy");
        };


        Mage mage1 = new Mage("Iwsonek", 212310, 1412344.5);
        Mage mage2 = new Mage("Adasko", 23121, 1234.3);
        Mage mage3 = new Mage("Adam", 23212, 1324.1);
        Mage mage4 = new Mage("Madzia", 2122, 124.1);
        Mage mage5 = new Mage("Szpagata", 267, 14.1);
        mageSet.add(new Mage("Henio", 2, 14.1));
        mageSet.add(new Mage("Szpagata", 12, 14.1));
        mageSet.add(new Mage("Zuzka", 1, 1));
        mageSet.add(new Mage("Zuzka", 2, 1));
        mageSet.add(new Mage("Kacpi", 1123, 31));
        mageSet.add(new Mage("Kacperek", 0, 1));

        mageSet.add(mage1);
        mageSet.add(mage2);
        mageSet.add(mage3);
        mageSet.add(mage4);
        mageSet.add(mage5);

        mage1.addApprentice(mage2);
        mage1.addApprentice(mage3);
        mage2.addApprentice(mage4);
        mage3.addApprentice(mage5);

        System.out.println("\n ZBIOR ? POSORTOWANY: \n");

        for (Mage mage : mageSet)
            System.out.println(mage);

        System.out.println("\n ZBIOR WYPISANY Z ZACHOWANIEM STRUKTURY REUKRENCYJNEJ: \n");

        for (Mage mage : mageSet){
            mage.printTree();
            System.out.println("\n");
        }

        System.out.println("\n STATYSTYKI: \n");

        printStatistics(mageSet, mode);
    }

    public static void printStatistics(Set<Mage> mageSet, String mode){
        Map<Mage, Integer> statistic;

        switch(mode) {
            case "natural", "alternative" -> statistic = new TreeMap<>();
            case "none" -> statistic = new HashMap<>();
            default -> throw new IllegalArgumentException("Nieprawidłowy argument startowy");
        };

        for (Mage mage : mageSet){
            mage.childrenCount(mage);
            statistic.put(mage, mage.getChildrenCount());
        }

        for (Map.Entry<Mage, Integer> entry : statistic.entrySet()) {
            Mage mage = entry.getKey();
            Integer wartosc = entry.getValue();
            System.out.println(mage + ", Liczba potmkow: " + wartosc);
        }
    }

}