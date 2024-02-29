class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        int wordLen = words[0].length();
        int substrLen = wordLen * words.length;

        // make a map from word to count
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words){
            int c = getHelper(wordCount, w);
            if (c<0) wordCount.put(w, 1);
            else wordCount.replace(w, c+1);
        }

        // sliding window to check if each substring is a concatenation
        for (int i = 0; i + substrLen <= s.length(); i++){
            String substr = s.substring(i, i+substrLen);
            if (checkSubstring(substr, wordCount, wordLen)) res.add(i);
        }

        return res;
    }

    public boolean checkSubstring(String s, Map<String, Integer> wordCount, int wordLen){

        Map<String, Integer> sCount = new HashMap<>();
        int i = 0;
        while (i<s.length()){
            String piece = s.substring(i, i+wordLen);
            //add to sCount and wait for final comparison
            int c = getHelper(sCount, piece);
            if (c<0) sCount.put(piece, 1);
            else sCount.replace(piece, c+1);
            i += wordLen;
        }

        return wordCount.equals(sCount);
    }

    public int getHelper(Map<String, Integer> m, String k){
        Object v = m.get(k);
        if (v == null) return -1;
        return (int) v;
    }
}