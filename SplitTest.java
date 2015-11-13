import java.util.*;
public class SplitTest {
	public static void main(String[] args) {
		String a = "aa/bb/cc//dd/ //ee";
		String[] aa = a.split("/");
		System.out.println(aa.length);
		for (int i = 0 ; i < aa.length ; i++) {
			System.out.println(aa[i]);
		}
	}
}