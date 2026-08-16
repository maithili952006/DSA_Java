class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> freqList = new ArrayList<>();

        int i = 0;
        while(i < nums.length){
            int count = 1;
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                count++;
                i++;
            };
            freqList.add(new int[]{count, nums[i]});
            i++;
        }
        freqList.sort((a,b) -> b[0]-a[0]);
        
        int[] result = new int[k];
        for(int j = 0; j < k;j++){
            result[j] = freqList.get(j)[1];
        }
        return result;
    }
}