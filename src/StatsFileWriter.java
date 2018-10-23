import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StatsFileWriter {
    void write(List<Player> players) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Player player : players) {
            lines.add(player.getFirstName() + ";" + player.getLastName() + ";" + player.getScore());
        }

        Files.write(Paths.get("C:\\Users\\natal\\IdeaProjects\\DOM zadanie-java-13.1\\src\\stats.csv"), lines);


    }
}
