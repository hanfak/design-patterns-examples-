package compsci.datastructures.graph.example02;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Graph<T> {

  // We use Hashmap to store the edges in the graph
  private Map<T, List<T>> map = new HashMap<>();

  // This function adds a new vertex to the graph
  private void addVertex(T vertex) {
    map.put(vertex, new LinkedList<T>());
  }

  // This function adds the edge
  // between source to destination
  void addEdge(T source,
               T destination,
               boolean bidirectional) {

    if (!map.containsKey(source))
      addVertex(source);

    if (!map.containsKey(destination))
      addVertex(destination);

    map.get(source).add(destination);
    if (bidirectional) {
      map.get(destination).add(source);
    }
  }

  // This function gives the count of vertices
  void getVertexCount() {
    System.out.println("The graph has "
            + map.keySet().size()
            + " vertex");
  }

  // This function gives the count of edges
  void getEdgesCount(boolean bidirection) {
    int count = 0;
    for (T v : map.keySet()) {
      count += map.get(v).size();
    }
    if (bidirection) {
      count = count / 2;
    }
    System.out.println("The graph has "
            + count
            + " edges.");
  }

  // This function gives whether
  // a vertex is present or not.
  void hasVertex(T vertex) {
    if (map.containsKey(vertex)) {
      System.out.println("The graph contains "
              + vertex + " as a vertex.");
    } else {
      System.out.println("The graph does not contain "
              + vertex + " as a vertex.");
    }
  }

  // This function gives whether an edge is present or not.
  void hasEdge(T sourceVertex, T destinationVertex) {
    if (map.get(sourceVertex).contains(destinationVertex)) {
      System.out.println("The graph has an edge between "
              + sourceVertex + " and " + destinationVertex + ".");
    } else {
      System.out.println("The graph has no edge between "
              + sourceVertex + " and " + destinationVertex + ".");
    }
  }

  // Prints the adjancency list of each vertex.
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (T vertex : map.keySet()) {
      builder.append(vertex.toString() + ": ");
      for (T w : map.get(vertex)) {
        builder.append(w.toString() + " ");
      }
      builder.append("\n");
    }

    return (builder.toString());
  }
}
