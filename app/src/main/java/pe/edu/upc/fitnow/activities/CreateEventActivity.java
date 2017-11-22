package pe.edu.upc.fitnow.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.adapters.EventsAdapter;
import pe.edu.upc.fitnow.adapters.ExercicesAdapter;
import pe.edu.upc.fitnow.model.Event;
import pe.edu.upc.fitnow.model.Exercice;
import pe.edu.upc.fitnow.model.Place;
import pe.edu.upc.fitnow.model.TypeEvent;
import pe.edu.upc.fitnow.references.FirebaseReferences;

public class CreateEventActivity extends AppCompatActivity {
    Spinner activitySpinner, placeSpinner;
    EditText starttimeEditText,timeEditText, descriptionEditText,dateEditText;
    Spinner quantitySpinner;
    TextView activitiesPlanNextTextView;
    Button saveButton;
    private FirebaseDatabase dataBase;
    private DatabaseReference DB;
    public ArrayList<TypeEvent> ArrayTypeEvent;
    public ArrayList<Place> ArrayPlace;
    public int nEvent = 1;
    //CARD VIEW EXERCICES
    private RecyclerView exerciceRecyclerView;
    private  ExercicesAdapter exercicesAdapter;
    private RecyclerView.LayoutManager exerciceManager;
    private List<Exercice> exercicess;
    DatabaseReference exerciceDataBase;

    //DATE PICKER
    static final int DIALOG_ID_DATE = 0;
    static final int DIALOG_ID_TIME = 1;
    Calendar c = Calendar.getInstance();
    int year_x=c.get(Calendar.YEAR);
    int month_x =c.get(Calendar.MONTH);
    int day_x=c.get(Calendar.DAY_OF_MONTH);

    //TIME PICKER
    int hour =c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        activitySpinner = (Spinner) findViewById(R.id.activitySpinner);//tipo de actividad
        placeSpinner = (Spinner) findViewById(R.id.placeSpinner);//lugar del evento
        quantitySpinner = (Spinner) findViewById(R.id.quantitySpinner);// cantidad de integrantes

        dateEditText = (EditText) findViewById(R.id.dateEditText);

        starttimeEditText = (EditText) findViewById(R.id.starttimeEditText);
        timeEditText = (EditText) findViewById(R.id.timeEditText);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
        //Button
        saveButton = (Button) findViewById(R.id.saveButton);

        DB = FirebaseDatabase.getInstance().getReference();

        spinnerTypeevent();
        spinnerPlace();
        spinnerMembers();

        //TIME Y DATE PICKER
        dateEditText.setInputType(InputType.TYPE_NULL);
        starttimeEditText.setInputType(InputType.TYPE_NULL);

        showOnEditTextClick();
        ArrayTypeEvent = new ArrayList<>();
        ArrayPlace = new ArrayList<>();
        autoincrementEvent();
        ButtonSave();

        //EXERCICES
        exercicess = new ArrayList<>();
        exerciceRecyclerView = (RecyclerView) findViewById(R.id.exerciceRecyclerView);
        exerciceRecyclerView.setHasFixedSize(true);
        exerciceManager = new GridLayoutManager(getApplicationContext(),1);
        exerciceRecyclerView.setLayoutManager(exerciceManager);
        exercicesAdapter = new ExercicesAdapter(exercicess);
        exerciceRecyclerView.setAdapter(exercicesAdapter);

        exerciceDataBase = FirebaseDatabase.getInstance().getReference();
        exerciceDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot exerciceSnapshot:dataSnapshot.child(FirebaseReferences.EXERCICE_REFERENCE).getChildren()) {
                    Exercice exercice = exerciceSnapshot.getValue(Exercice.class);
                    exercicess.add(exercice);
                }
                exercicesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void ButtonSave() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SaveEvent();
                    Intent intent = new Intent(CreateEventActivity.this, MainActivity.class);
                    startActivity(intent);
            }
        });
    }

    //DATE PICKER y TIME PICKER
    public void showOnEditTextClick(){
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID_DATE);
            }
        });
        starttimeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID_TIME);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID_DATE){
            return new DatePickerDialog(this,dpickerListener,year_x,month_x,day_x);
        }
        else if(id == DIALOG_ID_TIME){
            return new TimePickerDialog(this,dtimepickerListener,hour,minute,true);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            year_x=i;
            month_x=i1;
            day_x=i2;
            dateEditText.setText(day_x+"/"+(month_x+1)+"/"+year_x);
        }
    };

    private TimePickerDialog.OnTimeSetListener dtimepickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            hour = i;
            minute = i1;
            starttimeEditText.setText(hour + ":" + minute);
        }
    };



    public void spinnerTypeevent(){
        final ArrayList<String> activitiesarray = new ArrayList<>();
        DatabaseReference DBtypeevent = FirebaseDatabase.getInstance().getReference();
        DBtypeevent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot DSS : dataSnapshot.child("typeevents").getChildren())
                {
                    String activity = DSS.getValue(TypeEvent.class).getType();
                    activitiesarray.add(activity);
                    TypeEvent T_E = new TypeEvent();
                    T_E.setType(activity);
                    T_E.setKey(DSS.getKey());
                    ArrayTypeEvent.add(T_E);
                    ArrayAdapter<String> activitiesAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, activitiesarray);
                    activitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    activitySpinner.setAdapter(activitiesAdapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void spinnerPlace(){
        final ArrayList<String> placearray = new ArrayList<>();
        DatabaseReference DBplace = FirebaseDatabase.getInstance().getReference();
        DBplace.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot DSS : dataSnapshot.child("places").getChildren())
                {
                    String place = DSS.getValue(Place.class).getAddress();
                    placearray.add(place);
                    Place P = new Place();
                    P.setAddress(place);
                    P.setKey(DSS.getKey());
                    ArrayPlace.add(P);
                    ArrayAdapter<String> placeAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, placearray);
                    placeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    placeSpinner.setAdapter(placeAdapter);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void spinnerMembers(){
        String[] numero = {"10","15","20","25"};
        ArrayAdapter<String> activitiesAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, numero);
        activitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(activitiesAdapter);
    }

    public void autoincrementEvent(){
        FirebaseDatabase DBevent;
        DBevent = FirebaseDatabase.getInstance();
        DBevent.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot DSs:dataSnapshot.child("events").getChildren()) {
                    nEvent = nEvent + 1;
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void SaveEvent(){

        Event E = new Event();
        DatabaseReference DBevent = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = DBevent.child("events");

        String typeeE = "";
        String placeE = "";
        String activity = activitySpinner.getSelectedItem().toString();
        for(int i=0;i<ArrayTypeEvent.size();i++){
            if(activity == ArrayTypeEvent.get(i).getType().toString()){
                typeeE = ArrayTypeEvent.get(i).getKey();
            }
        }
        String place = placeSpinner.getSelectedItem().toString();
        for(int i=0 ;i<ArrayPlace.size();i++){
            if(place == ArrayPlace.get(i).getAddress()){
                placeE = ArrayPlace.get(i).getKey();
            }
        }
        String date = dateEditText.getText().toString();
        String start = starttimeEditText.getText().toString();
        int quantity = Integer.parseInt(quantitySpinner.getSelectedItem().toString());
        String time = timeEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
//String date, String hour_start, int members, String time, String description, String typeevent, String place)
        E.setDate(date);
        E.setHour_start(start);
        E.setMembers(quantity);
        E.setTime(time);
        E.setDescription(description);
        E.setTypeevent(typeeE);
        E.setPlace(placeE);
        ref.child("event" + String.valueOf(nEvent)).setValue(new Event(date,start,quantity,time,description,typeeE,placeE));
    }
}
