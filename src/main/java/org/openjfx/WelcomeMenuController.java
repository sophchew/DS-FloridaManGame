package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


import java.io.IOException;

import static javafx.scene.text.Font.font;

public class WelcomeMenuController {

    @FXML
    Label gameTitle;
    @FXML
    Label gameInstructions;
    @FXML
    Button startButton;

    public void initialize() {
        gameTitle.setText("Welcome to the Florida Man Game!");
        gameTitle.setFont(Font.font("Space Mono", 40));
        gameTitle.setStyle("-fx-text-fill: white;");

        gameInstructions.setText("To play, select the word you think best fits the Florida Man headline!");
        gameInstructions.setFont(Font.font("Space Mono", 20));
        gameInstructions.setStyle("-fx-text-fill: white;");

        startButton.setText("Start Game!");
        startButton.setFont(Font.font("Space Mono", 30));



    }

    public void startGame(){
        changeScene("GameView.fxml", (Stage) (startButton.getScene().getWindow()));

    }

    public void changeScene(String fxmlFile, Stage currentStage) {

        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene newScene = new Scene(newRoot);
            currentStage.setScene(newScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception appropriately
        }


    }




}
