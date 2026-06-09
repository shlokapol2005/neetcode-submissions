class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length ; i++){
        int leftover = target - nums[i];

        if(map.containsKey(leftover)){
            return new int[]{map.get(leftover), i};
        }
      map.put(nums[i], i);  // agar number nahi hai map mai then store kardo
        }

        return new int[]{};
    }
}