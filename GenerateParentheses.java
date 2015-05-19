// Test environment for Leetcode - generate parentheses
import java.util.*;

public class GenerateParentheses {
	public static void main(String[] args) {
		ArrayList<String> qwe = generateParenthesis(2);
		for (int i = 0 ; i < qwe.size() ; i++) {
			System.out.println(qwe.get(i));
		}
	}

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (n<=0) return ans;
        
        gp(0,0,n,ans,"");
        return ans;
    }
    
    public static void gp(int left, int right, int n, ArrayList<String> rec, String tmp) {
        System.out.println("left:"+left+" right:"+right+"  "+tmp);
		if (right>left) return;
        if (left<n) {
            //tmp += "(";
            gp(left+1, right, n, rec, tmp+"(");
        }
        if (right<left) {
            //tmp += ")";
            gp(left, right+1, n, rec, tmp+")");
        }
        if (right==n && left==n) {
            rec.add(tmp);
        }
        
    }
}