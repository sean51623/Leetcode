import java.util.*;
public class MinimumWindowSubstring {
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC","ABC"));
		System.out.println(minWindow("ADODBEDCODDEBDANDC","ABCDD"));
		System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));//cwae
		System.out.println(minWindow("bba","ab"));//ba
	}

    public static String minWindow(String s, String t) {
        String ans = "";
        if (s==null || t==null || s.length()==0 || t.length()==0) return ans;
        
        int start = 0;
        int count = 0;
        int minlen = s.length()+1;
		int [] res = new int[2];
        HashMap<Character, Integer> ch = new HashMap<>();
        HashMap<Character, Integer> rec = new HashMap<>();
        
        for (int i = 0 ; i < t.length() ; i++) {
            ch.put(t.charAt(i),(ch.containsKey(t.charAt(i))?ch.get(t.charAt(i))+1:1));
        }
        
        rec = new HashMap<>(ch);
        for (int i = 0 ; i < s.length() ; i++) {
            if (rec.containsKey(s.charAt(i))) {
                int tmp = rec.get(s.charAt(i));
                tmp--;
				if (rec.get(s.charAt(i))>0) count++;
				rec.put(s.charAt(i),tmp);
            }
            
            while(count==t.length()) {
				if (i-start+1<minlen) {
					res[0] = start;
					res[1] = i+1;
					minlen = i-start+1;
				}
				if (rec.containsKey(s.charAt(start))) {
					rec.put(s.charAt(start),rec.get(s.charAt(start))+1);
					if (rec.get(s.charAt(start))<=ch.get(s.charAt(start)) && rec.get(s.charAt(start))>0) count--;
				}
				start++;
			}
        }
		if (minlen>s.length()) return "";
		return s.substring(res[0],res[1]);
    }
}