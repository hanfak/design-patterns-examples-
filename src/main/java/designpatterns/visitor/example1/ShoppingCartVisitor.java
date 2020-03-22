package designpatterns.visitor.example1;

public interface ShoppingCartVisitor {
  int visit(Book book);
  int visit(Fruit fruit);
}
