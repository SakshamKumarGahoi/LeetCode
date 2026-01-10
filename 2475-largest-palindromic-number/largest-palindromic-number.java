class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }

        StringBuilder left = new StringBuilder();

        for (int d = 9; d >= 0; d--) {
            int pairs = count[d] / 2;

            if (d == 0 && left.length() == 0) continue;

            for (int i = 0; i < pairs; i++) {
                left.append(d);
            }
            count[d] -= pairs * 2;
        }

        String center = "";
        for (int d = 9; d >= 0; d--) {
            if (count[d] > 0) {
                center = String.valueOf(d);
                break;
            }
        }

        String right = left.reverse().toString();
        left.reverse(); 

        String result = left.toString() + center + right;

        return result.isEmpty() ? "0" : result;
    }
}