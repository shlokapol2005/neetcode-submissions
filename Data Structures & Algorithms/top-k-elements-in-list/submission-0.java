class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Bucket array
        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Place numbers into buckets
        for (int num : count.keySet()) {
            int c = count.get(num);
            freq[c].add(num);
        }

        // Collect top k
        int[] res = new int[k];
        int idx = 0;

        for (int i = freq.length - 1; i >= 0; i--) {

            for (int num : freq[i]) {

                res[idx++] = num;

                if (idx == k) {
                    return res;
                }
            }
        }

        return res;
    }
}