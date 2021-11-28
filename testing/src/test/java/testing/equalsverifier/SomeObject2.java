package testing.equalsverifier;

final class SomeObject2 {
  private final int x;
  private final int y;
  private final int z;

  public SomeObject2(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SomeObject2 that = (SomeObject2) o;

    if (x != that.x) return false;
    return y == that.y;
  }
}
