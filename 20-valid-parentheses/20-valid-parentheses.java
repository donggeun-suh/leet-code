class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else{
                if(stack.empty()) {
                    return false;
                }
            }
            
            if(c == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                } else {
                    return false;
                }
            }
            
            if(c == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                } else {
                    return false;
                }
            }
            
            if(c == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                } else {
                    return false;
                }
            }
            
        }
        
        
        if(stack.empty()){
            return true;
        } else{
            return false;
        }
    }
}