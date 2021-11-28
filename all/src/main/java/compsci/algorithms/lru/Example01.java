package compsci.algorithms.lru;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Example01 {
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(4);

    cache.set(10, 50);
    cache.print();

    cache.set(15, 25);
    cache.print();

    cache.set(20, 30);
    cache.print();

    cache.set(25, 35);
    cache.print();

    cache.set(20, 30);
    cache.print();

    cache.set(40, 50);
    cache.print();

    cache.set(25, 35);
    cache.print();

    cache.set(50, 10);
    cache.print();
  }
}

class LRUCache {
  int capacity;

  //LinkedListNode holds key and value pairs
  Set<Integer> cache;
  LinkedList<LinkedListNode> cache_vals;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashSet<>(capacity);
    cache_vals = new LinkedList<>();
  }

  LinkedListNode get(int key) {
    if (cache.contains(key)) {

      ListIterator<LinkedListNode> iterator1 = cache_vals.listIterator(0);
      while (iterator1.hasNext()) {
        LinkedListNode node = iterator1.next();
        if (node.key == key) {
          return node;
        }
      }
    }
    return null;
  }

  void set(int key, int value) {
    LinkedListNode node = get(key);

    if (node == null) {
      evict_if_needed();
      node = new LinkedListNode(key, value);
      cache_vals.addLast(node);
      cache.add(key);
    } else {
      cache_vals.remove(node);
      cache_vals.addLast(node);
    }
  }

  void evict_if_needed() {
    if (cache_vals.size() >= capacity) {
      LinkedListNode node = cache_vals.remove();
      cache.remove(node.key);
    }
  }

  void print() {
//    ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
//    while(iterator.hasNext()){
//      LinkedListNode node = iterator.next();
//      System.out.print(node.key + ":" +node.data + ", ");
//    }
//    System.out.println("");

    String collect = cache_vals.stream()
        .map(node -> node.key + ":" + node.data + ", ")
        .collect(joining());
    System.out.println(collect);
  }
}

class LinkedListNode {

  public int key;
  public int data;
  public LinkedListNode next;
  public LinkedListNode arbitrary_pointer;

  public LinkedListNode(int data) {
    this.data = data;
    this.next = null;
  }

  public LinkedListNode(int key, int data) {
    this.key = key;
    this.data = data;
    this.next = null;
  }

  public LinkedListNode(int data, LinkedListNode next) {
    this.data = data;
    this.next = next;
  }

  public LinkedListNode(int data, LinkedListNode next, LinkedListNode arbitrary_pointer) {
    this.data = data;
    this.next = next;
    this.arbitrary_pointer = arbitrary_pointer;
  }
}

