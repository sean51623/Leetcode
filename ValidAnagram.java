import java.util.*;
public class ValidAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","nagaram"));
		System.out.println(isAnagram("anag","nram"));
	}
	
	public static boolean isAnagram(String s, String t) {
		if (s.length()==0 && t.length()==0) return true;
		//if (s.length()==0 || t.length()==0) return false;
		if (s.length()!=t.length()) return false;
		
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		
		Arrays.sort(ss);
		Arrays.sort(tt);
		return Arrays.equals(ss,tt);
	}
}