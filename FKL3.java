import java.util.*;

public class FKL3 {
	public static void main(String[] args) {
		//int[] a1 = {5,8,6,2,4,3,75,8,6,2,1,4,9};
		//int[] a2 = {0};
		//int[] a3 = {3,1,2,4};
		//int[] a4 = {3,2,3,1,2,4,5,5,6};
		//int[] a5 = {3,3,3,3,3,3,3,3,3};
		//int[] a6 = {5,2,4,1,3,6,0};
		int[] a7 = {3,3,3,3,4,3,3,3,3};
		int[] a8 = {-1,2,0};
		//System.out.println(findKthLargest(a1,3));
		//System.out.println(findKthLargest(a2,1));
		//System.out.println(findKthLargest(a3,2));
		//System.out.println(findKthLargest(a4,4));
		//System.out.println(findKthLargest(a5,4));
		//System.out.println(findKthLargest(a6,4));
		System.out.println(findKthLargest(a7,1));
		System.out.println(findKthLargest(a8,1));
	}
    public static int findKthLargest(int[] nums, int k) {
        //if (nums==null || nums.length==0)
        return fkl(nums,0,nums.length-1,k);
    }
    
    public static int fkl(int[] nums, int start, int end, int k){
        if (start >= end) return nums[start];
        int pivot = nums[end];
        int j = start, m = start;
		for (int i = start ; i <= end ; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();

        for (int i = start ; i < end ; i++) {
            if (nums[i]>pivot) {
                swap(nums, i, j);
				if(j!=m) swap(nums, i, m);
                j++;
				m++;
            }
			else if (nums[i]==pivot) {
				swap(nums, i, m);
				m++;
			}
        }
        swap(nums, end, m);
		
		
		for (int i = start ; i <= end ; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
        
		System.out.print(start+"  "+end+"  "+j+"  "+m+"  "+k+"  "+pivot+"  "+nums[j]);
		System.out.println();
		
		if (k-1>=j-start && k-1<=m-start) {System.out.println("aa");return nums[j];}
		else if (k-1>m-start) {System.out.println("bb");return fkl(nums,m+1,end,k-m+start-1);}
		else {System.out.println("cc");return fkl(nums,start,j-1,k);}
		/*
        if (j-start+1==k) return nums[j];
        else if (j-start+1<k) return fkl(nums,j+1,end,k-j-1);
        else return fkl(nums,start,j-1,k);
		*/
    }
    
    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}