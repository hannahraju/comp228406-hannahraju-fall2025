package com.exercise1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.sql.Date;
import java.util.List;
import javafx.scene.control.TextField;
import com.exercise1.PlayerInfo;
import com.exercise1.GameInfo;
import com.exercise1.PostgreSQLManager;


public class HelloController {

    PostgreSQLManager dbManager;

    public HelloController(){
        String url = "aws-1-ca-central-1.pooler.supabase.com";
        int port = 5432;
        String dbName = "postgres";
        String user = "postgres.hkivvjnndxqcrpzbuiwv";
        String password = "nwn%25E%24VYt82H6Uw";
        this.dbManager = new PostgreSQLManager(url, port, dbName, user, password);

    }

    // handle submit button click
    protected void submitButtonClick(PlayerInfo player, GameInfo game){

        int playerId = player.id;

        // create new player if id empty, else update player
        if(playerId==0) {
            playerId = dbManager.addPlayer(player.firstName, player.lastName, player.address, player.postalCode, player.province, player.phoneNumber);
            player.setId(playerId);
        }
        else {
            dbManager.updatePlayer(playerId, player.firstName, player.lastName, player.address, player.postalCode, player.province, player.phoneNumber);
        }
        // create new game
        int gameId = dbManager.addGame(game.title);

        // create new player-game
        dbManager.addPlayerGame(gameId, playerId, game.date, game.score);

    }

    // look up all records and display in UI
    protected String searchButtonClick(int id){

        // get player info
        PlayerInfo player = dbManager.getPlayerById(id);
        String displayString = player.toString() + "\n";

        // look up all player-game records with player id
        List<GameInfo> records = dbManager.getRecords(id); // list of GameInfo obejcts
        for(GameInfo record : records) {
            displayString += record.toString();
        }

        return displayString;


    }

}
