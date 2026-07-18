class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        // 1. Sort the intervals based on their start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        // 2. Initialize the first interval container
        ArrayList<Integer> currentInterval = new ArrayList<>();
        currentInterval.add(arr[0][0]); // start
        currentInterval.add(arr[0][1]); // end
        res.add(currentInterval);
        
        // 3. Scan through the remaining intervals
        for (int i = 1; i < arr.length; i++) {
            int nextStart = arr[i][0];
            int nextEnd = arr[i][1];
            
            // Get the last merged interval tracking reference out of our result list
            ArrayList<Integer> lastMerged = res.get(res.size() - 1);
            
            // If the next interval starts before or exactly when the last one ends
            if (nextStart <= lastMerged.get(1)) {
                // Update the tracking end time to the maximum value
                lastMerged.set(1, Math.max(lastMerged.get(1), nextEnd));
            } else {
                // No overlap! Create a completely fresh interval and add it to the list
                ArrayList<Integer> freshInterval = new ArrayList<>();
                freshInterval.add(nextStart);
                freshInterval.add(nextEnd);
                res.add(freshInterval);
            }
        }
        
        return res;
    }
}