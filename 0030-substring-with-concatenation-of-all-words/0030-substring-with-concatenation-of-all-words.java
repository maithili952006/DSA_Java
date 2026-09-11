class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int len = words[0].length();
        int count = words.length;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            int left = i;
            int used = 0;

            HashMap<String, Integer> seen = new HashMap<>();

            for (int right = i; right + len <= s.length(); right += len) {
                String word = s.substring(right, right + len);

                if (!map.containsKey(word)) {
                    seen.clear();
                    used = 0;
                    left = right + len;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                used++;

                while (seen.get(word) > map.get(word)) {
                    String remove = s.substring(left, left + len);
                    seen.put(remove, seen.get(remove) - 1);
                    left += len;
                    used--;
                }

                if (used == count) {
                    ans.add(left);

                    String remove = s.substring(left, left + len);
                    seen.put(remove, seen.get(remove) - 1);
                    left += len;
                    used--;
                }
            }
        }

        return ans;
    }
}