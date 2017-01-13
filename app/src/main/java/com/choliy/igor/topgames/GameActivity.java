package com.choliy.igor.topgames;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    public static final String EXTRA_GAME = "GAME";
    private int genre = TopActivity.genre;
    private int gamePosition;

    private TextView gameName, name;
    private TextView gameDeveloper, developer;
    private TextView gameReleaseDate, releaseDate;
    private TextView gameRating, rating;
    private TextView gameWebsite, website;
    private TextView gameYoutube, youtube;
    private TextView gameDescription;
    private ImageView gamePicture;

    private AllGames allGames = new AllGames();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gamePosition = (int) getIntent().getExtras().get(EXTRA_GAME);
        getViews();

        // change fonts
        Typeface orbitronBold = Typeface.createFromAsset(getAssets(), "font/orbitron-bold.otf");
        gameName.setTypeface(orbitronBold);
        gameDeveloper.setTypeface(orbitronBold);
        gameReleaseDate.setTypeface(orbitronBold);
        gameRating.setTypeface(orbitronBold);
        gameWebsite.setTypeface(orbitronBold);
        gameYoutube.setTypeface(orbitronBold);

        Typeface orbitronLight = Typeface.createFromAsset(getAssets(), "font/orbitron-light.otf");
        gameDescription.setTypeface(orbitronLight);
        name.setTypeface(orbitronLight);
        developer.setTypeface(orbitronLight);
        releaseDate.setTypeface(orbitronLight);
        rating.setTypeface(orbitronLight);
        website.setTypeface(orbitronLight);
        youtube.setTypeface(orbitronLight);

        fillGameActivity();
        switchColor();
    }

    private void getViews() {
        gameName = (TextView) findViewById(R.id.game_name);
        name = (TextView) findViewById(R.id.name);
        gameDeveloper = (TextView) findViewById(R.id.game_developer);
        developer = (TextView) findViewById(R.id.developer);
        gameReleaseDate = (TextView) findViewById(R.id.game_release_date);
        releaseDate = (TextView) findViewById(R.id.release_date);
        gameRating = (TextView) findViewById(R.id.game_rating);
        rating = (TextView) findViewById(R.id.rating);
        gameWebsite = (TextView) findViewById(R.id.game_website);
        website = (TextView) findViewById(R.id.website);
        gameYoutube = (TextView) findViewById(R.id.game_youtube);
        youtube = (TextView) findViewById(R.id.youtube);
        gameDescription = (TextView) findViewById(R.id.game_description);
        gamePicture = (ImageView) findViewById(R.id.game_picture);
    }

    private void fillGameActivity() {
        checkOrientation();
        gameName.setText(allGames.allGames().get(genre).get(gamePosition).getName());
        gameDeveloper.setText(allGames.allGames().get(genre).get(gamePosition).getDeveloper());
        gameReleaseDate.setText(allGames.allGames().get(genre).get(gamePosition).getReleaseDate());
        gameRating.setText(allGames.allGames().get(genre).get(gamePosition).getRating());
        gameWebsite.setText(allGames.allGames().get(genre).get(gamePosition).getWebsite());
        gameYoutube.setText(allGames.allGames().get(genre).get(gamePosition).getYoutube());
        gameDescription.setText(allGames.allGames().get(genre).get(gamePosition).getDescription());
    }

    private void checkOrientation() {
        WindowManager winManager = (WindowManager) getBaseContext()
                .getSystemService(Context.WINDOW_SERVICE);
        int orientation = winManager.getDefaultDisplay().getOrientation();
        if (orientation == 0) {
            // Portrait
            gamePicture.setImageResource(allGames.allGames()
                    .get(genre).get(gamePosition).getImageHorizontal());
        } else if (orientation == 1) {
            // Landscape (left side)
            gamePicture.setImageResource(allGames.allGames()
                    .get(genre).get(gamePosition).getImageVertical());
        } else {
            // Landscape (right side)
            gamePicture.setImageResource(allGames.allGames()
                    .get(genre).get(gamePosition).getImageVertical());
        }
    }

    // switch layout background color by genre
    private void switchColor() {
        LinearLayout layoutColor = (LinearLayout) findViewById(R.id.game_layout_color);
        switch (TopActivity.genre) {
            case 0:
                layoutColor.setBackgroundColor(getResources().getColor(R.color.action_color));
                break;
            case 1:
                layoutColor.setBackgroundColor(getResources().getColor(R.color.adventure_color));
                break;
            case 2:
                layoutColor.setBackgroundColor(getResources().getColor(R.color.mmo_color));
                break;
            case 3:
                layoutColor.setBackgroundColor(getResources().getColor(R.color.rpg_color));
                break;
            case 4:
                layoutColor.setBackgroundColor(getResources().getColor(R.color.simulation_color));
                break;
            case 5:
                layoutColor.setBackgroundColor(getResources().getColor(R.color.sport_color));
                break;
            case 6:
                layoutColor.setBackgroundColor(getResources().getColor(R.color.strategy_color));
                break;
        }
    }
}