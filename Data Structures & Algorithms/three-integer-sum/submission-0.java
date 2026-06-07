class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length) {
            int a = nums[i];

            if (a > 0)
                break;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] + a == 0) {
                    List<Integer> temp = Arrays.asList(a, nums[l], nums[r]);
                    res.add(temp);

                    l++;
                    while(l< nums.length && nums[l] == nums[l-1]) l++;
                    r--;
                    while(r>= 0 && nums[r] == nums[r+1]) r--;
                }
                else if (nums[l] + nums[r] + a > 0) {
                    r--;
                } else {
                    l++;
                }
            }

            i++;
            while (i<nums.length && nums[i] == nums[i - 1]) i++;
        }

        return res;
    }
}
