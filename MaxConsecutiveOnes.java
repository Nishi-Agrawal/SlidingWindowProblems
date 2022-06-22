import java.util.*;

/*
Problem Statement 
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
Example 1:
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
Example 2:
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
*/

public class MaxConsecutiveOnes {
	
	public static int longestOnes(int[] A, int K) {
		int[] freq = new int[2];
		int windowStart = 0;
		int max = 0;
		
		for(int windowEnd = 0; windowEnd < A.length; windowEnd++) {
			int temp = A[windowEnd];
			freq[temp]++;
			
			while(freq[0] > K) {
				int startWindow = A[windowStart];
				freq[startWindow]--;
				windowStart++;
			}
			
			max = Math.max(max, windowEnd - windowStart + 1);
			
		}
		
		return max;
	}

	public static void main(String[] args) {
		int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		System.out.println(longestOnes(A, 3));

	}

}
