/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
*/

public class Solution {
    //interger courses makes it easier, we can just use an array of int, and do + - to record if incoming node, other wise, will have to use list and check list
    //when graph and tangle together, think about giving orders, what's eligible? level 0 
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = generateMap(prerequisites);
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int [] incoming = new int [numCourses];
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<prerequisites.length; i++){
            incoming[prerequisites[i][1]]++;
        }
        for(int i=0; i<incoming.length; i++){
            //no incoming , no outgoing
            if(incoming[i]==0 && !map.containsKey(i)){
                result.add(i);
            }else if(incoming[i]==0){
                //no incoming, but has outgoing, level 0, add to queue
                queue.addLast(i);
            }
        }
        while(!queue.isEmpty()){
            int current = queue.removeFirst();
            result.add(current);
            if(map.containsKey(current)){
                List<Integer> outgoing = map.get(current);
                for(Integer out: outgoing){
                    incoming[out]--;
                    if(incoming[out]==0){
                        queue.addLast(out);
                    }
                }
            }
            map.remove(current);
        }
        if(result.size()==numCourses){
            return listToArray(result);
        }
        return new int [0];
        
    }
    
    public Map<Integer, List<Integer>> generateMap(int [][] pre){
        Map<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i=0; i<pre.length; i++){
            if(!map.containsKey(pre[i][0])){
                map.put(pre[i][0],new ArrayList<Integer>());
            }
            map.get(pre[i][0]).add(pre[i][1]);
        }
        return map;
        
    }
    public int [] listToArray(List<Integer> result){
        int [] array = new int [result.size()];
        for(int i=0; i<array.length; i++){
            array[array.length-i-1] = result.get(i);
        }
        return array;
    }
}