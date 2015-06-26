/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    //DON'T FORGET TO MOVE FORWARD POINTERS!!!!
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows<=0){
            return result;
        }
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        result.add(list1);
        int current = 1;
        List<Integer> beforeList = list1;
        while(current<numRows){
            List<Integer> newLevel = generateOneLevel(beforeList);
            result.add(newLevel);
            beforeList = newLevel;
            current++;
        }
        return result;
    }
    public List<Integer> generateOneLevel(List<Integer> before){
        List<Integer> level = new ArrayList<Integer>();
        level.add(1);
        int length = before.size();
        int pointer1 = 0;
        int pointer2 = 1;
        while(pointer1 <length && pointer2<length){
            level.add(before.get(pointer1)+before.get(pointer2));
            pointer1++;
            pointer2++;
        }
        level.add(1);
        return level;
    }
}