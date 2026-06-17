class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int[] m: memo)
            Arrays.fill(m,-1);

        return dfs(word1, word2, 0, 0, memo);
    }

    private int dfs(String word1, String word2, int i, int j, int[][] memo) {
        if (i >= word1.length() && j >= word2.length())
            return 0;

        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }

        if(memo[i][j] != -1)
            return memo[i][j];

        if (i < word1.length() && j < word2.length() && word1.charAt(i) == word2.charAt(j))
            return memo[i][j] = dfs(word1, word2, i + 1, j + 1, memo);

        int s1 = dfs(word1, word2, i + 1, j + 1, memo) + 1;
        int s2 = dfs(word1, word2, i + 1, j, memo) + 1;
        int s3 = dfs(word1, word2, i, j + 1, memo) + 1;

        return memo[i][j] = Math.min(s1, Math.min(s2, s3));
    }
}
