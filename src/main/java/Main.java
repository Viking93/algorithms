import evatardos.graph.*;

import java.util.List;

public class Main {

    public static void printResult(List<Vertex> result){
        for (Vertex vertex : result){
            System.out.print(vertex.getId() + "->");
        }

        System.out.println("NULL\n");

    }

    public static void main(String[] args){

        printResult(BFS.run(Helper.setupGraph(), Helper.src));
        printResult(DFS.run(Helper.setupGraph(), Helper.src));
        System.out.println(ConnectedComponent.findConnectedComponents(Helper.setupGraph()).size());
        System.out.println(Bipartite.isBiPartite(Helper.setupGraph()));
        System.out.println(Cycle.isCyclePresent(Helper.getDirectedGraph()));
    }
}
