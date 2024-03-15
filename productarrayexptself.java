// problem : Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

//code 

class Solution {
    public int[] productExceptSelf(int[] nums) {
        //loop - condition- results
          int n = nums.length;
        
        // Initialize left and right product arrays
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        
        // Calculate left product array
        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }
        
        // Calculate right product array
        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }
        
        // Calculate answer array by multiplying left and right product arrays
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct[i] * rightProduct[i];
        }
        
        return answer;
    }
}
