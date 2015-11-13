import java.util.*;

public class MergeKArrays {
	public static void main(String[] args) {
		
	}
	
	public static ArrayList<Integer> merge(List<List<Integer>> input) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (input==null || input.size()==0) return res;
		
		int[] pointerRec = new int[input.size()];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0 ; i < input.size() ; i++) {
			pq.offer(input.get(i).get(pointerRec[i]));
		}
		
		while(!pq.isEmpty()) {
			
		}
		
		return res;
	}
	
	// conclusion:
	// you can't just offer iterators into PriorityQueue, that doesn't work
	// but if you just offer integer into PQ, you don't know which arraylist the polled element from
	// I consider additional spaces will be needed
	// e.g. record the pointer of each arraylist, to offer the next element
	// a new type of class which encapsulate integer and arraylist information or next element information
	// analogy: mer k sorted lists -> each listNode has .next information (additional space)
}