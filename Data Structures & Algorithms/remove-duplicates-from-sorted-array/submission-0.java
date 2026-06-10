class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 0)
        return 0 ;

        int count = 1; // count = next position where I should place a unique element
//initially 1 as first element will always be unique
        for(int i = 1;i<nums.length ; i++){
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i];   //nums[count]???
                count++; 
            }
        }
        return count;
    }
}