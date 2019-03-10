package com.ramesh.example.sampleprogram.consumerLambdaExample;

import java.util.ArrayList;
import java.util.function.Consumer;

//POJO for Movie class
class Movie {

    String movieName;
    String heroName;
    String heroineName;

    public Movie(String movieName, String heroName, String heroineName) {
        this.movieName = movieName;
        this.heroName = heroName;
        this.heroineName = heroineName;
    }
}

//This example prints the movie details only, does not return anything and for this Consumer Interface can be used
public class MovieDetailsConsumerExample {

  public static void main(String[] args) {
      ArrayList<Movie> movies = new ArrayList<>();
      populate(movies);

    Consumer<Movie> consumer =
        movie -> {
          System.out.println("Movie Name : " + movie.movieName);
          System.out.println("Hero Name : " + movie.heroName);
          System.out.println("Heroine Name : " + movie.heroineName);
          System.out.println();
        };

      for (Movie movie : movies) {
          consumer.accept(movie);
      }
  }

  public static void populate(ArrayList<Movie> movies){
      movies.add(new Movie("Alita","Rajes", "Hema"));
      movies.add(new Movie("Titanic", "Leonardo","Rose"));
  }


}
