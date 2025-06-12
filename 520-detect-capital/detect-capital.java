class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalcount = 0;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                capitalcount++;
            }
        }
        if(capitalcount == word.length()){
            return true;
        }
        else if(capitalcount == 0){
            return true;
        }

        else if(capitalcount == 1 && Character.isUpperCase(word.charAt(0))){
            return true;
        }
        else{
            return false;
        }
    }
}