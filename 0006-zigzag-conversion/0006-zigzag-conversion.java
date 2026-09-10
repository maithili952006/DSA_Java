class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int currentRow = 0;
        boolean goingDown = true;

        for (int i = 0; i < s.length(); i++) {

            rows[currentRow] += s.charAt(i);

            if (currentRow == 0) {
                goingDown = true;
            } 
            else if (currentRow == numRows - 1) {
                goingDown = false;
            }

            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        String ans = "";

        for (int i = 0; i < numRows; i++) {
            ans += rows[i];
        }

        return ans;
    }
}