/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Hide Tags
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points ==null || points.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Map<Float,Integer> numbers = new HashMap<Float,Integer>();
        for(int i=0; i<points.length; i++){
            
            int dup = 1;//element itself
            for(int j=i+1;j<points.length; j++){
                //calculate float
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    dup++;
                }else if(points[i].x == points[j].x){
                    updateValue(numbers,Float.MAX_VALUE);
                }else if(points[i].y == points[j].y){//float/double has -0.0 which will create trouble
                    updateValue(numbers,(float)0.0);
                }else{
                    float current = (points[j].y-points[i].y)/(float)(points[j].x - points[i].x);
                    updateValue(numbers,current);   
                }
            }
            if(numbers.isEmpty()){
                if(dup>max){
                    max = dup;
                }
                continue;
            }
            Set<Float> keySet = numbers.keySet();
            for(Float key: keySet){
                if(numbers.get(key)+dup>max){
                    max = numbers.get(key)+dup;
                }
            }
            numbers.clear();
        }
        return max;
    }
    public void updateValue(Map<Float,Integer> map, float value){
        if(!map.containsKey(value)){
            map.put(value,1);
        }
        else {
            map.put(value,map.get(value)+1);
        }
    }
}