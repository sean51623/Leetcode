import java.util.*;
public class DiffWaysParentheses {
	public static void main(String[] args) {
		//List<Integer> a = diffWaysToCompute("2-1-1");
		List<Integer> a = diffWaysToCompute("2*3-4*5");
		for (int i: a) System.out.print(i+", ");
		System.out.println();
	}
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int count = 0;
        for (int i = 0 ; i < input.length() ; i++) {
            if (input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*') {
                count++;
                op.add(i);
            }
        }
        if (count==0) {
            res.add(Integer.parseInt(input));
            return res;
        }
        
		//System.out.println("aaa");
        for (int i = 0 ; i < op.size() ; i++) {
            List<Integer> left = diffWaysToCompute(input.substring(0,op.get(i)));
            List<Integer> right = diffWaysToCompute(input.substring(op.get(i)+1));
            for (int j: left) {
                for (int k: right){
					//System.out.println(j+" "+k);
                    if (input.charAt(op.get(i))=='+') res.add(j+k);
                    else if (input.charAt(op.get(i))=='-') res.add(j-k);
                    else if (input.charAt(op.get(i))=='*') res.add(j*k);
                }
            }
        }
        return res;
    }
    /*
    public int calculate(String input) {
        
    }
    */
}