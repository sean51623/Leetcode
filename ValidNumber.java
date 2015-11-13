public class ValidNumber {
	public static void main(String[] args) {
	
	}
    public static boolean isNumber(String s) {
        if (s==null) return false;
        s = s.trim();
        if (s.length()==0) return false;
        
        boolean dot = false;
        boolean e = false;
        
        for (int i = 0 ; i < s.length() ; i++ ) {
            switch(s.charAt(i)) {
                case '.':
                    if (dot||e|| ((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'))&&(i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9')))) return false;
                    dot = true;
                    break;
                case '+':
                case '-':
                    if ((i>0&&(s.charAt(i-1)!='e'&&s.charAt(i-1)!='E')) || (i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'||s.charAt(i+1)=='.'))) return false;
                    break;
                case 'e':
                case 'E':
                    if (e || i==s.length()-1 || i==0) return false;
                    e = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}