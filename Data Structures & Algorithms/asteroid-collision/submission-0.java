class Solution {
    public int[] asteroidCollision(int[] asteroids) {
     
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > 0) {  // jabtak positive hai push karte raho in stack
                st.push(asteroids[i]);
            } else {

                // collision handling
                while (!st.isEmpty() && st.peek() > 0 
                       && st.peek() < -asteroids[i]) {
                    st.pop();
                }

                // equal size then both destroyed 
                if (!st.isEmpty() && st.peek() == -asteroids[i]) {
                    st.pop();
                }
                // no collision → push
                else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }

        // convert stack to array --> this is req for java 
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}