package company.Comparatorok.Pub;

public class Guest {
    private int name;
    private String favoriteDrink;
    private boolean drinkEls;
    private double timeToSpend;
    private boolean thirsty;
    private double alcoholLevel;

    public Guest(int name) {
        this.name = name;
        this.favoriteDrink = OperatePub.chooseRandomDrink();
        this.drinkEls = ((int) (Math.random() * 2 + 1) == 1);
        this.timeToSpend = ((int)(Math.random()*32+1)) / 2.0;
        this.alcoholLevel=5;
        this.thirsty = true;
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

    public boolean isDrinkEls() {
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
