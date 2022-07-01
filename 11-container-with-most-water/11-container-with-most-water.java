class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int max = 0;
        int water = 0;
        
        while(left < right){
           water = Math.min(height[right],height[left]) * (right- left);
           if(max < water){
               max = water;
           } 
            
           if(height[left] >= height[right]) {
               right--;
           } else {
               left++;
           }
            
        }
        
        return max;
        
    }
}