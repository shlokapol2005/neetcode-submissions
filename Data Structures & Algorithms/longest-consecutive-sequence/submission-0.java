

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);   //first store all in hashset
        }

        int longest = 0;

        for (int num : set) {
            // only start counting if num is the start of a sequence
            if (!set.contains(num - 1)) {
                int length = 1;
                int curr = num;

                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}