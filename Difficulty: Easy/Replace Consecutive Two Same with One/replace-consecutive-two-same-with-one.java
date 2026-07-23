class Solution {
    public String removeDuplicates(String s) {
        // code here
        
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i = 0; i < s.length();i++){
            
            char ch = s.charAt(i);
            
            if(list.isEmpty() || ch != list.get(list.size() - 1)){
                list.add(ch);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < list.size();i++){
            result.append(list.get(i));
        }
        
        return result.toString();
    }
}