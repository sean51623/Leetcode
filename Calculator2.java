public class Calculator2 {
	public static void main(String[] args) {
	
	}
	
    public static int calculate(String s) {
        if (s==null || s.length()==0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int ans = 0;
        
        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10*num + (int)(s.charAt(i)-'0');
            }
            if ((!Character.isDigit(s.charAt(i))&& s.charAt(i)!=' ') || i == s.length()-1) {
                if (sign=='*') {
                    stack.push(stack.pop()*num);
                }
                if (sign=='/') {
                    stack.push(stack.pop()/num);
                }
                if (sign=='+') {
                    stack.push(num);
                }
                if (sign=='-') {
                    stack.push(-num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        //int re = 0;
        for (int i: stack) ans+= i;
        return ans;
    }
}