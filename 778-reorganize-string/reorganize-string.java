class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        int maxfreq = 0;
        int maxchar = 0;

        for(int i = 0;i<26;i++){
            if(freq[i] > maxfreq){
                maxfreq = freq[i];
                maxchar = i;
            }
        }

        if (maxfreq>(s.length() + 1) / 2 ){ return "";};

        char[] res = new char[s.length()];
        int idx = 0;

        while (freq[maxchar]-- > 0) {
            res[idx] = (char) (maxchar + 'a');
            idx += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                if (idx >= s.length()) idx = 1; 
                res[idx] = (char) (i + 'a');
                idx += 2;
            }
        }

        return new String(res);

    }
}