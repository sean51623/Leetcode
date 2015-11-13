public class MySqrt {
	public static void main(String[] args) {
		int a = 2147395599;
		System.out.println(mySqrt(a));
		System.out.println(mySqrt(Integer.parseInt(args[0])));
	}

    public static int mySqrt(int x) {
        // if (x < 0) return ?;
        if (x==0 || x==1) return x;
        int down = 1;
        int up = x/2;
        int mid = down;
        
        while (down<=up) {
            mid = (down+up)/2;
			//System.out.println(mid);
            
            if (mid*mid==x) return mid;
            else if (mid<x/mid && (mid+1)>x/(mid+1)) {
				//System.out.println("aaa");
                return mid;
            }
            else if (mid<x/mid) {
                //System.out.println("bbb");
				down = mid+1;
            }
            else if (mid>x/mid) {
				//System.out.println("ccc");
                up = mid;
            }
        }
        return down;
    }
}