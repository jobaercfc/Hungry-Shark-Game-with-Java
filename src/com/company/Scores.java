package com.company;

/**
 * Created by mimtiaze on 03-Jan-17.
 */
public class Scores {
    private String name;
    private int score;

    public Scores(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Scores() {
        this.name = "";
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString(){
        return name + "----------->" + score;
    }
}
