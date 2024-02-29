class Solution {
    public int longestValidParentheses(String s) {

        //use stack to make it simpler but this is more efficient

        int curOpen = 0;
        int curValid = 0;
        int maxValid = 0;
        boolean valid = true;

        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                if (!valid){
                    curOpen = 0;
                    valid = true;
                }
                curOpen++;
            } else {
                curOpen--;
                if (curOpen >= 0){
                    curValid++;
                    if (curOpen==0) maxValid = Math.max(curValid, maxValid);
                } else {
                    valid = false;
                    curValid = 0;
                }
            }
        }

        // i have been counting in pairs
        return Math.max(maxValid*2, reverse(s));
    }

    public int reverse(String s) {

        int curOpen = 0;
        int curValid = 0;
        int maxValid = 0;
        boolean valid = true;

        for (int i=s.length()-1; i >= 0; i--){
            if (s.charAt(i) == ')'){
                if (!valid){
                    curOpen = 0;
                    valid = true;
                }
                curOpen++;
            } else {
                curOpen--;
                if (curOpen >= 0){
                    curValid++;
                    if (curOpen==0) maxValid = Math.max(curValid, maxValid);
                } else {
                    valid = false;
                    curValid = 0;
                }
            }
        }

        // i have been counting in pairs
        return maxValid*2;
    }



}