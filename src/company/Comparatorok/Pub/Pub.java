package company.Comparatorok.Pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Pub {
    private HashMap<String, Drink> drinkStorage;
    private List<Guest> guests;
    private static double openTime;
    private static int payBox;

    public Pub() {
        this.drinkStorage = new HashMap<>();
        this.guests = new ArrayList<>();
        Pub.openTime=16;
        Pub.payBox = 0;
    }

    public HashMap<String, Drink> getDrinkStorage() {
        return drinkStorage;
    }

    public void setDrinkStorage(HashMap<String, Drink> drinkStorage) {
        this.drinkStorage = drinkStorage;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public static double getOpenTime() {
        return openTime;
    }

    public void setOpenTime(double openTime) {
        Pub.openTime = openTime;
    }

    public static int getPayBox() {
        return payBox;
    }

    public static void setPayBox(int payBox) {
        Pub.payBox = payBox;
    }
}
