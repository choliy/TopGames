package com.choliy.igor.topgames;

import com.choliy.igor.topgames.genres.Action;
import com.choliy.igor.topgames.genres.Adventure;
import com.choliy.igor.topgames.genres.MMO;
import com.choliy.igor.topgames.genres.RPG;
import com.choliy.igor.topgames.genres.Simulation;
import com.choliy.igor.topgames.genres.Sport;
import com.choliy.igor.topgames.genres.Strategy;

import java.util.ArrayList;

public class AllGames {

    private Action action = new Action();
    private Adventure adventure = new Adventure();
    private MMO mmo = new MMO();
    private RPG rpg = new RPG();
    private Simulation simulation = new Simulation();
    private Sport sport = new Sport();
    private Strategy strategy = new Strategy();

    public ArrayList<ArrayList<Game>> allGames() {

        ArrayList<ArrayList<Game>> allGames = new ArrayList<>();

        allGames.add(action.games());
        allGames.add(adventure.games());
        allGames.add(mmo.games());
        allGames.add(rpg.games());
        allGames.add(simulation.games());
        allGames.add(sport.games());
        allGames.add(strategy.games());

        return allGames;
    }
}