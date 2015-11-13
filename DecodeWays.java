public class DecodeWays {
	public static void main(String[] args) {
		System.out.println(numDecodings("11"));
	}
	
    public static int numDecodings(String s) {
        if (s==null || s.length()==0) return 0;
        int[] count = new int[s.length()];
        
        if (s.charAt(0)=='0') return 0;
        else {
            count[0] = 1;
            for (int i = 1; i < s.length() ; i++) {
                if (s.charAt(i)=='0') {
                    if (s.charAt(i-1)=='1' || s.charAt(i-1)=='2') {
                        if (i<2) count[i] = count[i-1];
                        else count[i] = count[i-2];
                    }
                    else return 0;
                }
                else {
                    if (s.charAt(i-1)=='0' || s.charAt(i-1)>='3') {
                        count[i] = count[i-1];
						System.out.println("aaa");
                    }
                    else {
                        if (s.charAt(i-1)=='2' && s.charAt(i)>=7 && s.charAt(i)<=9) {
                            count[i] = count[i-1];
							System.out.println("bbb");
                        }
                        else {
                            if (i<2) {
                                count[i] = count[i-1]+1;
								System.out.println("ccc");
                            }
                            else count[i] = count[i-1] + count[i-2];
                        }
                    }
                }
            }
        }
        return count[s.length()-1];
    }
}