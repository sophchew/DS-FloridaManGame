package org.openjfx;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Headline {
    private String story;
    private String keyword;
    private ArrayList<String> options;


    public Headline(String story, String keyword, ArrayList<String> options) {
        this.story = story;
        this.keyword = keyword;
        this.options = options;
        options.add(keyword);
        Collections.shuffle(this.options);
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getKeyword() {
        return keyword;
    }


    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getQuestionString(){
        String returnString = this.story;
        return returnString.replace(this.keyword, "——————————");

    }

    public String getReplacedString(String word){
        String returnString = this.story;
        return returnString.replace(this.keyword, word);
    }



}

