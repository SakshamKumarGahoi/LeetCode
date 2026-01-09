class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i) == '(') stack.push('(');
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    ans++;
                }
            }    
        }
        while(!stack.isEmpty()){
            ans++;
            stack.pop();
        }
        return ans;
    }
}