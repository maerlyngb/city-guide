package io.maerlyn.cityguide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by maerlyn on 19/11/17.
 */

public class AttractionListFragment extends Fragment {

    public AttractionListFragment(){
        // mandatory empty constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        return rootView;
    }
}
