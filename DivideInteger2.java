public class DivideInteger2 {
	public static void main(String[] args){
		//System.out.println(-Math.abs(Integer.MIN_VALUE));
		//System.out.println(Math.abs(Integer.MIN_VALUE));
		//System.out.println(-(Math.abs(Integer.MIN_VALUE)));
		//System.out.println(divide(2147483647, 2));
		//System.out.println(divide(1004958205,-2137325331));
		//System.out.println(divide(-1010369383,-2147483648));
		System.out.println(divide(-2147483648,2));
	}
	
    public static int divide(int dividend, int divisor) {
        if (divisor==1) return dividend;
        if (divisor==0) return Integer.MAX_VALUE;
		if (divisor==Integer.MIN_VALUE) {
			if (dividend==Integer.MIN_VALUE) return 1;
			else return 0;
		}
        if (dividend==Integer.MIN_VALUE) {
            if (divisor==1) return Integer.MIN_VALUE;
            if (divisor==-1) return Integer.MAX_VALUE;
        }
        
        boolean isNeg = false;
        if ((dividend^divisor)<0) isNeg = true;
        
        int end = -Math.abs(dividend);
        int or = -Math.abs(divisor);
		System.out.println();
        
        int res = rec(end, or);
        return isNeg?-res:res;
    }
    
    public static int rec(int end, int or) {
        if (end>or) return 0;
        
        int save = or;
        int t = 1;
        while(end<or && (or<<1)<=0) {
			//System.out.println(end+" "+or);
            or<<=1;
            t<<=1;
        }
        
        if (or<end) {
            or>>=1;
            t>>=1;
        }
        
		System.out.println(t);
        return t+rec(end-or,save);
    }
    
}