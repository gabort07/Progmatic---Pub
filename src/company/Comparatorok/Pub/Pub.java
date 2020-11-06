package company.Comparatorok.Pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pub {
    private HashMap<String, Drink> drinkStorage;
    private List<Guest> guests;
    private  double openTime;
    private  int payBox;

    public Pub() {
        this.drinkStorage = new HashMap<>();
        this.guests = new ArrayList<>();
        this.openTime=16;
        this.payBox = 0;
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

    public  double getOpenTime() {
        return openTime;
    }

    public void setOpenTime(double openTime) {
        this.openTime = openTime;
    }

    public  int getPayBox() {
        return payBox;
    }

    public  void setPayBox(int payBox) {
        this.payBox = payBox;
    }
}
