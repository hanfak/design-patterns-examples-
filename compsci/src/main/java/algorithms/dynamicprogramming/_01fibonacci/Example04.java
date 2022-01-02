package algorithms.dynamicprogramming._01fibonacci;

// Bottom-up with Tabulation enhanced
// Tabulation is the opposite of the top-down approach and avoids recursion
//  - opposite of Memoization
//  -
// bottom-up
//        - solving all the related sub-problems first
// Aim:
//    - instead filling up an n-dimensional table, can use variables
//    - using results in the table to solve the original problem
public class Example04 {

  public int CalculateFibonacci(int n) {
    if (n == 0) return 0;

    //base cases
    int a = 0;
    int b = 1;

    // Fills the table/array with all values of fibonacci upto value we want (n)
    for (int i = 2; i <= n; i++) {
      int c = a + b;
      a = b;
      b = c;
    }
    // Time complexity  = O(n) - iterating to n
    // Space complexity = O(1) - storing in variable
    return b;
  }

  public static void main(String[] args) {
    Example04 fib = new Example04();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}
