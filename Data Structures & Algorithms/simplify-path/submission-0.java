class Solution {
    public String simplifyPath(String path) {
        
        String[] arr = path.split("/");
        Stack<String> stack= new Stack<>();

        for(String i : arr){

            if(i.equals("..") && !stack.isEmpty()){   //AGAR .. hai and empty nai hai toh pop
                stack.pop();

            } else if(!i.equals(".")  && !i.equals("..") && !i.equals("")){
                stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        //iterate thru stack 
        for(String i : stack){
            //start mai /
            sb.append("/");
            sb.append(i); //stack ki chize
        }
return sb.length() == 0 ? "/" : sb.toString();
    }
}