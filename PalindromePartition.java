import java.util.*;
public class PalindromePartition {

	public static void main(String[] args) {
		List<List<String>> hi = partition("aabbbaa");
		for (int i = 0 ; i < hi.size() ; i++) {
			for (int j = 0 ; j < hi.get(i).size() ; j++) {
				System.out.print(hi.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if (s==null || s.length()==0) return ans;
        
        solver(s,0,ans,new ArrayList<String>());
        return ans;
    }
    
    public static void solver(String s, int idx, List<List<String>> ans, ArrayList<String> cur) {
        if (idx>=s.length()) {
            ans.add(new ArrayList<String>(cur));
            return;
        }
        
        for (int i = idx ; i < s.length() ; i++) {
            String tmp = s.substring(idx,i+1);
            if (isP(tmp)) {
                cur.add(tmp);
                solver(s,i+1,ans,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    public static boolean isP(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<=end) {
            if (s.charAt(start)!=s.charAt(end)) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}