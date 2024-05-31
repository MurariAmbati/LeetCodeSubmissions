// https://leetcode.com/problems/word-search-ii

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }
}

public class Solution {
    private int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        
        // Build the Trie from the given list of words
        for (String word : words) {
            trie.insert(word);
        }

        m = board.length;
        n = board[0].length;

        // Explore each cell on the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#' || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        char ch = board[i][j];
        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate results
        }

        // Mark the cell as visited
        board[i][j] = '#';

        // Explore adjacent cells
        dfs(board, i + 1, j, node, result);
        dfs(board, i - 1, j, node, result);
        dfs(board, i, j + 1, node, result);
        dfs(board, i, j - 1, node, result);

        // Restore the cell's original value
        board[i][j] = ch;
    }

}
