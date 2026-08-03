class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length <= 1){
            return intervals;
        }
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));  //here a[0] and b[0] is used because we have to compare the frist elemnt in the each interval and sort them in the 2D arays.

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        result.add(current);

        for(int i = 0; i < intervals.length;i++){
            if(intervals[i][0] <= current[1]){
                current[1] = Math.max(current[1],intervals[i][1]);
            }else{
                current = intervals[i];
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}