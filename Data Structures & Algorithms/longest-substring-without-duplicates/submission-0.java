class Solution {
    public int lengthOfLongestSubstring(String s) {
         
         int[] hash = new int[256];   //Stores the last index where each ASCII character appeared.
           for (int i = 0; i < 256; i++)
            hash[i] = -1;  //start mai -1 so means not been seen yet

         int left =0;
         int right=0; 
         int maxlen = 0;

         int n= s.length();

         while(right < n ){
        char c = s.charAt(right);

            // if character already seen AND inside current window
            if (hash[c] != -1 && hash[c] >= left) {
                left = hash[c] + 1;
            }

            int len = right - left + 1;
            maxlen = Math.max(maxlen, len);

            hash[c] = right; // store latest index
            right++;
        }

        return maxlen;
    }
}