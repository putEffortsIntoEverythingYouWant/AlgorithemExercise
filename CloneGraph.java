/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /*
    copy linkedList - pointer
    copy tree - recursion with return of copy node
    linkedList with another random pointer: make copy of each then seperate two lists
    copy graph:
        - linkedlist/queue and visited set for breath first search
        -hashmap to store original node and copy node
    */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Map<UndirectedGraphNode,UndirectedGraphNode> copyMap = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        if(node==null){return null;}
        queue.add(node);
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        copyMap.put(node,newHead);
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.removeFirst();
            //copy of current must have already exist
            if(!visited.contains(current)){
                  visited.add(current);
                List<UndirectedGraphNode> neighbors = current.neighbors;
                for(UndirectedGraphNode neighbor: neighbors){
                    queue.addLast(neighbor);
                    if(!copyMap.containsKey(neighbor)){
                        copyMap.put(neighbor,new UndirectedGraphNode(neighbor.label));
                    }
                    copyMap.get(current).neighbors.add(copyMap.get(neighbor));
                }
              
            }
            
            
        }
        return newHead;
    }
}