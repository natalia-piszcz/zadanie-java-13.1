import java.util.Comparator;

public class LastNameComparator implements Comparator<Player> {


    @Override
    public int compare(Player o1, Player o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
