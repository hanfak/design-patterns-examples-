package compsci.algorithms.dynamicprogramming._03stairclimbing;

// recusive
public class Example01 {
  public int minSteps(int n) {
    if (n == 0)
      return 0;
    if (n == 1 || n == 2 || n == 3)
      return 1;

    return 1 + Math.min(
        Math.min(minSteps(n - 1), minSteps(n - 2)),
        minSteps(n - 3));
  }

  public static void main(String[] args) {
    Example01 example01 = new Example01();
    System.out.println(example01.minSteps(7));
  }
}
