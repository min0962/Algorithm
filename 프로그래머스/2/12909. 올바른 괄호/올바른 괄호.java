import java.util.Stack;

class Solution {
    boolean solution(String s) {
        
        boolean answer = true;        
        
        Stack<String> stack = new Stack<>();        
        
        for(int i = 0; i < s.length(); i++){
            if(String.valueOf(s.charAt(i)).equals("(")){
                stack.push("(");
            }else{
                if(stack.empty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.empty()){
            return false;
        }

        return true;
    }
}