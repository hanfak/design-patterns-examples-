package datastructures.graph.example02;

public class Runner {

  public static void main(String args[]) {

    // Object of graph is created.
    Graph<Integer> g = new Graph<>();

    // edges are added.
    // Since the graph is bidirectional,
    // so boolean bidirectional is passed as true.
    g.addEdge(0, 1, true);
    g.addEdge(0, 4, true);
    g.addEdge(1, 2, false);
    g.addEdge(1, 3, true);
    g.addEdge(1, 4, true);
    g.addEdge(2, 3, true);
    g.addEdge(3, 4, true);

    // print the graph.
    System.out.println("Graph:\n"
            + g.toString());

    // gives the no of vertices in the graph.
    g.getVertexCount();

    // gives the no of edges in the graph.
    g.getEdgesCount(true);

    // tells whether the edge is present or not.
    g.hasEdge(3, 4);

    // tells whether vertex is present or not
    g.hasVertex(5);
  }
}

