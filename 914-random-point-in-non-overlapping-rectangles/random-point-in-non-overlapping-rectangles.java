class Solution {
    int[][] rects;
    int[] prefixSums;
    Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSums = new int[rects.length];
        this.rand = new Random();

        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            int area = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            sum += area;
            prefixSums[i] = sum;
        }
    }

    public int[] pick() {
        int target = rand.nextInt(prefixSums[prefixSums.length - 1]);
        int rectIndex = binarySearch(target);

        int[] r = rects[rectIndex];
        int width = r[2] - r[0] + 1;
        int height = r[3] - r[1] + 1;

        int base = rectIndex == 0 ? 0 : prefixSums[rectIndex - 1];
        int offset = target - base;

        int x = r[0] + (offset % width);
        int y = r[1] + (offset / width);

        return new int[] {x, y};
    }

    private int binarySearch(int target) {
        int low = 0, high = prefixSums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target < prefixSums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */