class Solution {
    public int singleNonDuplicate(int[] nums) {

     int n = nums.length;
//edge cases for first , last and one element in the array 

     if(n==1) return nums[0] ; //only one ele in arr
     if(nums[0]!=nums[1] ) return nums[0]; // if first ele is not equal to 2nd ele
      if (nums[n - 1] != nums[n - 2]) return nums[n - 1];   


      int low = 0;
      int high = n-1;

      while(low<=high){
        int mid = (low+high)/2;

        // Single element found
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            // We are in left half
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } 
            // We are in right half
            else {
                high = mid - 1;
            }
        }
        return -1; // should never reach here
    }
}