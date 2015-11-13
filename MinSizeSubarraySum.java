public class MinSizeSubarraySum {
	public static void main(String[] args) {
		System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
		System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
	}

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums==null || nums.length == 0) return 0;
        
        int len = 0, minlen = nums.length+1;
        int left = 0, right = 0;
        int sum = nums[0];
        
        while(right!=nums.length-1 && left!=nums.length-1) {
            
            while(sum<s && right<nums.length-1) {
                right++;
                sum += nums[right]; 
            }
            if (sum>=s){
                len = right-left+1;
                minlen = Math.min(len,minlen);
            }
            else break;
            
			//System.out.println(minlen);
            while(sum>=s) {
				len = right-left+1;
				minlen = Math.min(len,minlen);
                sum -= nums[left];
                left++;
            }
            /*
            if(sum==s && right < nums.length) {
                sum += nums[right];
                right++;
            }
			System.out.println(minlen);
			*/
        }
        return (minlen==nums.length+1)?0:minlen;
    }
}