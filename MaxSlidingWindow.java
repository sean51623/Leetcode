import java.util.*;
public class MaxSlidingWindow {
	public static void main(String[] args) {
		int[] a = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
		int[] b = maxSlidingWindow(new int[]{8,7,6,5,4,3,2,1},3);
		int[] c = maxSlidingWindow(new int[]{1,2,3,4,5,6,7,8},3);
		
		// test case
		int[] d = maxSlidingWindow(new int[]{},0); // expected [] instead of [0];
		
		for (int i: d) System.out.print(i+" ");
		System.out.println();
		
	}

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int [] res = new int[nums.length-k+1];
		if (nums==null || nums.length==0 || k==0) return new int[0];
        
        Deque<Integer> rec = new ArrayDeque<>();
        for (int i = 0 ; i < k ; i++) {
            while(!rec.isEmpty()) {
                if (nums[i]>nums[rec.peekLast()]) rec.removeLast();
				else break;
            }
            rec.addLast(i);
        }
        res[0] = nums[rec.peekFirst()];
        
		//System.out.println("aaa");
        for (int i = k ; i < nums.length ; i++) {
            while(!rec.isEmpty()) {
				//System.out.println("bbb");
                if (nums[i]>nums[rec.peekLast()]) rec.removeLast();
                else break;
            }
			while(!rec.isEmpty() && rec.peekFirst()<=i-k)rec.removeFirst();
			
            rec.addLast(i);
            res[i-k+1] = nums[rec.peekFirst()];
        }
        
        return res;
    }
}