class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> result = new ArrayList<>();
        backTracking(n, n, "", result);
        
        return result;
        
    }
    
    private void backTracking(int left , int right, String ans, List<String> result){
        if(left == 0 && right == 0){
            result.add(ans);
            return;
        }
        
        if(left > 0){
            backTracking(left -1, right, ans + "(", result);
        }
        
        if(left < right){
            backTracking(left, right -1, ans + ")", result);
        }
        
    }
}