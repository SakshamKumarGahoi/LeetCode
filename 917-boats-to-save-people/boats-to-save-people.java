class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] weightCount = new int[limit + 1];
        for (int p : people) {
            weightCount[p]++;
        }
         int boats = 0;
        int light = 1;
        int heavy = limit;

        while (light <= heavy) {
            while (heavy >= light && weightCount[heavy] == 0) heavy--;
            if (heavy < light) break;

            weightCount[heavy]--;
            boats++;

            int remain = limit - heavy;
            if (remain >= light) {
                while (light <= remain && weightCount[light] == 0) light++;
                if (light <= remain) {
                    weightCount[light]--;
                }
            }
        }

        return boats;
    }
}