class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);

        return res;
    }

    private void dfs(int[] nums, List<Integer> temp, int idx) {
        res.add(new ArrayList<>(temp));

        for(int i = idx; i<nums.length; i++) {
            // This is to avoid the same number being seen at the same position multiple times
            if(i > idx && nums[i] == nums[i-1])
                continue;

            temp.add(nums[i]);
            dfs(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}


