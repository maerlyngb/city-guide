package io.maerlyn.cityguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Displays details about a specific Attraction
 *
 * @author Maerlyn Broadbent
 */
public class AttrDetailActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    Attraction attr;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attr_detail);

        // load the album data that was passed as an intent extra.
        Intent intent = getIntent();
        this.attr = (Attraction) intent.getSerializableExtra("attraction");

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(this.attr.getName());

        // Load the title image
        final ImageView imageView = findViewById(R.id.backdrop);
        imageView.setImageResource(this.attr.getImageResourceId());

        // load attraction description
        TextView description = findViewById(R.id.attraction_description);
        description.setText(this.attr.getDescription());

        TextView directions = findViewById(R.id.attr_directions);
        directions.setOnClickListener((view) -> showDirections());

        TextView phone = findViewById(R.id.attr_phone);
        phone.setOnClickListener((view) -> callAttraction());

        TextView website = findViewById(R.id.attr_webiste);
        website.setOnClickListener((view) -> showWebsite(this.attr.getUrl()));

        // load google map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * put a marker on the attraction location
     *
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng latLng = new LatLng(attr.getLat(), attr.getLng());
        this.googleMap.addMarker(new MarkerOptions().position(latLng));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        this.googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
    }

    /**
     * Start an implicit intent to open google maps with directions
     */
    private void showDirections() {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=" +
                        attr.getLat() + "," + attr.getLng()));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Start an implicit intent to call a phone number
     */
    private void callAttraction() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + attr.getPhoneNum()));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * Start an implicit intent to navigate to the attraction website
     */
    private void showWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
