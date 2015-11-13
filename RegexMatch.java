public class RegexMatch {
	public static void main(String[] args) {
		System.out.println(isMatch());
	}

    public static boolean isMatch(String s, String p) {
		return solve(s,p,0,0);
    }
	
	public static boolean solve(String s, String p, int sc, int pc) {
		if (sc==s.length()) return pc==p.length();
		
		if (pc==p.length()-1 || p.charAt(pc+1)!='*') {
			return (s.charAt(sc)==p.charAt(pc)) && solve(s,p,sc+1,pc+1);
		}
		else
	}
	
	public static boolean isMatch2(String s, String p) {
		if (s.length()==0 && p.length()==0) return true;
		if (s.length()==0 || p.length()==0) return false;
		boolean[][] res = new boolean[s.length()+1][p.length()+1];
		
		for (int j = 0 ; j < p.length()+1 ; j++) {
			if (p.charAt(j)=='*') {
				if (j>0 && res[0][j-1]) res[0][j+1] = true;
			}
			else {
				for (int i = 0 ; i < s.length()+1 ; i++) {
					if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') res[i+1][j+1] = res[i][j];
				}
			}
		}
		return res[s.length()][p.length()];
	}
	
	public static boolean isMatch3(String s, String p) {
		if (s.length()==0 && p.length()==0) return true;
		if (s.length()==0 || p.length()==0) return false;
		
		boolean[][] rec = new boolean[s.length()+1][p.length()+1];
		
		rec[0][0] = true;
		for (int i = 1 ; i < p.length()+1 ; i++) {
			if (p.charAt(i-1)=='*') rec[0][i] = ;
			else rec[0][i] = false;
		}
		
		for (int i = 1 ; i < s.length()+1 ; i++) {
			for (int j = 1 ; j < p.length()+1 ; j++) {
				if ((s.charAt(i)==p.charAt(j)) || p.charAt(j)=='.'){
					rec[i][j] = res[i-1][j-1];
				}
				
				else if 
			}
		}
		return rec[s.length()][p.length()];
	}
}

/* this works: DP
	public boolean isMatch(String s, String p) {
        boolean[] match = new boolean[s.length()+1];
        Arrays.fill(match, false);
        match[s.length()] = true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)=='*'){
                for(int j=s.length()-1;j>=0;j--)    match[j] = match[j]||match[j+1]&&(p.charAt(i-1)=='.'||s.charAt(j)==p.charAt(i-1));
                i--;
            }
            else{
                for(int j=0;j<s.length();j++)   match[j] = match[j+1]&&(p.charAt(i)=='.'||p.charAt(i)==s.charAt(j));
                match[s.length()] = false;
            }
        }
        return match[0];
    }
*/
