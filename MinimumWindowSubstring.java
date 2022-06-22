import java.util.*;
public class MinimumWindowSubstring {
	
	public static String minWindow(String s, String t) {
		String toReturn = "";
		if(s.equals(t)) {
			return s;
		}
		
		if(t.length() > s.length()) {
			return toReturn;
		}
		
		int windowStart = 0;
		int have = 0;
		int need = t.length();
		int minIndex = 0;
		int minIndexLength = Integer.MAX_VALUE;
		Map<Character, Integer> Smap = new HashMap<>();
		Map<Character, Integer> Tmap = new HashMap<>();
		for(int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if(Tmap.containsKey(c)) {
				int temp = Tmap.get(c);
				Tmap.put(c, temp+1);
			}
			else {
				Tmap.put(c, 1);
			}
			
		}
	
		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char schar = s.charAt(windowEnd);
			if(Smap.containsKey(schar)) {
				int temp = Smap.get(schar);
				Smap.put(schar, temp+1);
			}
			else {
				Smap.put(schar, 1);
			}
			
			if(Tmap.containsKey(schar)) {
				int thave = Tmap.get(schar);
				int shave = Smap.get(schar);
				if(thave == shave) {
					have++;
				}
			}
			
			if(have == need) {
				while(have == need) {
					if(windowEnd - windowStart + 1 < minIndexLength) {
						minIndexLength = windowEnd - windowStart + 1;
						minIndex = windowStart;
					}
					char startchar = s.charAt(windowStart);
					int sMapStartChar = Smap.get(startchar);
					if(sMapStartChar == 1) {
						Smap.remove(startchar);
					}
					else {
						Smap.put(startchar, sMapStartChar - 1);
					}
					sMapStartChar--;
					if(Tmap.containsKey(startchar)) {
						int TMapStartChar = Tmap.get(startchar);
						if(TMapStartChar != sMapStartChar) {
							have--;
						}
					}
					windowStart++;
					
				}
			}
			
			
		}
		if(minIndexLength != Integer.MAX_VALUE) {
			toReturn = s.substring(minIndex, minIndex+minIndexLength);
		}
		
		
		return toReturn;
		
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADCAD", "ABC"));

	}

}
