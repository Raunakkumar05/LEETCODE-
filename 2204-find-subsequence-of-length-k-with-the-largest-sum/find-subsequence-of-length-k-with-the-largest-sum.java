import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        // Copy array
        int[] arr = nums.clone();

        // Sort copied array
        Arrays.sort(arr);

        // Store top k elements
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= n - k; i--) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Result array
        int[] ans = new int[k];

        int idx = 0;

        // Traverse original array
        for (int num : nums) {

            if (map.getOrDefault(num, 0) > 0) {

                ans[idx++] = num;

                map.put(num, map.get(num) - 1);
            }
        }

        return ans;
    }
}