import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word==null || word.length()==0) return;
        TrieNode tmp = root;
        for (int i = 0 ; i < word.length() ; i++) {
            if (tmp.rec.containsKey(word.charAt(i))) {
                tmp.rec.get(word.charAt(i)).freq++;
                tmp = tmp.rec.get(word.charAt(i));
            }
            else {
                while(i!=word.length()) {
                    TrieNode node = new TrieNode(word.charAt(i));
                    tmp.rec.put(word.charAt(i), node);
                    tmp = node;
                    i++;
                }
                break;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp = root;
        for (int i = 0 ; i < word.length() ; i++) {
            if (tmp.rec.containsKey(word.charAt(i))) {
                TrieNode ct = tmp.rec.get(word.charAt(i));
                if (i==word.length()-1 && ct.rec.isEmpty()) {
                    return true;
                }
                else if (i==word.length()-1) {
                    int count = 0;
                    for (HashMap.Entry<Character, TrieNode> t: ct.rec.entrySet()) {
                        count += t.getValue().freq;
                    }
					System.out.println(count);
					System.out.println(ct.freq);
                    if (count==ct.freq) return false;
                    if (count<ct.freq) return true;
                }
                else tmp = tmp.rec.get(word.charAt(i));
            }
            else return false;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (int i = 0 ; i < prefix.length() ; i++) {
            if (tmp.rec.containsKey(prefix.charAt(i))) {
                tmp = tmp.rec.get(prefix.charAt(i));
            }
            else return false;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");