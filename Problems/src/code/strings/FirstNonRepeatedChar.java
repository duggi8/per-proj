package code.strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		String st = "ababccefgb";
		System.out.println(usingLinkedHashMap(st));
		System.out.println(usingSetAndList(st));
		System.out.println(usingHashMap(st));
		System.out.println(firstNonRepeatingCharWithRegex(st));
		System.out.println(firstNonRepeatChar(st));
	}
	/*LinkedHashMap maintains the order of insertion. 
	 * HashMap do not and TreeMap sorts the entries according to ascending order of keys.
	O(2n)*/
	public static char usingLinkedHashMap(String s) {
		Map<Character,Integer> map = new LinkedHashMap<>(s.length());
		
		for(char c : s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else
				map.put(c, 1);
		}
		
		for(Entry<Character,Integer> entry : map.entrySet()) {
			if(entry.getValue()==1) {
				return entry.getKey(); 
			}
		}
		throw new RuntimeException("did not find any non repeated characters");
	}

	/*Set does not allow duplicates and have no order.
	 *Element from an Arraylist can be removed using 'remove' method by specifying the object reference directly as its method argument. */
	public static char usingSetAndList(String s) {
		Set<Character> set = new HashSet<>(s.length());
		List<Character> list = new ArrayList<>(s.length());
		for(char c:s.toCharArray()) {
			if(!set.contains(c)) {
				set.add(c);
				list.add(c);
			}
			else {
				list.remove((Character)c);
			}
		}
		return list.get(0);
	}
	/*Store the count of character in string in HashMap and then iterate string to find the count.The first character in string which has count '1'
	 * in map is our result.*/
	public static char usingHashMap(String s) {
		Map<Character,Integer> map = new HashMap<>(s.length());
		for(char c:s.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}
			else {
				map.put(c, map.get(c)+1);
			}
		}
		for(int i =0;i<s.length();i++) {
			char c = s.charAt(i);
			if(map.get(c)==1) {
				return c;
			}
		}
		throw new RuntimeException("did not find any non repeated characters");
	}
	
	public static char firstNonRepeatingCharWithRegex(String word) {
		for (int i = 0; i < word.length(); i++) {
		char letter = word.charAt(i);
		if (!word.matches("(.*)" + letter + "(.*)" + letter + "(.*)")) {
		return letter;
		}
		}
		return ' ';
		}
	
	public static Character firstNonRepeatChar(String s){
		int[] found = new int[256];
		char[] chars = s.toCharArray();

		for(int i=0; i< chars.length; i++)
		found[chars[i]]++;

		for(int i=0; i< chars.length; i++){
		if(found[chars[i]]==1)
		return chars[i];
		} 
		return null; 
		}


}
