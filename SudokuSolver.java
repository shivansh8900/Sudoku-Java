public class SudokuSolver {

    // Solves the board using backtracking
    public boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Checks if placing num at (row, col) is valid
    public boolean isValid(int[][] board, int row, int col, int num) {
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num || board[x][col] == num)
                return false;
        }

        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    // ✅ New method: Validates that the entire board is a correct Sudoku solution
    public boolean isValidCompleteBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            for (int j = 0; j < 9; j++) {
                int rowVal = board[i][j];
                int colVal = board[j][i];

                if (rowVal < 1 || rowVal > 9 || rowCheck[rowVal - 1]) return false;
                if (colVal < 1 || colVal > 9 || colCheck[colVal - 1]) return false;

                rowCheck[rowVal - 1] = true;
                colCheck[colVal - 1] = true;
            }
        }

        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                boolean[] boxCheck = new boolean[9];
                for (int i = blockRow * 3; i < blockRow * 3 + 3; i++) {
                    for (int j = blockCol * 3; j < blockCol * 3 + 3; j++) {
                        int val = board[i][j];
                        if (val < 1 || val > 9 || boxCheck[val - 1]) return false;
                        boxCheck[val - 1] = true;
                    }
                }
            }
        }

        return true;
    }
}
