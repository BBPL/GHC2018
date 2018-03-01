import src.Tuple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int GlobalTime;
    private static ArrayList<Trip> trips;
    private static ArrayList<Car> cars;
    public static void main(String[] args) throws FileNotFoundException {

        trips = new ArrayList<Trip>();
        cars = new ArrayList<Car>();

        if (args.length <= 0) System.exit(0);
        Scanner scanner = new Scanner(new FileInputStream(args[0]));

        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();
        int vehicles = scanner.nextInt();
        int rides = scanner.nextInt();
        int bonus = scanner.nextInt();
        int time = scanner.nextInt();
        if(numRows < 1 || numCols < 1 || vehicles < 1 || rides < 1 || bonus < 1 || time < 1) System.exit(0);
        scanner.nextLine();
        while(scanner.hasNextLine()){
            int startx = scanner.nextInt();
            int starty = scanner.nextInt();
            int endx = scanner.nextInt();
            int endy = scanner.nextInt();
            int earliestStart = scanner.nextInt();
            int latestEnd = scanner.nextInt();
            Tuple s = new Tuple(startx,starty);
            Tuple e = new Tuple(startx,starty);
            trips.add(new Trip(s, e, earliestStart, latestEnd));
        }

        for(int i = 0; i < vehicles; i++){
            cars.add(new Car());
        }





    }
}
