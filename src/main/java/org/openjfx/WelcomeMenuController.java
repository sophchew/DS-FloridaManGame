package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


import static javafx.scene.text.Font.font;

public class WelcomeMenuController {

    @FXML
    Label gameTitle;
    @FXML
    Label gameInstructions;

    public void initialize() {
        gameTitle.setText("Welcome to the Florida Man Game!");
        gameTitle.setFont(Font.font("Space Mono", 40));
        gameTitle.setStyle("-fx-text-fill: white;");

        gameInstructions.setText("To play, select the word you think best fits the Florida Man headline!");
        gameInstructions.setFont(Font.font("Space Mono", 20));
        gameInstructions.setStyle("-fx-text-fill: white;");



    }




}
