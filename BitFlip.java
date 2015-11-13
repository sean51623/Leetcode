import java.util.*;

public class BitFlip {
	public static void main(String[] args) {
		System.out.println(flip(new int[]{0}));
		System.out.println(flip(new int[]{1}));
		System.out.println(flip(new int[]{0,0,1,0,1,0,1,0,0,1}));
		System.out.println(flip(new int[]{1,1,1,1,1,1,0,0,0,1,1,0,1,0,1,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,0,1,1,0,0,0,0,0,1}));
	}
	
	public static int flip(int [] nums) {
		int count = 0;
		for (int i = 0 ; i < nums.length ; i++) {
			if (nums[i]==1) count++;
		}
	
		int local = 0 , max = 0;
		for (int i = 0 ; i < nums.length ; i++) {
			if (nums[i]==0) local++;
			else local--;
			
			local = Math.max(local,0);
			max = Math.max(local, max);
		}
		
		return count+max;
	}
}