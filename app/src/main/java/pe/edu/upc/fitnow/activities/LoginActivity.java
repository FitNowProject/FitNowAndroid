package pe.edu.upc.fitnow.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import pe.edu.upc.fitnow.PreferenceManager;
import pe.edu.upc.fitnow.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button signUpNowButton, loginSignInButton;
    EditText loginEmailEditText, loginPasswordEditText;

    FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUpNowButton = (Button) findViewById(R.id.signUpNowButton);
        loginSignInButton = (Button) findViewById(R.id.loginSignInButton) ;
        loginEmailEditText = (EditText) findViewById(R.id.loginEmailEditText);
        loginPasswordEditText = (EditText) findViewById(R.id.loginPasswordEditText);
        signUpNowButton.setOnClickListener(this);
        loginSignInButton.setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.i("SESION", "sesion iniciada con email: " + user.getEmail());
                    //Iniciar Activity
                }else{
                    Log.i("SESION", "sesion cerrada");
                }
            }
        };
    }


    private void signin(String email, String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("SESION", "sesion iniciada");
                        }else{
                            Log.e("SESION", task.getException().getMessage()+"");
                        }
                    }
                });
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
                String emailInicio = loginEmailEditText.getText().toString();
                String passInicio = loginPasswordEditText.getText().toString();
                signin(emailInicio, passInicio);
                startActivity(new Intent(this, MainActivity.class));
                loadSlides(view);
                break;
            case R.id.signUpNowButton:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}
