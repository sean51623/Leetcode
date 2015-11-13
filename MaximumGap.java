public class MaximumGap {
	public static void main(String[] args) {
		//System.out.println(maximumGap(new int[]{0,1,2,3,4}));
		//System.out.println(maximumGap(new int[]{0,1,2,5,6,7}));
		
		//test case 
		System.out.println(maximumGap(new int[]{1,10000000}));
	}
    public static int maximumGap(int[] nums) {
        if (nums==null || nums.length<2) return 0;
        
        int max = nums[0], min = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        int[] bmax = new int[nums.length-1];
        int[] bmin = new int[nums.length-1];
        
        for (int i = 0 ; i < nums.length-1 ; i++) {
            bmax[i] = Integer.MIN_VALUE;
            bmin[i] = Integer.MAX_VALUE;
        }
        
        double bsize = ((double)(max-min))/(nums.length-1);
		//System.out.println(bsize);
        for (int i = 0 ; i < nums.length ; i++) {
            int bid = (int)((nums[i]-min)/bsize);
			if (nums[i]==max) bid--;
			//System.out.println(bid);
            bmax[bid] = Math.max(nums[i],bmax[bid]);
            bmin[bid] = Math.min(nums[i],bmin[bid]);
        }
        
        int gap = Math.max(bmax[0]-bmin[0],0), prev = bmax[0];
        for (int i = 1 ; i < bmax.length ; i++) {
            if (bmin[i]==Integer.MAX_VALUE) continue;
            gap = Math.max(gap, bmin[i]-prev);
            prev = bmax[i];
        }
        return gap;
        
    }
}