class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        
        int n = colors.length;
        if (n < 3) return 0;

        int ans = 0;
        for(int i=0;i<n;i++){
            int prev = colors[ (i -1 + n) % n];
            int next = colors[(i + 1) % n];
            if(colors[i] != prev && colors[i] != next){
                ans++;
            }
        }
        return ans;
    }
}