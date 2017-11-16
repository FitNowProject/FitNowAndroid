package pe.edu.upc.fitnow.fragments;


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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.activities.CreateEventActivity;
import pe.edu.upc.fitnow.adapters.EventsAdapter;
import pe.edu.upc.fitnow.model.Event;
import pe.edu.upc.fitnow.references.FirebaseReferences;

/**
 * A simple {@link Fragment} subclass.
 */
public class FitNowFragment extends Fragment {

    private RecyclerView eventRV;
    private List<Event> eventss;
    private EventsAdapter eventAdapter;
    private RecyclerView.LayoutManager eventsLayoutManager;

    TextView titleTextView;
    Spinner spinnerSpinner;
    FloatingActionButton createeventFloatingActionButton;
    ArrayList<String> ejercicios_filtro = new ArrayList<>();


    //*****FIREBASE*****//
    private FirebaseDatabase dataBase;
    private FirebaseDatabase typeEventDataBase;
    public FitNowFragment() {
        // Required empty public constructor
    }

    public ArrayList<String> ej(){
        ejercicios_filtro.add("Cycling");
        ejercicios_filtro.add("Running");
        ejercicios_filtro.add("Walking");
        ejercicios_filtro.add("Swimming");
        return ejercicios_filtro;
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
        View view = inflater.inflate(R.layout.fragment_fitnow,container,false);

        titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        spinnerSpinner = (Spinner) view.findViewById(R.id.spinner);
        createeventFloatingActionButton = (FloatingActionButton) view.findViewById(R.id.createeventFloatingActionButton);

        //*****FIREBASE*****//
        eventss  = new ArrayList<>();
        eventRV = (RecyclerView) view.findViewById(R.id.eventRecyclerView);
        eventRV.setHasFixedSize(true);
        eventsLayoutManager = new GridLayoutManager(view.getContext(),1);
        eventRV.setLayoutManager(eventsLayoutManager);
        eventAdapter = new EventsAdapter(eventss);
        eventRV.setAdapter(eventAdapter);


        dataBase = FirebaseDatabase.getInstance();
        dataBase.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventss.removeAll(eventss);
                for(DataSnapshot snapshot:dataSnapshot.child(FirebaseReferences.EVENT_REFERENCE).getChildren()){
                    //paso todos los valores que se parecen de firebase a el model
                    Event event = snapshot.getValue(Event.class);

                    //typo de evento que tiene
                    String T_E = event.getTypeevent();
                    String P = event.getPlace();

                    DataSnapshot typeeventDS  = dataSnapshot.child(FirebaseReferences.TYPEEVENT_REFERENCE).child(T_E);
                    DataSnapshot placeDS = dataSnapshot.child(FirebaseReferences.PLACA_REFERENCE).child(P);

                    event.setType(typeeventDS.child("type").getValue(String.class));
                    event.setAddress(placeDS.child("address").getValue(String.class));
                    event.setImage(typeeventDS.child("image").getValue(String.class));

                    eventss.add(event);
                }
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //SPINNER
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity()
                .getApplicationContext(),android.R.layout.simple_dropdown_item_1line,ej());

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSpinner.setAdapter(arrayAdapter);


        //FloatingActionButton
        changeViewFloating();
        return view;
    }


}
