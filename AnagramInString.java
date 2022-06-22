import java.util.*;
public class AnagramInString {
	
	public static List<Integer> findAnagrams(String s1, String s2) {
		List<Integer> toReturn = new ArrayList<>();
		int windowStart = 0;
		if(s1.length() > s2.length()) {
			return toReturn;
		}
		char[] s1char = s1.toCharArray();
		Arrays.sort(s1char);
		for(int windowEnd = s1.length() - 1; windowEnd < s2.length(); windowEnd++) {
			
			String temp = s2.substring(windowStart, windowStart+s1.length());
			char[] substringChar = temp.toCharArray();
			Arrays.sort(substringChar);
			if(Arrays.equals(s1char, substringChar)) {
				toReturn.add(windowStart);
			}
			windowStart++;			
		}
		return toReturn;
		
	}

	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(p, s));

	}

}
