package compsci.algorithms.dynamicprogramming._03stairclimbing;

// Bottom up improved
public class Example04 {
  public int minSteps(int n) {
    int a = 0;
    int b = 1;
    int c = 1;
    int d;

    for (int i = 3; i <= n; i++) {
      d = 1 + Math.min(Math.min(a, b), c);

      a = b;
      b = c;
      c = d;
    }

    return c;
  }

  public static void main(String[] args) {
    Example04 example02 = new Example04();
    int n = 2_000_000_000;

    System.out.println(example02.minSteps(n));
  }
}
