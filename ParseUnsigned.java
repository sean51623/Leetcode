public class ParseUnsigned {
	public static void main(String[] args) {
		//String a = "2147483648";//10000000000000000000000000000000
		//System.out.println(Integer.parseUnsignedInt(a));
		//
		int a = 100;
		for (int i = 0; i < 5 ; i++) {
			a >>>=1;
			System.out.println(a);
		}
	}
}