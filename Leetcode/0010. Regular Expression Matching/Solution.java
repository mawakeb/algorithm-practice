class Solution {

    public boolean isMatch(String s, String p) {

        // current index for s
        int i = 0;
        // current index for p
        int j = 0;

        while (j<p.length()) {
            char curP = p.charAt(j);

            // support for '*'
            if (j<p.length()-1 && p.charAt(j+1) == '*'){
                //skip if unmatched with current character in s
                if (i<s.length() && curP != '.' && s.charAt(i) != curP) j += 2;
                    //skip if s has ended
                else if (i>=s.length()) j += 2;
                else {
                    //decide if current character in s should be matched now
                    String tempS = s.substring(i, s.length());
                    String tempP = p.substring(j+2, p.length());
                    if (isMatch(tempS, tempP)){
                        j+=2;
                    } else {
                        i++;
                    }
                }
            }

            // normal alphabet
            else if (i<s.length() && curP >= 'a' && curP <= 'z') {
                if (curP!=s.charAt(i)) return false;
                i++;
                j++;
            }

            // support for '.'
            else if (i<s.length() && curP == '.'){
                i++;
                j++;
            }

            else return false;
        }

        // if part of s or p is left unmatched return false
        if (i<s.length()) return false;

        return true;
    }


}