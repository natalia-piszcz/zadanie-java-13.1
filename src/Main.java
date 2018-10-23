import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Player> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj wynik kolejnego gracza albo zakończ wpisując stop");
            String line = scanner.nextLine();
            if ("stop".equals(line)) {
                break;
            }
            String[] split = line.split(" ");
            Player player = new Player(split[0], split[1], Double.parseDouble(split[2]));
            list.add(player);
        }

        System.out.println("Po czym posegregować? wynik/nazwisko/imię");
        String selection = scanner.nextLine();
        switch (selection) {
            case "wynik":
                ScoreComparator scoreComparator = new ScoreComparator();
                list.sort(scoreComparator);
                System.out.println("Posortowano po wynikach");
                break;
            case "nazwisko":
                LastNameComparator lastNameComparator = new LastNameComparator();
                list.sort(lastNameComparator);
                System.out.println("posegregowano po nazwisku");
                break;
            case "imię":
                FirstNameComparator firstNameComparator = new FirstNameComparator();
                list.sort(firstNameComparator);
                System.out.println("Posegregowano po imieniu");
                break;
            default:
                System.out.println("Nie odnaleziono filtru");

        }

        for (Player player : list) {
            System.out.println(player);
        }

        StatsFileWriter statsFileWriter = new StatsFileWriter();
        try {
            statsFileWriter.write(list);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
