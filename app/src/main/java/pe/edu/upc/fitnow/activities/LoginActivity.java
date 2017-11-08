package pe.edu.upc.fitnow.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.upc.fitnow.PreferenceManager;
import pe.edu.upc.fitnow.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button signUpNowButton;
    Button loginSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUpNowButton = (Button) findViewById(R.id.signUpNowButton);
        loginSignInButton = (Button) findViewById(R.id.loginSignInButton) ;

        signUpNowButton.setOnClickListener(this);
        loginSignInButton.setOnClickListener(this);
    }

    public void loadSlides(View view){
        new PreferenceManager(this).clearPreferences();
        startActivity(new Intent(this, PlansActivity.class));
        finish();

    }

    @Override
    public void onClick(View view) {
        new PreferenceManager(this).clearPreferences();
        switch (view.getId()){
            case R.id.loginSignInButton:
                startActivity(new Intent(this, MainActivity.class));
                loadSlides(view);
                break;
            case R.id.signUpNowButton:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
        finish();
    }
}
