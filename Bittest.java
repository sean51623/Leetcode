public class Bittest {
	public static void main(String[] args) {
		System.out.println((1<<31));
		System.out.println(Integer.toBinaryString(-4));
		System.out.println(singleNumber(new int[]{-2,-2,1,1,1,-4,-2} ));
		System.out.println(singleNumber(new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2} ));
	}

    public static int singleNumber(int[] nums) {
        int[] rec = new int[32];
        int res = 0;
        for (int i = 0 ; i < 32 ; i++) {
            for (int j = 0 ; j < nums.length ; j++) {
                int mask = (1<<i);
                //if ((nums[j] & mask)>0) rec[i]++;
				if (((nums[j]>>i)&1)>0) rec[i]++;
            }
            res += ((rec[i]%3)<<i);
        }
		
		for (int i = 0 ; i < 32 ; i++ ) System.out.print(rec[i]%3+" ");
		System.out.println();
        return res;
    }
}