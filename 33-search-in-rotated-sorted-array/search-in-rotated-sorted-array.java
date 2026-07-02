class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // target in left half
                } else {
                    left = mid + 1; // target in right half
                }
            } else { // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // target in right half
                } else {
                    right = mid - 1; // target in left half
                }
            }
        }
        return -1; 
    }
}




// class Solution {
//     public int search(int[] nums, int target) {
//         for(int i = 0; i < nums.length;i++){
//             if(nums[i] == target){
//                 return i; 
//             }
//         }
//         return -1;
//     }
// }