package september;
//Hassan Farooq
//9-14-2018
//APCS P.5
//Song Project
//
//This project prints the cumulative song given in the Song_Project document

public class TestClass {
  public static void main(String args[]) {
    //Verse 1
    line1();
    line2();

    //Verse 2
    nextLine();
    line3();

    //Verse 3
    nextLine();
    line4();

    //Verse 4
    nextLine();
    line5();

    //Verse 5
    nextLine();
    line6();

    //Verse 6
    nextLine();
    line7();
  }

  public static void nextLine() {
    System.out.println();
    line1();
  }

  public static void line1() {
    System.out.println("Hey homies, my code is gonna rock this place");
    System.out.println("With a method named main and a curly brace");
  }

  public static void line2() {
    System.out.println("I put a semicolon at the end of each line");
    System.out.println("You haters never seen code that looked so fine");
  }

  public static void line3() {
    System.out.println("Eclipse loves my code, no need to debug");
    System.out.println("I can rap in Java until it unplug");
    line2();
  }

  public static void line4() {
    System.out.println("The first time I try, my code compiles");
    System.out.println("Lost a point for style cause my comments are vile");
    line3();
  }

  public static void line5() {
    System.out.println("Got help from Mr. Gibson and it was swell");
    System.out.println("But I didn't need it cause I code so well");
    line4();
  }

  public static void line6() {
    System.out.println("I got full credit on external correctness");
    System.out.println("Hey playa check this, my code eats yours for breakfast");
    line5();
  }

  public static void line7() {
    //Custom lines
    System.out.println("Java's the only language I'm working with");
    System.out.println("All other languages are just a myth");
    line6();
  }
}
