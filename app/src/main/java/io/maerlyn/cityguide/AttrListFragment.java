package io.maerlyn.cityguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Fragment to display a list of attractions
 *
 * @author Maerlyn Broadbent
 */
public class AttrListFragment extends Fragment {
    public static final String TYPE = "TYPE";
    private AttrType type;

    /**
     * Return a new instance of AttrListFragment
     *
     * @param type of attraction to display
     * @return new Attr list instance
     */
    public static AttrListFragment newInstance(AttrType type) {
        Bundle args = new Bundle();
        args.putInt(TYPE, type.getValue());
        AttrListFragment fragment = new AttrListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Called when the fragment is initially created.
     * loads any saved state and retrieves Bundle arguments.
     *
     * @param savedInstanceState saved instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();

        if (arguments != null) {
            int typeVal = arguments.getInt(TYPE);
            // the type of attraction list to display
            type = AttrType.valueOf(typeVal);
        }
    }

    /**
     * Called when the views are ready to be inflated
     *
     * @param inflater           used to inflate the views
     * @param container          parent views
     * @param savedInstanceState any saved state
     * @return inflated view
     */
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // used to display a scrolling list of attractions
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.attraction_list, container, false);

        // improves performance when items don't change size
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        // attach the adapter responsible for creating the attraction list
        recyclerView.setAdapter(new AttrListItemRecyclerAdapter(getData()));

        return recyclerView;
    }

    /**
     * Load attraction data
     *
     * @return list of attractions
     */
    private ArrayList<Attraction> getData() {
        Context context = getContext();
        switch (type) {
            case VISIT:
                return Data.getVisitList(context);
            case EAT:
                return Data.getEatList(context);
            case DRINK:
                return Data.getDrinkList(context);
            case SLEEP:
                return Data.getSleepList(context);
        }
        return null;
    }
}
