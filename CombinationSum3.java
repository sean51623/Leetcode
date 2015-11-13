import java.util.*;

public class CombinationSum3 {
	public static void main(String[] args) {
		List<List<Integer>> ans;// = new ArrayList<ArrayList<Integer>>();
		ans = combinationSum3(2,18);
		for (int i = 0 ; i < ans.size() ; i++) {
			for (int j = 0 ; j < ans.get(i).size() ; j++) {
				System.out.print(ans.get(i).get(j)+" ");
			}
		}
	}

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        if (k==0 || n==0) return ans;
        
        solver(ans, cur, k, n, 1);
        return ans;
    }
    
    public static void solver(List<List<Integer>> ans, List<Integer> cur, int k, int n, int index) {
        if (n<0) return;
        
        if (cur.size()==k) {
            if (n==0) ans.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int j = index; j <= 9 ; j++) {
            cur.add(j);
			//System.out.println(j);
			System.out.println(index);
            //if((n-j)>=9*(k-cur.size())){
                //solver(ans,cur,k,n-j,index+1);
				solver(ans,cur,k,n-j,j+1);
                cur.remove(cur.size()-1);
            //}
            //else continue;
        }
    }
}