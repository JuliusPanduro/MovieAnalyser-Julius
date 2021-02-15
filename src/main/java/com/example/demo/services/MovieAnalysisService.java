package com.example.demo.services;

import com.example.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Julius Panduro
 */

public class MovieAnalysisService {

    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private Random random = new Random();

    public MovieAnalysisService() {
        createArrayList();
    }


    public void createArrayList() {
        File file = new File("src/main/resources/static/film-new.csv");
        try {
            Scanner sc = new Scanner(file);

            sc.nextLine();
            sc.nextLine();
            while (sc.hasNext()) {
                String[] StringAsArray = sc.nextLine().split(";");

                Movie movie = new Movie(Integer.parseInt(StringAsArray[0]), Integer.parseInt(StringAsArray[1]),
                        StringAsArray[2], StringAsArray[3],
                        Integer.parseInt(StringAsArray[4]),
                        StringAsArray[5]);
                movieArrayList.add(movie);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    public Movie getFirstMovieOfList() {
        return movieArrayList.get(0);
    }

    public Movie getRandomMovieOfList() {
        return movieArrayList.get(random.nextInt(movieArrayList.size()));
    }

    public ArrayList<Movie> getRandomSortedByPopularity(int amount) {
        ArrayList<Movie> sortedByPopularityList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            sortedByPopularityList.add(movieArrayList.get(random.nextInt(movieArrayList.size())));
        }
        Collections.sort(sortedByPopularityList);
        Collections.reverse(sortedByPopularityList);

        return sortedByPopularityList;
    }

    public int getWonAnAward() {
        int counter = 0;
        for (int i = 0; i < movieArrayList.size(); i++) {
            if (movieArrayList.get(i).getAwards()) {
                counter++;
            }
        }
        return counter;
    }

}
