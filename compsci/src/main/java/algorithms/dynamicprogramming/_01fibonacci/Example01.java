package algorithms.dynamicprogramming._01fibonacci;

// This is non DP solution, just a simple recursive solution
public class Example01 {

  public int calculateFibonacci(int n) {
    if (n < 2)
      return n;
    return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    // Time complexity  = O(2^n) because of two recursions
    //    In fact as the number of calls in calculateFibonacci(n - 2) is always less than calculateFibonacci(n - 1)
    //    thus O(2^n) is an upper bound. Still exponential
    // Space complexity = O(n)
  }

  public static void main(String[] args) {
    Example01 fib = new Example01();
    System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacci(7));
  }
}
