class Solution {
   
         public static int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;

        for (int x : piles) {
            maxi = Math.max(maxi, x);
        }

        return maxi;
    }
    public static int calculateTotalhrs(int[] piles,int hourly){
        int totalH = 0;  //to calculate how many hrs har pile leraha hai after xbanan/hourly is found out
        for(int pile:piles){
            totalH += (pile + hourly - 1) / hourly; // totalH += (int)Math.ceil((double)pile / hourly);
        } 
        return totalH;
    }

    public static int minEatingSpeed(int[]piles, int h){

int low = 1;
        int high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int totalH = calculateTotalhrs(piles, mid);

            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}