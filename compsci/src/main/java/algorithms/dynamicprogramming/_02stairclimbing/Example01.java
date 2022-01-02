package algorithms.dynamicprogramming._02stairclimbing;

// Basic recusive formula
public class Example01 {
  public int totalWaysToReachNthStair(int n) {
    if (n == 0)
      return 1;
    if (n == 1)
      return 1;
    if (n == 2)
      return 2;

    return totalWaysToReachNthStair(n - 1)
        + totalWaysToReachNthStair(n - 2)
        + totalWaysToReachNthStair(n - 3);
    // Time complexity  = O(3^n) because of two recursions
    // Space complexity = O(n)
  }

  public static void main(String[] args) {
    Example01 example = new Example01();
    System.out.println("3 stairs is ---> " + example.totalWaysToReachNthStair(3));
    System.out.println("4 stairs is ---> " + example.totalWaysToReachNthStair(4));
    System.out.println("5 stairs is ---> " + example.totalWaysToReachNthStair(5));
  }
}
