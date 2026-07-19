import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int[] interval : arr) {

            // If answer is empty OR no overlap
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < interval[0]) {

                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(interval[0]);
                temp.add(interval[1]);
                ans.add(temp);

            } else {
                // Overlap
                ArrayList<Integer> last = ans.get(ans.size() - 1);
                last.set(1, Math.max(last.get(1), interval[1]));
            }
        }

        return ans;
    }
}