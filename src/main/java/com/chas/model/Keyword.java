package com.chas.model;

/**
 * Created by ShirUshI on 2017/5/13.
 */
public class Keyword {

    private String word;

    private int aspectId;

    private int score;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getAspectId() {
        return aspectId;
    }

    public void setAspectId(int aspectId) {
        this.aspectId = aspectId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
