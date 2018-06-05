import java.util.TreeMap;

/**
 * @author Daniel
 * @date 05/06/2018
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.startsWith("apple"));
        System.out.println(trie.search("apple"));

    }

    private TreeMap<String, Boolean> treeMap;
    private TreeMap<String, Boolean> searchMap;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.treeMap = new TreeMap<>();
        this.searchMap = new TreeMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        for (int i = 0; i < word.length(); i++) {
            treeMap.put(word.substring(0, i + 1), true);
        }
        searchMap.put(word, true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return searchMap.containsKey(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return treeMap.containsKey(prefix);
    }
}
