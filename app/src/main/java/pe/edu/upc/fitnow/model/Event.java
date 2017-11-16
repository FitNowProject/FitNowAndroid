package pe.edu.upc.fitnow.model;

/**
 * Created by Dreads on 16/10/2017.
 */

public class Event {

    private String date;
    private String hour_start;
    private int members;
    private String time;
    private String description;
    //TYPE EVENT
    private String image;
    private String type;
    //PLACE
    private String address;

    //****
    private String typeevent;
    private String place;

    public Event(String date, String hour_start, int members, String time, String description, String typeevent, String place) {
        this.date = date;
        this.hour_start = hour_start;
        this.members = members;
        this.time = time;
        this.description = description;
        this.typeevent = typeevent;
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public Event setPlace(String place) {
        this.place = place;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Event setImage(String image) {
        this.image = image;
        return this;
    }

    public String getType() {
        return type;
    }

    public Event setType(String type) {
        this.type = type;
        return this;
    }

    public Event() {
    }
    public String getTypeevent() {
        return typeevent;
    }

    public Event setTypeevent(String typeevent) {
        this.typeevent = typeevent;
        return this;
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
