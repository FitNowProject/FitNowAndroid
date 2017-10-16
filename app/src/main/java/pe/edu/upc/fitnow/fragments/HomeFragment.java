package pe.edu.upc.fitnow.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.adapters.EventsAdapter;
import pe.edu.upc.fitnow.model.Event;
import pe.edu.upc.fitnow.model.EventsRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView eventsRecyclerView;
    EventsAdapter eventsAdapter;
    RecyclerView.LayoutManager eventsLayoutManager;
    List<Event> events;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        eventsRecyclerView = (RecyclerView) view.findViewById(R.id.eventsRecyclerView);
        events = new ArrayList<>();
        eventsAdapter = new EventsAdapter(EventsRepository.getEvents());
        eventsLayoutManager = new GridLayoutManager(view.getContext(),2);
        eventsRecyclerView.setAdapter(eventsAdapter);
        eventsRecyclerView.setLayoutManager(eventsLayoutManager);
        return view;
    }

}
