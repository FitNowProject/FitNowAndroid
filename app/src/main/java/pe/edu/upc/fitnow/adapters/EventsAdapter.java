package pe.edu.upc.fitnow.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.activities.MoreEventActivity;
import pe.edu.upc.fitnow.model.Event;

/**
 * Created by Dreads on 29/09/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private List<Event> events;
    public EventsAdapter() {
    }
    public EventsAdapter(List<Event> events) {
        this.setEvents(events);
    }


    public List<Event> getEvents() {
        return events;
    }
    public EventsAdapter setEvents(List<Event> events) {
        this.events = events;
        return this;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LLamamos al card event del layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Event event = events.get(position);
        holder.addressTextView.setText(event.getAddress());
        holder.dateTextView.setText(event.getDate());
        holder.hour_startTextView.setText(event.getHour_start());
        holder.timeTextView.setText(event.getTime());
        holder.membersTextView.setText(Integer.toString(event.getMembers()));
    }

    @Override
    public int getItemCount() {
        return null != events ? events.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView addressTextView;
        public TextView dateTextView;
        public TextView hour_startTextView;
        public TextView timeTextView;
        public TextView membersTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            //LLamamos los Id del Layout para tenerlos como objeto
            addressTextView= (TextView) itemView.findViewById(R.id.addressTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            hour_startTextView = (TextView) itemView.findViewById(R.id.hour_startTextView);
            timeTextView = (TextView) itemView.findViewById(R.id.timeTextView);
            membersTextView = (TextView) itemView.findViewById(R.id.membersTextview);
        }
    }
}
