class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(String s, int start, List<String> list,
                   List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                list.add(s.substring(start, end + 1));
                backtrack(s, end + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}