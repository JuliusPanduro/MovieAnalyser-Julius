package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author Julius Panduro
 */

@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService();

    @ResponseBody
    @GetMapping("/")
    public String frontPage() {
        return "Welcome to the movie analyser web application<br><br>" +
                "You can now write in your url what you want to see, type things like<br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getFirst\" -> To get the title of the first movie in list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getRandom\" -> To get a random movie title from the list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getTenSortByPopularity\" -> To get the ten most popular movies from the list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getHowManyWonAnAward\" -> To get all the movies from the list that won an award</a><br><br>" +
                "best of luck :)";

    }


    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() {
        Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return "Title of the first movie is: " + firstMovieOfList.getTitle() + "<br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getRandom\" -> To get a random movie title from the list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getTenSortByPopularity\" -> To get the ten most popular movies from the list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getHowManyWonAnAward\" -> To get all the movies from the list that won an award</a><br><br>"+
                "Click here: " + "<a href=\"http://localhost:8080/\" -> Return to frontpage</a><br><br>";
    }

    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom() {
        Movie randomMovieFromList = movieService.getRandomMovieOfList();
        return "Title of the random movie is: " + randomMovieFromList.getTitle() + "<br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getFirst\" -> To get the title of the first movie in list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getTenSortByPopularity\" -> To get the ten most popular movies from the list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getHowManyWonAnAward\" -> To get all the movies from the list that won an award</a><br><br>"+
                "Click here: " + "<a href=\"http://localhost:8080/\" -> Return to frontpage</a><br><br>";
    }

    @ResponseBody
    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity() {
        ArrayList<Movie> tenSortedList = movieService.getRandomSortedByPopularity(10);
        String str = "";
        for (int i = 0; i < tenSortedList.size(); i++) {
            str += "Title: " + tenSortedList.get(i).getTitle() + " Popularity: " + tenSortedList.get(i).getPopularity() + "<br>";

        }
        return "Ten movie titles, sorted by popularity: <br>" + str + "<br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getFirst\" -> To get the title of the first movie in list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getRandom\" -> To get a random movie title from the list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getHowManyWonAnAward\" -> To get all the movies from the list that won an award</a><br><br>"+
                "Click here: " + "<a href=\"http://localhost:8080/\" -> Return to frontpage</a><br><br>";

    }

    @ResponseBody
    @GetMapping("/getHowManyWonAnAward")
    public String getHowManyWonAnAward() {
        return "Number of movies who won an award is: " + movieService.getWonAnAward() + "<br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getFirst\" -> To get the title of the first movie in list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getRandom\" -> To get a random movie title from the list</a><br><br>" +
                "Click here: " + "<a href=\"http://localhost:8080/getTenSortByPopularity\" -> To get the ten most popular movies from the list</a><br><br>"+
                "Click here: " + "<a href=\"http://localhost:8080/\" -> Return to frontpage</a><br><br>";
    }

}
