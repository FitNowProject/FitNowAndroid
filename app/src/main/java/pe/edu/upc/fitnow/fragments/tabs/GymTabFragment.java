package pe.edu.upc.fitnow.fragments.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.fitnow.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GymTabFragment extends Fragment {


    public GymTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gym_tab, container, false);
    }

}