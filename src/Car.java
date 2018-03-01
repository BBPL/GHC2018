import java.util.ArrayList;

public class Car {

    private ArrayList<Trip> _trips;
    private Tuple pos;
    private int time;
    private int id;
    private int cutoff;

    public Car(int id, int time){
        this.cutoff = time;
        this.id = id;
        pos = new Tuple(0,0);
        time = 0;
        _trips = new ArrayList<Trip>();
    }

    public ArrayList<Trip> makeTrips(ArrayList<Trip> trips){
        while(true){
            Trip t = CalculateBestTrip(trips);
            if(t == null)
                break;
            if(!canMakeCutoff(t))
                break;
            _trips.add(t);
            updateCar(t);
            trips.remove(t);
        }
        return trips;
    }

    public ArrayList<Trip> makeTrip(ArrayList<Trip> trips){
        Trip t = CalculateBestTrip(trips);
        if(t == null)
            return trips;
        if(!canMakeCutoff(t))
            return trips;
        updateCar(t);
        trips.remove(t);

        return trips;
    }

    private void updateCar(Trip t) {
        time += calculateDistance(pos,t.start)+ calculateDistance(t.start, t.end);
        pos = t.end;
        _trips.add(t);
    }

    private Trip CalculateBestTrip(ArrayList<Trip> trips){
        if(trips.size() <= 0)
            return null;
        int bestTime = Integer.MAX_VALUE;
        Trip best = null;
        for(Trip t : trips){
            if(canMakeCutoff(t))
                if(canMakeTrip(t))
                    if(best == null)
                        best = t;
                    else best = CompareTrips(best, t);
                continue;
        }
        return best;
    }

    private boolean canMakeCutoff(Trip t){
        if((calculateDistance(pos,t.start)+ calculateDistance(t.start, t.end) + time) < cutoff)
            return true;
        return false;
    }

    private boolean canMakeTrip(Trip t){
        int expectedEndTime = calculateDistance(pos,t.start)+ calculateDistance(t.start, t.end) + time;
        return t.endTime > expectedEndTime;
    }

    private Trip CompareTrips(Trip t1, Trip t2){
        int distT1 = calculateDistance(pos,t1.start);
        int distT2 = calculateDistance(pos, t2.start);
        if(distT1 > distT2)
            return t1;
        return t2;
    }

    private int calculateDistance(Tuple start, Tuple end){
        return Math.abs(start.x-end.y) + Math.abs(start.y-end.y);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(_trips.size());
        for(Trip t :  _trips){
            sb.append(t.toString());
        }
        return  sb.toString();
    }
}
