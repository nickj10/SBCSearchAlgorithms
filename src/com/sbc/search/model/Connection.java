package com.sbc.search.model;

public class Connection{
    private String from;
    private String to;
    private long distance;
    private long duration;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public long getDistance() {
        return distance;
    }

    public long getDuration() {
        return duration;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
