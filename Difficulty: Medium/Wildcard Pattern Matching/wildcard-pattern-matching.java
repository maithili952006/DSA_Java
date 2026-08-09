class Solution {
    public boolean wildCard(String txt, String pat) {
        // code here
        int i = 0;
        int j = 0;
        
        int start = -1;
        int match = -1;
        
        while(j < txt.length()){
            
            if(i < pat.length() && (pat.charAt(i) == txt.charAt(j) || pat.charAt(i) == '?')){
                i++;
                j++;
            }
            
            else if(i < pat.length() && pat.charAt(i) == '*'){
                start = i;
                match = j;
                
                i++;
            }
            else if(start != -1){
                i = start + 1;
                match++;
                j = match;
            }
            else{
                return false;
            }
        }
            
        while(i < pat.length() && pat.charAt(i) == '*'){
            i++;
        }
        return i == pat.length();
        }
    }