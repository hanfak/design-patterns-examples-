package gangoffour.visitor.example2;

abstract class Product implements Visitable {
  public abstract void accept(IVisitor visitor);
}
