class Solution {
    public boolean checkString(String s) {
        boolean x = false;

        for(int i = 0; i< s.length() ; i++){
            char character = s.charAt(i);
            if( character == 'b'){
                x = true;
            } else {
                if(x == true){
                    return false;
                }
            }
        }
        return true;
    }
}