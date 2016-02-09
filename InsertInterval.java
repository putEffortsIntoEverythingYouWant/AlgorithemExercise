/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        if(intervals==null){
            result.add(newInterval);
            return result;
        }
        for(Interval interval: intervals){
            if(newInterval.end<interval.start){
                Interval copy = new Interval(newInterval.start,newInterval.end);
                result.add(copy);
                newInterval = interval;
            }else if(newInterval.start>interval.end){
                result.add(interval);
            }else{
                newInterval.start = Math.min(newInterval.start,interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        //no matter what case, newInterval always left out
        result.add(newInterval);
        
        return result;
    }
}