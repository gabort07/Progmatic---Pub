package company.Comparatorok.Artist;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AwardsDB database = new AwardsDB();

        Creator.writeFromFile(database.awardedArtists, "./Files/foglalkozas.txt", "./Files/szemely.txt");
//        Creator.writeOutArtists(database.awardedArtists);

        database.sortByYear = Creator.makeHashMap(database.awardedArtists);
        List<String> list2 = Creator.alphabetSort(database.awardedArtists);
        System.out.println("Sorold fel ábécérendben a 2013-ban kitüntetettek nevét! Írd meg a feladatot comparator segítségével is!\n"+
                list2);

        System.out.println(" Balettel foglalkozó díjazottakra vagyunk kíváncsiak," +
                " de többféle ezzel kapcsolatos hivatás létezik." +
                " Írasd ki azoknak a nevét és foglalkozását, " +
                "akik foglalkozási neve tartalmazza a „balett” szórészletet!\n +");
    }
}
