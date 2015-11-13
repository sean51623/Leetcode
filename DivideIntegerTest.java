public class DivideIntegerTest  {
	public static void main(String[] args){
		System.out.println(-Math.abs(Integer.MIN_VALUE));
		System.out.println(Math.abs(Integer.MIN_VALUE));
		System.out.println(-(Math.abs(Integer.MIN_VALUE)));
		//System.out.println(divide(2147483647, 3));
		System.out.println(divide(-2147483648,2));
	}
	
    public static int divide(int dividend, int divisor) {
        if (divisor==0 || (dividend==Integer.MIN_VALUE && divisor==-1)) return Integer.MAX_VALUE;
        if (dividend==divisor) return 1;
        if (dividend==0) return 0;
		if (divisor==1) return dividend;
        
        boolean isNeg = false;
        if (dividend<0) isNeg = (divisor<0)?false:true;
        else isNeg = (divisor<0)?true:false;
        
        int a1 = -Math.abs(dividend);
        int a2 = -Math.abs(divisor);
		System.out.println(a1+" "+a2);
        int totalq = divide_rec(a1,a2);
		//System.out.println(a1+"  "+a2);
		//System.out.println(totalq);
        
        return isNeg?-totalq:totalq;
    }
    public static int divide_rec(int d1, int d2) {
        if (d1==0) return 0;
        if (d1==d2) return 1;
        if (d1>d2) return 0;
        
        int q = 1;
        int ds = d2;
        
        while(d1<ds && (ds<<1)<=0) {
            q<<=1;
            ds<<=1;
			//System.out.println(ds);
        }
        if (d1>ds) {
            q>>=1;
            ds>>=1;
        }
		//System.out.println(q);
		//System.out.println(d1-d2*q);
        return q+divide_rec(d1-d2*q,d2);
        
    }
}