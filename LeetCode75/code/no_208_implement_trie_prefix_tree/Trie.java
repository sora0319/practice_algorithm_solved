package no_208_implement_trie_prefix_tree;

class Trie {
    boolean isEnded;
    boolean[] isNext;
    Trie[] next;

    public Trie() {
        this.isEnded = false;
        this.isNext = new boolean[26];
        this.next = new Trie[26];
    }

    public void insert(String word) {
        Trie current = this;

        for (char c : word.toCharArray()) {
            int n = c - 'a';

            if (!current.isNext[n]) {
                current.next[n] = new Trie();
                current.isNext[n] = true;
            }
            current = current.next[n];
        }
        current.isEnded = true;
    }

    public boolean search(String word) {
        Trie current = this;

        for (char c : word.toCharArray()) {
            int n = c - 'a';

            if (current.next[n] == null) {
                return false;
            }
            current = current.next[n];
        }

        return current.isEnded;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;

        for (char c : prefix.toCharArray()) {
            int n = c - 'a';

            if (current.next[n] == null) {
                return false;
            }

            current = current.next[n];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");

        System.out.println(trie.search("apple"));    // true
        System.out.println(trie.search("app"));      // false
        System.out.println(trie.startsWith("app"));  // true

        trie.insert("app");

        System.out.println(trie.search("app"));      // true
        System.out.println(trie.startsWith("ap"));   // true
        System.out.println(trie.search("banana"));   // false
    }
}