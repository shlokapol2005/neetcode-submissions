class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < tokens.length ; i++){
            String token = tokens[i];

        if(token.equals("+") ||token.equals("-") || token.equals("/") ||token.equals("*")  ){
            int b = st.pop();   // pop top 2 and usme woh operator lagado
            int a = st.pop();
            

            if (token.equals("+")) {
                    st.push(a + b);
                } else if (token.equals("-")) {
                    st.push(a - b);
                } else if (token.equals("*")) {
                    st.push(a * b);
                } else {
                    st.push(a / b);
                }
        } else{  // numbers ko push kardo
            st.push(Integer.parseInt(token)) ;  //Integer.parseInt(token) converts a String into an int.--> Integer.parseInt("5") returns : 5
        }


        }
        return st.pop();   //final stack wil only have the answer - i.e one digit
    }
}