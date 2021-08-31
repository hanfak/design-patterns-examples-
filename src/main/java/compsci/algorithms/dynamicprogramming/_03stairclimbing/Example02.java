package compsci.algorithms.dynamicprogramming._03stairclimbing;

// top down
public class Example02 {
  public int minSteps(int[] arr, int n) {
    if (n == 0)
      return 0;
    if (n == 1 || n == 2 || n == 3)
      return 1;

    if (arr[n] == 0) {
      arr[n] = 1 + Math.min(
          Math.min(minSteps(arr, n - 1), minSteps(arr, n - 2)),
          minSteps(arr, n - 3));
    }

    return arr[n];
  }

  public static void main(String[] args) {
    Example02 example02 = new Example02();
    int n = 5000;
    int[] arr = new int[n + 1];

    System.out.println(example02.minSteps(arr, n));
  }
}
