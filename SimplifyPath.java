/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
public class Solution {
    public String simplifyPath(String path) {
        //split by /, ignore . and empty string 
        //always start with /  because it's absolute path
        
        if(path==null || path.isEmpty()){
            return "/";
        }
        String [] dirs = path.split("/");
        Stack<String> stack = new Stack<String>();
        StringBuilder builder = new StringBuilder();
        List<String> words = new ArrayList<String>();
        builder.append("/");
        for(int i=0; i<dirs.length; i++){
            if(dirs[i].isEmpty() || dirs[i].equals(".")){
                continue;
            }
            if(dirs[i].equals("..")){
                //pop from the stack
                if(!stack.empty()){
                    stack.pop();
                }
                
            }else{
                stack.push(dirs[i]);
            }
        }
        while(!stack.empty()){
            words.add(stack.pop());
        }
        int wordNum = words.size();
        for(int i=wordNum-1; i>=0; i--){
            builder.append(words.get(i));
            if(i!=0){
                builder.append("/");
            }
        }
        return builder.toString();
        
        
    }
}