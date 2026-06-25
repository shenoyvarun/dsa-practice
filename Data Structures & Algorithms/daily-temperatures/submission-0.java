class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temp.length];

        for(int i = 0; i<temp.length; i++) {
            int curr = temp[i];
            while(!stack.isEmpty() && stack.peek()[0] < curr) {
                int[] prev = stack.pop();
                res[prev[1]] = i - prev[1];
            }
            stack.push(new int[]{curr, i});
        }

        return res;
    }
}