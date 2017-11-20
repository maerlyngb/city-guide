package io.maerlyn.cityguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the fragments that make up the attraction list tabs
 *
 * @author Maerlyn Broadbent
 */
public class AttrListPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> fragmentTitles = new ArrayList<>();

    public AttrListPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /**
     * Add a new fragment to be displayed
     *
     * @param fragment to add
     * @param title    of the frament
     */
    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        fragmentTitles.add(title);
    }

    /**
     * Get a specific fragment
     *
     * @param index of the fragment to return
     * @return fragment
     */
    @Override
    public Fragment getItem(int index) {
        return fragments.get(index);
    }

    /**
     * Get tab titles
     *
     * @param index of the title to return
     * @return fragment title
     */
    @Override
    public CharSequence getPageTitle(int index) {
        // Generate title based on item position
        return fragmentTitles.get(index);
    }

    /**
     * Get the count of all fragments
     *
     * @return fragment count
     */
    @Override
    public int getCount() {
        return fragments.size();
    }
}
