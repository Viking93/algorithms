package evatardos.graph;

import java.util.LinkedList;
import java.util.List;

public class Helper {
    public static Vertex src;
    public static List<Vertex> vertices;
    public static List<Edge> edges;

    public static Graph setupGraph(){
        //Make Vertices

        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");
        Vertex<String> d = new Vertex<>("d");
        Vertex<String> e = new Vertex<>("e");
        Vertex<String> f = new Vertex<>("f");
//        Vertex<String> g = new Vertex<>("g");
//        Vertex<String> h = new Vertex<>("h");
//        Vertex<String> i = new Vertex<>("i");
//        Vertex<String> j = new Vertex<>("j");

        List<Vertex> vertices = new LinkedList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
//        vertices.add(g);
//        vertices.add(h);
//        vertices.add(i);
//        vertices.add(j);

        Helper.vertices = vertices;

        //Edges

        Edge e1 = new Edge(a, b);
        Edge e2 = new Edge(a, d);
        Edge e3 = new Edge(b, c);
        Edge e4 = new Edge(b, e);
        Edge e5 = new Edge(d, f);
        Edge e6 = new Edge(e, f);
//        Edge e7 = new Edge(g, i);

        List<Edge> edges = new LinkedList<>();
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);
        edges.add(e6);
//        edges.add(e7);

        Helper.edges = edges;

        Graph graph = new Graph(vertices, edges, false);
        src = a;

        return graph;
    }

    public static Graph getDirectedGraph(){
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");
        Vertex<String> d = new Vertex<>("d");

        List<Vertex> vertices = new LinkedList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);

        Edge e1 = new Edge(a, b);
        Edge e2 = new Edge(d, a);
        Edge e3 = new Edge(b, c);
        Edge e4 = new Edge(c, d);

        List<Edge> edges = new LinkedList<>();
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);

        Graph graph = new Graph(vertices, edges, true);
        return graph;
    }

    public static Graph getDirectedGraphForTopologicalSort(){
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");
        Vertex<String> d = new Vertex<>("d");
        Vertex<String> e = new Vertex<>("e");
        Vertex<String> f = new Vertex<>("f");

        List<Vertex> vertices = new LinkedList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);

        Edge e1 = new Edge(b, a);
        Edge e2 = new Edge(d, b);
        Edge e3 = new Edge(c, a);
        Edge e4 = new Edge(f, d);
        Edge e5 = new Edge(f, e);
        Edge e6 = new Edge(e, c);
        Edge e7 = new Edge(e, b);

        List<Edge> edges = new LinkedList<>();
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);
        edges.add(e6);
        edges.add(e7);

        Graph graph = new Graph(vertices, edges, true);
        return graph;
    }
}
