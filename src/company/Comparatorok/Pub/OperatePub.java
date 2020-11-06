package company.Comparatorok.Pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OperatePub {

    private  Pub pub;

    public OperatePub(Pub pub) {
        this.pub = pub;
    }

    public  void setUpPub() {
        HashMap<String, Drink> map = new HashMap<>();
        map.put("Sör", new Drink("Sör", 15, 0.045, 500, 0.5));
        map.put("Wine", new Drink("Wine", 15, 0.11, 360, 0.3));
        map.put("Palinka", new Drink("Palinka", 2, 0.30, 400, 0.04));
        map.put("Water", new Drink("Water", 1, 0, 40, 0));
        pub.setDrinkStorage(map);

        List<Guest> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new Guest(i, map.keySet()));
        }
        pub.setGuests(list);
    }

    public  List<Drink> getTypeOfDrink(String key, HashMap<Drink, List<Drink>> storage) {
        return new ArrayList<Drink>(storage.get(key));
    }

    public void printOut(HashMap<String, Drink> list, List<Guest> guest) {
        System.out.println(list.toString());
        System.out.println(guest.toString());
    }


    public  void pubRunning(List<Guest> guestList, HashMap<String, Drink> drinkStorage) {
        for (double i = 0; i <= pub.getOpenTime(); i += 0.5) {
            for (Guest actualGuest : guestList) {
                String favoriteDrink = actualGuest.getFavoriteDrink();
                if (actualGuest.isThirsty()) {
                    System.out.println("A(z) " + actualGuest.getName() + ". vendég szomjas és rendelne");
                    if (drinkStorage.containsKey(favoriteDrink) && checkQuantity(drinkStorage.get(favoriteDrink))) {
                        System.out.println("A(z) " + actualGuest.getName() + ". a kedvencét rendeli ami " + favoriteDrink);
                        serveGuest(actualGuest,drinkStorage.get(favoriteDrink));
                    } else if (actualGuest.drinkEls()){
                        System.out.println("Sajnos nincs a kedvencéből, de szívesen inna mást.");
                        serveGuest(actualGuest,drinkStorage.get(actualGuest.chooseRandomDrink()));
                    }
                }
            }
        }
    }

    public boolean checkQuantity(Drink drink){
        return drink.getQuantity()>drink.getDose();
    }

    public  void serveGuest(Guest actualGuest, Drink actualDrink) {
        actualDrink.setQuantity(actualDrink.getQuantity() - actualDrink.getDose());

        actualGuest.setAlcoholLevel(actualGuest.getAlcoholLevel() - actualDrink.getAlcoholLevel());
        pub.setPayBox(pub.getPayBox() + actualDrink.getPrice());
    }

public void random(){
    System.out.println("Random");
}

}
