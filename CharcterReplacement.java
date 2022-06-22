/*
Problem Statement 
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
find the length of the longest substring having the same letters after replacement.
Example 1:
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:
Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:
Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
*/
import java.util.*;
public class CharcterReplacement {
	
	public int characterReplacement(String s, int k) {
		int[] freq = new int[26];
		int mostFrequentLetter = 0;
		int left = 0;
		int max = 0;
		
		for(int right = 0; right < s.length(); right++) {
			freq[s.charAt(right) - 'A']++;
			mostFrequentLetter = Math.max(mostFrequentLetter, s.charAt(right) - 'A');
			
			int lettersTochange = (right - left + 1) - mostFrequentLetter;
			if(lettersTochange > k) {
				freq[s.charAt(left) - 'A']--;
				left++;
			}
			max = Math.max(max, right-left+1);
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
