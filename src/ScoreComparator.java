import java.util.Comparator;

public class ScoreComparator implements Comparator<Player> {
    public int compare (Player o1, Player o2) {
        return Double.compare(o2.getScore(), o1.getScore());
    }
}
