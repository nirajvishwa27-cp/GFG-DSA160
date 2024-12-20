// You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

// Examples :

// Input: stalls[] = [1, 2, 4, 8, 9], k = 3
// Output: 3
// Explanation: The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
// Input: stalls[] = [10, 1, 2, 7, 5], k = 3
// Output: 4
// Explanation: The first cow can be placed at stalls[0],
// the second cow can be placed at stalls[1] and
// the third cow can be placed at stalls[4].
// The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.
// Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
// Output: 1
// Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
// The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.

// CODE:

import java.util.Arrays;

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        int ans = 0;
        Arrays.sort(stalls);
        if(k == n) return 1;
        int low = 1, high = stalls[n-1]-stalls[0];
        while(low<=high){
            int dist = low+(high-low)/2;
            if(can_placed(stalls, dist, k)==true){
                ans = dist;
                low = dist+1;
            }else high = dist-1;
            
        }
        return ans;
        
    }
    static boolean can_placed(int [] stalls, int dist, int k) {
        int count_cow = 1, last = stalls[0];
        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-last>=dist){
                count_cow++;
                last =stalls[i];
            }if(count_cow>=k) return true; 
        }
        return false;
    }
}