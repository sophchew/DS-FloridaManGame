package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;

import javax.swing.*;

public class GameViewController {

    @FXML
    Label questionLabel;
    @FXML
    RadioButton opt1;
    @FXML
    RadioButton opt2;
    @FXML
    RadioButton opt3;
    @FXML
    RadioButton opt4;
    @FXML
    RadioButton optionGuessed;
    @FXML
    Button submitButton;
    @FXML
    Label statsLabel;
    @FXML
    Label incorrectLabel;
    @FXML
    Label correctLabel;
    @FXML
    Label percentageLabel;
    @FXML
    Label questionsLeftLabel;
    @FXML
    Label guessResultLabel;


    public void initialize(){
       FloridaManGame.initializeHeadlines();
       loadNewHeadlineUI();
        questionLabel.setFont(Font.font("Space Mono", 30));
        questionLabel.setStyle("-fx-text-fill: white;");

        opt1.setFont(Font.font("Space Mono", 20));
        opt2.setFont(Font.font("Space Mono", 20));
        opt3.setFont(Font.font("Space Mono", 20));
        opt4.setFont(Font.font("Space Mono", 20));

        opt1.setStyle("-fx-text-fill: white;");
        opt2.setStyle("-fx-text-fill: white;");
        opt3.setStyle("-fx-text-fill: white;");
        opt4.setStyle("-fx-text-fill: white;");


       submitButton.setFont(Font.font("Space Mono", 30));

       questionsLeftLabel.setFont(Font.font("Space Mono", 20));
       questionsLeftLabel.setStyle("-fx-text-fill: white;");

        statsLabel.setFont(Font.font("Space Mono", 12));
        statsLabel.setStyle("-fx-text-fill: white;");
        statsLabel.setText("Player Stats:");

        incorrectLabel.setFont(Font.font("Space Mono", 12));
        incorrectLabel.setStyle("-fx-text-fill: red;");

        correctLabel.setFont(Font.font("Space Mono", 12));
        correctLabel.setStyle("-fx-text-fill: green;");

        percentageLabel.setFont(Font.font("Space Mono", 12));
        percentageLabel.setStyle("-fx-text-fill: white;");

        guessResultLabel.setFont(Font.font("Space Mono", 20));



    }

    @FXML
    public void onOptionClick(ActionEvent event){
        RadioButton option = (RadioButton) event.getSource();
        if(optionGuessed != null && !optionGuessed.equals(option)){
            optionGuessed.setSelected(false);
        }
        optionGuessed = option;

        questionLabel.setText(FloridaManGame.getCurrentHeadline().getReplacedString(optionGuessed.getText()));

    }

    @FXML
    public void onSubmitClick(ActionEvent event){
        Button buttonClicked = (Button) event.getSource();
        if(buttonClicked.getText().equals("Submit!")) {
            boolean correct = FloridaManGame.checkGuess(optionGuessed.getText());
            if(correct){
                FloridaManGame.addCorrectGuess();
                guessResultLabel.setStyle("-fx-text-fill: green;");
                guessResultLabel.setText("\"" + (optionGuessed.getText()) + "\" was correct!");
            } else {
                FloridaManGame.addIncorrectGuess();
                questionLabel.setText(FloridaManGame.getCurrentHeadline().getStory());
                guessResultLabel.setStyle("-fx-text-fill: red;");
                guessResultLabel.setText("\"" + (optionGuessed.getText()) + "\" is wrong. The correct answer is \"" + FloridaManGame.getCurrentHeadline().getKeyword() + ".\"" );

            }

            opt1.setVisible(false);
            opt2.setVisible(false);
            opt3.setVisible(false);
            opt4.setVisible(false);

            guessResultLabel.setVisible(true);
            submitButton.setText("Next");
        } else {
            nextQuestion();
        }



    }

    public void nextQuestion(){
        FloridaManGame.decQuestionsLeft();
        if(FloridaManGame.getQuestionsLeft() != 0){
            FloridaManGame.setPercentCorrect();
            FloridaManGame.loadNewHeadline();
            loadNewHeadlineUI();
        } else {
            submitButton.setVisible(false);
        }

    }

    public void loadNewHeadlineUI(){
        questionLabel.setText(FloridaManGame.getCurrentHeadline().getQuestionString());


        opt1.setText(FloridaManGame.getCurrentHeadline().getOptions().get(0));
        opt2.setText(FloridaManGame.getCurrentHeadline().getOptions().get(1));
        opt3.setText(FloridaManGame.getCurrentHeadline().getOptions().get(2));
        opt4.setText(FloridaManGame.getCurrentHeadline().getOptions().get(3));

        opt1.setVisible(true);
        opt2.setVisible(true);
        opt3.setVisible(true);
        opt4.setVisible(true);

        opt1.setSelected(false);
        opt2.setSelected(false);
        opt3.setSelected(false);
        opt4.setSelected(false);


        questionsLeftLabel.setText("Questions Left: " + FloridaManGame.getQuestionsLeft());
        incorrectLabel.setText("Incorrect Guesses: " + FloridaManGame.getIncorrectGuesses());
        correctLabel.setText("Correct Guesses: " + FloridaManGame.getCorrectGuesses());

        percentageLabel.setText("Percent Correct: " + FloridaManGame.getPercentCorrect() + "%");
        if(FloridaManGame.getPercentCorrect() <= 60) {
            percentageLabel.setStyle("-fx-text-fill: red;");
        } else if (FloridaManGame.getPercentCorrect() <= 75) {
            percentageLabel.setStyle("-fx-text-fill: yellow;");
        } else {
            percentageLabel.setStyle("-fx-text-fill: green;");
        }

        submitButton.setText("Submit!");

        guessResultLabel.setVisible(false);
    }

}
