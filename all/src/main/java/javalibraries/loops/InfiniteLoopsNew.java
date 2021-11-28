package javalibraries.loops;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

// Post Java 8
public class InfiniteLoopsNew {

  private static final int DEFAULT_LIMIT = 11;

  public static void main(String... args) {
    List<String> items = List.of("apple", "banana", "carrot", "dog"); //This java 11 way of creating an immutable list

    // Java 8 gave us stream, here are some basic examples
    // See package "functional" for more examples of how to use stream
//    loopingOverArray(items);
    // A case against using forEach but using traditional for loops
    // https://blog.jooq.org/2015/12/08/3-reasons-why-you-shouldnt-replace-your-for-loops-by-stream-foreach/

    // Infinite loops
    // In java 8 world we use streams. We can use infinite streams as they are built lazily
    // Stream.iterate(1, i -> i + 1) is same as for(int i =1; true; i++)
    String output = Stream.iterate(1, i -> i + 1)
            .map(i -> Integer.toString(i)) // Just to be able to collect it
            .limit(10) //It is crucial to use a limit() method before executing a collect() method that is a terminal operation, otherwise our program will run indefinitely:
            .collect(joining(", "));
    System.out.println("output = " + output);


    // another example
    Supplier<UUID> randomUUIDSupplier = UUID::randomUUID;
    Stream<UUID> infiniteStreamOfRandomUUID = Stream.generate(randomUUIDSupplier);
    infiniteStreamOfRandomUUID
            .skip(10)
            .limit(10)
            .forEach(System.out::println);

    // Similar as other infinite loops in InfiniteLoopsOld class
    // This is a style choice of whether to use streams or for/while loops for infinite loops
    example1InfiniteStreams();

    // Using some logic to decide limit ie the break point of the loop
    example2InfiniteStream();

    //using predicate in iterate
    example3InfiniteStream();

    //using takeWhile, same as example3InfiniteStream
    example4InfiniteStream();

  }

  private static void example4InfiniteStream() {
    Stream.iterate(1, i -> i + 1)
            .takeWhile(i -> i != 11)
            .forEach(i -> {
              System.out.println("Loop number: " + i + " hello " + i);
              if (i % 2 == 0) { // check if even number
                System.out.println("Loop number: " + i + " hello even after increment " + i);
              }
              System.out.println();
            });
  }
  private static void example3InfiniteStream() {
    Stream.iterate(1, i -> i != 11, i -> i + 1)
            .forEach(i -> {
              System.out.println("Loop number: " + i + " hello " + i);
              if (i % 2 == 0) { // check if even number
                System.out.println("Loop number: " + i + " hello even after increment " + i);
              }
              System.out.println();
            });
  }

  private static void example1InfiniteStreams() {
    Stream.iterate(1, i -> i + 1)
            .limit(11) // This acts as the break
            .forEach(i -> {
              System.out.println("Loop number: " + i + " hello " + i);
              if (i % 2 == 0) { // check if even number
                System.out.println("Loop number: " + i + " hello even after increment " + i);
                System.out.println();
                // No need for 'continue' as this is last step, but
                // if there were more steps after the if statement,
                // then we could use "return;" here at the end of this block to go to the next element
              }
            });
  }

  private static void example2InfiniteStream() {
    Stream.iterate(1, i -> i + 1)
            .limit(someDeciderToChooseLimitToBreakFromInfiniteStream(DEFAULT_LIMIT))// have tenary op or call a method which has some more logic to determine size
            .forEach(i -> {
              System.out.println("Loop number: " + i + " hello " + i);
              if (i % 2 == 0) { // check if even number
                System.out.println("Loop number: " + i + " hello even after increment " + i);
                System.out.println();
              }
            });
  }

  private static long someDeciderToChooseLimitToBreakFromInfiniteStream(long defaultLimit) {
    // Logic can be complex as necessary
    if (defaultLimit > 11) {
      return defaultLimit * 2 - 1;
    }
    return defaultLimit;
  }

  private static void loopingOverArray(List<String> items) {
    items.forEach(item -> System.out.println("item = " + item));
    // These two are the same
    items.forEach(item -> System.out.println(item));
    items.forEach(System.out::println);
  }
}
