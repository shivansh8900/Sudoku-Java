import javax.swing.*;
import java.awt.*;

public class SudokuApp extends JFrame {
    public SudokuApp(boolean darkMode) {
        setTitle("Sudoku App - Dark Mode");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        int[][] initialPuzzle = {
                 {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuModel model = new SudokuModel(initialPuzzle);
        SudokuView view = new SudokuView(model, darkMode);
        SudokuSolver solver = new SudokuSolver();

        JLabel timerLabel = new JLabel("Time: 0s");
        timerLabel.setForeground(darkMode ? Color.WHITE : Color.BLACK);
        SudokuTimer sudokuTimer = new SudokuTimer(timerLabel);
        sudokuTimer.start();

        JButton checkButton = new JButton("Check");
checkButton.addActionListener(e -> {
    int[][] board = view.getGridValues();
    if (solver.isValidCompleteBoard(board)) {
        JOptionPane.showMessageDialog(this, "Correct so far!");
    } else {
        JOptionPane.showMessageDialog(this, "There are mistakes!");
    }
});

// 🧠 Solve button
JButton solveButton = new JButton("Solve");
solveButton.addActionListener(e -> {
    int[][] board = view.getGridValues();
    if (!solver.solve(board)) {
        JOptionPane.showMessageDialog(this, "No solution found!");
    } else {
        view.updateGrid(board);
        JOptionPane.showMessageDialog(this, "Solved successfully!");
        sudokuTimer.stop();
    }
});

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            view.clearEditableCells();
            sudokuTimer.reset();
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(darkMode ? new Color(40, 40, 40) : Color.WHITE);
         controlPanel.add(checkButton);     
        controlPanel.add(solveButton);
        controlPanel.add(timerLabel);
        controlPanel.add(resetButton);

        add(view, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SudokuApp(true).setVisible(true));
    }
}
