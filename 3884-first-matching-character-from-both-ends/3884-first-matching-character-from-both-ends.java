class Solution {
    public int firstMatchingIndex(String s) {
        int min = 0;
        int flag = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==s.charAt(s.length()-i-1)){
                min=Math.min(i,s.length()-i-1);
                flag = 1;
                break;
            }
        }

        if(flag == 1){
            return min;
        }else{
            return -1;
        }

    }
}