/*
Problem Challenge 1
Permutation in a String (hard) 
Given a string and a pattern, find out if the string contains any permutation of the pattern.
Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters it will have n!n! permutations.
Example 1:
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:
Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:
Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:
Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
*/

import java.util.*;
public class PermutationInString {
	
	public static boolean checkInclusion(String s1, String s2) {
		
		int windowStart = 0;
		if(s1.length() > s2.length()) {
			return false;
		}
		char[] s1char = s1.toCharArray();
		Arrays.sort(s1char);
		for(int windowEnd = s1.length() - 1; windowEnd < s2.length(); windowEnd++) {
			
			String temp = s2.substring(windowStart, windowStart+s1.length());
			char[] substringChar = temp.toCharArray();
			Arrays.sort(substringChar);
			if(Arrays.equals(s1char, substringChar)) {
				return true;
			}
			windowStart++;			
		}		
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidboaooo"));

	}

}
