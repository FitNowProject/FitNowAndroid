package pe.edu.upc.fitnow.models;

/**
 * Created by mac on 10/23/17.
 */

public class Event {
    private int id;
    private String type;
    private int image;
    private String place;
    private String date;
    private String hour_start;
    private String hour_finish;
    private int distance;
    private int members;

    public Event(int id,String type, int image, String place, String date, String hour_start, String hour_finish, int distance, int members) {
        this.id=id;
        this.type = type;
        this.image = image;
        this.place = place;
        this.date = date;
        this.hour_start = hour_start;
        this.hour_finish = hour_finish;
        this.distance = distance;
        this.members = members;
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public Event setId(int id) {
        this.id = id;
        return this;
    }

    public int getImage() {
        return image;
    }

    public Event setImage(int image) {
        this.image = image;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Event setPlace(String place) {
        this.place = place;
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

    public String getType() {
        return type;
    }

    public Event setType(String type) {
        this.type = type;
        return this;
    }

    public String getHour_finish() {
        return hour_finish;
    }

    public Event setHour_finish(String hour_finish) {
        this.hour_finish = hour_finish;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public Event setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public int getMembers() {
        return members;
    }

    public Event setMembers(int members) {
        this.members = members;
        return this;
    }
}
