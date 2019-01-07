package evatardos.graph;

import java.util.*;

/**
 * Finding cycle makes sense only in a directed graph.
 */
public class Cycle  {

    public static boolean detectCycleConnected(Graph graph, Map<Vertex, STATE> vertexStateInfo, Vertex src){
        Map<Vertex, List<Vertex>> adjList = graph.getAdjList();
        Stack<Vertex> stack = new Stack<>();

        stack.push(src);

        while (!stack.empty()){
            Vertex parent = stack.pop();

            if(vertexStateInfo.get(parent) == STATE.UNSEEN){
                vertexStateInfo.put(parent, STATE.SEEN);

                for (Vertex child : adjList.get(parent)){
                    if(vertexStateInfo.get(child) == STATE.UNSEEN){
                        stack.push(child);
                    }
                    else {
                        if((vertexStateInfo.get(child) == vertexStateInfo.get(parent)) && vertexStateInfo.get(parent) == STATE.SEEN){
                            return true;
                        }
                    }
                }

                if(adjList.get(parent).size() == 0){
                    vertexStateInfo.put(parent, STATE.PROCESSED);
                }
            }

        }

        return false;
    }

    public static boolean isCyclePresent(Graph graph){
        Map<Vertex, STATE> vertexStateInfo = new HashMap<>();
        Map<Vertex, List<Vertex>> adjList = graph.getAdjList();

        for(Vertex vertex : adjList.keySet()){
            vertexStateInfo.put(vertex, STATE.UNSEEN);
        }

        //for graoh having more than one connected components
        for(Vertex vertex : adjList.keySet()){
            if(detectCycleConnected(graph, vertexStateInfo, vertex)){
                return true;
            }
        }

        return false;
    }

    enum STATE{
        SEEN,
        UNSEEN,
        PROCESSED
    }
}
