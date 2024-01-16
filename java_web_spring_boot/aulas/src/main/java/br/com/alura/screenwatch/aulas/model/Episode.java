package br.com.alura.screenwatch.aulas.model;

import br.com.alura.screenwatch.aulas.EpisodeData;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer number;
    private Double review;
    private LocalDate launchDate;

    //constructor
    public Episode(Integer season, EpisodeData e) {
        this.season = season;
        this.title = e.title();
        this.number = e.episodeNumber();

        try {
            this.review = Double.valueOf(e.review());
        } catch (NumberFormatException ex) {
            this.review = 0.0;
        }

        try {
            this.launchDate = LocalDate.parse(e.releaseDate());
        } catch (DateTimeParseException ex) {
            this.launchDate = null;
        }
    }

    // tostring

    @Override
    public String toString() {
        return "season=" + season +
                ", title='" + title + '\'' +
                ", number=" + number +
                ", review=" + review +
                ", launchDate=" + launchDate ;
    }


    // constructor

    // getter e setter

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getReview() {
        return review;
    }

    public void setReview(Double review) {
        this.review = review;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }
}
