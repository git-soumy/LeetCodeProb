class Solution {
    public String reversePrefix(String s, int k) {
        int i = 0;
        int j = k-1;
        char temp = '\0';
        char[] arr = s.toCharArray();
        while(i<=j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        String str = new String(arr);
        return str;
    }
}