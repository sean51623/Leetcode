import java.util.*;

public class SubsetII {
	public static void main(String[] args) {
		List<List<Integer>> res = subsetsWithDup(new int[]{1,2,3});
		//List<List<Integer>> res = subsetsWithDup(new int[]{1,2,3,4,5,6,7,8,10,0});
		/*
		for (List<Integer> i: res) {
			for (int j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		*/
	}

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        List<Integer> toAdd = new ArrayList<>();
        res.add(toAdd);
		//tmp.add(toAdd);
        for (int i = 0 ; i < nums.length ; i++) {
            //int s = tmp.size();
            if (i>0 && nums[i]==nums[i-1]) {
                for (int j = 0 ; j < tmp.size() ; j++) {
                    toAdd = new ArrayList<>(tmp.get(j));
                    toAdd.add(nums[i]);
                }
                
            }
            else {
				tmp.removeAll(tmp);
				//int s = res.size();
                for (int j = 0 ; j < res.size() ; j++) {
                    toAdd = new ArrayList<>(res.get(j));
					for (int x: toAdd) System.out.print(x+" ");
					System.out.println();
                    toAdd.add(nums[i]);
                    tmp.add(toAdd);
					for (int x: toAdd) System.out.print(x+" ");
					System.out.println();
                }
				System.out.println();
                res.addAll(tmp);
            }
            if (tmp.size()!=0) res.addAll(tmp);
        }
        return res;
    }
}