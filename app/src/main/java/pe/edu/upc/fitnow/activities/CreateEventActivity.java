package pe.edu.upc.fitnow.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import pe.edu.upc.fitnow.R;

public class CreateEventActivity extends AppCompatActivity {

    Spinner activitySpinner;
    EditText placeEditText,starttimeEditText,finishtimeEditText, descriptionEditText,dateEditText;
    Spinner quantitySpinner;

    //DATE PICKER
    static final int DIALOG_ID = 0;
    Calendar c = Calendar.getInstance();
    int year_x=c.get(Calendar.YEAR);
    int month_x =c.get(Calendar.MONTH);
    int day_x=c.get(Calendar.DAY_OF_MONTH);

    //TIME PICKER
    int hour =c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    int second = c.get(Calendar.SECOND);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        activitySpinner = (Spinner) findViewById(R.id.activitySpinner);
        placeEditText = (EditText) findViewById(R.id.placeEditText);
        dateEditText = (EditText) findViewById(R.id.dateEditText);
        quantitySpinner = (Spinner) findViewById(R.id.quantitySpinner);
        starttimeEditText = (EditText) findViewById(R.id.starttimeEditText);
        finishtimeEditText = (EditText) findViewById(R.id.finishtimeEditText);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);

        dateEditText.setInputType(InputType.TYPE_NULL);
        starttimeEditText.setInputType(InputType.TYPE_NULL);
        finishtimeEditText.setInputType(InputType.TYPE_NULL);

        //from eventTabFragment to CreateActivity
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("some")!=null){
                Toast.makeText(getApplicationContext(),"data:" + bundle.getString("some"),Toast.LENGTH_SHORT).show();
            }
        }
        showOnEditTextClick();
    }

    //DATE PICKER
    public void showOnEditTextClick(){
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new DatePickerDialog(this,dpickerListener,year_x,month_x,day_x);
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
}
