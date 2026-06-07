class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        int[]left = new int[len];
        int[]right = new int[len];

        left[0] = 1;
        right[len-1] = 1;

        for(int i=1, j=len-2; i<len && j>=0; i++, j--) {
            left[i] = left[i-1] * nums[i-1];
            right[j] = right[j+1] * nums[j+1];
        }

        int[] res = new int[len];

        for(int i = 0; i<len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}  
