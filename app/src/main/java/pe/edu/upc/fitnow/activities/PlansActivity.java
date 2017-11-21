package pe.edu.upc.fitnow.activities;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import pe.edu.upc.fitnow.PreferenceManager;
import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.adapters.PlansAdapter;

public class PlansActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager plansPager;
    private int[] layouts = {R.layout.first_slide , R.layout.second_slide, R.layout.third_slide,
            R.layout.fourth_slide};

    private PlansAdapter plansAdapter;

    private LinearLayout dots_layout;
    private ImageView[] dots;

    private Button nextButton, skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (new PreferenceManager(this).checkPreference()){
            loadHome();
        }

        if (Build.VERSION.SDK_INT>19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        setContentView(R.layout.activity_plans);

        plansPager = (ViewPager) findViewById(R.id.viewPager);
        plansAdapter = new PlansAdapter(layouts, this);
        plansPager.setAdapter(plansAdapter);

        dots_layout = (LinearLayout) findViewById(R.id.dotsLayout);
        nextButton = (Button) findViewById(R.id.nextButton);
        //skipButton = (Button) findViewById(R.id.skipButton);
        nextButton.setOnClickListener(this);
        //skipButton.setOnClickListener(this);

        createDots(0);

        plansPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                createDots(position);
                if (position == layouts.length-1){
                    nextButton.setText("Start");
                    //skipButton.setVisibility(View.INVISIBLE);
                }else{
                    nextButton.setText("Next");
                    //skipButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int current_position){
        if (dots_layout != null)

            dots_layout.removeAllViews();
        dots = new ImageView[layouts.length];

        for (int i = 0; i<layouts.length; i++){
            dots[i] = new ImageView(this);
            if (i == current_position){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            }else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);

            dots_layout.addView(dots[i], params);

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nextButton:
                loadNextSlide();
                break;
            /*case R.id.skipButton:
                loadHome();
                new PreferenceManager(this).writePreference();
                break;*/
        }
    }

    private void loadHome(){
        startActivity(new Intent(this, ProgramPlanActivity.class));
        finish();
    }

    private void loadNextSlide(){
        int next_slide = plansPager.getCurrentItem()+1;
        if(next_slide<layouts.length){
            plansPager.setCurrentItem(next_slide);
        }else {
            loadHome();
            new PreferenceManager(this).writePreference();
        }
    }
}
