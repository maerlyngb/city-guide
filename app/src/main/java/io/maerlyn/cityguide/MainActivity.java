package io.maerlyn.cityguide;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Main Activity to display sliding tabs of activity lists
 *
 * @author Maerlyn Broadbent
 */
public class MainActivity extends AppCompatActivity {

    SideNavHandler navHandler;

    /**
     * Setup the 'home' screen
     *
     * @param savedInstanceState any state that was previously saved
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navHandler = new SideNavHandler(this);

        Toolbar toolbar = findViewById(R.id.toolbar);

        // set this toolbar as the main app toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.city_name_and_country);

        // setup the side navigation drawer
        SetupNavigationView(toolbar);

        // setup swiping content
        SetupTabbedContent();
    }

    /**
     * Setup the side navigation drawer
     *
     * @param toolbar to place the toggle button
     */
    private void SetupNavigationView(Toolbar toolbar) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        // toggle button in action bar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // listen for nav items being clicked
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this.navHandler);
    }

    /**
     * Setup tabbed attraction tabs and content
     */
    private void SetupTabbedContent() {
        ViewPager viewPager = findViewById(R.id.viewpager);

        if (viewPager != null) {
            AttrListPageAdapter adapter = new AttrListPageAdapter(getSupportFragmentManager());

            // each fragment is one of the attraction lists
            adapter.addFragment(AttrListFragment.newInstance(AttrType.VISIT), getString(R.string.visit_tab_title));
            adapter.addFragment(AttrListFragment.newInstance(AttrType.EAT), getString(R.string.eat_tab_title));
            adapter.addFragment(AttrListFragment.newInstance(AttrType.DRINK), getString(R.string.drink_tab_title));
            adapter.addFragment(AttrListFragment.newInstance(AttrType.SLEEP), getString(R.string.sleep_tab_title));

            viewPager.setAdapter(adapter);

            // display tabbed content
            TabLayout tabLayout = findViewById(R.id.tab_layout);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    /**
     * Close the side nav pane when the back button is pressed.
     * If the nav pane is already closed, perform the standard os action.
     */
    @Override
    public void onBackPressed() {
        if (this.navHandler.isDrawerOpen()) {
            this.navHandler.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
