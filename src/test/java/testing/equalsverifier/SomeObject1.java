package testing.equalsverifier;

final class SomeObject1 {
  private final int x;
  private final int y;
  private final int z;

  public SomeObject1(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SomeObject1 that = (SomeObject1) o;

    if (x != that.x) return false;
    return y == that.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}
