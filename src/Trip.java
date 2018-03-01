import java.util.Objects;

public class Trip {
    public Tuple start;
    public Tuple end;
    public int startTime;
    public int endTime;
    private int id;

    public Trip(Tuple start, Tuple end, int startTime, int endTime,int id) {
        this.start = start;
        this.end = end;
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
    }

    @Override
    public String toString() {
        return " " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return startTime == trip.startTime &&
                endTime == trip.endTime &&
                id == trip.id &&
                Objects.equals(start, trip.start) &&
                Objects.equals(end, trip.end);
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, end, startTime, endTime, id);
    }
}
