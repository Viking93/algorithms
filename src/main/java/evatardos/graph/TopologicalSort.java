package evatardos.graph;

import java.util.*;

public class TopologicalSort {
    public static List<Vertex> topologicalSort(Graph graph){
        List<Vertex> topologicalOrdering = new LinkedList<>();
        Map<Vertex, List<Vertex>> adjList = graph.getAdjList();
        List<Vertex> vertices = new LinkedList<>(adjList.keySet());
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();

        for(Vertex vertex : vertices){
            if(!visited.contains(vertex)){

                stack.push(vertex);

                while (!stack.empty()){
                    Vertex top = stack.peek();

                    if(!visited.contains(top)){
                        visited.add(top);
                        int verticesPushed = 0;

                        for (Vertex u : adjList.get(top)){
                            if(!visited.contains(u)){
                                stack.push(u);
                                verticesPushed++;
                            }
                        }

                        if(verticesPushed == 0){
                            topologicalOrdering.add(top);
                            stack.pop();
                        }
                    }
                    else {
                        topologicalOrdering.add(stack.pop());
                    }
                }


            }
        }

        return topologicalOrdering;
    }
}
