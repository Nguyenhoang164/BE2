package com.example.pictureofday.Model;

import javax.persistence.*;

@Entity
@Table(name = "Picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private int rate;
    private String author;
    private String feedBack;

    public Picture(int id, int rate, String author, String feedBack) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.feedBack = feedBack;
    }

    public Picture() {
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
}
