import java.util.*;

public class LVP {
	public static void main(String [] args) {
		System.out.println(longestValidParentheses("(((()()()()()))"));
		System.out.println(longestValidParentheses(")))()()"));
	}

    public static int longestValidParentheses(String s) {
        int max_len = 0, last = -1;
        Stack<Integer> stk = new Stack<>();
        
        for (int i = 0 ; i < s.length() ; i ++) {
            if (s.charAt(i)=='(') {
                stk.push(i);
            }
            else {
                if (stk.empty()) last = i;
                else {
                    stk.pop();
                    if (stk.empty()) {
                        max_len = Math.max(max_len, i-last);
                    }
                    else {
                        max_len = Math.max(max_len, i-stk.peek());
                    }
                }
            }
        }
        return max_len;
    }
}