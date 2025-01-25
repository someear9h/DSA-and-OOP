package Backtracking;

class Solution {
    private boolean backtrack(char[][] board, String word, int row, int col, int index) {

        // base case
        if(index == board.length){
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '!';


        // move in all directions
        boolean found = backtrack(board, word, row - 1, col, index + 1) || // top
                        backtrack(board, word, row + 1, col, index + 1) || // bottom
                        backtrack(board, word, row, col - 1, index + 1) || // left
                        backtrack(board, word, row, col + 1, index + 1); // right
        

        // backtrack: restore the original value of the cell
        board[row][col] = temp;

        return found; // Return true if the word is found in any direction
    }

    public boolean exists(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class WordSearch {
    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";

        System.out.println(sol.exists(board, word));
    }
}
