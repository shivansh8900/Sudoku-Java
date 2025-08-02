import javax.swing.*;
import java.awt.event.ActionListener;

public class SudokuTimer {
    private Timer timer;
    private int secondsPassed = 0;
    private JLabel timerLabel;

    public SudokuTimer(JLabel label) {
        this.timerLabel = label;
        this.timer = new Timer(1000, e -> {
            secondsPassed++;
            timerLabel.setText("Time: " + secondsPassed + "s");
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void reset() {
        timer.stop();
        secondsPassed = 0;
        timerLabel.setText("Time: 0s");
        timer.start();
    }
}
