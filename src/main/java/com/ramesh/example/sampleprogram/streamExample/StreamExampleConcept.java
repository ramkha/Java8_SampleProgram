package com.ramesh.example.sampleprogram.streamExample;

/*
     With java 1.8 another powerful feature got introduced "STREAM" concept.
       ~ Stream concept is only applicable on the Collection.
       ~ Stream process the object from the collection.
       ~ It is used when we want to perform bulk operation on collection object.

     From java 1.8, In any collection interface, stream() method is present as the default method,
        so, using Stream s = collectionObject.stream() we can create the stream object.
            here, Stream is an interface present inside java.util.stream and .stream() method is present inside every collection interface as the default method.

       Once the stream object is ready, then we can go ahead and process the collection object.
         These stream processing contains the two stages :-
           1) Configuration :- The first stage is configuring the stream. This configuration can be be achieved on two two ways :-

               a) Map mechanism:- Go for the map configuration, if the requirement is to create a separate or new mapped object based on some function,
                                  for each and every object present in the collection.
                                   We can implement the map by using map() method present inside the Stream interface.
                                       method syntax :- public Stream map(Function<T, R> function)
                                        e.g Stream s = c.stream().map(i -> i*2);

               b) Filter mechanism :- Go for filter configuration, if the requirement is to filter out the collection object on some boolean condition
                                       and perform further operation on those filtered objects only.
                                       We can configure the filter by using filter() method present inside the Stream interface.
                                       method syntax :- public Stream filter(Predicate<T> predicate)
                                        e.g Stream s = c.stream().filter(i -> i%2 == 0);


           2) Processing :- The second stage is to process the configuration achieved by using Map or filter
               1) Processing by collection() method :- This method collects the elements from the stream and add to the other specified collection.
               2) Processing by count() method :- This method returns the number of elements present in stream. public long count()
               3) Processing by sorted() method :- This can be used to sort the elements inside the stream. we can sort based on either natural sorting order or our own
                                                   customized order specified by comparator object.
                                                   E.g.
                                                    a) sorted() => For default natural sorting order
                                                    b) sorted (comparator c) => for customized sorting order

               4) Processing by min() and max() method :-This method returns min and max value based on the specified comparator.
                                                         a) min(Comparator c) :- Returns minimum value
                                                         b) max(Comparator c) :- Returns maximum value

               5) Processing by forEach() method :- ~ This method does not return anything
                                                    ~ This method can take lambda expression as an argument and apply it for each element present in the stream.

               6) Processing by toArray() method :- This method can be used to copy elements present inside the stream into the specified array.

               7) Processing by stream.of() method :- This method is very important in a sense, as it resolves the misconception that streams are applicable to collection only.
                                                      streams can be applied to the group of values and for arrays.
                                                        a) For group of values :-
                                                            syntax e.g
                                                                       Stream<Integer> s = Stream.of(1,11,111,1111,11111); //Creating a stream object for the group of values
                                                                       s.forEach(System.out::println);  //Once the stream object is available, we can apply all the method available inside the stream

                                                        b) For arrays :-
                                                             syntax e.g
                                                                       Double[] d = {0.0,1.1,2.2,3.3,4.4,5.5};    //Initializing the double array d
                                                                       Stream<Double> stream = stream.of(d);     //Creating a stream object for the arrays
                                                                       stream.forEach(System.out::println);     //using forEach method from stream
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//This example demonstrate the find even number from Aerialist using stream and without stream to draw out the differences
public class StreamExampleConcept {

  public static void main(String[] args) {
    // Tradition way to get even number from Arraylist until Java 1.7

      ArrayList<Integer> arrayList= new ArrayList<Integer>();
      arrayList.add(0);
      arrayList.add(5);
      arrayList.add(10);
      arrayList.add(15);
      arrayList.add(20);

      //Example_1 write the condition to filter out the even number and add those filtered even number on different list
      List<Integer> evenList = new ArrayList<Integer>();
      for( int i : arrayList){
          if(i%2 ==0){
              evenList.add(i);
          }
      }
    System.out.println("Traditional way to get even number list : " + evenList);

      //Example_1 Using stream java 1.8
      evenList = arrayList.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
    System.out.println("Using Stream to get the list of even number : " + evenList);


    //Example_2 Traditional way to double the value of existing list value
      List<Integer> evenList_2 = new ArrayList<Integer>();
      for( int i : arrayList){
              evenList_2.add(i*2);
          }
      System.out.println("Traditional way to double the value: " + evenList_2);

      //Example_2 Using streams to double the value of the existing list value
      evenList_2 = arrayList.stream().map(i -> i*2).collect(Collectors.toList());
      System.out.println("Using Stream to double the value : " + evenList_2);

  }
}

// Processing by collection() method  Example on filter and map
class ProcessByMethodStream {

  public static void main(String[] args) {
    // Initializing string array to hold some string values
      ArrayList<String> arrayList = new ArrayList<String>();
      arrayList.add("Ram");
      arrayList.add("Shyam");
      arrayList.add("Harinandan");
      arrayList.add("rabindranath");
      arrayList.add("haqullahmulla");

      //Now I want to get some elements from the above array list based on some condition and then add those elements into another collection
      List<String> newList = arrayList.stream().filter(s -> s.length() >= 9 ).collect(Collectors.toList());
     System.out.println(newList);

     //With following example, we will use map to perform operation on each and every elements and then use collect() method to collect those elements into the new collection
      List<String> newMapList = arrayList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
    System.out.println(newMapList);
  }

}


// Processing by count() method  Example on filter and map
class ProcessCountStream {

    public static void main(String[] args) {
        // Initializing string array to hold some string values
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Ram");
        arrayList.add("Shyam");
        arrayList.add("Harinandan");
        arrayList.add("rabindranath");
        arrayList.add("haqullahmulla");

        //Now I want to get some elements from the above array list based on some condition and then get the counts of such elements
        Long count = arrayList.stream().filter(s -> s.length() >= 9 ).count();
        System.out.println(count);

    }
}

//processing by sorted() method to sort out either in natural order or customized order
class ProcessSortedStream {
  public static void main(String[] args) {
    // Initializing integer array to hold some int values
      ArrayList<Integer> randomInt = new ArrayList<Integer>();
      randomInt.add(15);
      randomInt.add(0);
      randomInt.add(10);
      randomInt.add(20);
      randomInt.add(25);

      List<Integer> sortedList = randomInt.stream().sorted().collect(Collectors.toList());
    System.out.println("Natural order sorting asscending : " + sortedList);

   // List<Integer> customizedSortedList = randomInt.stream().sorted((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? +1 : 0).collect(Collectors.toList());
     // List<Integer> customizedSortedList = randomInt.stream().sorted((o1, o2) -> - o1.compareTo(o2) ).collect(Collectors.toList());
      List<Integer> customizedSortedList = randomInt.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
    System.out.println(" Customized sorted descending : " + customizedSortedList);
  }
}


//processing by min() and max() method to get the min and max value based on the comparator provided
class ProcessMinMaxMethodStream {
    public static void main(String[] args) {
        // Initializing integer array to hold some int values
        ArrayList<Integer> randomInt = new ArrayList<Integer>();
        randomInt.add(15);
        randomInt.add(0);
        randomInt.add(10);
        randomInt.add(20);
        randomInt.add(25);

        //Integer min = randomInt.stream().min((o1,o2) -> o1.compareTo(o2)).get();  can be replaced with Comparator.naturalOrder()
        Integer min = randomInt.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Min value for asscending order: " + min);

        Integer max = randomInt.stream().min((o1,o2) -> o1.compareTo(o2)).get();
        System.out.println("Min value for asscending order: " + max);

    }
}

//Processing by forEach() method will not return anything after performing certain operation on the elements present inside the stream
class ProcessForEachStream {
  public static void main(String[] args) {
    //Initializing string array to hold some string values
      ArrayList<String> arrayList = new ArrayList<String>();
      arrayList.add("A");
      arrayList.add("BB");
      arrayList.add("CCC");

   // arrayList.stream().forEach(s -> System.out.println(s));  can be replaced with method reference
      arrayList.stream().forEach(System.out::println);
  }
}

//processing by toArray() method copy the elements inside the stream into the specified array
class ProcessToArrayStream {
    public static void main(String[] args) {
        // Initializing integer array to hold some int values
        ArrayList<Integer> randomInt = new ArrayList<Integer>();
        randomInt.add(15);
        randomInt.add(0);
        randomInt.add(10);
        randomInt.add(20);
        randomInt.add(25);

        // Integer[] x = randomInt.stream().toArray(value -> new Integer[value]); // This lambda expression can be replaced with method reference
        Integer[] x = randomInt.stream().toArray(Integer[]::new);  // Integer[]::new [method reference] will have the reference of Integer[]x which will get created with new keyword
        for ( Integer i: x ) {
            System.out.println(i);

        }
    }
}

//Stream can also be applied on the group of values
class ProcessStreamOf {
  public static void main(String[] args) {

      Stream<Integer> stream = Stream.of(1,11,111,1111,11111);  //Creating stream object for the group of integer values
      stream.forEach(System.out::println);                      // Performing forEach() method available inside stream for each values

      Double[] d = {0.0,1.1,2.2,3.3,4.4,5.5};    //Initializing the double array d
      Stream<Double> stream1 = Stream.of(d);     //Creating a stream object for the arrays
      stream1.forEach(System.out::println);     //using forEach method from stream

  }
}