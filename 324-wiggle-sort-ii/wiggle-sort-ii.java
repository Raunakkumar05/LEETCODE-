import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        int[] arr = new int[n];

        int ptr = n - 1;

        // Fill odd indexes
        for (int i = 1; i < n; i += 2) {
            arr[i] = nums[ptr--];
        }

        // Fill even indexes
        for (int i = 0; i < n; i += 2) {
            arr[i] = nums[ptr--];
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }
}