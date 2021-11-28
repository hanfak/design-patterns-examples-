package designpatterns.gangoffour.visitor.example1;

public interface ItemElement {
  int accept(ShoppingCartVisitor visitor);
}
