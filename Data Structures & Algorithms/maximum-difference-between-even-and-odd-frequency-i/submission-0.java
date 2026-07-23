class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer>map= new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);

        }
        int maxodd= Integer.MIN_VALUE;
        int mineven= Integer.MAX_VALUE;

        //fidnd max odd and min even in the table
        for(int freq: map.values()){
            if(freq % 2 == 1){
                maxodd = Math.max(maxodd,freq);

            }else{
                mineven = Math.min(mineven,freq);
            }
        }
        return maxodd-mineven;
    }
}