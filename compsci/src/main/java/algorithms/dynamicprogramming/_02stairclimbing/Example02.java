package algorithms.dynamicprogramming._02stairclimbing;

// Top down DP
public class Example02 {
  public int execute(int n) {
    int[] cache = new int[n + 1];
    return totalWaysToReachNthStair(cache, n);
  }

  public int totalWaysToReachNthStair(int[] cache, int n) {
    if (n == 0)
      return 1;
    if (n == 1)
      return 1;
    if (n == 2)
      return 2;

    if (cache[n] == 0 ){
      cache[n] = totalWaysToReachNthStair(cache, n - 1)
          + totalWaysToReachNthStair(cache, n - 2)
          + totalWaysToReachNthStair(cache, n - 3);
    }
    return cache[n];
    // Time complexity  = O(n)
    // Space complexity = O(n)
  }

  public static void main(String[] args) {
    Example02 example = new Example02();
    System.out.println("3 stairs is ---> " + example.execute(3));
    System.out.println("4 stairs is ---> " + example.execute(4));
    System.out.println("5 stairs is ---> " + example.execute(5));
  }
}
