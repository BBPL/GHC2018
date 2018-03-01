import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int GlobalTime;
    public static ArrayList<Trip> trips;
    public static ArrayList<Car> cars;
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        trips = new ArrayList<Trip>();
        cars = new ArrayList<Car>();

        if (args.length <= 0) System.exit(0);
        Scanner scanner = new Scanner(new FileInputStream(args[0]));

        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();
        int vehicles = scanner.nextInt();
        int rides = scanner.nextInt();
        int bonus = scanner.nextInt();
        int GlobalTime = scanner.nextInt();
        scanner.nextLine();
        int i = 0;
        while(scanner.hasNextLine()){
            int startx = scanner.nextInt();
            int starty = scanner.nextInt();
            int endx = scanner.nextInt();
            int endy = scanner.nextInt();
            int earliestStart = scanner.nextInt();
            int latestEnd = scanner.nextInt();
            Tuple s = new Tuple(startx,starty);
            Tuple e = new Tuple(endx,endy);
            trips.add(new Trip(s, e, earliestStart, latestEnd, i));
            i++;
            scanner.nextLine();
        }

        for(int j = 0; j < vehicles; j++){
            cars.add(new Car(j, GlobalTime));
        }
        int lastsize = trips.size();
        boolean ended = false;
        while(!trips.isEmpty()){
            lastsize = trips.size();
            for(Car c : cars){
                if(trips.size() == 0)
                    break;
                trips = c.makeTrip(trips, ended);
                System.out.println(trips.size() + " " + ended);
                System.out.println("");
            }
            if(lastsize == trips.size())
                ended = true;
        }
        PrintWriter writer = new PrintWriter("output.out", "UTF-8");
        for(Car c : cars){
            writer.println(c.toString());
        }
        writer.close();
    }
}
