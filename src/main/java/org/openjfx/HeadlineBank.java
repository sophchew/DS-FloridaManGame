package org.openjfx;

import java.util.ArrayList;
import java.util.Collections;

public class HeadlineBank {
    private static ArrayList<Headline> headlines = new ArrayList<Headline>();
    private static int totalQuestions = headlines.size();

    public static ArrayList<Headline> getHeadlines() {
        return headlines;
    }
    public static void addHeadline(Headline headline) {
        HeadlineBank.headlines.add(headline);
    }

    public static int getTotalQuestions() {
        return totalQuestions;
    }

    public static void shuffleHeadlines() {
        Collections.shuffle(headlines);
    }

    public static Headline nextHeadline() {
        Headline currentHeadline = headlines.get(0);
        headlines.remove(0);
        return currentHeadline;
    }
}
