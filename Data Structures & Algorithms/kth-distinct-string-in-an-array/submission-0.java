class Solution {
    public String kthDistinct(String[] arr, int k) {

        // Store frequency of each string
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : arr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Traverse in original order
        for (String word : arr) {

            // Check if current word is distinct
            if (map.get(word) == 1) {

                // Found one distinct string
                k--;

                // If this is the kth distinct string
                if (k == 0) {
                    return word;
                }
            }
        }

        // Less than k distinct strings exist
        return "";
    }
}