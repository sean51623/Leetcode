public class SubStringTest {
	public static void main(String[] args) {
		String s = "qwertyuiop";
		System.out.println(s.length());
		System.out.println(s.substring(0,1));
		System.out.println(s.substring(9,10));
		//System.out.println(s.substring(10,11)); //runtime error
		System.out.println(s.substring(10));
		//System.out.println(s.substring(11)); //runtime error
		System.out.println(s.substring(5));
		System.out.println(s.substring(5,6));
	}
}