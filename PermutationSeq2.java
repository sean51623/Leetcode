import java.util.*;

public class PermutationSeq2 {
	public static void main(String[] args) {
		System.out.println(permIndex(2,2,2));
		System.out.println(permIndex(2,2,3));
		
		System.out.println(permIndex(2,4,15));
	}
	
	public static String permIndex(int x, int y, int k) {
		int psum = x+y;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1 ; i <= psum ; i++) {
			int c = comb(x,y);
			int p1 = (x*c)/(x+y);
			
			if (k>p1) {
				sb.append("V");
				y--;
				k -= p1;
			}
			else {
				sb.append("H");
				x--;
			}
		}
		
		return sb.toString();
	}
	
	public static int fac(int x) {
		if (x<=1) return 1;
		return x*fac(x-1);
	}
	
	public static int comb(int x, int y) {
		int max = Math.max(x,y);
		int min = Math.min(x,y);
		
		long nominator = 1, denominator = 1;
		for (int i = max+1 ; i <= x+y ; i++) {
			nominator *= i;
			denominator *= (i-max);
		}
		
		return (int)(nominator/denominator);
	}
}
