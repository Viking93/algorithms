133. Clone Graph

Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and
a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in
its neighbors.

import java.util.Map;

class Solution{
    private HashMap<Integer, UndirectedGraphNode> visited = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null){
            return node;
        }
        
        else{
            
            if(visited.containsKey(node.label)){
                return visited.get(node.label);
            }
            else{
                UndirectedGraphNode start = new UndirectedGraphNode(node.label);
                visited.put(node.label, start);
                
                List<UndirectedGraphNode> neighbours = new ArrayList<UndirectedGraphNode>();

                for(UndirectedGraphNode v : node.neighbors){                    
                    neighbours.add(cloneGraph(v));
                }

                start.neighbors = neighbours;

                return start;
            }
        }

        
    }
}
