class Solution {
    public int firstMatchingIndex(String s) {
        int min = 0;
        for(int i=0;i<=s.length()/2;i++){
            if(s.charAt(i)==s.charAt(s.length()-i-1)){
                return i;
            }
        }
        return -1;
    }
}