/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals ==null || intervals.size()==0){
            return result;
        }
        int size = intervals.size();
        Interval [] array = intervals.toArray(new Interval [size]);
        Arrays.sort(array,new IntervalComparator());
        Interval current = array[0];
        for(int i=1;i<size;i++){
            Interval interval = array[i];
            if(interval.start>current.end){
                result.add(current);
                current = interval;
            }else if(interval.end < current.start){
                result.add(interval);
            }else{
                Interval newInterval = new Interval(Math.min(interval.start,current.start),Math.max(interval.end,current.end));
                current = newInterval;
            }
            
        }
        result.add(current);
        return result;
        
    }
    public class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval in1, Interval in2){
            if(in1.start<in2.start){
                return -1;
            }
            else if(in1.start == in2.start){
                return 0;
            }
            else{
                return 1;
            }
        }
    }
}