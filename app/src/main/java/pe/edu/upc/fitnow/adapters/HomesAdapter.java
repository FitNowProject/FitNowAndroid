package pe.edu.upc.fitnow.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.fitnow.R;
import pe.edu.upc.fitnow.activities.MoreEventActivity;
import pe.edu.upc.fitnow.models.Home;

/**
 * Created by Dreads on 29/09/2017.
 */

public class HomesAdapter extends RecyclerView.Adapter<HomesAdapter.ViewHolder> {

    private List<Home> homes;

    public HomesAdapter(List<Home> homes) {
        this.setHomes(homes);
    }

    public HomesAdapter() {
    }

    @Override
    public HomesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.card_event, parent));
    }

    @Override
    public void onBindViewHolder(HomesAdapter.ViewHolder holder, int position) {
        Home home = homes.get(position);
        holder.nameTextView.setText(home.getName());
        holder.logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }


        });
        holder.moreTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MoreEventActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homes.size();
    }

    public List<Home> getHomes() {
        return homes;
    }

    public HomesAdapter setHomes(List<Home> homes) {
        this.homes = homes;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView   logoImageView;
        TextView    nameTextView;
        TextView    descriptionTextView;
        TextView    moreTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            logoImageView = (ImageView) itemView.findViewById(R.id.logoImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionTextView);
            moreTextView = (TextView) itemView.findViewById(R.id.moreTextView);
        }
    }
}
