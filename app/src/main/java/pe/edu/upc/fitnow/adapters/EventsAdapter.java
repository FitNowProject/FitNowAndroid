package pe.edu.upc.fitnow.adapters;

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
 * Created by Dreads on 29/09/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private List<Event> events;

    public EventsAdapter(List<Event> events) {
        this.setEvents(events);
    }

    public EventsAdapter() {
    }


    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.card_event, parent, false));
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, int position) {
        Event event = events.get(position);
        holder.nameTextView.setText(event.getName());
        holder.moreTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public List<Event> getEvents() {
        return events;
    }

    public EventsAdapter setEvents(List<Event> events) {
        this.events = events;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logoImageView;
        TextView nameTextView;
        TextView descriptionTextView;
        TextView moreTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            logoImageView = (ImageView) itemView.findViewById(R.id.logoImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionTextView);
            moreTextView = (TextView) itemView.findViewById(R.id.moreTextView);
        }
    }
}
