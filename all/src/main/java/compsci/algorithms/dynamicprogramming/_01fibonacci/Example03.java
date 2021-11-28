package compsci.algorithms.dynamicprogramming._01fibonacci;

// Bottom-up with Tabulation
// Tabulation is the opposite of the top-down approach and avoids recursion
//  - opposite of Memoization
//  -
// bottom-up
//        - solving all the related sub-problems first
// Aim:
//    - filling up an n-dimensional table
//    - using results in the table to solve the original problem
public class Example03 {

  public int CalculateFibonacci(int n) {
    if (n == 0) return 0;
    int[] dp = new int[n + 1];

    //base cases
    dp[0] = 0;
    dp[1] = 1;

    // Fills the table/array with all values of fibonacci upto value we want (n)
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    // Time complexity  = O(n) - iterating to n
    // Space complexity = O(n) - storing in array all values up to needed
    return dp[n];
  }

  public static void main(String[] args) {
    Example03 fib = new Example03();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}
