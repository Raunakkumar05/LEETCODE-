class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Since constraints show max value is 100, we can use a lookup array
        boolean[] present = new boolean[101];
        for (int num : nums) {
            if (num <= 100) {
                present[num] = true;
            }
        }
        
        for (int i = 1; ; i++) {
            int target = k * i;
            if (target > 100 || !present[target]) {
                return target;
            }
        }
    }
}