// Search in a sorted Matrix
// Difficulty: MediumAccuracy: 56.27%Submissions: 124K+Points: 4
// Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
// Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.

// Examples:

// Input: mat[][] = [[1, 5, 9], [14, 20, 21], [30, 34, 43]], x = 14
// Output: true
// Explanation: 14 is present in the matrix, so output is true.

// Code:

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
   if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }
        
        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns
        int left = 0, right = n * m - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = mat[mid / m][mid % m]; // Map 1D index to 2D indices
            
            if (midElement == x) {
                return true; // Element found
            } else if (midElement < x) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        
        return false; // Element not found
    }
}
