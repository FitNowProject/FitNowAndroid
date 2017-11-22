package pe.edu.upc.fitnow.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.fragments.ChatFragment;
import pe.edu.upc.fitnow.fragments.FoodFragment;
import pe.edu.upc.fitnow.fragments.FitNowFragment;
import pe.edu.upc.fitnow.fragments.PersonalFragment;
<<<<<<< HEAD
import pe.edu.upc.fitnow.fragments.PlanFragment;
=======
import pe.edu.upc.fitnow.fragments.PlaceFragment;
>>>>>>> jose's_branch

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateAccordingTo(item.getItemId());}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateAccordingTo(R.id.navigation_fitnow);

    }




    private Fragment getFragmentFor(int id){
        switch(id){
                case R.id.navigation_fitnow:
                    return new FitNowFragment();
                case R.id.navigation_food:
                    return new FoodFragment();
                case R.id.navigation_place:
                    return new PlanFragment();
                case R.id.navigation_personal:
                    return new PersonalFragment();
                case R.id.navigation_chat:
                    return new ChatFragment();
        }
        return null;
    }

    private boolean navigateAccordingTo(int id){
        try{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, getFragmentFor(id))
                    .commit();
            return true;
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }
}
