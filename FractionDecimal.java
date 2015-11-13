// things to be aware of:
// 1. where to insert the parentheses? -> 0.(16)(X) 0.1(6)(O)
// 2. handle the negative -> -50, 8
// 3. handle the overflow -> -1, -2147483648

import java.util.*;

public class FractionDecimal {
	public static void main(String[] args) {
		//System.out.println(fractionToDecimal(1,2));
		//System.out.println(fractionToDecimal(2,3));
		//System.out.println(fractionToDecimal(2,7));
		//System.out.println(fractionToDecimal(1,6));
		//System.out.println(fractionToDecimal(-50,8));
		//System.out.println(fractionToDecimal(7,-12));
		System.out.println(fractionToDecimal(-1, -2147483648));
	}

    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0 ) return "";
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
		boolean isNeg = false;
		isNeg = ((numerator>0)==(denominator>0))?false:true;
		if (isNeg) sb.append("-");
		long num2 = Math.abs((long)numerator); // (long)
		long den2 = Math.abs((long)denominator); // (long)
		System.out.println(den2);
		System.out.println(Math.abs(Integer.MIN_VALUE));
        long q = num2/den2;
		long newnum = num2%den2;
        sb.append(q);
        if (newnum==0) return sb.toString();
        
        sb.append(".");
        
        HashMap<Long, Integer> rec = new HashMap<>();
        StringBuilder tmp = new StringBuilder();
        int location = 1;
		
        while(newnum!=0 && !rec.containsKey(newnum)) {
            rec.put(newnum,location);
			location++;
            newnum *= 10;
            q = newnum/den2;
            tmp.append(q);
            newnum = newnum%den2;
        }
        
        if (newnum==0) {
            sb.append(tmp);
        }
        else {
            tmp.insert(rec.get(newnum)-1,"(");
            tmp.append(")");
            sb.append(tmp);
        }
        return sb.toString();
        
    }
}