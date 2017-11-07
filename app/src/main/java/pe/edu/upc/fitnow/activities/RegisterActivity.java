package pe.edu.upc.fitnow.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.upc.fitnow.PreferenceManager;
import pe.edu.upc.fitnow.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button regCreateAccButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regCreateAccButton = (Button) findViewById(R.id.regCreateAccButton);

        regCreateAccButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new PreferenceManager(this).clearPreferences();
        startActivity(new Intent(this, PlansActivity.class));
        finish();
    }
}
