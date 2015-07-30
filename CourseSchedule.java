/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //process prerequ to a hashmap for faster lookup
        if(prerequisites ==null || prerequisites.length ==0 || prerequisites[0].length == 0){
            return true;
        }
        Map<Integer,List<Integer>> pre = processPrereq(prerequisites);
        Set<Integer> visited = new HashSet<Integer>();//can be reused for each noLoop call, because all values will be cleared up at the end
        Set<Integer> qualified = new HashSet<Integer>();//for nodes that already checked and qualified, add in so will skip it next time..drastically improve time efficiency
        for(int i=0; i<numCourses; i++){//have to do it in loop because 0 may not lead to all branches, and qualified set will always help to skip
            if(!noLoop(i,pre,visited,qualified)){
                return false;
            }
        } 
        return true;
        
    }
    public boolean noLoop(int current,Map<Integer,List<Integer>> pre,Set<Integer> visited,Set<Integer> qualified){
        if(!pre.containsKey(current) || qualified.contains(current)){
            return true;
        }
        List<Integer> prereq = pre.get(current);
        visited.add(current);
        for(Integer course: prereq){
            if(visited.contains(course)){
                return false;
            }
            boolean result =  noLoop(course,pre,visited,qualified);
            if(!result){
                return false;
            }
        }
        visited.remove(current);
        qualified.add(current);
        return true;
        
    }
    public Map<Integer,List<Integer>> processPrereq(int[][] prerequisites){
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i=0; i<prerequisites.length; i++){
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0],new ArrayList<Integer>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        return map;
    }
}