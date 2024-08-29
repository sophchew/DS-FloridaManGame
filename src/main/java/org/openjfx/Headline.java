package org.openjfx;

import java.lang.reflect.Array;

public class Headline {
    private String story;
    private String keyword;
    private String[] options;

    public Headline(String story, String keyword, String[] options) {
        this.story = story;
        this.keyword = keyword;
        this.options = options;
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

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }



}

