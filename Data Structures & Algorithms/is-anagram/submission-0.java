class Solution {
    public boolean isAnagram(String s, String t) {
//FREQ ARRAY in which a=0, b=1,c=2 as idexes so we just store value and map it wiht the index
if(s.length() != t.length())
return false;

int[] freq = new int[26];

for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
}