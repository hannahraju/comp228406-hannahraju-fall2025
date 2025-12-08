package com.exercise1;

import java.sql.Date;

public class GameInfo {

    String title;
    Date date;
    int score;

    public GameInfo(String title, Date date, int score){
        this.title = title;
        this.date = date;
        this.score = score;
    }

    public String toString(){
        String results = "Title: " + title + "\nDate: "+ date + "\nScore: " + score + "\n";
        return results;
    }
}