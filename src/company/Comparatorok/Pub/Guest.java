package company.Comparatorok.Pub;

import java.util.*;

public class Guest {
    private int name;
    private String favoriteDrink;
    private boolean drinkEls;
    private double timeToSpend;
    private boolean thirsty;
    private double alcoholLevel;
    private List<String> drinksList;

    public Guest(int name, Set<String> drinks) {
        this.name = name;
        this.favoriteDrink = chooseRandomDrink();
        this.drinkEls = ((int) (Math.random() * 2 + 1) == 1);
        this.timeToSpend = ((int)(Math.random()*32+1)) / 2.0;
        this.alcoholLevel=5;
        this.thirsty = true;
        this.drinksList = new ArrayList<>(drinks);
    }

    public void setTimeToSpend(double timeToSpend) {
        this.timeToSpend = timeToSpend;
    }

    public void setThirsty() {
        this.thirsty =  ((int) (Math.random() * 2 + 1) == 1);
    }

    public void setAlcoholLevel(double alcoholLevel) {
        this.alcoholLevel = alcoholLevel;
    }

    public int getName() {
        return name;
    }

    public String getFavoriteDrink() {
        return favoriteDrink;
    }

    public boolean drinkEls() {
        return drinkEls;
    }

    public double getTimeToSpend() {
        return timeToSpend;
    }

    public boolean isThirsty() {
        return thirsty;
    }

    public double getAlcoholLevel() {
        return alcoholLevel;
    }

    public  String chooseRandomDrink() {
        int drink = (int) (Math.random() * drinksList.size() + 1);
        return drinksList.get(drink);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name=" + name +
                ", favoriteDrink='" + favoriteDrink + '\'' +
                ", drinkEls=" + drinkEls +
                ", timeToSpend=" + timeToSpend +
                ", thirsty=" + thirsty +
                ", alcoholLevel=" + alcoholLevel +
                '}';
    }
}
