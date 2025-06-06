class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int i =0; i< n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        int minLength = Integer.MAX_VALUE;
        
        for(int i = 0; i < n;i++ ){
            int requiredSum = prefix[i] + target;
            int left = i+1;
            int right = n;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(prefix[mid]>=requiredSum){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            if(left <= n){
                minLength = Math.min(minLength , left - i);

            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;


    }
}