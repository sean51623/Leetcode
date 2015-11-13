public class PaintHouse2 {
	public static void main(String[] args) {
		System.out.println(minCostII(new int[][]{{20,19,11,13,12,16,16,17,15,9,5,18},{3,8,15,17,19,8,18,3,11,6,7,12},{15,4,11,1,18,2,10,9,3,6,4,15}}));
	}
    public static int minCostII(int[][] costs) {
        if (costs.length==0) return 0;
        
        int[] cur = costs[0];
        int[] next = new int[costs[0].length];
        
        for (int i = 1 ; i < costs.length ; i++) { // n
            for ( int j = 0 ; j < next.length ; j++) next[j] = Integer.MAX_VALUE;
            
            for ( int j = 0 ; j < costs[0].length ; j++) { // k
                for (int k = 0 ; k < costs[0].length ; k++) { // k
                    if (j==k) continue;
                    else next[j] = Math.min(cur[k]+costs[i][j], next[j]);
                }
            }
            for (int j = 0 ; j < cur.length ; j++) cur[j] = next[j];
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < cur.length ; i++) {
			System.out.println(cur[i]);
            min = Math.min(min, cur[i]);
        }
        return min;
    }
}