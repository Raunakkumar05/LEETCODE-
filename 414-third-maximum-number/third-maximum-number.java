import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {

        Arrays.sort(nums);

        int count = 1;
        int n = nums.length;

        int prev = nums[n - 1];

        // Traverse from back
        for (int i = n - 2; i >= 0; i--) {

            // New distinct number
            if (nums[i] != prev) {

                count++;
                prev = nums[i];
            }

            // Found 3rd maximum
            if (count == 3) {
                return nums[i];
            }
        }

        // If no 3rd maximum
        return nums[n - 1];
    }
}