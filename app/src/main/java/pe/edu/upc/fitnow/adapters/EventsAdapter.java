package pe.edu.upc.fitnow.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.models.Event;

/**
 * Created by mac on 10/23/17.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private List<Event> events;
    Context context;

    public Context getContext() {
        return context;
    }

    public EventsAdapter setContext(Context context) {
        this.context = context;
        return this;
    }

    public List<Event> getWorkout() {
        return events;
    }

    public EventsAdapter setWorkout(List<Event> events) {
        this.events = events;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView type_eventTextView;
        public ImageView pictureImageView;
        public TextView placeTextView;
        public TextView dateTextView;
        public TextView hour_startTextView;
        public TextView hour_finishTextView;
        public TextView distanceTextView;
        public TextView membersTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            type_eventTextView = (TextView) itemView.findViewById(R.id.type_eventTextView);
            pictureImageView=(ImageView) itemView.findViewById(R.id.pictureImageView);
            placeTextView = (TextView) itemView.findViewById(R.id.placeTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            hour_startTextView = (TextView) itemView.findViewById(R.id.hour_startTextView);
            hour_finishTextView = (TextView) itemView.findViewById(R.id.hour_finishTextView);
            distanceTextView = (TextView) itemView.findViewById(R.id.distanceTextView);
            membersTextView = (TextView) itemView.findViewById(R.id.membersTextview);
        }
    }

    public EventsAdapter(List<Event> event) {
        this.setWorkout(event);
    }

    public EventsAdapter() {

    }

    public EventsAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.cardview_event,parent,false));
    }


    //va permitir que los datos aparescan en la pantalla solo mostrarlos
    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, final int position) {
        final Event event = events.get(position);
        holder.type_eventTextView.setText(event.getType());
        holder.placeTextView.setText(event.getPlace());
        holder.dateTextView.setText(event.getDate());
        holder.hour_startTextView.setText(event.getHour_start());
        holder.hour_finishTextView.setText(event.getHour_finish());
        holder.distanceTextView.setText(Integer.toString(event.getDistance()));
        holder.membersTextView.setText(Integer.toString(event.getMembers()));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
