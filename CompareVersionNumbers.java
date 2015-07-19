/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/
public class Solution {
    /*
    this solution works with the cases that "." appears more than once or number of "." is different between the two string
    [01.01..] will be processed to [1,1, , ] 
    empty string or index exceeds size in the processed result will be replace by "0" when comparing
    */
    public int compareVersion(String version1, String version2) {
        List<String> list1 = breakString(version1);
        List<String> list2 = breakString(version2);
        int size1 = list1.size();
        int size2 = list2.size();
        int i = 0;
        String s1 = null;
        String s2 = null;
        while(i<Math.max(size1,size2)){
            if(i>=size1 || list1.get(i).isEmpty()){
                s1 = "0";
            }else{
                s1 = list1.get(i);
            }
            
            if(i>=size2 || list2.get(i).isEmpty()){
               s2 = "0";
            }else{
                 s2 = list2.get(i);
            }
            int result = compareString(s1,s2);
            if(result<0){
                return -1;
            }
            if(result>0){
                return 1;
            }
            i++;
        }
        return 0;
        
        
    }
    public  List<String> breakString(String str){
	        //break by .
	        //remove 0
	        List<String> result = new ArrayList<String>();
	        int start =0;
	        int end =0;
	        int length = str.length();
	        while(end<length){
	            if(str.charAt(end)=='.'){
	                while(str.charAt(start)=='0'){
	                    start++;
	                }
	                result.add(str.substring(start,end));
	                start=end+1;
	            }
	            end++;
	        }
	        while(start<length && str.charAt(start)=='0'){
                start++;
            }
	        if(start<=end){
	        	result.add(str.substring(start,end));
	        }
	        return result;
	        
	 }
	 public int compareString(String str1, String str2){
	     int length1 = str1.length();
	     int length2 = str2.length();
	     if(length1 > length2){
	         return 1;
	     }
	     if(length2 > length1){
	         return -1;
	     }
	     for(int i=0; i<length1; i++){
	         if(str1.charAt(i) != str2.charAt(i)){
	             return Character.compare(str1.charAt(i),str2.charAt(i));
	         }
	     }
	     return 0;
	 }
}