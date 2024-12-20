// Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

// Examples :

// Input: arr[] = [2, 3, 4, 7, 11], k = 5
// Output: 9
// Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
// Input: arr[] = [1, 2, 3], k = 2
// Output: 5
// Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
// Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
// Output: 2
// Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.

// CODE:


class Solution {
    public int kthMissing(int[] arr, int k) {
          int left = 0, right = arr.length - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missingBefore = arr[mid] - (mid + 1);

            if (missingBefore < k) {
                // If fewer than k numbers are missing, move to the right half
                left = mid + 1;
            } else {
                // Otherwise, move to the left half
                right = mid - 1;
            }
        }

        // At the end of the loop, `left` is the position where `k` lies
        // If `k` lies before the array starts:
        // Result is `k + left`
        return k + left;
    }
}