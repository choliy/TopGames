package com.choliy.igor.topgames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TopActivity extends AppCompatActivity implements View.OnClickListener {

    public static int genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        // change font to custom at this activity
        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(),
                "font/orbitron-light.otf");
        fontChanger.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));

        ImageView logo = (ImageView) findViewById(R.id.logo);
        Button actionButton = (Button) findViewById(R.id.action_button);
        Button adventureButton = (Button) findViewById(R.id.adventure_button);
        Button mmoButton = (Button) findViewById(R.id.mmo_button);
        Button rpgButton = (Button) findViewById(R.id.rpg_button);
        Button simulationButton = (Button) findViewById(R.id.simulation_button);
        Button sportButton = (Button) findViewById(R.id.sport_button);
        Button strategyButton = (Button) findViewById(R.id.strategy_button);

        logo.setOnClickListener(this);
        actionButton.setOnClickListener(this);
        adventureButton.setOnClickListener(this);
        mmoButton.setOnClickListener(this);
        rpgButton.setOnClickListener(this);
        simulationButton.setOnClickListener(this);
        sportButton.setOnClickListener(this);
        strategyButton.setOnClickListener(this);
    }

    public void intentMethod() {
        Intent intent = new Intent(this, GameListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logo:
                Toast.makeText(this, R.string.toast, Toast.LENGTH_LONG).show();
                break;
            case R.id.action_button:
                genre = 0;
                intentMethod();
                break;
            case R.id.adventure_button:
                genre = 1;
                intentMethod();
                break;
            case R.id.mmo_button:
                genre = 2;
                intentMethod();
                break;
            case R.id.rpg_button:
                genre = 3;
                intentMethod();
                break;
            case R.id.simulation_button:
                genre = 4;
                intentMethod();
                break;
            case R.id.sport_button:
                genre = 5;
                intentMethod();
                break;
            case R.id.strategy_button:
                genre = 6;
                intentMethod();
                break;
        }
    }
}