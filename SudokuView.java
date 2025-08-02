import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuView extends JPanel {
    private final JTextField[][] cells = new JTextField[9][9];
    private final boolean[][] isEditable = new boolean[9][9];

    public SudokuView(SudokuModel model, boolean darkMode) {
        setLayout(new GridLayout(9, 9));
        setBackground(darkMode ? new Color(40, 40, 40) : Color.WHITE);

        int[][] board = model.getBoard();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("Arial", Font.BOLD, 20));

                if (board[row][col] != 0) {
                    cell.setText(String.valueOf(board[row][col]));
                    cell.setEditable(false);
                    cell.setBackground(darkMode ? new Color(60, 60, 60) : new Color(220, 220, 220));
                    cell.setForeground(darkMode ? Color.WHITE : Color.BLACK);
                } else {
                    cell.setText("");
                    cell.setEditable(true);
                    cell.setBackground(darkMode ? new Color(30, 30, 30) : Color.WHITE);
                    cell.setForeground(darkMode ? Color.GREEN : Color.BLACK);
                }

                isEditable[row][col] = cell.isEditable();
                cell.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                add(cell);
                cells[row][col] = cell;
            }
        }
    }

    public JTextField getCell(int row, int col) {
        return cells[row][col];
    }

    public boolean isEditable(int row, int col) {
        return isEditable[row][col];
    }

    public void clearEditableCells() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (isEditable[row][col]) {
                    cells[row][col].setText("");
                }
            }
        }
    }

    // ✅ Renamed for clarity — use this instead of getBoard()
    public int[][] getGridValues() {
        int[][] board = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String text = cells[row][col].getText().trim();
                if (!text.isEmpty()) {
                    try {
                        board[row][col] = Integer.parseInt(text);
                    } catch (NumberFormatException e) {
                        board[row][col] = 0;
                    }
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return board;
    }

    // ✅ Renamed for clarity — use this instead of setBoard()
    public void updateGrid(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (isEditable[row][col]) {
                    if (board[row][col] == 0) {
                        cells[row][col].setText("");
                    } else {
                        cells[row][col].setText(String.valueOf(board[row][col]));
                    }
                }
            }
        }
    }
}
