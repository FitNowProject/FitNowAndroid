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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button regCreateAccButton;
    EditText regEmailEditText, regPassEditText;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regCreateAccButton = (Button) findViewById(R.id.regCreateAccButton);
        regEmailEditText = (EditText) findViewById(R.id.regEmailEditText);
        regPassEditText = (EditText) findViewById(R.id.regPassEditText);
        regCreateAccButton.setOnClickListener(this);

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

    private void register(String email, String pass){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("SESION", "usuario creado correctamente");
                        }else{
                            Log.e("SESION", task.getException().getMessage()+"");
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        new PreferenceManager(this).clearPreferences();
        switch (view.getId()){
            case R.id.regCreateAccButton:
                String emailReg = regEmailEditText.getText().toString();
                String passReg = regPassEditText.getText().toString();
                register(emailReg, passReg);
                startActivity(new Intent(this, PlansActivity.class));
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
