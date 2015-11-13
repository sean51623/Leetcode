import java.util.*;

public class FKL2 {
	public static void main(String[] args) {
		int[] a1 = {5,8,6,2,4,3,75,8,6,2,1,4,9};
		int[] a2 = {0};
		int[] a3 = {3,1,2,4};
		int[] a4 = {3,2,3,1,2,4,5,5,6};
		System.out.println(findKthLargest(a1,3));
		System.out.println(findKthLargest(a2,1));
		System.out.println(findKthLargest(a3,2));
		System.out.println(findKthLargest(a4,4));
	}
    public static int findKthLargest(int[] nums, int k) {
        //if (nums==null || nums.length==0)
        return fkl(nums,0,nums.length-1,k);
    }
    
    public static int fkl(int[] nums, int start, int end, int k){
        if (start == end) return nums[start];
        int pivot = nums[end];
        int j = start;
        for (int i = start ; i < end ; i++) {
            if (nums[i]>pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, end, j);
        
        if (j-start+1==k) return nums[j];
        else if (j-start+1<k) return fkl(nums,j+1,end,k-j-1);
        else return fkl(nums,start,j-1,k);
        
    }
    
    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}