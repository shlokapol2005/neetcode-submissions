class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        int idx = 0;

        for(int i=0 ; i< n ; i++){

            // 1. Remove indices out of current window
                if(!dq.isEmpty()  && dq.peekFirst() <= i-k ){
                    dq.pollFirst();
                }

             // 2. Remove smaller elements from back
             while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

                // 3. Add current index
                dq.offerLast(i);

                // 4. Store max when window is ready
                if (i >= k - 1) {
                    ans[idx++] = nums[dq.peekFirst()];
                }
            }

            return ans;
        }
    }