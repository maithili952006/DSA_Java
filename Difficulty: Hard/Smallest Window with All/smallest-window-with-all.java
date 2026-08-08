class Solution {
    public static String minWindow(String s, String p) {
        // code here
        int [] count = new int[256];
        
        for(int i = 0; i < p.length();i++){
            count[p.charAt(i)]++;
        }
        
        int left = 0; 
        int right = 0;
        
        int required = p.length();
        
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        
        while (right < s.length()){
            char ch = s.charAt(right);
            
            if(count[ch] > 0){
                required--;
            }
            
            count[ch]--;
            right++;
            
            while(required == 0){
                if(right - left < minLength){
                    minLength = right - left;
                    startIndex = left;
                }
                
                char leftChar = s.charAt(left);
                
                count[leftChar]++;
                
                if(count[leftChar] > 0){
                    required++;
                }
                left++;
            } 
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        
        return s.substring(startIndex,startIndex + minLength);
    }
}