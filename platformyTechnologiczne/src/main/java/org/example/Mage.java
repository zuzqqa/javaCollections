package org.example;
import java.util.*;

public class Mage implements Comparable<Mage>{
    private String name;
    private int level;
    private double power;
    private final int recursionLevel;
    private int childrenCount;
    private Set<Mage> students;

    // konstruktor

    public Mage(String name, int level, double power){
        this.name = name;
        this.level = level;
        this.power = power;
        this.recursionLevel = 0;
        this.childrenCount = 0;
        this.students = new HashSet<>();
    }

    // gettery i settery dla pól

    public void setName(String name){
        this.name = name;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setPower(double power){
        this.power = power;
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return this.level;
    }

    public double getPower(){
        return this.power;
    }

    public int getChildrenCount() { return this.childrenCount; }

    @Override
    public int compareTo(Mage other){
        if(!Objects.equals(this.name, other.name)) return this.name.compareTo(other.name);
        if(this.level != other.level) return Integer.compare(this.level, other.level);
        return Double.compare(this.power, other.power);
    }

    @Override
    public String toString(){
        return String.format("Mage{name='%s', level=%d, power=%.2f}", name, level, power);
    }

    public void addApprentice(Mage apprentice){
        students.add(apprentice);
    }

    public void printTree() {
        printTree(this, "", recursionLevel);
    }

    private void printTree(Mage mage, String indent, int recursionLevel) {
        String dashes = "-".repeat(recursionLevel + 1);

        System.out.println(indent + dashes + mage);

        for (Mage apprentice : mage.students) {
            printTree(apprentice, indent, recursionLevel + 1);
        }
    }

   public int childrenCount(Mage mage){
       childrenCount = 0;

        for (Mage student : mage.students) {
            childrenCount += 1;
            childrenCount += childrenCount(student);
        }

        return childrenCount;
   }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, power, students);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Mage)) return false;
        Mage mage = (Mage) obj;
        return level == mage.level &&
                Double.compare(mage.power, power) == 0 &&
                Objects.equals(name, mage.name);
    }
}

