class Solution {
    
    private List<String> ans = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        
        if (digits.equals("")){
            return ans;
        }
        
        char[] charArray = digits.toCharArray();
        
        HashMap<Integer, List<String>> map = new HashMap<>();
        map.put(2 ,new ArrayList<String>(Arrays.asList("a","b","c")) );
        map.put(3 ,new ArrayList<String>(Arrays.asList("d","e","f")) );
        map.put(4 ,new ArrayList<String>(Arrays.asList("g","h","i")) );
        map.put(5 ,new ArrayList<String>(Arrays.asList("j","k","l")) );
        map.put(6 ,new ArrayList<String>(Arrays.asList("m","n","o")));
        map.put(7 ,new ArrayList<String>(Arrays.asList("p","q","r","s")) );
        map.put(8 ,new ArrayList<String>(Arrays.asList("t","u","v")) );
        map.put(9 ,new ArrayList<String>(Arrays.asList("w","x","y","z")));
        
        
        
        
        backTracking(charArray, map, 0,"");
        
        return ans;
        
    }
    
    public void backTracking(char[] charArray, HashMap<Integer, List<String>> map, int depth, String str){
        
        if (depth == charArray.length){
            ans.add(str);
            return;
        }
        
        int target = charArray[depth]-'0';
        List<String> letter = map.get(target);
        
        for(int i = 0; i < letter.size(); i++){
            backTracking(charArray, map, depth+1, str+letter.get(i));
        }
    }
    
}