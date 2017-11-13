package pe.edu.upc.fitnow.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.fitnow.R;
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

    //*****FIREBASE*****//
    private FirebaseDatabase dataBase;
    private DatabaseReference myref;
    public FitNowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fitnow,container,false);

        //*****FIREBASE*****//


        eventss  = new ArrayList<>();
        eventRV = (RecyclerView) view.findViewById(R.id.eventRecyclerView);
        eventRV.setHasFixedSize(true);


        eventsLayoutManager = new GridLayoutManager(view.getContext(),1);
        eventRV.setLayoutManager(eventsLayoutManager);


        eventAdapter = new EventsAdapter(eventss);
        eventRV.setAdapter(eventAdapter);

        dataBase = FirebaseDatabase.getInstance();
        dataBase.getReference(FirebaseReferences.EVENT_REFERENCE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventss.removeAll(eventss);
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Event event = snapshot.getValue(Event.class);
                    eventss.add(event);
                }
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }

}
