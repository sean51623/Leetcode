import java.util.*;
public class PalindromePermutation {
	public static void main(String[] args) {
		List<String> ans = generatePalindromes("aabbc");
		for (String s: ans) {
			System.out.println(s);
		}
	}

    public static List<String> generatePalindromes(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s==null || s.length()==0 ) return res;
        
        char [] charArray = s.toCharArray();
        Arrays.sort(charArray);
        ArrayList<Character> element = new ArrayList<>();
        
        int single = 0, count = 1;
        char cur = charArray[0];
        char singlechar = ' ';
        //if (charArray.length==1) singlechar = cur;
        for (int i = 1 ; i < charArray.length ; i++) {
            if (charArray[i]==cur) count++;
            else {
                if (count%2!=0) {
                    if (single!=0) return res;
                    else {
                        single = 1;
                        singlechar = cur;
                    }
                }
                for (int j = 0 ; j < count/2 ; j++) element.add(cur);
                cur = charArray[i];
                count = 1;
            }
        }
        
        
        if (count%2!=0) {
            if (single!=0) return res;
            else {
                single = 1;
                singlechar = cur;
            }
        }
        for (int j = 0 ; j < count/2 ; j++) element.add(cur);
        //System.out.println(element.size());
		//System.out.println(singlechar);
		//for (char c: element) System.out.print(c);
		//System.out.println();
		
        boolean[] used = new boolean[element.size()];
        solve(res, element, singlechar, used, new StringBuilder());
        return res;
    }
    
    public static void solve(ArrayList<String> res, ArrayList<Character> element, char singlechar, boolean [] used, StringBuilder sb) {
        //System.out.println(sb);
		if (sb.length()==element.size()) {
            StringBuilder sb2 = new StringBuilder(sb.reverse());
			sb.reverse();
			//System.out.println(sb);
			//System.out.println(sb2);
			//System.out.println(sb);
            if (singlechar!=' ') {
                sb.append(singlechar);
                //sb.append(sb2);
            }
            //else sb.append(sb2);
			//System.out.println(sb);
			String s = sb.toString() + sb2.toString();
			//System.out.println(sb);
			if (singlechar!=' ') sb.deleteCharAt(sb.length()-1);
            res.add(s);
            return;
        }
        for (int i = 0 ; i < element.size() ; i++) {
            if (used[i] || (i!=0 && element.get(i)==element.get(i-1) && !used[i-1])) continue;
			System.out.println(sb.length());
            sb.append(element.get(i));
            used[i] = true;
			//System.out.println(sb);
            solve(res, element, singlechar, used, sb);
            used[i] = false;
			System.out.println(sb.length());
            sb.deleteCharAt(sb.length()-1);
        }
    }
}