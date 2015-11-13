import java.util.*;

public class TextJustify {
	public static void main(String[] args) {
		List<String> hi = fullJustify(new String[]{"a"}, 1);
		for (String i: hi) System.out.println(i);
		
		//["Listen","to","many,","speak","to","a","few."], 6
		List<String> hi2 = fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6);
		for (String i: hi2) System.out.println(i);
		
		//["What","must","be","shall","be."], 12
		List<String> hi3 = fullJustify(new String[]{"What","must","be","shall","be."}, 12);
		for (String i: hi3) System.out.println(i);
	}

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        if (words==null || words.length==0) return ans;
        if (words[0].length()==0) {
            if (maxWidth==0) {
                ans.add("");
                return ans;
            }
            else {
                char[] tt = new char[maxWidth];
                Arrays.fill(tt, ' ');
                ans.add(new String(tt));
                return ans;
            }
        }
        
        int line = 0;
        int idx = -1;
		int space = 0, wordnum = 0, spacenum = 0;
		char[] insert;
		StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < words.length ; i++) {
            if ((line+((i==(idx+1))?words[i].length():1+words[i].length()))>maxWidth) {
                sb = new StringBuilder();
                space = maxWidth - line;
                for (int j = idx+1 ; j < i ; j++) {
                    sb.append(words[j]);
                    if (j!=(i-1)) sb.append(" ");
                    wordnum = i-j-1;
                    if (wordnum!=0) spacenum = (space%(wordnum)==0)?space/wordnum:(space/wordnum)+1;
					else spacenum = space;
					//System.out.println(wordnum);
                    space -= spacenum;
                    insert = new char[spacenum];
                    Arrays.fill(insert, ' ');
                    sb.append(insert);
                }
                idx = i-1;
				line = words[i].length();
                ans.add(sb.toString());
            }
            else {
				if (i == (idx+1)) line+= (words[i].length());
                else line += (1+words[i].length());
            }
        }
		if (line!=0) {
			sb = new StringBuilder();
			space = maxWidth-line;
			for (int j = idx + 1 ; j < words.length ; j++) {
				sb.append(words[j]);
				if (j!=(words.length-1)) sb.append(" ");
				//wordnum = words.length-j;
				//spacenum = (space%(wordnum)==0)?space/wordnum:(space/wordnum)+1;
				//space -= spacenum;
				//insert = new char[spacenum];
				//Arrays.fill(insert, ' ');
				//sb.append(insert);
			}
			insert = new char[space];
			Arrays.fill(insert, ' ');
			sb.append(insert);
			ans.add(sb.toString());
		}
        return ans;
    }
}