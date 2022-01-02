package algorithms.dynamicprogramming._02stairclimbing;

// bottom down DP
public class Example03 {
  public int execute(int n) {
    return totalWaysToReachNthStair( n);
  }

  public int totalWaysToReachNthStair(int n) {
    int[] f = new int[n + 1];

    f[0] = 1;
    f[1] = 1;
    f[2] = 2;

    for(int i = 3; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2] + f[i -3];
    }

    return f[n];
    // Time complexity  = O(n)
    // Space complexity = O(n)
  }

  public static void main(String[] args) {
    Example03 example = new Example03();
    System.out.println("3 stairs is ---> " + example.execute(3));
    System.out.println("4 stairs is ---> " + example.execute(4));
    System.out.println("5 stairs is ---> " + example.execute(5));
  }
}
