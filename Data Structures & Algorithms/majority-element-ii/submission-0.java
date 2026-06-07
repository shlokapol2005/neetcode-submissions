class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int el1 = Integer.MIN_VALUE;
        int el2 =  Integer.MIN_VALUE;
        
        int count1 =0;
        int count2 =0;

        for(int i =0; i<nums.length ; i++){

            if(count1 ==0 && nums[i]!= el2){
                el1 = nums[i];
                count1=1;
            } else if (count2 == 0 && nums[i] != el1){
                el2 = nums[i];
                count2 =1;
                }
                else if (nums[i]== el1) count1++;
                else if(nums[i] == el2)count2++;
         else{
            count1 --;
            count2--;

        }
        }

        List<Integer> result = new ArrayList<>();
        int checkCount1 = 0;
        int checkCount2 = 0;
        for (int num : nums) {
            if (count1 > 0 && num == el1) checkCount1++;
            if (count2 > 0 && num == el2) checkCount2++;
        }
        if (checkCount1 > nums.length / 3) result.add(el1);
        if (checkCount2 > nums.length / 3) result.add(el2);
        return result;
    }
}