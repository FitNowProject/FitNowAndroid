package pe.edu.upc.fitnow.activities;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.adapters.EventsAdapter;
import pe.edu.upc.fitnow.fragments.ChatFragment;
import pe.edu.upc.fitnow.fragments.FoodFragment;
import pe.edu.upc.fitnow.fragments.HomeFragment;
import pe.edu.upc.fitnow.fragments.PersonalFragment;
import pe.edu.upc.fitnow.fragments.PlaceFragment;
import pe.edu.upc.fitnow.model.EventsRepository;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

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
        navigateAccordingTo(R.id.navigation_home);

    }




    private Fragment getFragmentFor(int id){
        switch(id){
                case R.id.navigation_home:
                    return new HomeFragment();
                case R.id.navigation_food:
                    return new FoodFragment();
                case R.id.navigation_place:
                    return new PlaceFragment();
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
