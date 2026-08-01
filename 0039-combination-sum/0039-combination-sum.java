import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        
        // Start the recursive exploration
        backtrack(0, candidates, target, new ArrayList<>(), result);
        
        return result;
    }

    private void backtrack(int startIndex, int[] candidates, int remaining, List<Integer> current, List<List<Integer>> result) {
        // Base Case: We hit the target!
        if (remaining == 0) {
            result.add(new ArrayList<>(current)); // Save a snapshot copy
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
    
            if (num > remaining) {
                break;
            }

            current.add(num);

            backtrack(i, candidates, remaining - num, current, result);

            // 3. Un-choose (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}