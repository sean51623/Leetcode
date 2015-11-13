import java.util.*;

public class PermutationSeq {
	public static void main(String[] args) {
		System.out.println(permIndex(new int[]{1,4,2,2}));
		System.out.println(permIndex(new int[]{2,4,2,1}));
		System.out.println(permIndex(new int[]{3,4,2,1}));
		System.out.println(permIndex(new int[]{2,8,6,4,5,7}));
		
		System.out.println(permIndex2(new int[]{1,4,2,2}));
		System.out.println(permIndex2(new int[]{2,4,2,1}));
		System.out.println(permIndex2(new int[]{3,4,2,1}));
		System.out.println(permIndex2(new int[]{2,8,6,4,5,7}));

	}
	
	public static long permIndex(int[] nums) {
		if (nums==null || nums.length==0) return 0;
		
		TreeMap<Integer, Integer> rec = new TreeMap<>();
		for (int i = 0 ; i < nums.length ; i++) {
			if (!rec.containsKey(nums[i])) rec.put(nums[i],1);
			else rec.put(nums[i], rec.get(nums[i])+1);
		}
		
		int k = 0;
		for (int i = 0 ; i < nums.length ; i++) {
			int take = nums[i];
			k += comb(take, rec, nums.length-i);
			if (rec.get(take)==1) rec.remove(take);
			else rec.put(take, rec.get(take)-1);
		}
		
		return k+1;
	}
	
	public static long fac(int x) {
		if (x<=1) return 1;
		return x*fac(x-1);
	}
	
	public static long comb(int x, TreeMap<Integer, Integer> rec, int size) {
		int i = 0;
		long total = fac(size);
		for (Map.Entry<Integer,Integer> entry: rec.entrySet()) {
			if (x==entry.getKey()) break;
			else i+= entry.getValue();
		}
		
		for (Map.Entry<Integer,Integer> entry: rec.entrySet()) total /= fac(entry.getValue());
		
		long val = i*total/size;
		//System.out.println(i+" "+val+" "+size);
		return val;
	}
	
	// wrong
	/*
	public static long permIndex2 (int[] nums) {
		ArrayList<Integer> sortArray = new ArrayList<>();
		for (int i: nums) sortArray.add(i);
		Collections.sort(sortArray);
		//for(int i : sortArray) System.out.print(i+" ");
		//System.out.println();
		
		int k = 0;
		for (int i = 0 ; i < nums.length ; i++) {
			for (int j = 0 ; j < sortArray.size() ; j++) {
				if (sortArray.get(j)==nums[i]) {
					k += (j*(nums.length-1-i));
					//System.out.println(j+" "+(nums.length-1-i));
					sortArray.remove(j);
					//for(int x : sortArray) System.out.print(x+" ");
					//System.out.println(k);
					break;
				}
			}
		}
		
		return k;
	}
	*/
}

/*
public class Solution {
    long fac(int numerator) {
			
		long now = 1;
		for (int i = 1; i <= numerator; i++) {
			now *= (long) i;
		}
		return now;
	}
	long generateNum(HashMap<Integer, Integer> hash) {
		long denominator = 1;
		int sum = 0;
		for (int val : hash.values()) {
			if(val == 0 )	
				continue;
			denominator *= fac(val);
			sum += val;
		}
		if(sum==0) {
			return sum;
		}
		return fac(sum) / denominator;
	}

	public long permutationIndexII(int[] A) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < A.length; i++) {
			if (hash.containsKey(A[i]))
				hash.put(A[i], hash.get(A[i]) + 1);
			else {
				hash.put(A[i], 1);
			}
		}
		long ans = 0;
		for (int i = 0; i < A.length; i++) {
			HashMap<Integer, Integer> flag = new HashMap<Integer, Integer>();
			
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < A[i] && !flag.containsKey(A[j])) {
				    	flag.put(A[j], 1);
				
					hash.put(A[j], hash.get(A[j])-1);
					ans += generateNum(hash);
					hash.put(A[j], hash.get(A[j])+1);
					
				}
			
			}
				hash.put(A[i], hash.get(A[i])-1);
		}
		
		return ans+1;

	}
}
*/