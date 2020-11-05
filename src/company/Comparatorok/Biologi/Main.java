package company.Comparatorok.Biologi;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AnimalDBase dataBase = new AnimalDBase();
        dataBase.makeAnimalList("Files/animals.txt", "Files/foldresz.txt");

        dataBase.getThe3Fastest(dataBase.animalCollection);
        dataBase.sortFromTerrestrial(dataBase.animalCollection);
        dataBase.printFastest(dataBase.animalCollection, "Európa");
    }
}
