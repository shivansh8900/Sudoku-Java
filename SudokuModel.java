public class SudokuModel {
    private final int[][] puzzle;

    public SudokuModel(int[][] initial) {
        this.puzzle = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(initial[i], 0, this.puzzle[i], 0, 9);
        }
    }

    public int getValue(int row, int col) {
        return this.puzzle[row][col];
    }

    public void setValue(int row, int col, int value) {
        this.puzzle[row][col] = value;
    }

    public boolean isEditable(int row, int col) {
        return this.puzzle[row][col] == 0;
    }

    public int[][] getBoard() {
        return this.puzzle;
    }
}
