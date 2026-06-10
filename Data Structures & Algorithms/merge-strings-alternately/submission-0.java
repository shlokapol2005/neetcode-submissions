class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder output = new StringBuilder();

         int i = 0;
         int j = 0;
// word1 and word2 
          while (i < word1.length() && j < word2.length()) {
            output.append(word1.charAt(i++));
            output.append(word2.charAt(j++));
        }
//left overword1 ka stuff
            while (i < word1.length()) {
            output.append(word1.charAt(i++));
        }
// leftover word2 ka stuff
        while (j < word2.length()) {
            output.append(word2.charAt(j++));
        }

        return output.toString();
    }
}