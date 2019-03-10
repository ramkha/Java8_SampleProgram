package com.ramesh.example.sampleprogram.jodaDateTimeApiExample;
import java.time.*;

 /*
    Up until Java 1.7 to handle Date and Time, we had Date, Time and calender classes, which was not up to the mark on performance wise.
    So Java 1.8 introduced Date and Time API developed by joda.org, which promise the convenient and efficient processing.
 */
public class DateTimeApiExample {
  public static void main(String[] args) {
    // Example to get local date and time
    LocalDate localDate = LocalDate.now();  //Get localDate from the system
    System.out.println(localDate);
    LocalTime localTime = LocalTime.now();
    System.out.println(localTime);
  }
}

class DateCustomizeFormat {
  public static void main(String[] args) {
    LocalDate localDate = LocalDate.now(); //Get local date
    System.out.println(localDate);   //Print the date in default format
      int dd = localDate.getDayOfMonth(); //extract day
      int mm = localDate.getMonthValue(); //extract month
      int yyyy = localDate.getYear();     //extract year
    System.out.printf("%d-%d-%d ",dd,mm,yyyy);
  }
}

class TimeCustomizeFormat {
  public static void main(String[] args) {
    LocalTime localTime = LocalTime.now(); //get local time
    System.out.println(localTime);
      int hh = localTime.getHour(); //extract hour
      int mm = localTime.getMinute(); //extact minute
      int ss = localTime.getSecond(); //extract second
      int nn = localTime.getNano(); //extract nano
    System.out.printf("%d:%d:%d:%d",hh,mm,ss,nn);
  }
}

class DateTimeCustomizeFormat {
  public static void main(String[] args) {
    LocalDateTime dt = LocalDateTime.now(); //Get local date and time
    System.out.println(dt);
      int dd = dt.getDayOfMonth(); //extract day
      int mm = dt.getMonthValue(); //extract month
      int yyyy = dt.getYear();     //extract year
      System.out.printf("%d-%d-%d ",dd,mm,yyyy);
      int h = dt.getHour(); //extract hour
      int m = dt.getMinute(); //extact minute
      int s = dt.getSecond(); //extract second
      int n = dt.getNano(); //extract nano
      System.out.printf("%d:%d:%d:%d",h,m,s,n);
  }
}

class ParticularDateTime {
  public static void main(String[] args) {
    LocalDateTime localDateTime = LocalDateTime.of(1993,Month.MARCH,27,22,18);  //We can specify the particular date also
    System.out.println(localDateTime);
    // LocalDateTime class has several method that can come handy, lets explore some of them
    System.out.println("Before 6 month date was : " + localDateTime.minusMonths(6));
    System.out.println("After 6 month date was : " + localDateTime.plusMonths(6));
  }
}