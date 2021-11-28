package compsci.algorithms.dynamicprogramming._01fibonacci;

// Top down and memoization
// Aim:
//   - solve the bigger problem by recursively finding the solution to smaller sub-problems
//   - Whenever we solve a sub-problem, we cache its result, so not repeat calculation
// It is the same as recursive solution, but we just store the results as we calculate them
// we solve the top problem first (which typically recurses down to solve the sub-problems)
public class Example02 {

  public int calculateFibonacci(int n) {
    int[] cache = new int[n + 1];
    return calculateFibonacciRecursive(cache, n);
    // Time complexity  = O(n) - we dont repeat calculations
    // Space complexity = O(n)
  }

  public int calculateFibonacciRecursive(int[] cache, int n) {
    if (n < 2)
      return n;

    // if we have already solved this subproblem, simply return the result from the cache
    if (cache[n] != 0)
      return cache[n];

    cache[n] = calculateFibonacciRecursive(cache, n - 1) + calculateFibonacciRecursive(cache, n - 2);
    return cache[n];
  }

  public static void main(String[] args) {
    Example02 fib = new Example02();
    System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacci(7));
  }
}
