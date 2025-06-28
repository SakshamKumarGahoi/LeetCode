class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for ( char c: text.toCharArray()){
            freq.put(c , freq.getOrDefault(c,0)+1);
        }     

        HashMap<Character, Integer> balloonFreq = new HashMap<>();
        balloonFreq.put('b', 1);
        balloonFreq.put('a', 1);
        balloonFreq.put('l', 2);
        balloonFreq.put('o', 2);
        balloonFreq.put('n', 1);
        int min = Integer.MAX_VALUE;

        for(char c: balloonFreq.keySet() ){
            int available = freq.getOrDefault(c,0);
            int needed = balloonFreq.get(c);
            min = Math.min(min , available / needed);
        }
        return min;
    }
}