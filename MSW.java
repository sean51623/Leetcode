import java.util.*;

public class MSW {
	public static void main(String[] args) {
		System.out.println(minWindow("a","a"));
		System.out.println(minWindow("bdab","ab"));
	}
	
    public static String minWindow(String s, String t) {
        
        HashMap<Character, Integer> rec = new HashMap<>();
        for (int i = 0 ; i < t.length() ; i++) {
            if (!rec.containsKey(t.charAt(i))) rec.put(t.charAt(i),1);
            else rec.put(t.charAt(i),rec.get(t.charAt(i))+1);
        }
        
        int start = 0 , end = 0 , count = 0;
        String res = s+" ";
        for (int i = 0 ; i < s.length() ; i++) {
            if (rec.containsKey(s.charAt(i))) {
                if (rec.get(s.charAt(i))>0)count++;
                rec.put(s.charAt(i), rec.get(s.charAt(i))-1);
            }
            
            while(count==t.length()) {
                if (rec.containsKey(s.charAt(start)) && rec.get(s.charAt(start))<=0) {
                    rec.put(s.charAt(start), rec.get(s.charAt(start))+1);
					System.out.println(res);
                    if (rec.get(s.charAt(start))>0) {
                        if (i-start+1 <= res.length()) res = s.substring(start, i+1);
						System.out.println(res);
                        count--;
                        continue;
                    }
                    
                }
                start++;
            }
            
        }
        
        return res.length()>s.length()?"":res;
    }
}