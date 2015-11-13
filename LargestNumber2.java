import java.util.*;

public class LargestNumber2 {
	public static void main(String [] args) {
		System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
	}
	
    public static String largestNumber(int[] nums) {
        //if (nums==null || nums.length==0) return "";
        
        Comparator<Integer> cp = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                String s1 = Integer.toString(i1);
                String s2 = Integer.toString(i2);
                String s1s2 = s1+s2;
                String s2s1 = s2+s1;
                
                for (int i = 0 ; i < s1s2.length() ; i++) {
                    if (s1s2.charAt(i)>s2s1.charAt(i)) return -1;
                    else if (s1s2.charAt(i)<s2s1.charAt(i)) return 1;
                }
                return 0;
            }
        };
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, cp);
        for(int i: nums) pq.offer(i);
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) sb.append(Integer.toString(pq.poll()));
        
        return sb.toString();
    }
}