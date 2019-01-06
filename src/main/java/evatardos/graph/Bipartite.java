package evatardos.graph;

import java.util.*;

public class Bipartite {
    public static boolean isBiPartite(Graph graph){
        Map<Vertex, List<Vertex>> adjList = graph.getAdjList();
        Map.Entry<Vertex, List<Vertex>> entry = adjList.entrySet().iterator().next();
        Vertex src = entry.getKey();

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        Map<Vertex, Color> colors = new HashMap<>();

        queue.add(src);
        colors.put(src, Color.RED);

        while (!queue.isEmpty()){
            Vertex top = queue.peek();
            queue.remove();

            if(!visited.contains(top)){
                visited.add(top);

                for (Vertex u : adjList.get(top)){
                    if(!visited.contains(u)){
                        queue.add(u);
                        colors.put(u, colors.get(top).toggle());

                    }
                    else {
                        if(colors.get(top).equals(colors.get(u))){
                            return false;
                        }
                    }
                }
            }


        }

        return true;
    }

    enum Color{
        RED, BLUE;

        Color toggle(){
            if(this.equals(BLUE)){
                return RED;
            }
            else {
                return BLUE;
            }
        }
    }
}
