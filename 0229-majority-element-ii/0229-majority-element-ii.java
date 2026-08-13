class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;

        while(i < n){
            int count = 1;

            while(i + 1 < n && nums[i] == nums[i + 1]){
                count++;
                i++;
            }
            if(count > n /3){
                result.add(nums[i]);
            }
            i++;
        }
        return result;
        
    } 
}