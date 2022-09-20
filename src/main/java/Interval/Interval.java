package Interval;

public class Interval {
    int start;
    int ending;

    public Interval(int start ,int ending) {
        this.ending = ending;
        this.start=start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnding(int ending) {
        this.ending = ending;
    }
    @Override
    public String toString(){
        return String.format("%d---%d",start,ending);
    }
}

