class Solution {
    public int secondHighest(String s) {
        HashMap<Integer,Boolean> digitMap = new HashMap<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                int digit = c - '0';
            digitMap.put(digit,true);
            }   
        }
        List<Integer> digits = new ArrayList<>(digitMap.keySet());
        Collections.sort(digits, Collections.reverseOrder());

        return digits.size() >= 2 ? digits.get(1) : -1;

    }
}