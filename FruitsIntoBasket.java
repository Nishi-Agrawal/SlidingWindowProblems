/*
Problem Statement 
Given an array of characters where each character represents a fruit tree, you are given two baskets 
and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket
 can have only one type of fruit.
You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit
 from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
Write a function to return the maximum number of fruits in both the baskets.

Example 1:
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Example 2:
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

*/
import java.util.*;

public class FruitsIntoBasket {
	
	public static int fruitsIntoBaskets(char[] arr) {
		int windowStart = 0;
		int longestSequence = 0;
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			char c = arr[windowEnd];
			count++;
			if(map.containsKey(c)) {
				int temp = map.get(c);
				map.put(c, temp+1);
			}
			else {
				map.put(c, 1);
			}
			
			if(map.size() > 2) {
				count--;
				char charInMap = arr[windowStart];
				if(map.get(charInMap) == 1) {
					map.remove(charInMap);
				}
				else {
					int temp = map.get(charInMap);
					map.put(charInMap, temp-1);
				}
				windowStart++;
			}
			longestSequence = Math.max(longestSequence, count);
		}
		
		return longestSequence;
	}

	public static void main(String[] args) {
		char[] fruit = {'A', 'B', 'C', 'A', 'C'};
		//char[] fruit = {'A', 'B', 'C', 'B', 'B', 'C'};
		System.out.println(fruitsIntoBaskets(fruit));

	}

}
