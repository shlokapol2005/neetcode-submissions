class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found the target
            if (nums[mid] == target) {
                return true;
            }

  // Handle duplicates: shrink the search range
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {
                // Target is in the left sorted half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else { // Otherwise, search right half
                    low = mid + 1;
                }
            }
            // Otherwise, right half must be sorted
            else {
                // Target is in the right sorted half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else { // Otherwise, search left half
                    high = mid - 1;
                }
            }
        }

        // Not found
        return false;
    }
}