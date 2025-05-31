import java.util.*;



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int low = 0 , high = x;
        while(low<=high){
            int PartitionX = (low + high) / 2;
            int PartitionY = (x + y + 1) / 2 - PartitionX;
            int maxLeftX = (PartitionX == 0) ? Integer.MIN_VALUE : nums1[PartitionX - 1];
            int minRightX = (PartitionX == x) ? Integer.MAX_VALUE : nums1[PartitionX];
            int maxLeftY = (PartitionY == 0) ? Integer.MIN_VALUE : nums2[PartitionY - 1];
            int minRightY = (PartitionY == y) ? Integer.MAX_VALUE : nums2[PartitionY];
            if (maxLeftX<=minRightY && maxLeftY <= minRightX){
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, 
                    minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
                }else if(maxLeftX>minRightY){
                high = PartitionX - 1;
            } else {
                low = PartitionX + 1;
            }


        }
        throw new IllegalArgumentException("Input Arrays Are Not Sorted");
    }
}