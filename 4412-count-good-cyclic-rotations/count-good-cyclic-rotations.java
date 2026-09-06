class Solution {
    public int countGoodRotations(int[] nums) {
        int n =nums.length;
        int half =n/2;
        long total = 0;
        for(int x: nums){
            total+=x;
        }
        long first = 0;
        for(int i =0; i<half; i++){
            first += nums[i];
        }
        int ans =0;
        for(int start = 0; start < n ; start++){
            long sec = total- first;
            if(first> sec) ans++;
            first-=nums[start];
            first+=nums[(start+half)%n];
        }
        return ans;
        
        
    }
}