class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int i = 0, j = heights.length - 1;

        while(i<j) {
            res = Math.max(res, (Math.min(heights[i], heights[j]) * (j - i)));

            if(heights[j] >= heights[i])
                i++;
            else
                j--;
        }

        return res;
    }
}
