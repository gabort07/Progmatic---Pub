package company.Comparatorok.Biologi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Animal {
    private String race;
    private String type;
    private double averageWeight;
    private double maxSpeed;
    private double averageLifeTime;
    private List<String> occurrence;

    public Animal(String race, String type, double averageWeight, double maxSpeed, double averageLifeTime) {
        this.race = race;
        this.type = type;
        this.averageWeight = averageWeight;
        this.maxSpeed = maxSpeed;
        this.averageLifeTime = averageLifeTime;
        this.occurrence = new ArrayList<>();
    }

    public String getRace() {
        return race;
    }

    public String getType() {
        return type;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getAverageLifeTime() {
        return averageLifeTime;
    }

    public List<String> getOccurrence() {
        return occurrence;
    }

    public void addOccurrence(String[] list){
        this.occurrence.addAll(Arrays.asList(list));
    }


}
