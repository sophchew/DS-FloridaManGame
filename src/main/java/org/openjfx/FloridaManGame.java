package org.openjfx;

import java.util.ArrayList;
import java.util.Arrays;

public class FloridaManGame {

    private static int correctGuesses = 0;
    private static int incorrectGuesses = 0;
    private static double percentCorrect = 0;
    private static int questionsLeft = HeadlineBank.getHeadlines().size();
    private static int totalQuestions = 0;
    private static Headline currentHeadline;

    public static int getCorrectGuesses() {
        return correctGuesses;
    }

    public static void addCorrectGuess() {
        FloridaManGame.correctGuesses++;

    }

    public static int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public static void addIncorrectGuess() {
        FloridaManGame.incorrectGuesses++;
    }

    public static double getPercentCorrect() {
        return percentCorrect;
    }

    public static void setPercentCorrect() {
        FloridaManGame.percentCorrect = Math.round(100 * ((1.0*correctGuesses)/(1.0*(totalQuestions-questionsLeft))));
    }

    public static int getQuestionsLeft() {
        return questionsLeft;
    }

    public static void decQuestionsLeft() {
        FloridaManGame.questionsLeft--;
    }

    public static Headline getCurrentHeadline() {
        return currentHeadline;
    }

    public static void setCurrentHeadline(Headline currentHeadline) {
        FloridaManGame.currentHeadline = currentHeadline;
    }

    public static void initializeHeadlines() {
        System.out.print("Starting");

        Headline headline1 = new Headline("Five Finalists Vying for the Most ‘Benevolent Beard’ in America.", "Beard", new ArrayList<>(Arrays.asList("Hat", "Smile", "Pet")));
        Headline headline2 = new Headline("Florida Man Accused of Posing as Legitimate Pizzeria.", "Pizzeria", new ArrayList<>(Arrays.asList("Doctor", "Professor", "Police Officer")));
        Headline headline3 = new Headline("Florida man speeding from deputies in stolen car gets trapped in tennis court fence on Holmes Beach.", "tennis court fence", new ArrayList<>(Arrays.asList("parking lot", "shopping mall", "bridge")));
        Headline headline4 = new Headline("Florida cop claims Burger King put dirt on his food.", "dirt", new ArrayList<>(Arrays.asList("sand", "hair", "bugs")));
        Headline headline5 = new Headline("Florida man tries to evade arrest by cartwheeling away from cops.", "cartwheeling", new ArrayList<>(Arrays.asList("dancing", "skateboarding", "sprinting")));
        Headline headline6 = new Headline("Florida man attempting to time travel crashes into strip mall.", "time travel", new ArrayList<>(Arrays.asList("teleport", "fly", "swim")));
        Headline headline7 = new Headline("Puppy shoots Florida man, deputies say.", "Puppy", new ArrayList<>(Arrays.asList("Kitten", "Bird", "Hamster")));
        Headline headline8 = new Headline("Florida Man Steals Excavator, Goes for Joyride, Crashes into Walmart.", "Excavator", new ArrayList<>(Arrays.asList("Tractor", "Bulldozer", "Crane")));
        Headline headline9 = new Headline("Florida Man Driving Car Full of Stolen Mail Crashes into Trailer Full of Alpacas.", "Alpacas", new ArrayList<>(Arrays.asList("Llamas", "Sheep", "Goats")));
        Headline headline10 = new Headline("Florida man busted for stealing his twin brother’s identity.", "twin brother", new ArrayList<>(Arrays.asList("cousin", "neighbor", "friend")));


        HeadlineBank.addHeadline(headline1);
        HeadlineBank.addHeadline(headline2);
        HeadlineBank.addHeadline(headline3);
        HeadlineBank.addHeadline(headline4);
        HeadlineBank.addHeadline(headline5);
        HeadlineBank.addHeadline(headline6);
        HeadlineBank.addHeadline(headline7);
        HeadlineBank.addHeadline(headline8);
        HeadlineBank.addHeadline(headline9);
        HeadlineBank.addHeadline(headline10);

        HeadlineBank.shuffleHeadlines();
        questionsLeft = HeadlineBank.getHeadlines().size();
        totalQuestions = HeadlineBank.getHeadlines().size();

        loadNewHeadline();

    }

    public static void loadNewHeadline(){
        if(HeadlineBank.getHeadlines().isEmpty()) {
            currentHeadline = null;
        } else {
            currentHeadline = HeadlineBank.nextHeadline();
        }
    }

    public static boolean checkGuess(String guess) {
        if(guess.equals(currentHeadline.getKeyword())) {
            return true;
        } else {
            return false;
        }
    }






}
