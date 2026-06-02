class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);

        int res = dfs(coins, amount, memo);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int[] coins, int sum, int[] memo) {
        if(sum == 0)
            return 0;

        if(memo[sum] != -2)
            return memo[sum];

        int res = Integer.MAX_VALUE;

        for(int num: coins) {
            if(sum - num >= 0) {
                int ans = dfs(coins, sum - num, memo);

                if(ans != Integer.MAX_VALUE)
                    res = Math.min(res, 1 + ans);
            }
        }

        memo[sum] = res;
        return res;
    }
}
