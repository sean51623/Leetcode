import java.util.*;

public class SubstringConcatenation {
	public static void main(String[] args) {
		
		List<Integer> test = findSubstring("abaababbaba", new String[]{"ab","ba","ab","ba"});
		for (int i = 0 ; i < test.size() ; i++ ) {
			System.out.print(test.get(i)+" ");
		}
	}

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        
        if (s==null || s.length()==0) return ans;
        
        int len = words[0].length();
        int start = 0, count = 0;
        HashMap<String, Integer> dict = new HashMap<>();
        //HashMap<String, Integer> rec = new HashMap<>();
        for (int i = 0 ; i < words.length ; i++) {
            if (!dict.containsKey(words[i])) dict.put(words[i],1);
            else dict.put(words[i],dict.get(words[i])+1);
        }
        
        int i = 0;
        HashMap<String,Integer> rec = new HashMap<>(dict);
        
        while(i <= s.length() - (words.length-count)*len) {
            String tmp = s.substring(i,i+len);
			System.out.println(tmp);
            if (dict.containsKey(tmp)) {
                if (count == 0) start = i;
                
                if (!rec.containsKey(tmp)) {
                    i = start+1;
                    count = 0;
                    rec = new HashMap<>(dict);
                }
                else {
                    int c = rec.get(tmp)-1;
                    if (c<=0) rec.remove(tmp);
                    else rec.put(tmp, c);
                    
                    count++;
                    i = i+len;
                    
                    if (rec.isEmpty()) {
                        ans.add(start);
                        count = 0;
                        rec = new HashMap<>(dict);
                        i = start+1;
                    }
                }
            }
            else {
                rec = new HashMap<>(dict);
                count = 0;
                i = start + 1 ;
				start ++;
            }
        }
        
        return ans;
    }
}

/*
"abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa
babababababababab", ["ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
"ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba",
"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
"ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba",
"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
"ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba",
"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
"ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba",
"ab","ba","ab","ba"]
*/