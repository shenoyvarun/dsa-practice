class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();

        dfs(nums, new ArrayList<>(), 0);

        return res;
    }

    private void dfs(int[] nums, List<Integer> temp, int idx) {
        res.add(new ArrayList<>(temp));

        for(int i = idx; i<nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
