package pe.edu.upc.fitnow.fragments.tabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.activities.CreateEventActivity;
import pe.edu.upc.fitnow.adapters.EventsAdapter;
import pe.edu.upc.fitnow.models.Event;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventTabFragment extends Fragment {

    RecyclerView eventRecyclerView;//los datos que no se vean sera eliminados para no ocupar espacio en el movil
    TextView titleTextView;
    Spinner spinnerSpinner;
    EventsAdapter eventsAdapter;//LIST
    RecyclerView.LayoutManager eventsLayoutManager;
    List<Event> Listevents;
    FloatingActionButton createeventFloatingActionButton;

    String[] ejercicios_filtro = {"Cycling","Running","Walking","Swimming"};

    public EventTabFragment() {
        // Required empty public constructor
    }

    public void changeViewFloating(){

        createeventFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateEventActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_event_tab,container,false);

        Listevents = new ArrayList<>();
        Listevents.add(new Event(1,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(2,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(3,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(4,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(5,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(6,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(7,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(8,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(9,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));
        Listevents.add(new Event(10,"cycling", R.drawable.run, "Lima", "01 de enero", "8:00 am", "12:00 pm", 8 , 12));


        //como obtener el recycler?

        titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        spinnerSpinner = (Spinner) view.findViewById(R.id.spinner);
        eventRecyclerView = (RecyclerView) view.findViewById(R.id.eventFragmenLayout);
        createeventFloatingActionButton = (FloatingActionButton) view.findViewById(R.id.createeventFloatingActionButton);
        eventsAdapter = new EventsAdapter(Listevents);

        eventsLayoutManager = new GridLayoutManager(view.getContext(),1);

        //Recycler view
        eventRecyclerView.setAdapter(eventsAdapter);
        eventRecyclerView.setLayoutManager(eventsLayoutManager);


        //crear adapter para el spinner
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity()
                .getApplicationContext(),android.R.layout.simple_dropdown_item_1line,ejercicios_filtro);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSpinner.setAdapter(arrayAdapter);


        //FloatingActionButton
        changeViewFloating();

        // Inflate the layout for this fragment
        return view;
    }
}

