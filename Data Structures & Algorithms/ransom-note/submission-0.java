class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        // Count frequencies in magazine
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if ransomNote can be formed
        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                return false;
            }
            freq[c - 'a']--;
        }

        return true;
    }
}