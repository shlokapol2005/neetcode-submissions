class Solution {
    public int largestRectangleArea(int[] heights) {
        
int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int[] leftsmall = new int [n];
        int[] rightsmall = new int [n];


//pse
        for(int i = 0 ; i < heights.length ; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();

            }
            leftsmall[i] = st.isEmpty() ? 0 :  st.peek()+1;      
            st.push(i);
              }

              st.clear();

              // Compute NSE (Nearest Smaller to Right)
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                rightsmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
                st.push(i);
            }

            int maxarea = 0;
            for (int i = 0; i < n; i++) {
                int width = rightsmall[i] - leftsmall[i] + 1;
                maxarea = Math.max(maxarea, heights[i] * width);
            }

            return maxarea;
    }
}
