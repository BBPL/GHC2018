import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public int GlobalTime;
    public static void main(String[] args) throws FileNotFoundException {

        if (args.length <= 0) System.exit(0);
        Scanner scanner = new Scanner(new FileInputStream(args[0]));

        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();
        int vehicles = scanner.nextInt();
        int rides = scanner.nextInt();
        int time = scanner.nextInt();
    }
}
