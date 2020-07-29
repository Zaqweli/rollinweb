package com.rollin.rollinweb.model;

import javax.persistence.Entity;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
public class Game extends BaseModel {

    private Long id;
    private String title;
    private String content;
    private String image;
    private ZonedDateTime gameDate;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getPublished() {
        return gameDate;
    }

    public void setPublished(Date published) {
        this.gameDate = gameDate;
    }



}
