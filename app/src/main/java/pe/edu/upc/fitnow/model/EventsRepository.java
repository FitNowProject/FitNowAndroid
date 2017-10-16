package pe.edu.upc.fitnow.model;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.fitnow.R;

/**
 * Created by Dreads on 16/10/2017.
 */

public class EventsRepository {
    public static List<Event> getEvents(){
        List<Event> events = new ArrayList<>();
        events.add(new Event("Event 1", "Description 1", R.mipmap.ic_launcher));
        events.add(new Event("Event 2", "Description 2", R.mipmap.ic_launcher));
        events.add(new Event("Event 3", "Description 3", R.mipmap.ic_launcher));
        events.add(new Event("Event 4", "Description 4", R.mipmap.ic_launcher));
        events.add(new Event("Event 5", "Description 5", R.mipmap.ic_launcher));
        events.add(new Event("Event 6", "Description 6", R.mipmap.ic_launcher));
        events.add(new Event("Event 7", "Description 7", R.mipmap.ic_launcher));
        events.add(new Event("Event 8", "Description 8", R.mipmap.ic_launcher));
        return events;
    }
}
