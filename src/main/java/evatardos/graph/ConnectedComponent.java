package evatardos.graph;

import java.util.*;

public class ConnectedComponent {
    public static List<List<Vertex>> findConnectedComponents(Graph graph){
        List<List<Vertex>> components = new LinkedList<>();

        Map<Vertex, List<Vertex>> adjList = graph.getAdjList();
        Set<Vertex> visited = new HashSet<>();

        for(Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()){
            Vertex vertex = entry.getKey();

            if(!visited.contains(vertex)){
                List<Vertex> result = BFS.run(graph, vertex);
                visited.addAll(result);
                components.add(result);
            }

        }

        return components;
    }
}
