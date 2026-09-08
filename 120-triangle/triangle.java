class Solution {
    private int helper(int i, int j, List<List<Integer>> triangle, Integer[][] memo) {
        int n = triangle.size();
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int down = helper(i + 1, j, triangle, memo);
        int diagonal = helper(i + 1, j + 1, triangle, memo);

        return memo[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return helper(0, 0, triangle, memo);
    }
}