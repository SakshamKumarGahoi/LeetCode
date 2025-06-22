class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer , Integer> countmap = new HashMap<>();
        countmap.put(0,1);
        int count = 0;
        int oddcount = 0;
        for(int num: nums){
            if(num % 2 ==1){
                oddcount++;
            }
            count += countmap.getOrDefault(oddcount - k,0);
            countmap.put(oddcount, countmap.getOrDefault(oddcount, 0) + 1);
        }
        return count;

    }
}