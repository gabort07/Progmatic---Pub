package company.Comparatorok.Pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class OperatePub {

    private Pub pub;

    public OperatePub(Pub pub) {
        this.pub = pub;
    }

    public void setUpPub() {
        HashMap<String, Drink> map = new HashMap<>();
        map.put("Sör", new Drink("Sör", 15, 0.045, 500, 0.5));
        map.put("Wine", new Drink("Wine", 15, 0.11, 360, 0.3));
        map.put("Palinka", new Drink("Palinka", 2, 0.30, 400, 0.04));
        map.put("Water", new Drink("Water", 1, 0, 40, 0));
        pub.setDrinkStorage(map);

        List<Guest> list = new ArrayList<>();
        List<String> drinks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new Guest(i, map.keySet()));
        }
//        System.out.println(list.toString());
        pub.setGuests(list);
    }

    public List<Drink> getTypeOfDrink(String key, HashMap<Drink, List<Drink>> storage) {
        return new ArrayList<Drink>(storage.get(key));
    }

    public void printOut(HashMap<String, Drink> list, List<Guest> guest) {
        System.out.println(list.toString());
        System.out.println(guest.toString());
    }


    public void pubRunning(List<Guest> guestList, HashMap<String, Drink> drinkStorage) {

        for (double i = 0; i <= pub.getOpenTime(); i += 0.5) {
            if (guestList.isEmpty()) {
                break;
            }

            Iterator<Guest> guestIterator = guestList.iterator();
            while (guestIterator.hasNext()) {
                Guest actualGuest = guestIterator.next();
                if (actualGuest.getTimeToSpend() <= i) {
                    // guestList.remove(actualGuest);
                    guestIterator.remove();
                    System.out.println("A " + actualGuest.getName() + ". vendég távozik a kocsmából.");
                } else {
                    servGuest(drinkStorage, actualGuest);
                   /* String favoriteDrink = actualGuest.getFavoriteDrink();

                    if (actualGuest.isThirsty()) {
                        System.out.println("A(z) " + actualGuest.getName() + ". vendég szomjas és rendelne " + actualGuest.getFavoriteDrink() + " italt.");

                        if (checkQuantity(drinkStorage.get(favoriteDrink))) {
                            System.out.println("A " + actualGuest.getName() + ". a kedvencét tudja rendelni, ami " + favoriteDrink);
                            serveGuest(actualGuest, drinkStorage.get(favoriteDrink));

                        } else if (actualGuest.drinkEls()) {
                            System.out.println("Sajnos nincs a kedvencéből, de szívesen inna mást.");
                            Drink drink = drinkStorage.get(actualGuest.chooseRandomDrink());
                            serveGuest(actualGuest, drink);
                            System.out.println("A " + actualGuest.getName() + ". mást ivott, ami " + drink.getType());

                        } else {
                            System.out.println("Elfogyott a kedvence, ami " + actualGuest.getFavoriteDrink() + ", és most nem inna mást, inkább beszélget tovább...");
                        }
                    }*/
                }
            }
            System.out.println("Eltelt fél óra: " + i);
        }
        System.out.println("A kocsma bezárt.");

    }

    public boolean checkQuantity(Drink drink) {
        return drink.getQuantity() > drink.getDose();
    }

    public void drinkServing(Guest actualGuest, Drink actualDrink) {
        actualDrink.decreesQuantity(actualDrink.getDose());
        actualGuest.incriseAlcoholLevel(actualDrink.getAlcoholLevel());
        pub.handlePayBox(actualDrink.getPrice());
    }

    public void servGuest(HashMap<String, Drink> drinkStorage, Guest actualGuest) {
        String favoriteDrink = actualGuest.getFavoriteDrink();

        if (actualGuest.isThirsty()) {
            System.out.println("A(z) " + actualGuest.getName() + ". vendég szomjas és rendelne " + actualGuest.getFavoriteDrink() + " italt.");

            if (checkQuantity(drinkStorage.get(favoriteDrink))) {
                System.out.println("A " + actualGuest.getName() + ". a kedvencét tudja rendelni, ami " + favoriteDrink);
                drinkServing(actualGuest, drinkStorage.get(favoriteDrink));

            } else if (actualGuest.drinkEls()) {
                System.out.println("Sajnos nincs a kedvencéből, de szívesen inna mást.");
                Drink drink = drinkStorage.get(actualGuest.chooseRandomDrink());
                drinkServing(actualGuest, drink);
                System.out.println("A " + actualGuest.getName() + ". mást ivott, ami " + drink.getType());

            } else {
                System.out.println("Elfogyott a kedvence, ami " + actualGuest.getFavoriteDrink() + ", és most nem inna mást, inkább beszélget tovább...");
            }
        }
    }
}


