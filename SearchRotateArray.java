// Binary Search

/*
Search Insert Position
Search for a Range
Sqrt(x)
Search a 2D Matrix
Search in Rotated Sorted Array
Search in Rotated Sorted Array II
Find Peak Element
Find Minimum in Rotated Sorted Array
Find Minimum in Rotated Sorted Array II
*/
import java.util.*;

public class SearchRotateArray {
	public static void main(String[] args) {
		//bsearch
		//System.out.println(bsearch(new int[]{1,2}, 1));
		//System.out.println(bsearch(new int[]{2,3,4,5,6,7,8}, 4));
		//System.out.println(bsearch(new int[]{2,3,4,5,6,7,8}, 3));
		//System.out.println(bsearch(new int[]{2,3,6,7,8}, 4));
		
		//searchInsert
		System.out.println(searchInsert(new int[]{1,3,5,6},5));
		System.out.println(searchInsert(new int[]{1,3,5,6},2));
		System.out.println(searchInsert(new int[]{1,3,5,6},7));
		System.out.println(searchInsert(new int[]{1,3,5,6},0));
	}
	
	public static int bsearch(int[] nums, int target) { // return the index
		if (nums==null || nums.length==0) return -1;
		int begin = 0, end = nums.length-1, mid = 0;
		
		while(begin<=end) {
			mid = (begin+end)/2;
			if (nums[mid]==target) return mid;
			else if (nums[mid]>target) end = mid-1;
			else begin = mid+1;
		}
		return -1;
	}
	
	// what should be returned if the target is not found?
	public static int searchInsert (int[] nums, int target) {
		if (nums==null || nums.length==0) return -1;
		int begin = 0, end = nums.length-1, mid = 0;
		
		while(begin<=end) {
			mid = (begin+end)/2;
			if (nums[mid]==target) {System.out.println(begin+" "+end);return mid;}
			else if (nums[mid]>target) end = mid-1;
			else begin = mid+1;
		}
		System.out.println(begin+" "+end);
		return begin;
		//return end;
	}
	
	public static int[] searchRange (int[] nums, int target) {
		if (nums==null || nums.length==0) return new int[]{-1,-1};
		int[] res = new int[2];
		int begin = 0, end = nums.length-1, mid = 0;
		
		while(begin<=end) {
			mid = (begin+end)/2;
			if (nums[mid]==target) {System.out.println(begin+" "+end);return mid;}
			else if (nums[mid]>target) end = mid-1;
			else begin = mid+1;
		}
	}
}