// You are given an integer array nums and a positive integer k.

//Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

//A subarray is a contiguous sequence of elements within an array.

class Solution {
    public long countSubarrays(int[] nums, int k) {
         int mx = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int l = 0,r=0,n=nums.length;
        
        while (r < n) {
            k -= nums[r] == mx ? 1 : 0;
            r++;
            while (k == 0) {
                k += nums[l] == mx ? 1 : 0;
                l++;
            }
            ans += l;
        }
        
        return ans;
    }
}
