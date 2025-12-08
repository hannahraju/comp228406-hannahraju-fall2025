/*
 * @author Hannah Raju
 * @date December 7, 2025
 * @info COMP 228 Lab Assignment 5
 * @filename GameInfo.java
 *
 * This class acts as the Model for Game
 */

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