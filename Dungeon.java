public class Dungeon {
	public static void main(String[] args) {
		//int[][] dungeon = {{0,1,2},{1,2,3}};
		//int[][] dungeon = {{-200}};
		//int[][] dungeon = {{0,-3}};
		int[][] dungeon = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
		System.out.println(calculateMinimumHP(dungeon));
	}
	
    public static class Tp {
        public int curmin;
        public int curhp;
        public Tp() {
            this.curmin = 0;
            this.curhp = 0;
        }
        public Tp(int curmin, int curhp) {
            this.curmin = curmin;
            this.curhp = curhp;
        }
    }
    
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 0;
        
        int tmp = 0;
		int min=0, hp=0;
        Tp[][] rec = new Tp[dungeon.length][dungeon[0].length];
		rec[0][0] = new Tp(dungeon[0][0],dungeon[0][0]);
        
        for (int i = 1 ; i < dungeon.length ; i++) {
            tmp = rec[i-1][0].curhp+dungeon[i][0];
            min = (tmp<rec[i-1][0].curmin)?tmp:rec[i-1][0].curmin;
            hp = tmp;
			rec[i][0] = new Tp(min,hp);
        }
        for (int i = 1 ; i < dungeon[0].length ; i++) {
            tmp = rec[0][i-1].curhp+dungeon[0][i];
            min = (tmp<rec[0][i-1].curmin)?tmp:rec[0][i-1].curmin;
            hp = tmp;
			rec[0][i] = new Tp(min,hp);
        }
        for (int i = 1 ; i < dungeon.length ; i++) {
            for (int j = 1 ; j < dungeon[0].length ; j++) {
                Tp a = rec[i-1][j];
                Tp b = rec[i][j-1];
                int x = (a.curhp+dungeon[i][j]<a.curmin)?a.curhp+dungeon[i][j]:a.curmin;
                int y = (b.curhp+dungeon[i][j]<b.curmin)?b.curhp+dungeon[i][j]:b.curmin;
                if (x>y) {
                    min = x;
                    hp = a.curhp+dungeon[i][j];
					rec[i][j] = new Tp(min,hp);
                }
                else {
                    min = y;
                    hp = b.curhp+dungeon[i][j];
					rec[i][j] = new Tp(min,hp);
                }
            }
        }
        
        tmp = (rec[dungeon.length-1][dungeon[0].length-1].curmin<0)?rec[dungeon.length-1][dungeon[0].length-1].curmin:0;
		//System.out.println(rec[dungeon.length-1][dungeon[0].length-1].curmin);
		for (int i = 0 ; i < dungeon.length ; i++) {
			for (int j = 0 ; j < dungeon[0].length ; j++) {
				System.out.print(rec[i][j].curmin+","+rec[i][j].curhp+"  ");
			}
			System.out.println();
		}
        return Math.abs(tmp)+1;
    }
}