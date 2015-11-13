import java.util.*;
public class ContainsDup3 {
	public static void main(String[] args) {
		//System.out.println(containsNearbyAlmostDuplicate(new int[]{7,1,3},2,3));
		System.out.println(containsNearbyAlmostDuplicate(new int[]{0,2147483647}, 1, 2147483647));
		//[2,2], 3, 0
		System.out.println(containsNearbyAlmostDuplicate(new int[]{2,2}, 3, 0));
		// [-1,2147483647], 1, 2147483647
		System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
	}

	/*
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums==null || nums.length==0 || k==0) return false;
        
        int min = Integer.MAX_VALUE;
        int bin = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            min = Math.min(min, nums[i]);
        }
        
        HashMap<Integer,Integer> rec = new HashMap<>();
        for (int i = 0 ; i <= k && i<nums.length ; i++) {
            if (nums[i]-min<=t) bin = 0;
            else bin = (nums[i]-min+t)/2*t;
            
            if (rec.containsKey(bin)) return false;
            else rec.put(bin, i);
        }
        
        for (int i = k+1 ; i < nums.length ; i++) {
            if (nums[i]-min<=t) bin = 0;
            else bin = (nums[i]-min+t)/2*t;
            
            if (!rec.containsKey(bin)) rec.put(bin, i);
            else if (rec.get(bin)<i-k) rec.put(bin, i);
            else return false;
        }
        
        return true;
    }
	*/
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2  || t < 0 || k < 0) return false;
        
        int min = Integer.MAX_VALUE;
        long bin = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            min = Math.min(min, nums[i]);
        }
        
        HashMap<Long,Long> rec = new HashMap<>();
        
        bin = ((long)nums[0] - min)/((long)t+1);
        rec.put(bin, (long)nums[0]);
        
        
        for (int i = 1 ; i < nums.length ; i++) {
            
            if (rec.size()>k) {
                long lastbin = ((long)nums[i-k-1]-min)/((long)t+1);
                rec.remove(lastbin);
            }
            
            bin = ((long)nums[i] - min)/((long)t+1);
            System.out.println((nums[i]-min)+"  "+bin);
            
            if (rec.containsKey(bin) || (rec.containsKey(bin-1) && nums[i]-rec.get(bin-1)<=t) || (rec.containsKey(bin+1) && rec.get(bin+1) - nums[i] <= t)) return true;
            else rec.put(bin, (long)nums[i]);
        }
        
        return false;
    }
}