class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Precompute the smallest value from each index to the end
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }

        // Step 2: Track the largest value seen so far from the left
        int maxLeft = nums[0];

        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);

            // If the difference is at most k, we found our answer
            if (maxLeft - minRight[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}