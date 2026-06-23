class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer>st = new Stack<>();
 int[] nge = new int[n];

        for(int i = nums2.length -1 ; i>=0 ; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();

            }
        nge[i] = st.isEmpty() ? -1 : st.peek();    //agar stack empty hai toh nge ans array mai-1 warna st.peek
            st.push(nums2[i]);   // nums arr ke eleemnt ko push kardo
                map.put(nums2[i], nge[i]);   // <-- Missing line
        }
         int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}