class Solution {
    public int getLPSLength(String s) {
        // code here
        
        int n = s.length();
        int i = 1;
        int j = 0;
        
        int[] lps = new int[n];
        
        while( i < n){
            if(s.charAt(i) == s.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else{
                if(j != 0){
                    j = lps[j - 1];
                    }else{
                        lps[i] = 0;
                        i++;
                    }
                }
        }        
                return lps[n - 1];
    }
}
