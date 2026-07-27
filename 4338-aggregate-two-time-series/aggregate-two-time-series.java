class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] s1, int[][] s2) {
        List<List<Integer>> ans = new ArrayList<>();
        int i=0,j=0;
        int m = s1.length, n = s2.length;

        while(i<m || j<n){
            if(j==n || (i<m && s1[i][0] < s2[j][0])){
                int time = s1[i][0];
                int val1 = s1[i][1];
                int val2 = (j<n) ? s2[j][1] : 0;

                ans.add(Arrays.asList(time, val1+val2));
                i++;
            }

            else if(i==m || s2[j][0] < s1[i][0]){
                int time = s2[j][0];
                int val1 = (i<m) ? s1[i][1] : 0;
                int val2 = s2[j][1];

                ans.add(Arrays.asList(time, val1+val2));
                j++;
            }

            else{
                int time = s1[i][0];
                ans.add(Arrays.asList(time, s1[i][1] + s2[j][1]));
                i++;
                j++;
            }
        }

        return ans;
    }
}