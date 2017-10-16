package pe.edu.upc.fitnow.model;

import android.os.Bundle;

/**
 * Created by Dreads on 16/10/2017.
 */

public class Event {
    private String name;
    private String description;
    private int pictureId;

    public Event() {
    }

    public Event(String name, String description, int pictureId) {
        this.name = name;
        this.description = description;
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPictureId() {
        return pictureId;
    }

    public Event setPictureId(int pictureId) {
        this.pictureId = pictureId;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("description", description);
        bundle.putInt("picture_id", pictureId);
        return  bundle;
    }

    public static Event front(Bundle bundle){
        Event event = new Event();
        return event.setName(bundle.getString("name"))
                .setDescription(bundle.getString("description"))
                .setPictureId(bundle.getInt("picture_id"));
    }
}
