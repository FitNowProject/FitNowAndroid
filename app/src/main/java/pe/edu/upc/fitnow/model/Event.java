package pe.edu.upc.fitnow.model;

/**
 * Created by Dreads on 16/10/2017.
 */

public class Event {
    private String address;
    private String date;
    private String hour_start;
    private int members;
    private String time;

    public Event(String address, String date, String hour_start, int members, String time) {
        this.address = address;
        this.date = date;
        this.hour_start = hour_start;
        this.members = members;
        this.time = time;
    }

    public Event() {
    }

    public String getAddress() {
        return address;
    }

    public Event setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Event setDate(String date) {
        this.date = date;
        return this;
    }

    public String getHour_start() {
        return hour_start;
    }

    public Event setHour_start(String hour_start) {
        this.hour_start = hour_start;
        return this;
    }

    public int getMembers() {
        return members;
    }

    public Event setMembers(int members) {
        this.members = members;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Event setTime(String time) {
        this.time = time;
        return this;
    }
}
