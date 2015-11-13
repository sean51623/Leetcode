public class RangeBitwise {
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5,7));
		System.out.println(rangeBitwiseAnd(63,97));
		System.out.println(rangeBitwiseAnd(121,800));
	}

    public static int rangeBitwiseAnd(int m, int n) {
		if (m==0) return 0;
		int count = 0;
		while(m!=n) {
			m>>=1;
			n>>=1;
			count++;
			System.out.println("m: "+m+"  n: "+n+"  count: "+count);
		}
		return m<<count;
    }
	
	/*
	public int rangeBitwiseAnd(int m, int n) {
		while(n > m) { 
			n = n & (n-1);
		}
		return n;
	}
	*/
}