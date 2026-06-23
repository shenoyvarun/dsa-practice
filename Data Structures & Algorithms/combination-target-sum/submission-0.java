class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();

        dfs(nums, new ArrayList<>(), target, 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> temp, int sum, int idx) {
        if(sum == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }          

        for(int i = idx; i<nums.length; i++) {
            if(sum - nums[i] < 0) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, temp, sum-nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
