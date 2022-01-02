package algorithms.dynamicprogramming._02stairclimbing;

// bottom down DP without array
public class Example04 {
  public int execute(int n) {
    return totalWaysToReachNthStair(n);
  }

  public int totalWaysToReachNthStair(int n) {
    int d = 0;

    int a = 1;
    int b = 1;
    int c = 2;

    for (int i = 3; i <= n; i++) {
      d = a + b + c;
      a = b;
      b = c;
      c = d;
    }

    return d;
    // Time complexity  = O(n)
    // Space complexity = O(n)
  }

  public static void main(String[] args) {
    Example04 example = new Example04();
    System.out.println("3 stairs is ---> " + example.execute(3));
    System.out.println("4 stairs is ---> " + example.execute(4));
    System.out.println("5 stairs is ---> " + example.execute(5));
  }
}
