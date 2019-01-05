package evatardos.graph;

import java.util.*;

public class Graph {
    private List<Vertex> vertices;
    private Map<Vertex, List<Vertex>> adjList = new HashMap<>();

    public Graph(List<Vertex> vertices, List<Edge> edges){
        this.vertices = vertices;

        for (Vertex vertex : vertices){
            adjList.put(vertex, new LinkedList<>());
        }

        for(Edge edge : edges){
            Vertex src = edge.getSrc();
            Vertex dst = edge.getDst();

            List<Vertex> srcList = adjList.get(src);
            List<Vertex> dstList = adjList.get(dst);

            srcList.add(dst);
            dstList.add(src);
        }
    }

    public void display(){
        for (Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()){
            System.out.println("Vertex : " + entry.getKey().getId());

            for (Vertex vertex : entry.getValue()){
                System.out.print("->"+vertex.getId());
            }
        }
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Map<Vertex, List<Vertex>> getAdjList() {
        return adjList;
    }

    public void setAdjList(Map<Vertex, List<Vertex>> adjList) {
        this.adjList = adjList;
    }
}
