class Solution {
    public int numDecodings(String s) {
        return dp(s, 0);
    }

    private int dp(String s, int i) {
        if(i == s.length())
            return 1;
        if(s.charAt(i) == '0')
            return 0;

        int singD = Integer.parseInt(s.substring(i, i+1));
        int doubleD = 0;
        if(i<s.length() - 1)
            doubleD = Integer.parseInt(s.substring(i, i+2));
        
        boolean singleValid = isValid(singD);
        boolean doubleValid = doubleD > 9 && isValid(doubleD);

        int res = 0;
        
        if(singleValid)
            res += dp(s, i+1);

        if(doubleValid)
            res += dp(s, i+2);
        
        return res;
    }

    private boolean isValid(int num) {
        return num >=1 && num <=26;
    }
}