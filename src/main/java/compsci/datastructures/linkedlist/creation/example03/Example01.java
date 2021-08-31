package compsci.datastructures.linkedlist.creation.example03;

public class Example01 {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.add(1);
    LinkedList list = linkedList.add(2);
    System.out.println("Print: linked list: \t\t" + list);
    System.out.println("size: \t\t\t\t" + list.size());
    
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);

    System.out.println("Print: linked list: \t\t" + linkedList);
    System.out.println("size: \t\t\t\t" + linkedList.size());
  }
}
