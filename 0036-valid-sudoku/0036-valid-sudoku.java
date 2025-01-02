class Solution {
    int row, col;

    public boolean isValidSudoku(char[][] board) {
        row = board.length;
        col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (invalidRow(board, i) == true) return false;
        }

        for (int i = 0; i < col; i++) {
            if (invalidCol(board, i) == true) return false;
        }

        for (int i = 0; i < row; i += 3) {
            for (int j = 0; j < col; j += 3) {
                if (invalidBox(board, i, j) == true) return false;
            }
        }

        return true;
    }

    public boolean invalidRow(char[][] board, int r) {
        Set<Character> seen = new HashSet();
        for (int i = 0; i < col; i++) {
            if (seen.contains(board[r][i]) && board[r][i] != '.') {
                return true;
            } else seen.add(board[r][i]);
        }
        return false;
    }

    public boolean invalidCol(char[][] board, int c) {
        Set<Character> seen = new HashSet();
        for (int i = 0; i < row; i++) {
            if (seen.contains(board[i][c]) && board[i][c] != '.') {
                return true;
            } else seen.add(board[i][c]);
        }
        return false;
    }

    public boolean invalidBox(char[][] board, int r, int c) {
        Set<Character> seen = new HashSet();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (seen.contains(board[i][j]) && board[i][j] != '.') {
                    return true;
                } else seen.add(board[i][j]);
            }
        }

        return false;
    }
}
