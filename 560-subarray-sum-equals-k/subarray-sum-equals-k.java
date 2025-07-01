class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer , Integer> prefixSums = new HashMap<>();
        prefixSums.put(0,1);

        for(int num:nums){
            sum+=num;
            if(prefixSums.containsKey(sum - k)){
                count += prefixSums.get(sum - k);
            }
            prefixSums.put(sum , prefixSums.getOrDefault(sum,0)+1);

        }
        return count;

    }
}