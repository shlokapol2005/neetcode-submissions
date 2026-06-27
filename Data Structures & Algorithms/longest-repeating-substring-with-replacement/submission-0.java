class Solution {
    public int characterReplacement(String s, int k) {
        
int[] hash = new int[26]; //hash array of 26 alphabets so store alphabet and freq
        int maxlen = 0;
        int l = 0;
        int maxfreq = 0;

        for(int r = 0 ; r < s.length(); r++){
                hash[s.charAt(r)- 'A']++;
                maxfreq = Math.max(maxfreq, hash[s.charAt(r) - 'A']);
         // shrink window if more than k replacements needed
            while ((r - l + 1) - maxfreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            // update answer
            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }
}
