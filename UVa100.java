import java.io.*;
import java.util.*;

public class UVa100 { // 3n+1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		threen(sc.nextInt());
	}
	
	public static void threen(int n) {
		if (n<=1) return;
		int count = 0;
		while(n>1) {
			if (n%2==1) n = n*3+1;
			else n /= 2;
			count++;
		}
		System.out.println(count);
	}
}