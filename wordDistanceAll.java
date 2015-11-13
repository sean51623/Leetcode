public int shortestDistance(String[] words, String word1, String word2) {
    int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) 
            p1 = i;

        if (words[i].equals(word2)) 
            p2 = i;

        if (p1 != -1 && p2 != -1)
            min = Math.min(min, Math.abs(p1 - p2));
    }

    return min;
}

public class WordDistance {

	private Map<String, List<Integer>> map;

	public WordDistance(String[] words) {
		map = new HashMap<String, List<Integer>>();
		for(int i = 0; i < words.length; i++) {
			String w = words[i];
			if(map.containsKey(w)) {
				map.get(w).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(w, list);
			}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int ret = Integer.MAX_VALUE;
		for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
			int index1 = list1.get(i), index2 = list2.get(j);
			if(index1 < index2) {
				ret = Math.min(ret, index2 - index1);
				i++;
			} else {
				ret = Math.min(ret, index1 - index2);
				j++;
			}
		}
		return ret;
	}
}

public int shortestWordDistance(String[] words, String word1, String word2) {
    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
    for (int i=0; i<words.length; i++) {
        if (words[i].equals(word1)) i1 = i;
        if (words[i].equals(word2)) {
            if (word1.equals(word2)) i1 = i2;
            i2 = i;
        }
        dist = Math.min(dist, Math.abs(i1 - i2));
    }
    return (int) dist;
}

public int shortestWordDistance(String[] words, String word1, String word2) {
    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
    boolean same = word1.equals(word2);
    for (int i=0; i<words.length; i++) {
        if (words[i].equals(word1)) {
            if (same) {
                i1 = i2;
                i2 = i;
            } else {
                i1 = i;
            }
        } else if (words[i].equals(word2)) {
            i2 = i;
        }
        dist = Math.min(dist, Math.abs(i1 - i2));
    }
    return (int) dist;
}
