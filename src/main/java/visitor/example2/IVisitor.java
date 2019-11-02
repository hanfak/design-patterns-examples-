package visitor.example2;

public interface IVisitor {
  void visit(Book book);
  void visit(Car car);
  void visit(Wine wine);
}
