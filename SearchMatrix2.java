public class SearchMatrix2 {
	public static void main(String[] args) {
		//int[][] a = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
		//System.out.println(searchMatrix(a,5));
		//System.out.println(searchMatrix(a,20));
		
		//int[][] b = new int[][]{{-5}};
		//System.out.println(searchMatrix(b,-2));

		int[][] b2 = new int[][]{{1},{1}};
		System.out.println(searchMatrix(b2,2));
		
		int[][] c = new int[][]{{1,1}};
		System.out.println(searchMatrix(c,2));
	}

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length == 0 || matrix[0].length==0) return false;
        //test1
        /*
        int rowbegin = 0, rowend = matrix.length, mid = 0;
        while(rowbegin<=rowend) {
            mid = (rowbegin+rowend)/2;
            if (matrix[mid][0]==target) return true;
            else if (matrix[mid][0]<target) rowbegin = mid+1;
            else rowend = mid-1;
        }
        
        int colbegin = 0, colend = matrix[0].length;
        mid = 0;
        while(colbegin<=colend) {
            mid = (colbegin+colend)/2;
            if (matrix[0][mid]==target) return true;
            else if (matrix[0][mid]<target) return colbegin = mid+1;
            else colend = mid-1;
        }
        */
        //test2
        int rowbegin = 0, rowend = matrix.length-1;
        int colbegin = 0, colend = matrix[0].length-1;
        int rowmid = 0, colmid = 0;
        while(rowbegin<=rowend && colbegin<=colend) {
            rowmid = (rowbegin+rowend)/2;
            colmid = (colbegin+colend)/2;
            if (matrix[rowmid][colmid]==target) return true;
            else if (matrix[rowmid][colmid] < target) {
                rowbegin = rowmid+1;
                colbegin = colmid+1;
            }
            else {
                rowend = rowmid-1;
                colend = colmid-1;
            }
        }
        
        return (rowend>=0&&bsearch(matrix,target,rowend,rowend,colend,matrix[0].length-1))||(rowbegin<=matrix.length-1 && bsearch(matrix,target,rowbegin,rowbegin,0,colbegin))||(colend>=0&&bsearch(matrix,target,rowend,matrix.length-1,colend,colend))||(colbegin<=matrix[0].length-1 && bsearch(matrix,target,0,rowbegin,colbegin,colbegin));
    }
    
    public static boolean bsearch(int[][] matrix, int target, int rowstart, int rowfinish, int colstart, int colfinish) {
        System.out.println(rowstart+" "+rowfinish+" "+colstart+" "+colfinish);
		if (rowstart==rowfinish) {
            int begin = colstart, end = colfinish, mid = 0;
            while(begin<=end) {
				//System.out.println(mid);
                mid = (begin+end)/2;
                if (matrix[rowstart][mid]==target) return true;
                else if (matrix[rowstart][mid]<target) begin = mid+1;
                else end = mid-1;
				System.out.println(begin+" "+end);
            }
        }
        else if (colstart==colfinish) {
            int begin = rowstart, end = rowfinish, mid = 0;
            while(begin<=end) {
                mid = (begin+end)/2;
                if (matrix[mid][colstart]==target) return true;
                else if (matrix[mid][colstart]<target) begin = mid+1;
                else end = mid-1;
            }
        }
        return false;
    }
}