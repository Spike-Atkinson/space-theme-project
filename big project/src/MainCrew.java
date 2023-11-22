import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class MainCrew {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String path;
        Crew crew1;
        while (true) {
            try {
                System.out.println("Please enter the path of nationalities (try src/nationalities): ");
                path = input.nextLine();
                crew1 = new Crew(path);
                break;
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }
        }
        while (true) {
            System.out.println("Please enter:\n" +
                    "1 to print crew (sorted)\n" +
                    "2 to print crew (shuffled)\n" +
                    "3 to assemble and print mission crew\n" +
                    "quit to quit ");
            String selection = input.nextLine().toLowerCase(Locale.ROOT);
            if (selection.equals("1")){
                crew1.sortCrew();
                crew1.printCrew();
            }
            else if (selection.equals("2")){
                crew1.shuffleCrew();
                crew1.printCrew();
            }
            else if (selection.equals("3")){
                System.out.println(crew1.assembleMissionCrew());
            }
            else if (selection.equals("quit")){
                System.out.println("Goodbye.");
                break;
            }
            else{
                System.out.println("Invalid entry!");
            }

        }
    }
}
