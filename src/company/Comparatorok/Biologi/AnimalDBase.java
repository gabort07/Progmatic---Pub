package company.Comparatorok.Biologi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AnimalDBase {
    public List<Animal> animalCollection = new ArrayList<>();
    public HashMap<String, List<Animal>> sortByRace = new HashMap<>();

    public void makeAnimalList(String pathName1, String pathName2) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File(pathName1));
        while (sc1.hasNextLine()) {
            String[] specifics = sc1.nextLine().split(",");
            Animal animal = new Animal(specifics[0], specifics[1],
                    Double.parseDouble(specifics[2]), Double.parseDouble(specifics[3]),
                    Double.parseDouble(specifics[4]));
            animalCollection.add(animal);
            sortByRace.putIfAbsent(specifics[0], new ArrayList<>());
            sortByRace.get(specifics[0]).add(animal);
        }

        Scanner sc2 = new Scanner(new File(pathName2));
        while (sc2.hasNextLine()) {
            String[] occurrence = sc2.nextLine().split(",", 2);
            String race = occurrence[0];
            String[] continents = occurrence[1].trim().split(",");
            for (Animal actual : sortByRace.get(race)) {
                actual.addOccurrence(continents);
            }
        }
    }

    public void getThe3Fastest(List<Animal> collection) {
        Collections.sort(collection, new SortBySpeedAscendent());
        System.out.println(collection.get(0).getRace() + ", " + collection.get(1).getRace() + ", "
                + collection.get(2).getRace());
    }

    public void sortFromTerrestrial(List<Animal> collection) {
        HashMap<String, List<Animal>> terrestrialAnimals = new HashMap<>();
        for (Animal actualAnimal : collection) {
            terrestrialAnimals.putIfAbsent(actualAnimal.getType(), new ArrayList<>());
            terrestrialAnimals.get(actualAnimal.getType()).add(actualAnimal);
        }
        getThe3Fastest(terrestrialAnimals.get("szárazföldi"));
    }

    public void writeOut() {
        for (Animal animal : animalCollection) {
            System.out.println(animal.getOccurrence());
        }
    }

    public void writeOut(HashMap<String, ArrayList<Animal>> list, String key){
        for(Animal actual : list.get(key)){
            System.out.println(actual.getRace());
        }
    }

    public void printFastest(List<Animal> collection, String key) {
        HashMap<String, ArrayList<Animal>> euAnimal = new HashMap<>();
        for (Animal actual : collection) {
            for (String continent : actual.getOccurrence()) {
                euAnimal.putIfAbsent(continent, new ArrayList<>());
                euAnimal.get(continent).add(actual);
            }
        }

        Collections.sort(euAnimal.get(key), new SortBySpeedAscendent());
        System.out.println(euAnimal.get(key).get(0).getRace() + ", " + euAnimal.get(key).get(1).getRace() + ", " +
                euAnimal.get(key).get(2).getRace());
    }


}
