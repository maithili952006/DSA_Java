// class Solution {
//     public int countSubstrings(String s) {
        
//         int count = 0;
//         for(int i = 0;i < s.length();i++){
//             for(int j = i; j < s.length();j++){
//                 String sub = s.substring(i,j+1);

//                 if(isPalindrome(sub)){
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }

//     private boolean isPalindrome(String s){
//             int left = 0;
//             int right = s.length() - 1;

//             while (left < right){
//                     if(s.charAt(left) != s.charAt(right)){
//                             return false;
//                         }
//                         left++;
//                         right--;
//                     }

//                 return true;
//     }        
// }

class Solution{
    public int countSubstrings(String s){

        int count = 0;

        for(int i = 0; i < s.length();i++){
            count += expandAroundCenter(s,i,i);

            count += expandAroundCenter(s,i,i+1);
        }

        return count;
    }

    private int expandAroundCenter(String s, int left,int right){
        int count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;

            left--;
            right++;
        }

        return count;
    }
}