package com.exercise1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Separator;
import javafx.geometry.Orientation;
import javafx.scene.text.Text;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.geometry.HPos;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

// pass nwn%25E%24VYt82H6Uw

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        PostgreSQLManager dbManager = new PostgreSQLManager("jdbc:postgresql://aws-1-ca-central-1.pooler.supabase.com:5432/postgres?user=postgres.hkivvjnndxqcrpzbuiwv&password=nwn%25E%24VYt82H6Uw") ;

        try{
            Connection conn = dbManager.connect();
            System.out.println("Successfully connected to the database!");
            Statement sql_stmt = conn.createStatement();
            ResultSet rset = sql_stmt.executeQuery("SELECT first_name FROM \"Player\" ORDER BY first_name");


        }
        catch(SQLException e){
            e.printStackTrace();
        }

        // setup GridPane as main pane
        GridPane info = new GridPane();
        info.setPadding(new Insets(5, 5, 5, 5));
        info.setHgap(30);

        // add fields for Player info
        Text text = new Text("---PLAYER INFO---");
        info.add(text, 0, 0, 2, 1);
        //info.setHalignment(text, HPos.CENTER);

        info.add(new Label("First Name:"), 0,1);
        TextField firstname = new TextField();
        info.add((firstname), 1,1);

        info.add(new Label("Last Name:"), 0, 2);
        TextField lastname = new TextField();
        info.add(lastname, 1, 2);

        info.add(new Label("Address:"), 0, 3);
        TextField address = new TextField();
        info.add(address, 1, 3);

        info.add(new Label("City:"), 0, 4);
        TextField city = new TextField();
        info.add(city, 1, 4);

        info.add(new Label("Postal Code:"), 0, 5);
        TextField postalcode = new TextField();
        info.add(postalcode, 1, 5);

        info.add(new Label("Province:"), 0, 6);
        TextField province = new TextField();
        info.add(province, 1, 6);

        info.add(new Label("Phone:"), 0, 7);
        TextField phone = new TextField();
        info.add(phone, 1, 7);

        //add fields for game info:
        Text text2 = new Text("--- GAME INFO--- ");
        info.add(text2, 2, 0, 2, 1);

        info.add(new Label("Game:"), 2, 1);
        TextField game = new TextField();
        info.add(game, 3, 1);

        info.add(new Label("Date:"), 2, 2);
        DatePicker date = new DatePicker();
        info.add(date, 3, 2);

        info.add(new Label("Score:"), 2, 3);
        TextField score = new TextField();
        info.add(score, 3, 3);

        // create submit button
        Button submit = new Button("Submit");
        info.add(submit, 0, 8, 4, 1);
        info.setHalignment(submit, HPos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(info);
        stage.setTitle("Lab 4 Exercise 1"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }

}
