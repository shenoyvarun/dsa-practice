class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int i, int[] memo) {
        if(i >= nums.length)
            return 0;
        if(memo[i] != -1)
            return memo[i];
        
        int pick = dfs(nums, i + 2, memo);
        int noPick = dfs(nums, i + 1, memo);

        return memo[i] = Math.max(nums[i] + pick, noPick);
    }
}
