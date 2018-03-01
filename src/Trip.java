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
}
