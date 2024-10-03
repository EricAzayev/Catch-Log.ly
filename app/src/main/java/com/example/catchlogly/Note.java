package com.example.catchlogly;

import java.util.Objects;

public class Note {
    private boolean inLogly;
    private String content;
    private String date;
    private String title;

    public Note(String title) { //empty note
        this.title = title;
    }

    // Constructor
    public Note(boolean inLogly, String content, String date, String title) {
        this.inLogly = inLogly;
        this.content = content;
        this.date = date;
        this.title = title;
    }

    // Getters and Setters (optional)
    public boolean inLogly() {
        return inLogly;
    }

    public void setIn(boolean in) {
        this.inLogly = in;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Note o){
        if(this.getTitle().equals(o.getTitle()) && this.getDate().equals(o.getDate()))return true;
        return false;
    }
}



