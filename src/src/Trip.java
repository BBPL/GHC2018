public class Trip {
    public Tuple start;
    public Tuple end;
    public int startTime;
    public int endTime;

    public Trip(Tuple start, Tuple end, int startTime, int endTime) {
        this.start = start;
        this.end = end;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
