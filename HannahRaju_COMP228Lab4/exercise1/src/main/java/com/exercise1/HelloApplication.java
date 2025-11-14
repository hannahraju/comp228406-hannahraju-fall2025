package com.exercise1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.CheckBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // setup BorderPane as main pane
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5, 5, 5, 5));

        GridPane info = new GridPane();
        info.setPadding(new Insets(5, 5, 5, 5));
        pane.setLeft(info);
        info.add(new Label("Name:"), 0, 0);
        info.add(new TextField(), 1, 0);
        info.add(new Label("Address:"), 0, 1);
        info.add(new TextField(), 1, 1);
        info.add(new Label("Province:"), 0, 2);
        info.add(new TextField(), 1, 2);
        info.add(new Label("City:"), 0, 3);
        info.add(new TextField(), 1, 3);
        info.add(new Label("Postal Code:"), 0, 4);
        info.add(new TextField(), 1, 4);
        info.add(new Label("Phone Number:"), 0, 5);
        info.add(new TextField(), 1, 5);
        info.add(new Label("Email:"), 0, 6);
        info.add(new TextField(), 1, 6);

        // add checkboxes for extracurriculars
        VBox extracurriculars = new VBox();
        extracurriculars.setPadding(new Insets(5, 5, 5, 5));
        pane.setCenter(extracurriculars);
        CheckBox cb1 = new CheckBox("Volunteer Work");
        CheckBox cb2 = new CheckBox("Student Council");
        extracurriculars.getChildren().add(cb1);
        extracurriculars.getChildren().add(cb2);

        // add radio buttons for selecting student's major
        VBox right = new VBox();
        HBox majors = new HBox();
        majors.setPadding(new Insets(5, 5, 5, 5));
        right.getChildren().add(majors);
        RadioButton button1 = new RadioButton("Computer Science");
        RadioButton button2 = new RadioButton("Business");
        ToggleGroup buttongroup = new ToggleGroup();
        button1.setToggleGroup(buttongroup);
        button2.setToggleGroup(buttongroup);
        majors.getChildren().addAll(button1, button2);

        // add combo box for course selection
        ComboBox<String> cmb = new ComboBox<String>();
        right.getChildren().add(cmb);

        // add list view for course selection
        ListView<String> listview = new ListView<>(); // For a list of Strings
        right.getChildren().add(listview);
        ObservableList<String> selected = listview.getItems();

        pane.setRight(right);

        // create submit button
        VBox bottom = new VBox();
        bottom.setAlignment(Pos.CENTER);
        Button btDisp = new Button("Display");
        bottom.getChildren().add(btDisp);

        // add text field
        TextField output = new TextField();
        bottom.getChildren().add(output);
        pane.setBottom(bottom);

        // handle events for radio buttons
        ObservableList<String> csOptions = FXCollections.observableArrayList("Java", "Python", "Databases");
        ObservableList<String> bsOptions = FXCollections.observableArrayList("Marketing", "Economics");
        button1.setOnAction(e -> cmb.setItems(csOptions));
        button2.setOnAction(e -> cmb.setItems(bsOptions));

        // handle events for course selection
        cmb.setOnAction(event->{
                String selectedCourse = cmb.getValue();

                //make sure duplicate courses can't be added
                if(selectedCourse != null && !selected.contains(selectedCourse)){
                    selected.add(selectedCourse);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setTitle("ShowGridPane"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }

}
