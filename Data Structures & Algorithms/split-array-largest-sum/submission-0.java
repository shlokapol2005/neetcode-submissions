class Solution {
 // SAME AS BOOK ALLOCATION AND PAINTER PROBLEM - DITTO SAME
    public int countPartitions(int[] nums, int maxSum) {

        int partitions = 1;
        long currSum = 0;

        for (int num : nums) {

            if (currSum + num <= maxSum) {
                currSum += num;
            } else {
                partitions++;
                currSum = num;
            }
        }

        return partitions;
    }

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int partitions = countPartitions(nums, mid);

            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}

// class Solution {

//     public int countStudents(int[] books, int maxPages) {

//         int students = 1;
//         long pages = 0;

//         for (int book : books) {

//             if (pages + book <= maxPages) {
//                 pages += book;
//             } else {
//                 students++;
//                 pages = book;
//             }
//         }

//         return students;
//     }

//     public int findPages(int[] books, int students) {

//         int n = books.length;

//         if (students > n) {
//             return -1;
//         }

//         int low = 0;
//         int high = 0;

//         for (int book : books) {
//             low = Math.max(low, book);
//             high += book;
//         }

//         while (low <= high) {

//             int mid = low + (high - low) / 2;

//             int requiredStudents = countStudents(books, mid);

//             if (requiredStudents > students) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return low;
//     }
// }