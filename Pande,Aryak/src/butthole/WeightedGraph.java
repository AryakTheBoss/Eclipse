package butthole;
/** @author: Tim Wahls
    @version: 9/14/2012
    purpose: implement a weighted undirected graph using the adjacency
             list representation */

import java.io.*;
import java.util.*;

public class WeightedGraph {
  public static final int DefaultSize = 10;
  private List<Edge>[] edges;      // edges of the graph

  /** post: intialize graph of default size (number of vertices) */
  public WeightedGraph() {
    this(DefaultSize);
  }

  /** post: intialize graph of indicated size
            display error message if size is invalid */
  public WeightedGraph(int size) {
    if (size > 0) {
      edges = new ArrayList [size];
      for (int i = 0; i < size; i++) {
        edges[i] = new ArrayList<Edge>();
      }
    } else {
      System.out.println("Error: invalid number of verticies.");
    }
  }

  /** post: add edge from vertex #v1 to #v2 with the specified weight
            if both vertex numbers are valid */
  public void addEdge(int v1, int v2, double weight) {
    if (v1 == v2) {
      System.out.println("Error: self loops not allowed.");
    } else if (v1 < 0 || v2 < 0 || v1 >= edges.length || v2 >= edges.length) {
      System.out.println("Error: invalid vertex.");
    } else if (hasEdge(v1, v2)) {
      System.out.println("Error: edge already exists.");
    } else {
      edges[v1].add(new Edge(v1, v2, weight));
      edges[v2].add(new Edge(v2, v1, weight));
    }
  }

  /**  @return true iff v1 and v2 are valid and adjacent  */
  public boolean hasEdge(int v1, int v2) {
    return !Double.isInfinite(getWeight(v1, v2));
  }

  /** @return the weight of the edge from v1 to v2, or infinity if
              no such edge exists */
  public double getWeight(int v1, int v2) {
    if (v1 < 0 || v2 < 0 || v1 >= edges.length || v2 >= edges.length) {
      return Double.POSITIVE_INFINITY;
    } else {
      Iterator<Edge> it = getIncidentEdges(v1);
      while (it.hasNext()) {
        Edge e = it.next();
        if (e.getVertex2() == v2) {
          return e.getWeight();
        }
      }
      return Double.POSITIVE_INFINITY;
    }
  }
 
  /** @return an iterator over all edges incident on vertex # vNum */
  public Iterator<Edge> getIncidentEdges(int vNum) {
    if (vNum < 0 || vNum >= edges.length) return null;
    else return edges[vNum].iterator();
  }

  /** @return all information about the graph (edges and weights) in
              a human readable form */
  public String toString() {
    String res = "Edges:\n";
    Iterator<Edge> iter;
    Edge e;
    boolean first;
    for (int i = 0; i < edges.length; i++) {
      res += "  from " + i + " to: [";
      iter = getIncidentEdges(i);
      first = true;
      while (iter.hasNext()) { 
        e = iter.next();
        if (first) first = false;
        else {
          res += ", ";
        }
        res += e.getVertex2() + " weight: " + e.getWeight();
      }
      res += "]\n";
    }
    return res;
  }

  /** post: read the representation of a weighted graph from a file */
  public static WeightedGraph readGraph(String file) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    int size = Integer.parseInt(in.readLine());
    WeightedGraph wg = new WeightedGraph(size);
    if (size > 0) {
      int vNum;
      int vNum2;
      double weight;
      String sval = in.readLine();
      while (sval != null) {
        vNum = Integer.parseInt(sval);
        vNum2 = Integer.parseInt(in.readLine());
        weight = Double.parseDouble(in.readLine());
        wg.addEdge(vNum, vNum2, weight);
        sval = in.readLine();
      }
    }
    in.close();
    return wg;
  }

  /** @return true iff the sequence of vertices is a path in the graph */
  public boolean isAPath(int [] verts) {
    for (int i = 0; i < verts.length - 1; i++) {
      if (!hasEdge(verts[i], verts[i + 1])) {
        return false;
      }
    }
    return true;
  }

  /** @return the total weight of all edges in the path represented by
                  the array verts
              infinity if verts does not represent a path */
  public double totalWeight(int [] verts) {
    double sum = 0;
    for (int i = 0; i < verts.length - 1; i++) {
      sum += getWeight(verts[i], verts[i + 1]);
    }
    return sum;
  }

  public static void main(String argv[]) throws IOException {
/*
    WeightedGraph wg = new WeightedGraph(6);
    wg.addEdge(0, 1, 100);
    wg.addEdge(0, 3, 350);
    wg.addEdge(1, 2, 100);
    wg.addEdge(1, 3, 300);
    wg.addEdge(2, 3, 250);
    wg.addEdge(3, 4, 400);
    wg.addEdge(3, 5, 550);
    wg.addEdge(4, 5, 200);
    System.out.println(wg);
*/
    WeightedGraph wg = readGraph("input.txt");
    System.out.println(wg);
    System.out.println(wg.getWeight(6, 5));
    System.out.println(wg.hasEdge(6, 5));
    System.out.println(wg.getWeight(3, 5));
    System.out.println(wg.hasEdge(3, 5));
    int [] p1 = {0,3,5,4};
    int [] p2 = {0,3,5,6,4};
    System.out.println(wg.isAPath(p1));
    System.out.println(wg.totalWeight(p1));
    System.out.println(wg.isAPath(p2));
    System.out.println(wg.totalWeight(p2));
  }
   
}

