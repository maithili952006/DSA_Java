
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Store all elements of nums1 in a set
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Use another set to store unique intersection elements
        Set<Integer> intersectSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectSet.add(num);
            }
        }
        
        // Convert the set to an int[] array
        int[] result = new int[intersectSet.size()];
        int i = 0;
        for (int num : intersectSet) {
            result[i++] = num;
        }
        
        return result;
    }
}