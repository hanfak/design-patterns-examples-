package loops;

import java.util.Iterator;
import java.util.List;

// comment out all methods but the one you are interested in, otherwise output will be a lot
// Before Java 8
public class InfiniteLoopsOld {
  public static void main(String... args) {
    List<String> items = List.of("apple", "banana", "carrot", "dog"); //This java 11 way of creating an immutable list

    // A Loop is generally used to go through the contents of a data structure, like an array, list etc
//    examplesOfLoopingOverAList(items);


    /**
     Another use of a loop is to keep the thread the loop is in from never stopping
     Examples,
     1. can be some engine ie accepting commands from commnad line, and restarting the game,
     and breaking out of the loop when the command inputed meets some criteria ie "exit"
     see https://youtu.be/gQb3dE-y1S4?t=915
     2. Http server, this is an infinite loop behind lots of code, this is always waiting for http requests
     and when a method on the server(which is just an object) is called (ie "server.stop()") or the program crashes the loop exits and
     cannot accept any more requests
     3. Streamed input. Think kafka, http2, reactive programming
    */

    // Example of while loop
    exampleOfInfiniteWhileLoop();

    // Example of for loop, same as while loop
    exampleOfInfiniteForLoop();

    // The above can be condensed to another for loop
    exampleOfInfiniteForLoop2();


    // The following examples, are for infinite loops, with missing parts, they all produce the same output
    // Example of infinite loop with missing first section
    exampleOfInfiniteForLoopWithMissingFirstSection();
    // Example of infinite loop with missing middle section
    exampleOfInfiniteForLoopWithMissingSecondSection();
    // Example of infinite loop with missing middle section
    exampleOfInfiniteForLoopWithMissingLastSection();

  }

  private static void exampleOfInfiniteForLoopWithMissingLastSection() {
    System.out.println("\nan infinite for loop with missing last section");
    for (int k = 1 ; true ;) {
      // can still have a missing last condition, as long as it is set at the end of the loop
      // or before the continue. Thus variable increments, and can reach the break statement
      int loopNumber = k; // just for example
      System.out.println("Loop number: " + loopNumber + " hello " + k);
      if (k % 2 == 0) { // check if even number
        System.out.println("Loop number: " + loopNumber + " hello even after increment " + k);
        System.out.println();
        k++;
        continue; // skips the current loop, and goes to next loop
      }
      if (k == 11){ // Needs this overwise will continue
        break;
      }
      k++;
      System.out.println();
    }
  }

  private static void exampleOfInfiniteForLoopWithMissingFirstSection() {
    System.out.println("\nan infinite for loop with missing first section");
    int k = 1;
    for ( ; true ; k++) {
      // can still have a missing first condition, as long as it is set out side the loop
      int loopNumber = k; // just for example
      System.out.println("Loop number: " + loopNumber + " hello " + k);
      if (k % 2 == 0) { // check if even number
        System.out.println("Loop number: " + loopNumber + " hello even after increment " + k);
        System.out.println();
        continue; // skips the current loop, and goes to next loop
      }
      if (k == 11){ // Needs this overwise will continue
        break;
      }
      System.out.println();
    }
  }

  private static void exampleOfInfiniteForLoopWithMissingSecondSection() {
    System.out.println("\nan infinite for loop with missing middle section");
    for (int k = 1; ; k++) {
      // can still have a missing second section, as it defaults to true
      int loopNumber = k; // just for example
      System.out.println("Loop number: " + loopNumber + " hello " + k);
      if (k % 2 == 0) { // check if even number
        System.out.println("Loop number: " + loopNumber + " hello even after increment " + k);
        System.out.println();
        continue; // skips the current loop, and goes to next loop
      }
      if (k == 11){ // Needs this overwise will continue
        break;
      }
      System.out.println();
    }
  }

  private static void exampleOfInfiniteForLoop2() {
    System.out.println("\na better infinite for loop");
    for (int k = 1; true ; k++) {
      // As the increment happens in the for loop, and thus at the end of each loop
      // The internals of the loop block, will be different to the other inifinite loops
      int loopNumber = k; // just for example
      System.out.println("Loop number: " + loopNumber + " hello " + k);
      if (k % 2 == 0) { // check if even number
        System.out.println("Loop number: " + loopNumber + " hello even after increment " + k);
        System.out.println();
        continue; // skips the current loop, and goes to next loop
      }
      if (k == 11){ // Needs this overwise will continue
        break;
      }
      System.out.println();
    }
  }

  private static void exampleOfInfiniteForLoop() {
    System.out.println("\ninfinite for loop");
    int j = 1;
    for (;;) { // same a s while(true) {...}
      int loopNumber = j;
      System.out.println("Loop number: " + loopNumber + " hello " + j);
      if (j % 2 == 0) { // check if even number
        System.out.println("Loop number: " + loopNumber + " hello even after increment " + j);
        System.out.println();
        j++; // need this otherwise will be stuck on the initial value of the variable, 1
        continue; // skips the current loop, and goes to next loop
      }
      if (j == 11){ // Needs this overwise will continue
        break;
      }
      System.out.println();
      j++; // need this otherwise will be stuck on the initial value of the variable, 1
    }
  }

  private static void exampleOfInfiniteWhileLoop() {
    System.out.println("\ninfinite while loop");
    int i = 1;
    while(true) {
      int loopNumber = i;
      System.out.println("Loop number: " + loopNumber + " hello " + i);
      if (i % 2 == 0) { // check if even number
        System.out.println("Loop number: " + loopNumber + " hello even after increment " + i);
        System.out.println();
        i++; // need this otherwise will be stuck on the initial value of the variable, 1
        continue; // skips the current loop, and goes to next loop
      }
      if (i == 11){ // Needs this overwise will continue
        break;
      }
      System.out.println();
      i++; // need this otherwise will be stuck on the initial value of the variable, 1
    }
  }

  private static void examplesOfLoopingOverAList(List<String> items) {
    // Old school way was to use for loops:
    //  Not very good, can grow complex, hard to read and understand, has temp variables (i)
    System.out.println("\nOld For Loop");
    for (int i = 0; i <items.size(); i++) { // Your ide should give you hint to change
      String item = items.get(i);
      System.out.println("item = " + item);
    }
    // This way is very old school and should not be used, instead use
    // easier to read, maintain
    System.out.println("\nnew For Loop");
    for(String item : items) {
      System.out.println("item = " + item);
    }

    // There is an even older way of looping/iterating, which the above new for loop does under the hood
    System.out.println("\nUsing iterator pattern with for loop");
    //This works as List implements Iterator. Iterator is a design pattern, that allows us to iterate over data structure despite whether its a list or tree etc
    // You still use this way of iterating, especailly with jdbc(sql) results from 'Select'
    for (Iterator<String> itemsIterator = items.iterator(); itemsIterator.hasNext(); ) {// Your ide should give you hint to change
      String item = itemsIterator.next();
      System.out.println("item = " + item);
    }

    // OR using a while loop
    System.out.println("\nUsing iterator pattern with while loop");
    Iterator<String> itemsIterator = items.iterator();

    while(itemsIterator.hasNext()) {
      System.out.println("item = " + itemsIterator.next());
    }

    // Here is another way of way using a while loop, very similar to old for loop,
    // but harder to understand and should be avoided
    System.out.println("\nUsing while loop");
    int i = 0;
    while (i < items.size()) {
      System.out.println(items.get(i));
      i++;
    }
  }
}
