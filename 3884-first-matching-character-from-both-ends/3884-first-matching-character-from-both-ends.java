class Solution {
    public int firstMatchingIndex(String s) {
        int j = 0;
        int min = 0;
        int flag = 0;
        for(int i=0;i<s.length();i++){
            j=s.length()-i-1;
            if(s.charAt(i)==s.charAt(j)){
                min=Math.min(i,j);
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