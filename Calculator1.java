public class Calculator1 {
	public static void main(String[] args) {
	
	}
    public static int calculate(String s) {
        if (s==null||s.length()==0) return 0;
        
        Stack<Integer> stk = new Stack<>();
        int ans = 0;
        int sign = 1;
        int num = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10*num + (int)(s.charAt(i)-'0');
            }
            else if (s.charAt(i)=='+') {
                ans += sign*num;
                num = 0;
                sign = 1;
            }
            else if (s.charAt(i)=='-') {
                ans += sign*num;
                num = 0;
                sign = -1;
            }
            else if (s.charAt(i)=='(') {
                stk.push(ans);
                stk.push(sign);
                sign = 1;
                ans = 0;
            }
            else if (s.charAt(i)==')') {
                ans += sign*num;
                num = 0;
                ans *= stk.pop();
                ans += stk.pop();
            }
            
        }
        if (num!=0) ans += sign*num;
        return ans;
    }
    
}