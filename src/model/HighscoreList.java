package model;

import java.util.HashMap;

/**
 * Represents a highscore list for the game. Every player is saved
 * with his name and a score of points.
 */
public class HighscoreList {

    /**
     * Maps every player's name to a highscore.
     */
    private HashMap<String, Integer> highscores;

    /**
     * Default constructor (not needed).
     */
    public HighscoreList(){}

    public HashMap<String, Integer> getHighscores() {
        return highscores;
    }

    public void setHighscores(HashMap<String, Integer> highscores) {
        this.highscores = highscores;
    }

    public static void saveHighscore() {
        //TODO!
    }
}
