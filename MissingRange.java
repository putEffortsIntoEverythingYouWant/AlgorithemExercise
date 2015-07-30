/*
Given a sorted integer array where the range of elements are [0, 99] inclusive, return its
missing ranges.
For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
*/
public List<String> findMissingRanges(int [] vals, int start, int end){
	
	List<String> result = new ArrayList<String>();
	if(vals==null || vals.length ==0){
		result.add(generateRange(start,end));
		return result;
	}
	int startValue = start-1;
	int endValue = end+1;
	int index = 0;
	while(index<vals.length){
		endValue = vals[index];
		if(endValue-startValue>1){
			result.add(generateRange(startValue+1,endValue-1));
		}
		startValue = endValue;
		index++;
	}
	if(end+1-endValue >1){
		result.add(generateRange(endValue+1,end));
	}
	return result;

}
//inclusive
public String generateRange(int start, int end){
	if(start==end){
		return String.valueOf(start);
	}
	return start+"->"+end;
}
