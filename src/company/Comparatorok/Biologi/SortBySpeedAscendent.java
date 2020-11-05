package company.Comparatorok.Biologi;

import java.util.Comparator;

public class SortBySpeedAscendent implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        if (o2.getMaxSpeed() - o1.getMaxSpeed() < 0) {
            return -1;
        } else if (o2.getMaxSpeed() - o1.getMaxSpeed() == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
