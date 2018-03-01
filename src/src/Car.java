package src;

import java.util.ArrayList;

public class Car {

    private ArrayList<Trip> _trips;
    private Tuple pos;
    private int time;
    private int id;

    public Car(int id){
        this.id = id;
        pos = new Tuple(0,0);
        time = 0;
        _trips = new ArrayList<Trip>();
    }

    public ArrayList<Trip> makeTrips(ArrayList<Trip> trips){
        return null;
    }

    @Override
    public String toString() {
        return _trips.size() + "" +_trips.toString();
    }
}
