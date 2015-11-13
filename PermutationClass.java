// next_permutation (reverse, swap)
// permutation sequence
// permutation1 (copy & insert) (no duplicate)
// permutation2 (recursive) (no duplicate)
// permutation3 (recursive) (duplicate)
// permutationByNP (by next_permutation)
// permutationByNP2 (by next_permutation)
// subsets
import java.util.*;

public class PermutationClass {

	public int[] nums;
	public List<Integer> numslist;
	public PermutationClass() {}
	public PermutationClass(int[] nums) {
		this.nums = nums;
		Integer[] tmp = new Integer[nums.length];
		for (int i = 0 ; i < nums.length ; i++) tmp[i]=nums[i];
		this.numslist = Arrays.asList(tmp);
	}
	
	public void next_permutation() {
		if (nums==null || nums.length <= 1) return;
		
		int k = nums.length-2;
		while ( k>=0 && nums[k]>=nums[k+1]) { k--; } // >= is useful for duplicate
		if (k==-1) reverse(nums,0,nums.length-1);
		else {
			for (int i = nums.length-1 ; i >= k+1 ; i--) {
				if (nums[i] > nums[k]) {
					swap(nums,i,k);
					break;
				}
			}
			reverse(nums,k+1,nums.length-1);
		}
		return;
	}
	
	void swap(int[] nums, int i1, int i2) {
		int tmp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = tmp;
	}
	
	void reverse(int[] nums, int start, int end) {
		if (start==end) return;
		
		while(start<end) {
			swap(nums,start,end);
			start++;
			end--;
		}
	}
	
	public void printP() {
		for (int i = 0 ; i < nums.length ; i++) {
			if (i==nums.length-1) System.out.print(nums[i]);
			else System.out.print(nums[i]+", ");
		}
		System.out.println();
	}
	
	
	public void permutation_seq(int n) { // what if there are duplicates in the array?
		// assume no duplicate
		ArrayList<Integer> rec = new ArrayList<Integer>(numslist);
		Collections.sort(rec);
		StringBuilder sb = new StringBuilder();
		int k = rec.size();
		for (int i = 0 ; i < k ; i++) {
			System.out.println("aa");
			int fc = factorial(k-1-i);
			int index = (n%fc==0)?n/fc:n/fc+1;
			sb.append(rec.remove(index-1));
			n = n%fc;
			if (n==0) n = fc;
			
			for (int j = 0 ; j < rec.size() ; j++) {System.out.print(rec.get(j)+", ");}
			System.out.println();
			System.out.println(sb);
			System.out.println(fc+"  "+n+"  "+k);
		}	
	}
	
	/*
	public void permutation1(){ // two methods: 1-copy and insert, 2-recursion
	
	}
	*/
	
	public void permutation2(){
		ArrayList<Integer> rec = new ArrayList<Integer>(numslist);
		Collections.sort(rec);
		boolean[] used = new boolean[rec.size()];
		solver2(rec,used,new ArrayList<Integer>());
	}
	
	public void solver2(ArrayList<Integer> rec, boolean[] used, ArrayList<Integer> cur) {
		if (cur.size()==rec.size()) {
			for (int i = 0 ; i < cur.size() ; i++) {
				System.out.print(cur.get(i)+", ");
			}
			System.out.println();
			return;
		}
		for (int i = 0 ; i < rec.size() ; i++) {
			if (!used[i]) {
				cur.add(rec.get(i));
				used[i] = true;
				solver2(rec,used,cur);
				used[i] = false;
				cur.remove(cur.size()-1);
			}
		}
	}
	
	public void permutation3() {
		ArrayList<Integer> rec = new ArrayList<Integer>(numslist);
		Collections.sort(rec);
		//boolean[] used = new boolean[rec.size()];
		HashSet<Integer> dup = new HashSet<>();
		solver3(rec,dup,new ArrayList<Integer>());
	}
	
	public void solver3(ArrayList<Integer> rec, HashSet<Integer> dup, ArrayList<Integer> cur) {
		if (cur.size()==rec.size()) {
			for (int i = 0 ; i < cur.size() ; i++) {
				System.out.print(cur.get(i)+", ");
			}
			System.out.println();
			return;
		}
		for (int i = 0 ; i < rec.size() ; i++ ) {
			if (!dup.contains(rec.get(i))) {
				cur.add(rec.get(i));
				solver3(rec,dup,cur);
				dup.add(rec.get(i));
				cur.remove(rec.get(i));
			}
		}
	}
	
	public void permutationByNP(){
		// not working if there are duplicates
		Arrays.sort(nums);
		int times = factorial(nums.length);
		for (int i = 0 ; i < times ; i++) {
			printP();
			next_permutation();
		}
	}
	
	public void permutationByNP2(){
		Arrays.sort(nums);
		HashMap<Integer, Integer> rec = new HashMap<>();
		for (int i = 0 ; i < nums.length ; i++) {
			if (!rec.containsKey(nums[i])) rec.put(nums[i],1);
			else rec.put(nums[i],rec.get(nums[i])+1);
		}
		
		int times = factorial(nums.length);
		for (HashMap.Entry<Integer,Integer> e: rec.entrySet()) {
			times = times / factorial(e.getValue());
		}
		
		for (int i = 0 ; i < times ; i++) {
			printP();
			next_permutation();
		}
	}
	
	public int factorial(int n) {
		if (n<=1) return 1;
		else return n*factorial(n-1);
	}
	
}
