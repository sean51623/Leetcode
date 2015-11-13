import java.util.*;

class TrieNode {
    // Initialize your data structure here.
    char ch;
    int freq;
    public HashMap<Character, TrieNode> rec;
    public TrieNode() {
        rec = new HashMap<>();
    }
    public TrieNode(char ch) {
        this.ch = ch;
        freq = 1;
        rec = new HashMap<>();
    }
}

