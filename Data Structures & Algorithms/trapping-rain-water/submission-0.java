class Solution {
    public int trap(int[] height) {
        int res = 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int lMax = height[0];
        int rMax = height[height.length - 1];

        for(int i = 0; i<height.length; i++) {
            lMax = Math.max(lMax, height[i]);
            leftMax[i] = lMax;
        }
        for(int i = height.length-1; i>=0; i--) {
            rMax = Math.max(rMax, height[i]);
            rightMax[i] = rMax;
        }

        leftMax[0] = 0;
        rightMax[height.length-1] = 0;
        rightMax[0] = 0;
        leftMax[height.length-1] = 0;

        for(int i = 0; i<height.length; i++) {
            if(Math.min(leftMax[i], rightMax[i]) - height[i] > 0)
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }
}
