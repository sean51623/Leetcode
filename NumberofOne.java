

public class NumberofOne {
	public static void main(String[] args) {
		System.out.println(countDigitOne(1001));
	}

    public static int countDigitOne(int n) {
        // 1-9 -> 1
        // 10-19 -> 11
        // 20-99 -> 8
        // 100-199 -> (1-99) + 100
        // 200-999 -> (1-99)*8
        // 1000-1999 -> (1-999) + 1000
        // 2000-9999 -> (1-999)*8
        // 10000-19999 -> (1-9999) + 10000
        // 20000-99999 -> (1-9999)*8
        
        if (n==0) return 0;
        int ans = 0, remain = 0, forcount = n;
        int power = 0;
        while(forcount!=0) {
			remain = forcount%10;
            forcount = forcount/10;
			if (remain>1) {
				ans += (forcount+1)*Math.pow(10,power);
			}
			else if (remain==1) {
				ans += (forcount)*Math.pow(10,power);
				ans += (n%Math.pow(10,power)+1);
			}
			else if (remain==0){
				ans += (forcount)*Math.pow(10,power);
			}
			power++;
        }
        return ans;
    }
}