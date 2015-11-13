import java.util.*;

public class CourseSchedule {
	public static void main(String[] args) {
		System.out.println(canFinish(2,new int[][]{{1,0}}));
	}
	
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] num = new int[numCourses];
        HashMap<Integer,ArrayList<Integer>> rec = new HashMap<>();
        
        
        for (int i = 0 ; i < prerequisites.length ; i++) {
            if (!rec.containsKey(prerequisites[i][1])) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(prerequisites[i][0]);
                rec.put(prerequisites[i][1],tmp);
            }
            else {
                ArrayList<Integer> hi = rec.get(prerequisites[i][1]);
                hi.add(prerequisites[i][0]);
                rec.put(prerequisites[i][1],hi);
            }
            num[prerequisites[i][0]]++;
        }
        
        ArrayList<Integer> rem = new ArrayList<>();
        for (int i = 0 ; i < num.length ; i++) {
            if (num[i]==0) rem.add(i);
        }
		System.out.println(rem.size());
		System.out.println(rec.get(rem.get(0)));
        
        for (int i = 0 ; i < rem.size() ; i++) {
            if(rec.containsKey(rem.get(i))) {
				//System.out.println(rem.get(i));
				//System.out.println(rec.get(rem.get(i)));
                for (Integer itg: rec.get(rem.get(i))) {
                    num[itg]--;
                    if (num[itg]==0) {
                        rem.add(itg);
						//System.out.println(rem.size());
                    }
                }
            }
        }
        if (rem.size()==numCourses) return true;
        else return false;
    }
}