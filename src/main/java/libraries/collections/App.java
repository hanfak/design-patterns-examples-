package libraries.collections;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class App {
  int y;

  public String aMethod(int x) throws Exception {
    throw new Exception();
  }

  public static void main(String[] args) {

    List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
    int size = integerList.size();
//        Integer integer = integerList.get(4);

    List<Integer> anArrayList = new ArrayList<>();
    anArrayList.add(5);
    System.out.println(anArrayList);
    anArrayList.addAll(Arrays.asList(1, 2, 3, 4));
    System.out.println(anArrayList);
    Collections.reverse(anArrayList);
    System.out.println(anArrayList);
    List<Integer> sortedList = anArrayList.stream().sorted().collect(Collectors.toList());
    System.out.println(sortedList);

    List<Integer> sortedReversedOrderList = anArrayList.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
    System.out.println("sortedUsingComparator = " + sortedReversedOrderList);
    anArrayList.contains(2);
    boolean b = anArrayList.containsAll(Arrays.asList(1, 8));
    System.out.println("b = " + b);
    int i = anArrayList.indexOf(3);

    Blah blah1 = new Blah(1);
    Blah blah2 = new Blah(2);
    Blah blah3 = new Blah(3);
    List<Blah> blahList = Arrays.asList(blah2, blah1, blah3);
    Collections.sort(blahList, Comparator.comparingInt(x -> x.id));

    anArrayList.remove(0);
    System.out.println(anArrayList);
    anArrayList.remove(new Integer(5));
    System.out.println(anArrayList);
    anArrayList.set(1, 10);
    System.out.println(anArrayList);

    List<Integer> listThatHasChangedElement = IntStream.range(0, anArrayList.size()).
            mapToObj(replaceElementAtIndex(anArrayList, 1, 4)).
            collect(Collectors.toList());
    System.out.println("listThatHasChangedElement = " + listThatHasChangedElement);

    HashMap<Object, Object> objectObjectHashMap = new HashMap<>();


    List<Integer> anArrayListWithNewElementAtTheEnd = Stream.of(anArrayList, Collections.singletonList(12))
            .flatMap(Collection::stream).collect(Collectors.toList());
    System.out.println("anArrayListWithNewElementAtTheEnd = " + anArrayListWithNewElementAtTheEnd);
    Integer elementToRemove = 1;
    List<Integer> listWithAllOnesRemoved = anArrayListWithNewElementAtTheEnd.stream().filter(elements -> !elements.equals(elementToRemove)).collect(Collectors.toList());
    System.out.println("listWithOneRemoved = " + listWithAllOnesRemoved);


    List<Integer> integers = Arrays.asList(2, 4, 1, 2, 5, 1);
    List<Integer> collect = integers.stream().filter(elements -> !elements.equals(elementToRemove)).collect(Collectors.toList());
    System.out.println("collect = " + collect);

    List<Integer> listWithfirstOneRemoved = IntStream.range(0, integers.size())
            .filter(currentIndex -> currentIndex != integers.indexOf(elementToRemove))
            .mapToObj(integers::get)
            .collect(Collectors.toList());
    System.out.println("collect1 = " + listWithfirstOneRemoved);

//        IntStream.range(0, integers.size() - 1).filter(index -> index !=integers.indexOf(1)).collect(Collectors.toList())
  }

  private static IntFunction<Integer> replaceElementAtIndex(List<Integer> anArrayList, int indexOfElementToReplace, int replacementElement) {
    return index -> index == indexOfElementToReplace ? replacementElement : anArrayList.get(index);
  }
}

class Blah {
  public final Integer id;

  Blah(Integer id) {
    this.id = id;
  }
}

