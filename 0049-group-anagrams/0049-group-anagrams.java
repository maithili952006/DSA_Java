class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);

            String sortedKey = new String(charArray);

            if(!map.containsKey(sortedKey)){
                map.put(sortedKey, new ArrayList<>());
            }

            map.get(sortedKey).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}