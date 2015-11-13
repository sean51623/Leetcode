import java.util.*;

public class Permutation {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> per = new ArrayList<ArrayList<Integer>>();
		int [] ins = {1,2,3,4,5};
		System.out.println("hi1");
		for (int i = 0 ; i < ins.length ; i++) {
			per = perm(ins[i], per);
		}
		
		System.out.println("hi");
		for (int i = 0 ; i < per.size() ; i++) {
			for (int j = 0 ; j < per.get(i).size() ; j++) {
				System.out.print(per.get(i).get(j)+", ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> perm (int a, ArrayList<ArrayList<Integer>> b) {
		if (b.size()==0){
			ArrayList<Integer> x = new ArrayList<>();
			x.add(a);
			b.add(x);
			return b;
		}
	
		ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0 ; i < b.size() ; i++) {
			for (int j = 0 ; j <= b.get(i).size() ; j++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>(b.get(i));
				tmp.add(j,a);
				next.add(tmp);
			}
		}
		return next;
	}
}