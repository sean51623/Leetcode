public class FKL {
	public static void main(String[] args) {
		/*
		int[] a = new int[1];
		a[0] = 1;
		System.out.println(findKthLargest(a,1));
		*/
		
		int[] a = new int[10];
		for (int i = 0 ; i < a.length ; i++) {a[i] = i+1;}
		System.out.println(findKthLargest(a,5));
		
	}
    public static int findKthLargest(int[] nums, int k) {
        //if (nums==null || nums.length==0)
        return fkl(nums,0,nums.length-1,k);
    }
    
    public static int fkl(int[] nums, int start, int end, int k) {
        int p = qs(nums,start,end); // return index in array or largest element?
        if (p==k) return nums[p-1]; // p: largest element, p-1: index in the array
        else if (p<k) return fkl(nums,p+1,end,k-p);
        else return fkl(nums,start,p-1,k);
    }
    
    public static int qs(int[] nums, int start, int end) {
		//System.out.println(start);
		//System.out.println(end);
        //if (start==end) return start;
        int point = start;
        int pivot = end;
        for (int i = point ; i < end ; i++) {
            if (nums[i] <= nums[pivot]) {
                swap(nums[i],nums[point]);
                point++;
            }
        }
		//System.out.println(pivot);
		//System.out.println(point);

        swap(nums[pivot],nums[point]);
        return point-start+1;
    }
    
    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}