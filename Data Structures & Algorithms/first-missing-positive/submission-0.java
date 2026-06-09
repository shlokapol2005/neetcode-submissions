class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
 // Place each number at its correct index(we care only abt positive no.,1st +ve no chaiye so less than n we care)
        for(int i = 0; i<n;i++){
            while( nums[i]>0 && nums[i]<=n && nums[i]!=nums[nums[i]-1] ){ //correct index placement for x is x-1
            
            int correctindex = nums[i]-1;

            int temp = nums[i];
            nums[i] = nums[correctindex];
            nums[correctindex] = temp;
            }
        }
          //  the first index where value != index + 1 --> so thats the missing
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
    