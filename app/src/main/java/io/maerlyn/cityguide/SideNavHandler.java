package io.maerlyn.cityguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

/**
 * This class is used to handle actions associated with the side navigation drawer
 *
 * @author Maerlyn Broadbent
 */
public class SideNavHandler implements NavigationView.OnNavigationItemSelectedListener {

    Activity activity;
    DrawerLayout drawer;

    public SideNavHandler(Activity activity) {
        this.activity = activity;
        drawer = activity.findViewById(R.id.drawer_layout);
    }

    /**
     * navigate to external urls when menu items are tapped
     * @param item that was tapped
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        String url = "";

        switch (item.getItemId()){
            case R.id.train:
                url = activity.getString(R.string.train_timetable_url);
                break;

            case R.id.bus:
                url = activity.getString(R.string.bus_timetable_url);
                break;

            case R.id.ferry:
                url = activity.getString(R.string.ferry_timetable_url);
                break;

            case R.id.bike:
                url = activity.getString(R.string.cycling_url);
                break;
        }

        // implicit intent to open external link
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (browserIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(browserIntent);
        }

        closeDrawer();

        // returning false so the menu item isn't highlighted
        return false;
    }

    /**
     * Close the drawer if it's currently open
     */
    public void closeDrawer() {
        if (isDrawerOpen()) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    /**
     * @return true of the drawer is currently open
     */
    public boolean isDrawerOpen() {
        return drawer.isDrawerOpen(GravityCompat.START);
    }
}
