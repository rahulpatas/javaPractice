package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        TrieNode node = buildTrie(words);

        for(int i = 0; i < board.length; i++) {
            for (int j = 0 ; j < board[0].length; j++) {
                findWords(board, result, i, j, node);
            }
        }

        return result;
    }

    private void findWords(char[][] board,  List<String> result, int i, int j, TrieNode node) {

        char specialChar = '*';
        char c = board[i][j];
        int index = c - 'a';

        if (c == specialChar || node.next[index] == null) {
            return;
        }

        node = node.next[index];

        if(node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = specialChar;

        if (i > 0) {
            findWords(board, result, i - 1, j, node);
        }

        if (j > 0) {
            findWords(board,  result, i, j - 1, node);
        }

        if (board.length - 1 > i) {
            findWords(board, result, i + 1, j, node);
        }

        if (board[0].length - 1 > j) {
            findWords(board, result, i, j + 1, node);
        }

        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words) {

            TrieNode node = root;
            for(char c : word.toCharArray()) {
                int i = c - 'a';

                if(node.next[i] == null) {
                    node.next[i] = new TrieNode();
                }

                node = node.next[i];
            }

            node.word = word;
        }

        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
