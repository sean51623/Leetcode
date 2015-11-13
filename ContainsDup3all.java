public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
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
            //System.out.println((nums[i]-min)+"  "+bin);
            
            if (rec.containsKey(bin) || (rec.containsKey(bin-1) && nums[i]-rec.get(bin-1)<=t) || (rec.containsKey(bin+1) && rec.get(bin+1) - nums[i] <= t)) return true;
            else rec.put(bin, (long)nums[i]);
        }
        
        return false;
    }
}
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
}

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}