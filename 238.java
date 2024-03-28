class Solution {
    public int[] productExceptSelf(int[] nums) {

      
        int n = nums.length;

        int [] left = new int[n]; 
        int [] right = new int [n];

        //Array travesing from left to right AND calculate the product of left side ele from current
        left[0] =1;
        for(int i=1; i<n; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        //Array travesing from right to left AND calculate the product of right side ele from current
        right[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            right[i] = right[i+1]*nums[i+1];
        }

        // multifly left & right array
        
        int [] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = left[i]*right[i];
        }
        return res;
    }

        
    
}
