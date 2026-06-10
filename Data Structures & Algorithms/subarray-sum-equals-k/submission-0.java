class Solution {
    // Function to find count of subarrays with sum equal to k using prefix sums and hashmap
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;

        // Map to store frequency of prefix sums
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        // Base case
        prefixSumCount.put(0, 1);

        for (int i = 0; i < n; i++) {

            // Update prefix sum
            prefixSum += arr[i];

            // Find required prefix sum
            int remove = prefixSum - k;

            // Add its frequency to count
            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }

            // Store/update current prefix sum frequency
            prefixSumCount.put(
                prefixSum,
                prefixSumCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }
}