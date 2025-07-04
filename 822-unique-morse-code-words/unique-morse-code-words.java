class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morsemap = new String[]{
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."
        };

        Set<String> transformations = new HashSet<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){
                sb.append(morsemap[c - 'a']);
            }
            transformations.add(sb.toString());
        }

        return transformations.size();
    }
}