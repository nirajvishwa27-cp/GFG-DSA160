// Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
// Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

// Examples :

// Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
// Output: true
// Explanation: 9 is present in the matrix, so the output is true.
// Input: mat[][] = [[19, 22, 27, 38, 55, 67]], x = 56
// Output: false
// Explanation: 56 is not present in the matrix, so the output is false.
// Input: mat[][] = [[1, 2, 9],[65, 69, 75]], x = 91
// Output: false
// Explanation: 91 is not present in the matrix.

// CODE:


class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        int n =mat.length;
        for(int row =0; row<n; row++){
        int low=0, high=mat[0].length-1;
            while(low<=high){
               int mid = low+(high-low)/2;
               if(mat[row][mid]==x) return true;
               else if(mat[row][mid]>x) high = mid-1;
               else low = mid+1;
            
        }
    }
            return false;
}
}
