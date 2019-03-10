package com.ramesh.example.sampleprogram.consumerLambdaExample;
import java.util.function.Consumer;
/*
  Consumer chaining is the operation performed on two consumer to perform more complex consumer operation using default method present in the Function interfaces
    Default function available inside Consumer interface :
      1) c1.andThen(c2) => here c1 operation will be applied first and then followed by c2
 */

class Film {
    String name;
    String result;

    public Film(String name, String result) {
        this.name = name;
        this.result = result;
    }
}

public class ConsumerChainingExample {
  public static void main(String[] args) {

    Consumer<Film> c1 = film -> System.out.println("Film " + film.name + "is released!");
    Consumer<Film> c2 = film -> System.out.println("Film " + film.name + " is " + film.result);
    Consumer<Film> c3 = film -> System.out.println(" Film " + film.name + "information storing!");

    Consumer<Film> chainedConsumer = c1.andThen(c2).andThen(c3);

    Film film = (new Film("Titanic", "Flop"));
    chainedConsumer.accept(film);
  }
}