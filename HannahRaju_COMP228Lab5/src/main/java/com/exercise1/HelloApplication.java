package com.exercise1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Separator;
import javafx.geometry.Orientation;
import javafx.scene.text.Text;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.geometry.HPos;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.exercise1.HelloController;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        // instantiate controller
        HelloController ctrl = new HelloController();

        //build GUI
        // setup Vbox for main pan
        VBox vbox = new VBox(10);

        // setup GridPane for user info
        GridPane info = new GridPane();
        vbox.getChildren().add(info); //

        vbox.setPadding(new Insets(5, 5, 5, 5));
        info.setHgap(30);

        // add fields for Player info
        Text text = new Text("---PLAYER INFO---");
        info.add(text, 0, 0, 2, 1);
        info.setHalignment(text, HPos.CENTER);

        info.add(new Label("First Name:"), 0,1);
        TextField firstname = new TextField();
        info.add((firstname), 1,1);

        info.add(new Label("Last Name:"), 0, 2);
        TextField lastname = new TextField();
        info.add(lastname, 1, 2);

        info.add(new Label("Address:"), 0, 3);
        TextField address = new TextField();
        info.add(address, 1, 3);

        info.add(new Label("Postal Code:"), 0, 4);
        TextField postalcode = new TextField();
        info.add(postalcode, 1, 4);

        info.add(new Label("Province:"), 0, 5);
        TextField province = new TextField();
        info.add(province, 1, 5);

        info.add(new Label("Phone:"), 0, 6);
        TextField phone = new TextField();
        info.add(phone, 1, 6);

        //add fields for game info:
        Text text2 = new Text("--- GAME INFO--- ");
        info.add(text2, 2, 0, 2, 1);
        info.setHalignment(text2, HPos.CENTER);

        info.add(new Label("Game title:"), 2, 1);
        TextField title = new TextField();
        info.add(title, 3, 1);

        info.add(new Label("Date:"), 2, 2);
        DatePicker date = new DatePicker();
        info.add(date, 3, 2);

        info.add(new Label("Score:"), 2, 3);
        TextField score = new TextField();
        info.add(score, 3, 3);

        // create submit button - clears game info when submitted
        Button submit = new Button("Submit");
        info.add(submit, 0, 7);

        // create clear button - when user in finished entering all their info, clears user
        Button clear = new Button("Clear");
        info.add(clear, 1,7);

        // add empty hbox for spacing??
        Separator separator = new Separator(Orientation.HORIZONTAL); // Create a horizontal separator
        vbox.getChildren().add(separator);

        //create user search hbox, add to main vbox
        GridPane userSearch = new GridPane();
        userSearch.add(new Label("User Search by ID:"), 0, 0);
        TextField search = new TextField();
        userSearch.add(search, 1, 0);
        Button searchBtn = new Button("Search");
        userSearch.add(searchBtn, 2, 0);
        userSearch.setHgap(30);
        vbox.getChildren().add(userSearch);

        // add display box, add to main vbox
        TextArea display = new TextArea();
        vbox.getChildren().add(display);


        // Create a scene and place it in the stage
        Scene scene = new Scene(vbox);
        stage.setTitle("LAB 6"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage

        // handle submit button click
        submit.setOnAction(event -> {

            // get info from UI
            PlayerInfo player = new PlayerInfo(firstname.getText(), lastname.getText(), address.getText(), postalcode.getText(), province.getText(), phone.getText());
            LocalDate ld = date.getValue();
            GameInfo game = new GameInfo(title.getText(), Date.valueOf(ld), Integer.parseInt(score.getText()));

            // submit info to db via controller
            ctrl.submitButtonClick(player, game);

            // clear game fields
            title.clear();
            date.getEditor().clear();
            date.setValue(null);
            score.clear();
        });


        // handle clear button click
        clear.setOnAction(event -> {

            firstname.clear();
            lastname.clear();
            address.clear();
            postalcode.clear();
            province.clear();
            phone.clear();

        });

        // handle search button click
        searchBtn.setOnAction(event -> {

            // get submitted id from UI
            int id = Integer.parseInt(search.getText());

            // display records by user id
            String displayString = ctrl.searchButtonClick(id);
            display.setText(displayString);


        });

    }

}
