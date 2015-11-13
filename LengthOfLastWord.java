public class LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" ")); // split(" ")->length=0
	}
	
    public static int lengthOfLastWord(String s) {
		//System.out.println();
        if (s==null || s.length()==0) return 0;
        String[] sp = s.split(" ");
		System.out.println(sp.length);
		for (String x: sp) System.out.println(x.length()+" "+x);
		//System.out.println();
        if (sp.length==0) return s.length();
        else return sp[sp.length-1].length();
    }
}