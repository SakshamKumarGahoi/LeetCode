class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        int[] masks = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            masks[i] = mask;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (masks[i] == masks[j]) {
                    count++;
                }
            }
        }

        return count;
        
    }
}