package no_211_design_add_and_search_words_data_structure;

class WordDictionary {
    boolean isEnded;
    WordDictionary[] next;

    public WordDictionary() {
        this.next = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary current = this;

        for (char c : word.toCharArray()) {
            int n = c - 'a';

            if (current.next[n] == null) {
                current.next[n] = new WordDictionary();
            }

            current = current.next[n];
        }

        current.isEnded = true;
    }

    public boolean search(String word) {
        WordDictionary current = this;

        for (int w = 0; w < word.length(); w++) {
            if (word.charAt(w) == '.') {
                return dfs(word, w, current);
            }

            int n = word.charAt(w) - 'a';

            if (current.next[n] == null) {
                return false;
            }

            current = current.next[n];
        }

        return current.isEnded;
    }

    private boolean dfs(String word, int w, WordDictionary current) {
        if (w == word.length()) {
            return current.isEnded;
        }

        if (word.charAt(w) == '.') {
            for (WordDictionary dict : current.next) {
                if (dict == null) {
                    continue;
                }

                if (dfs(word, w + 1, dict)) {
                    return true;
                }
            }
        } else {
            int n = word.charAt(w) - 'a';

            if (current.next[n] == null) {
                return false;
            }

            current = current.next[n];

            return dfs(word, w + 1, current);
        }

        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
        System.out.println(wordDictionary.search("ba.")); // true
        System.out.println(wordDictionary.search("...")); // true
        System.out.println(wordDictionary.search("....")); // false
    }
}