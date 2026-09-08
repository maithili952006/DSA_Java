class Solution {
    public int maxVowels(String s, int k) {
        int currentVowelCount = 0;

        for(int i = 0; i < k;i++){
            if(isVowel(s.charAt(i))){
                currentVowelCount++;
            }
        }
        int maxVowels = currentVowelCount;

        for(int i = k; i < s.length(); i++){
            if(maxVowels == k){
                return k;
            }

            if(isVowel(s.charAt(i))){
                currentVowelCount++;
            }

            if(isVowel(s.charAt(i - k))){
                currentVowelCount--;
            }
            maxVowels = Math.max(maxVowels, currentVowelCount);
        }
        return maxVowels;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c =='i' || c== 'o' || c== 'u';
    }
}