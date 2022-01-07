package enums;

// Strategy pattern with enum
// Better to do it with lambdas
public enum Operation2 {
  ADD {
    @Override
    public int apply(int x, int y) {
      return x + y;
    }
  },
  SUBTRACT{
    @Override
    public int apply(int x, int y) {
      return x - y;
    }
  };

  public abstract int apply(int x, int y);
}
