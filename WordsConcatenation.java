import java.util.*;
public class WordsConcatenation {
	
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> l = new ArrayList<>();
		int windowStart = 0;
		int wordLength = words[0].length();
		int have = 0;
		int letters = words.length;
		
		
		Map<String, Integer> wordsMap = new HashMap<>();
		Map<String, Integer> sMap = new HashMap<>();
		for(String word : words) {
			if(wordsMap.containsKey(word)) {
				int temp = wordsMap.get(word);
				wordsMap.put(word, temp+1);
			}
			else {
				wordsMap.put(word, 1);
			}
		}
		int count = 0;
		int need = wordsMap.size();
		for(int windowEnd = 0; windowEnd < s.length() - wordLength; windowEnd += wordLength) {
			String current = s.substring(windowEnd, windowEnd + wordLength);
			count++;
			if(sMap.containsKey(current)) {
				int temp = sMap.get(current);
				sMap.put(current, temp+1);
			}
			else {
				sMap.put(current, 1);
			}
			
			if(wordsMap.containsKey(current)) {
				int temp = wordsMap.get(current);
				int sMapLength = sMap.get(current);
				if(temp == sMapLength) {
					have++;
				}
			}
			
			if(count == letters) {
				if(have == need) {
					l.add(windowStart);
				}
				String newString = s.substring(windowStart, windowStart + wordLength);
				int startWordTime = sMap.get(newString);
				if(startWordTime == 1) {
					sMap.remove(newString);
				}
				else {
					sMap.put(newString, startWordTime - 1);
				}
				if(wordsMap.containsKey(newString)) {
					int wordM = wordsMap.get(newString);
					if(wordM != startWordTime - 1) {
						have--;
					}
				}
				count--;
				windowStart+=wordLength;
				
			}
			
			
		}
		return l;
	}

	public static void main(String[] args) {
		String s = "barfoofoobarthefoobarman";
		String[] words = {"bar","foo","the"};
		System.out.println(findSubstring(s, words));
	}

}
