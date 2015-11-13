import java.util.*;

public class TestTrie {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
	}
}