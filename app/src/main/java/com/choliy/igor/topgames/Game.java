package com.choliy.igor.topgames;

public class Game {

    private String name;
    private String developer;
    private String releaseDate;
    private String rating;
    private String website;
    private String youtube;
    private String description;
    private int imageHorizontal;
    private int imageVertical;
    private int imageSquare;

    public Game(String name, String developer, String releaseDate,
                String rating, String website, String youtube, String description,
                int imageHorizontal, int imageVertical, int imageSquare) {
        this.name = name;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.website = website;
        this.youtube = youtube;
        this.description = description;
        this.imageHorizontal = imageHorizontal;
        this.imageVertical = imageVertical;
        this.imageSquare = imageSquare;
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public String getWebsite() {
        return website;
    }

    public String getYoutube() {
        return youtube;
    }

    public String getDescription() {
        return description;
    }

    public int getImageHorizontal() {
        return imageHorizontal;
    }

    public int getImageVertical() {
        return imageVertical;
    }

    public int getImageSquare() {
        return imageSquare;
    }

    @Override
    public String toString() {
        return this.name;
    }
}