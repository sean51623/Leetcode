import java.util.*;

public class LargestNumber {
	public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{3,30,34,9,5}));
		System.out.println(largestNumber(new int[]{3,30,34,9,5,19}));
		System.out.println(largestNumber(new int[]{3,333,353,339,537,5,7}));
		
		// test case
		System.out.println(largestNumber(new int[]{121,12}));
		System.out.println(largestNumber(new int[]{1212,12}));
		System.out.println(largestNumber(new int[]{1212,121}));
		System.out.println(largestNumber(new int[]{345,34534}));
		System.out.println(largestNumber(new int[]{543,54354}));
		
		// test case 2
		System.out.println(largestNumber(new int[]{0,0})); // 0
	}

    public static String largestNumber(int[] nums) {
        if (nums==null || nums.length==0) return "";
        if (nums.length==1) return Integer.toString(nums[0]);
        
        Comparator<String> cp = new Comparator<String>(){
            public int compare(String s1, String s2) {
				String s1s2 = s1+s2;
				String s2s1 = s2+s1;
				char c1, c2;
                for (int i = 0 ; i < s1s2.length() ; i++) {
					c1 = s1s2.charAt(i);
					c2 = s2s1.charAt(i);
                    if (c1!=c2) {
                        if (c1>c2) return -1;
                        else if (c1<c2) return 1;
                    }
                }
				return 0;
            }
        };
        
        PriorityQueue<String> pq = new PriorityQueue<String>(nums.length, cp);
        for (int i = 0 ; i < nums.length ; i++) {
            pq.offer(Integer.toString(nums[i]));
        }
        
        String res = "";
        while(!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }

	/*
    public static String largestNumber(int[] nums) {
        if (nums==null || nums.length==0) return "";
        if (nums.length==1) return Integer.toString(nums[0]);
        
        int largestpow = 0;
		int power = 0;
		int tmp = 0;
        ArrayList<Integer> cur = new ArrayList<>();
		HashMap<Integer, Integer> rec = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            tmp = nums[i];
            while(tmp>10) {
                power++;
                tmp /= 10;
            }
			largestpow = Math.max(power, largestpow);
			power = 0;
        }
		
		System.out.println(largestpow);
		for (int i = 0 ; i < nums.length ; i++) {
			tmp = nums[i];
			//System.out.println(tmp/Math.pow(10,largestpow));
			while((int)(tmp/Math.pow(10,largestpow))==0) {
				tmp*=10;
			}
			rec.put(tmp,nums[i]);
			cur.add(tmp);
			System.out.println(tmp);
		}
        
		
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
		//System.out.println(bucket.size());
        for (int i = 0 ; i < 10 ; i++) {
			bucket.add(new ArrayList<Integer>());
		}
		//System.out.println(bucket.size());
		
        for (int i = 0 ; i <= largestpow ; i++) {
            for (int j = 0 ; j < cur.size() ; j++) {
                int remainder = (int)(cur.get(j)/Math.pow(10,i))%10;
				//System.out.println(remainder);
				bucket.get(remainder).add(cur.get(j));
            }
            
            cur.clear();
            for (int j = bucket.size()-1 ; j >= 0 ; j--) {
                ArrayList<Integer> gather = bucket.get(j);
                for (int k = gather.size()-1 ; k >= 0 ; k--) {
                    cur.add(gather.get(k));
					//System.out.println(gather.get(k));
                }
				bucket.get(j).clear();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < cur.size() ; i++) {
            sb.append(rec.get(cur.get(i)));
        }
        return sb.toString();
    }
	*/
}