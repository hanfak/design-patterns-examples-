package algorithms.dynamicprogramming._03stairclimbing;

// Bottom up
public class Example03 {
  public int minSteps(int n) {
    int[] f = new int[n + 1];

    f[0] = 0;
    f[1] = 1;
    f[2] = 1;

    for(int i = 3; i <= n; i++) {
      f[i] = 1 + Math.min(Math.min(f[i - 1], f[i - 2]), f[i - 3]);
    }

    return f[n];
  }

  public static void main(String[] args) {
    Example03 example02 = new Example03();
    int n = 50000000;

    System.out.println(example02.minSteps(n));
  }
}
