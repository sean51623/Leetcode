import java.util.*;
public class SpiralMatrix {
	public static void main(String[] args) {
		//int[][] a = new int[][]{{1}};
		//int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		//int[][] a = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25},{26,27,28,29,30},{31,32,33,34,35}};
		//int[][] a = new int[][]{{1,2,3,4,5,6,7},{8,9,10,11,12,13,14},{15,16,17,18,19,20,21},{22,23,24,25,26,27,28},{29,30,31,32,33,34,35}};
		int[][] a = new int[][]{{1,2},{3,4}};
		
		for (int[] i: a) {
			for (int j: i) System.out.print(j+" ");
			System.out.println();
		}
		
		List<Integer> b = spiralOrder(a);
		for (int i: b) System.out.print(i+" ");
		System.out.println();
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix==null || matrix.length==0 || matrix[0].length==0) return res;
		
		int m = matrix.length, n = matrix[0].length;
		int x = 0, y = -1, level = 0, start = 0;
		while(start < m*n) {
			while(y<n-level-1 && start < m*n) {res.add(matrix[x][++y]);++start;}
			while(x<m-level-1 && start < m*n) {res.add(matrix[++x][y]);++start;}
			while(y>level && start < m*n) {res.add(matrix[x][--y]); ++start;}
			while(x>level+1 && start < m*n) {res.add(matrix[--x][y]); ++start;}
			level++;
		}
		return res;
	}
}