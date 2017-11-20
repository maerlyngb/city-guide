package io.maerlyn.cityguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Responsible for managing the list of attraction summaries
 *
 * @author Maerlyn Broadbent
 */
public class AttrListItemRecyclerAdapter
        extends RecyclerView.Adapter<AttrListItemRecyclerAdapter.ViewHolder> {
    private ArrayList<Attraction> attractions;

    /**
     * Load the list of attractions to display in a list
     *
     * @param attractions of attractions
     */
    public AttrListItemRecyclerAdapter(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    /**
     * Inflate a view for each attraction summary
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attraction_summary, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Bind data for each attraction summary
     *
     * @param holder
     * @param index  of the attraction in the dataset
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int index) {
        final Attraction attr = attractions.get(index);

        holder.attrName.setText(attr.getName());
        holder.attrRating.setRating(attr.getRating());

        // load images with glide to prevent performance issues
        Glide.with(holder.attrImage.getContext())
                .load(attr.getImageResourceId())
                .fitCenter()
                .into(holder.attrImage);

        // load activity detail when user taps the card
        holder.cardView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, AttrDetailActivity.class);
            intent.putExtra("attraction", attr);
            context.startActivity(intent);
        });
    }

    /**
     * Return the number of attractions
     *
     * @return number of attractions
     */
    @Override
    public int getItemCount() {
        return attractions.size();
    }

    /**
     * Hold views and data about for an attraction summary
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final CardView cardView;
        public final TextView attrName;
        public final ImageView attrImage;
        public final RatingBar attrRating;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            cardView = view.findViewById(R.id.card_view);
            attrName = view.findViewById(R.id.attraction_name);
            attrImage = view.findViewById(R.id.attraction_image);
            attrRating = view.findViewById(R.id.attraction_rating);
        }
    }
}

