package evatardos.graph;

import java.util.*;

public class DFS {
    public static List<Vertex> run(Graph graph, Vertex src){

        Map<Vertex, List<Vertex>> adjList = graph.getAdjList();
        List<Vertex> result = new LinkedList<>();
        Set<Vertex> discovered = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();

        if(src == null){
            Map.Entry<Vertex, List<Vertex>> entry = adjList.entrySet().iterator().next();
            src = entry.getKey();
        }

        stack.push(src);

        while(!stack.empty()){
            Vertex top = stack.pop();

            result.add(top);

            if(!discovered.contains(top)){
                discovered.add(top);

                for (Vertex vertex : adjList.get(top)){
                    if(!discovered.contains(vertex)){
                        stack.push(vertex);
                    }
                }
            }

        }

        return result;
    }
}
