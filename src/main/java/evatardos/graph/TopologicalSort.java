package evatardos.graph;

import java.util.*;

public class TopologicalSort {
    public static List<Vertex> topologicalSort(Graph graph){
        List<Vertex> topologicalOrdering = new LinkedList<>();
        Map<Vertex, List<Vertex>> adjList = graph.getAdjList();
        List<Vertex> vertices = new LinkedList<>(adjList.keySet());
        Map<Vertex, STATE> visited = new HashMap<>();
        Stack<Vertex> stack = new Stack<>();

        for (Vertex vertex : vertices){
            visited.put(vertex, STATE.UNSEEN);
        }

        for(Vertex vertex : vertices){
            if(visited.get(vertex) == STATE.UNSEEN){

                stack.push(vertex);

                while (!stack.empty()){
                    Vertex top = stack.peek();

                    if(visited.get(top) == STATE.UNSEEN){
                        visited.put(top, STATE.SEEN);
                        int verticesPushed = 0;

                        for (Vertex u : adjList.get(top)){
                            if(visited.get(u) == STATE.UNSEEN){
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

    enum STATE{
        SEEN,
        UNSEEN
    }
}
