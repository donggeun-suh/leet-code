class Solution {
    
    private int maxLength;
    private int lo;
    
    public  String longestPalindrome(String s) {
        
        if(s.length()< 2){
            return s;
        }
                
           for (int i = 0; i < s.length()- 1; i++){
               makePalindrome(s, i, i);
               makePalindrome(s, i, i+1);
           }
        
        return s.substring(lo,lo + maxLength );

    }
    
    public void makePalindrome(String s, int low, int high){
        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            low--;
            high++;
        }
        
        if(maxLength < high - low -1 ){
            lo = low + 1;
            maxLength = high - low -1;
        }
    }
}