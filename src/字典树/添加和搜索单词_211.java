package 字典树;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class 添加和搜索单词_211 {

    private WordTrieNode root;

    public 添加和搜索单词_211() {
        root = new WordTrieNode();
    }


    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        WordTrieNode p = root;
        int i = 0, len = word.length();
        while (i < len) {
            char ch = word.charAt(i);
            if (p.nexts.containsKey(ch)) {
                p = p.nexts.get(ch);
                i++;
            } else {
                break;
            }
        }

        while (i < len) {
            WordTrieNode node = new WordTrieNode();
            node.index = i;
            p.nexts.put(word.charAt(i), node);
            p = node;
            i++;
        }
        p.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, WordTrieNode node) {
        if (index == word.length() - 1) {
            if (word.charAt(index) == '.') {
                for (WordTrieNode node1 : node.nexts.values()
                ) {
                    if (node1.isWord) {
                        return true;
                    }
                }
                return false;
            } else {
                WordTrieNode node1 = node.nexts.get(word.charAt(index));
                return node1 != null && node1.isWord;
            }
        }
        if (index >= word.length()) {
            return false;
        }
        if (word.charAt(index) == '.') {
            boolean res = false;
            for (WordTrieNode node1 : node.nexts.values()
            ) {
                res |= dfs(word, index + 1, node1);
            }
            return res;
        } else {
            if (node.nexts.containsKey(word.charAt(index))) {
                return dfs(word, index + 1, node.nexts.get(word.charAt(index)));
            } else {
                return false;
            }
        }

    }
}

class WordTrieNode {
    boolean isWord;
    int index;
    HashMap<Character, WordTrieNode> nexts;

    WordTrieNode() {
        nexts = new HashMap<>();
    }
}
