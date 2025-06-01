import java.util.*;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxlength = 0;
        int start = 0;
        for(int end = 0;end < s.length();end++){
            char currentchar = s.charAt(end);
            while (seen.contains(currentchar)){
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(currentchar);
            maxlength = Math.max(maxlength, end - start + 1);
        }
        return maxlength;
    } 
}