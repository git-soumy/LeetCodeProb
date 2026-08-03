class Solution {
    public String reverseByType(String s) {

        StringBuilder letters = new StringBuilder();
        StringBuilder specials = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                letters.append(ch);
            } else {
                specials.append(ch);
            }
        }

        char[] ans = new char[s.length()];

        int letterIndex = letters.length() - 1;
        int specialIndex = specials.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                ans[i] = letters.charAt(letterIndex--);
            } else {
                ans[i] = specials.charAt(specialIndex--);
            }
        }

        return new String(ans);
    }
}