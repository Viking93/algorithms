package evatardos.graph;

import java.util.*;

public class BFS {
    public static List<Vertex> run(Graph graph, Vertex src){

        Map<Vertex, List<Vertex>> adjList = graph.getAdjList();
        Set<Vertex> discovered = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        List<Vertex> result = new LinkedList<>();

        if(src == null){
            Map.Entry<Vertex, List<Vertex>> entry = adjList.entrySet().iterator().next();
            src = entry.getKey();
        }

        queue.add(src);

        while (!queue.isEmpty()){
            Vertex top = queue.peek();
            queue.remove();

            result.add(top);

            if(!discovered.contains(top)){
                discovered.add(top);

                for (Vertex vertex : adjList.get(top)){
                    if(!discovered.contains(vertex)){
                        queue.add(vertex);
                    }
                }
            }

        }

        return result;
    }
}
