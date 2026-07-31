class Solution {
    public int firstMatchingIndex(String s) {
        int min = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==s.charAt(s.length()-i-1)){
                min=Math.min(i,s.length()-i-1);
                return i;
            }
        }
        return -1;
    }
}