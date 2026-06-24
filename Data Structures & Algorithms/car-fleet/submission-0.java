
//refer notes--last mai
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] cars = new int[n][2];   //merged of (position,speed) array

        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];   //filling 2d array
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> a[0] - b[0]);   //sort by position so closest car to the target is now at the end

        int fleets = 0;
        double maxTime = 0;

        for(int i = n - 1; i >= 0; i--) {

            double time = (target - cars[i][0]) * 1.0 / cars[i][1];    //calcluate timetotarget

            if(time > maxTime) {
                fleets++;
                maxTime = time;
            }
        }

        return fleets;
    }
} //LOGIC LAST WALA

// maxTime = arrival time of fleet ahead

// If current car takes MORE time,
// it can never catch fleet ahead
// => new fleet

// If current car takes LESS/EQUAL time,
// it catches fleet ahead
// => same fleet