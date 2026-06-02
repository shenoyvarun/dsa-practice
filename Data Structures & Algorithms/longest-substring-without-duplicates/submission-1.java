class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;

        while(i<s.length() && j<s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            else {
                res = Math.max(res, j-i);
                set.clear();
                i++; 
                j = i;
            }
        }

        return Math.max(res, j-i);
    }
}
