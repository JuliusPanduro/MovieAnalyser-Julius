package com.example.demo.models;

/**
 * @author Julius Panduro
 */

public class Movie implements Comparable<Movie> {
    private int year;
    private int length;
    private int popularity;
    private Boolean awards;
    private String title;

    public Movie(int year, int length, String title, String cat, int popularity, String awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.popularity = popularity;

        if (awards.equalsIgnoreCase("yes")) {
            this.awards = true;
        } else {
            this.awards = false;
        }
    }

    public Boolean getAwards() {
        return awards;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPopularity() {
        return popularity;
    }

    @Override
    public int compareTo(Movie movie) {
        return Integer.compare(getPopularity(), movie.getPopularity());
    }
}
