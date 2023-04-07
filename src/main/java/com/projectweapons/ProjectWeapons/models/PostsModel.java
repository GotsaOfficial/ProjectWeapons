package com.projectweapons.ProjectWeapons.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PostsModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title, minitext, text;
    private int views, likes;

    public PostsModel() {
    }

    public PostsModel(String title, String minitext, String text) {
        this.title = title;
        this.minitext = minitext;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinitext() {
        return minitext;
    }

    public void setMinitext(String minitext) {
        this.minitext = minitext;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
