package org.openjfx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {

    @FXML
    Label gameOverLabel;
    @FXML
    Label statsLabel;
    @FXML
    Label incorrectLabel;
    @FXML
    Label correctLabel;
    @FXML
    Label percentageLabel;
    @FXML
    Button replayButton;
    @FXML
    Button quitButton;

    public void initialize(){

        gameOverLabel.setText("Game Over!");
        gameOverLabel.setFont(Font.font("Space Mono", 40));
        gameOverLabel.setStyle("-fx-text-fill: white;");
        statsLabel.setFont(Font.font("Space Mono", 25));
        statsLabel.setStyle("-fx-text-fill: white;");
        statsLabel.setText("Player Stats:");

        incorrectLabel.setFont(Font.font("Space Mono", 20));
        incorrectLabel.setStyle("-fx-text-fill: red;");
        incorrectLabel.setText("Incorrect Guesses: " + FloridaManGame.getIncorrectGuesses());

        correctLabel.setFont(Font.font("Space Mono", 20));
        correctLabel.setStyle("-fx-text-fill: green;");
        correctLabel.setText("Correct Guesses: "+ FloridaManGame.getCorrectGuesses());

        percentageLabel.setFont(Font.font("Space Mono", 20));
        percentageLabel.setStyle("-fx-text-fill: white;");
        percentageLabel.setText("Percent Correct: " + FloridaManGame.getPercentCorrect()+"%");

        replayButton.setFont(Font.font("Space Mono", 20));
        replayButton.setText("Play Again!");

        quitButton.setFont(Font.font("Space Mono", 20));
        quitButton.setText("Quit Game");

    }

    public void onReplayClick(){
        changeScene("GameView.fxml" ,(Stage) (replayButton.getScene().getWindow()));

    }

    public void onQuit(){
        //close app
        Platform.exit();
        System.exit(0);
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
