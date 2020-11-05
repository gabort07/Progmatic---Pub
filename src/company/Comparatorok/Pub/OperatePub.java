package company.Comparatorok.Pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OperatePub {

    public  void setUpPub(Pub pub) {
        HashMap<String, Drink> map = new HashMap<>();
        map.put("Sör", new Drink("Sör", 15, 0.045, 500, 0.5));
        map.put("Wine", new Drink("Wine", 15, 0.11, 360, 0.3));
        map.put("Palinka", new Drink("Palinka", 2, 0.30, 400, 0.04));
        map.put("Water", new Drink("Water", 1, 0, 40, 0));
        pub.setDrinkStorage(map);

        List<Guest> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new Guest(i));
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
        for (double i = 0; i <= Pub.getOpenTime(); i += 0.5) {
            for (Guest actualGuest : guestList) {
                String favoriteDrink = actualGuest.getFavoriteDrink();
                if (actualGuest.isThirsty()) {
                    System.out.println("A(z) " + actualGuest.getName() + ". vendég szomjas és rendelne");
                    if (drinkStorage.containsKey(favoriteDrink)) {
                        System.out.println("A(z) " + actualGuest.getName() + ". a kedvencét rendeli ami " + favoriteDrink);
                        serveGuest(actualGuest,drinkStorage.get(favoriteDrink));
                    } else {

                        chooseRandomDrink();
                    }
                }
            }
        }
    }

    public  void serveGuest(Guest actualGuest, Drink actualDrink) {
        actualDrink.setQuantity(actualDrink.getQuantity() - actualDrink.getDose());
        if(actualDrink.getQuantity()==0){

        }
        actualGuest.setAlcoholLevel(actualGuest.getAlcoholLevel() - actualDrink.getAlcoholLevel());
        Pub.setPayBox(Pub.getPayBox() + actualDrink.getPrice());
    }

    public static String chooseRandomDrink() {
        int drink = (int) (Math.random() * 5 + 1);
        return switch (drink) {
            case 1 -> "Sör";
            case 2 -> "Wine";
            case 3 -> "Palinka";
            case 4 -> "Water";
            case 5 -> "";
            default -> throw new IllegalStateException("Unexpected value: " + drink);
        };
    }

}
