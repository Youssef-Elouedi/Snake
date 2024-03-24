import javax.swing.*;
import java.awt.*;

public class ScoreSquare extends SquarePanel {
    private int scoreValue;

    public ScoreSquare(int scoreValue) {
        // Call the parent class constructor with a color
        super(Color.YELLOW); // Initialize with the color representing score
        this.scoreValue = scoreValue;
        setPreferredSize(new Dimension(20, 20)); // Set preferred size
        updateColor(); // Update color based on score value
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
        updateColor(); // Update color based on score value
    }

    private void updateColor() {
        // Set color based on score value
        if (scoreValue == 0) {
            setBackground(Color.BLACK); // No score
        } else {
            setBackground(Color.YELLOW); // Score present
        }
    }
}
