class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for(int row = 1; row <= numRows; row++){

            List<Integer> temp = new ArrayList<>();

            int res = 1;
            temp.add(res);

            for(int col = 1;col < row;col++){
                res = res * (row - col) / col;

                temp.add(res);
            }

            ans.add(temp);
        }

        return ans;
    }
}
