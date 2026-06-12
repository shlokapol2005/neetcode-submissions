class Solution {
    public int searchInsert(int[] nums, int target) {

      int n = nums.length; //size of the array.
        int low = 0, high = n - 1;

        // Perform the steps:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return low;  // when the loop ends i.e when low>high --> wherever low is there thats the place to insert
    }   
    }