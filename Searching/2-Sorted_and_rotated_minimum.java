// A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

// Examples:

// Input: arr[] = [5, 6, 1, 2, 3, 4]
// Output: 1
// Explanation: 1 is the minimum element in the array.
// Input: arr[] = [3, 1, 2]
// Output: 1
// Explanation: Here 1 is the minimum element.
// Input: arr[] = [4, 2, 3]
// Output: 2
// Explanation: Here 2 is the minimum element.


// CODE:

class Solution {
    public int findMin(int[] arr) {
     int n = arr.length;
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if the middle element is greater than the rightmost element
            if (arr[mid] > arr[high]) {
                // Minimum is in the right half
                low = mid + 1;
            } else {
                // Minimum is in the left half, including mid
                high = mid;
            }
        }

        // `low` points to the minimum element
        return arr[low];
    }
}