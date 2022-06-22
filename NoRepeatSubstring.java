/*
Problem Statement 
Given a string, find the length of the longest substring which has no repeating characters.
Example 1:
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
Example 2:
Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
Example 3:
Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
*/
import java.util.*;
public class NoRepeatSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
		int windowStart = 0;
		int longestSequence = 0;
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char c = s.charAt(windowEnd);
			if(map.containsKey(c)){
				int temp = map.get(c);
				map.put(c, temp+1);
			}
			else {
				map.put(c, 1);
				}
				
			
			count++;
			
			while(count != map.size()) {
				count--;
				char letterToRemove = s.charAt(windowStart);
				if(map.get(letterToRemove) == 1) {
					map.remove(letterToRemove);
				}
				else {
					int temp = map.get(letterToRemove);
					map.put(letterToRemove, temp-1);
				}
				
				windowStart++;
				
			}
			longestSequence = Math.max(longestSequence, count);
		
		}
		return longestSequence;
	}

	public static void main(String[] args) {
		//String s = "aabccbb";
		//String s = "abbbb";
		String s = "abccde";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
