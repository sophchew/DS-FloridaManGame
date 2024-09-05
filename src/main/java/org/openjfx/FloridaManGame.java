package org.openjfx;

public class FloridaManGame {

    private static int correctGuesses = 0;
    private static int incorrectGuesses = 0;
    private static double percentCorrect = 0;
    private static int questionsLeft = HeadlineBank.getTotalQuestions();
    private static Headline currentHeadline = HeadlineBank.getHeadlines().get(0);

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
        FloridaManGame.percentCorrect = (1.0*correctGuesses)/(1.0*HeadlineBank.getTotalQuestions());
    }

    public static int getQuestionsLeft() {
        return questionsLeft;
    }

    public static void setQuestionsLeft(int questionsLeft) {
        FloridaManGame.questionsLeft = questionsLeft;
    }

    public static Headline getCurrentHeadline() {
        return currentHeadline;
    }

    public static void setCurrentHeadline(Headline currentHeadline) {
        FloridaManGame.currentHeadline = currentHeadline;
    }

    public static void initializeHeadlines() {

        Headline headline1 = new Headline("Five Finalists Vying for the Most ‘Benevolent Beard’ in America", "Beard", new String[]{"Hat", "Smile", "Pet"});
        Headline headline2 = new Headline("Florida Man Accused of Posing as Legitimate Pizzeria", "Pizzeria", new String[]{"Doctor", "Professor", "Police Officer"});
        Headline headline3 = new Headline("Florida man speeding from deputies in stolen car gets trapped in tennis court fence on Holmes Beach", "tennis court fence", new String[]{"parking lot", "shopping mall", "bridge"});
        Headline headline4 = new Headline("Florida cop claims Burger King put dirt on his food", "dirt", new String[]{"sand", "hair", "bugs"});
        Headline headline5 = new Headline("Florida man tries to evade arrest by cartwheeling away from cops", "cartwheeling", new String[]{"dancing", "skateboarding", "sprinting"});
        Headline headline6 = new Headline("Florida man attempting to time travel crashes into strip mall", "time travel", new String[]{"teleport", "fly", "swim"});
        Headline headline7 = new Headline("Puppy shoots Florida man, deputies say", "Puppy", new String[]{"Kitten", "Bird", "Hamster"});
        Headline headline8 = new Headline("Florida Man Steals Excavator, Goes for Joyride, Crashes into Walmart", "Excavator", new String[]{"Tractor", "Bulldozer", "Crane"});
        Headline headline9 = new Headline("Florida Man Driving Car Full of Stolen Mail Crashes into Trailer Full of Alpacas", "Alpacas", new String[]{"Llamas", "Sheep", "Goats"});
        Headline headline10 = new Headline("Florida man busted for stealing his twin brother’s identity", "twin brother", new String[]{"cousin", "neighbor", "friend"});

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
