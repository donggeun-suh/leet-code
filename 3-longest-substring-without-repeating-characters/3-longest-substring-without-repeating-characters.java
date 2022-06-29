class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        char[] chars;
        HashMap<Character, Boolean> hasLetter = new HashMap<>();
        List<Integer> countList = new ArrayList<>();
        boolean hasSpace = false;
        for(int i = 0; i< s.length(); i++){
            chars = s.substring(i).toCharArray();
            
            for (char letter : chars){
            // 1. 공백 체크
                if(letter == ' '){
                    if(hasSpace == false){    
                        count++;
                        hasSpace = true;
                    } else {
                        break;
                    }
                    continue;
                }
            
            // 2. 글자  체크
                if(hasLetter.get(letter) == null || !hasLetter.get(letter)){
                    count++;
                    hasLetter.put(letter, true);
                } else if(hasLetter.get(letter) != null && hasLetter.get(letter)){
                    break;
                }
            }
            
            
            countList.add(count);
            count = 0;
            hasSpace = false;
            hasLetter.clear();
        }
        

        
        
        
        
        if(countList.size() == 0){
            return 0;
        } else {
            return Collections.max(countList);
        }
        
        
        
    }
}