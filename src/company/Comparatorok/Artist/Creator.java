package company.Comparatorok.Artist;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.Collator;
import java.util.*;

public class Creator {

    public static void writeFromFile(List<AwardedArtist> list, String professionFile, String personFile) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File(professionFile));
        Scanner sc2 = new Scanner(new File(personFile));
        while (sc1.hasNextLine()) {
            String[] professionData = sc1.nextLine().split(",");
            ArrayList<String> profession = new ArrayList<>(Arrays.asList(professionData));
            String name = profession.get(0);
            profession.remove(0);
            String[] awardData = sc2.nextLine().split(",");
            if (awardData.length == 3) {
                list.add(new AwardedArtist(name, profession, awardData[2], Integer.parseInt(awardData[1])));
            } else {
                list.add(new AwardedArtist(name, profession));
            }
        }
    }

    public static void writeOutArtists(List<AwardedArtist> list) {
        for (AwardedArtist actual : list) {
            System.out.println(actual.getPersonName() + ", " + actual.getAwardName());
        }
    }

    public static HashMap<Integer, List<AwardedArtist>> makeHashMap(List<AwardedArtist> list){
        HashMap<Integer, List<AwardedArtist>> map = new HashMap<>();
        for(AwardedArtist actual : list){
            map.putIfAbsent(actual.getAwardedIn(), new ArrayList<>());
            map.get(actual.getAwardedIn()).add(actual);
        }
        return map;
    }

    public static List<String> alphabetSort(List<AwardedArtist> list) {
        HashMap<Integer, List<AwardedArtist>> map = makeHashMap(list);;
        List<String> list2 = new ArrayList<>();
        for(AwardedArtist actual : map.get(2013)){
            list2.add(actual.getPersonName());
        }
        list2.sort(Collator.getInstance(new Locale("hu","HU")));
        return list2;
    }
}
