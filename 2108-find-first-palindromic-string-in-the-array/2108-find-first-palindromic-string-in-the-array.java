class Solution {
    public String firstPalindrome(String[] words) {
        String s = "";
        int flag = 0;
        for(int p=0;p<words.length;p++){
            flag = 0;
            s = words[p];
            int i=0;
            int j=s.length()-1;
            while(i<=j){
                if(s.charAt(i)!=s.charAt(j)){
                    flag=1;
                }
                i++;
                j--;
            }
            if(flag == 0){
                break;
            }
        }
        if(flag==0){
            return s;
        }else{
            return "";
        }
    }
}