class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        int maxScore = 0;
        int leftZeros = 0;
        int leftOnes = 0;

        // Go only till second last character (split should be non-empty on both sides)
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                leftOnes++;
            }
            int score = leftZeros + (totalOnes - leftOnes);
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    
        
    }
}