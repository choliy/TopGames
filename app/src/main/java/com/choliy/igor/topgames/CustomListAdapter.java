package com.choliy.igor.topgames;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {

    private Context context;
    private List<ArrayList<Game>> allGames;

    public CustomListAdapter(Context context, List<ArrayList<Game>> allGames) {
        this.context = context;
        this.allGames = allGames;
    }

    @Override
    public CustomListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return allGames.get(TopActivity.genre).size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CardView cardView;
        private ImageView gameImage;
        private TextView name;
        private TextView developer;
        private TextView releaseDate;
        private TextView rating;
        private LinearLayout listAnimation;
        private LinearLayout layoutColor;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            cardView.setOnClickListener(this);
            gameImage = (ImageView) view.findViewById(R.id.custom_list_logo_image);
            name = (TextView) view.findViewById(R.id.custom_list_game_name);
            developer = (TextView) view.findViewById(R.id.custom_list_developer);
            releaseDate = (TextView) view.findViewById(R.id.custom_list_release_date);
            rating = (TextView) view.findViewById(R.id.custom_list_rating);
            listAnimation = (LinearLayout) view.findViewById(R.id.list_genre);
            layoutColor = (LinearLayout) view.findViewById(R.id.layout_color);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, GameActivity.class);
            intent.putExtra(GameActivity.EXTRA_GAME, getAdapterPosition());
            context.startActivity(intent);
        }

        private void bindView(int position) {
            Typeface orbitronBold = Typeface.createFromAsset(context.getAssets(),
                    "font/orbitron-bold.otf");
            Typeface orbitronLight = Typeface.createFromAsset(context.getAssets(),
                    "font/orbitron-light.otf");
            name.setTypeface(orbitronBold);
            developer.setTypeface(orbitronLight);
            releaseDate.setTypeface(orbitronLight);
            rating.setTypeface(orbitronLight);

            Drawable drawable = context
                    .getResources()
                    .getDrawable(allGames.get(TopActivity.genre).get(position).getImageSquare());
            gameImage.setImageDrawable(drawable);
            name.setText(allGames.get(TopActivity.genre).get(position).getName());
            developer.setText(allGames.get(TopActivity.genre).get(position).getDeveloper());
            releaseDate.setText(allGames.get(TopActivity.genre).get(position).getReleaseDate());
            rating.setText(allGames.get(TopActivity.genre).get(position).getRating());

            switch (TopActivity.genre) {
                case 0:
                    resetViewByGenre(R.color.action_color, R.drawable.layout_action);
                    break;
                case 1:
                    resetViewByGenre(R.color.adventure_color, R.drawable.layout_adventure);
                    break;
                case 2:
                    resetViewByGenre(R.color.mmo_color, R.drawable.layout_mmo);
                    break;
                case 3:
                    resetViewByGenre(R.color.rpg_color, R.drawable.layout_rpg);
                    break;
                case 4:
                    resetViewByGenre(R.color.simulation_color, R.drawable.layout_simulation);
                    break;
                case 5:
                    resetViewByGenre(R.color.sport_color, R.drawable.layout_sport);
                    break;
                case 6:
                    resetViewByGenre(R.color.strategy_color, R.drawable.layout_strategy);
                    break;
            }
        }

        private void resetViewByGenre(int colorId, int drawableId) {
            listAnimation.setBackgroundColor(cardView.getResources().getColor(colorId));
            rating.setTextColor(cardView.getResources().getColor(colorId));
            layoutColor.setBackgroundResource(drawableId);
        }
    }
}