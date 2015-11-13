import java.util.*;
public class RepeatedDNASequences {
	public static void main(String[] args) {
		List<String> a = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		for (String i: a) System.out.println(i);
		
		// test case
		List<String> b = findRepeatedDnaSequences("AAAAAAAAAAAA");
		for (String i: b) System.out.println(i);
	}
	
    public static List<String> findRepeatedDnaSequences(String s) {
        /*
		List<String> ans = new ArrayList<>();
        if (s.length() <= 10) return ans;
        
        HashSet<String> rec = new HashSet<>();
		StringBuilder start = new StringBuilder(s.substring(0,10));
		rec.add(start.toString());
		
        for (int i = 1 ; i < s.length()-10 ; i++) {
            start.deleteCharAt(0);
			start.append(s.charAt(i+9));
			//System.out.println(start);
            if (rec.contains(start.toString())) ans.add(start.toString());
			else rec.add(start.toString());
        }
        
        return ans;
		*/
		
		List<String> ans = new ArrayList<>();
        if (s.length() <= 10) return ans;
		HashMap<Character, Integer> mp = new HashMap<>();
		HashSet<Long> rec = new HashSet<>();
		HashSet<Long> repeat = new HashSet<>();
		mp.put('A',1); mp.put('C',2); mp.put('G',3); mp.put('T',4);
		
		long val = 0;
		for (int i = 0 ; i < 10 ; i++) {
			val = 5*val+mp.get(s.charAt(i));
		}
		rec.add(val);
		
		for (int i = 10 ; i < s.length() ; i++) {
			val -= (mp.get(s.charAt(i-10))*Math.pow(5,9));
			val = 5*val + mp.get(s.charAt(i));
			if (rec.contains(val) && !repeat.contains(val)) {
				ans.add(s.substring(i-9,i+1));
				repeat.add(val);
			}
			else rec.add(val);
		}
		
		return ans;
    }
}