import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {
    private JTextField textField1;
    private JTextField textField2;
    private JButton startButton;

    public StartScreen() {
        // Set layout manager
        setLayout(new BorderLayout());

        // Create text fields
        textField1 = new JTextField("SNAKE GAME", 20);
        textField2 = new JTextField("GROUP 1", 20);

        // Create start button
        startButton = new JButton("Start");

        // Add components to the panel
        add(textField1, BorderLayout.NORTH);
        add(textField2, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    // Getter method for the start button
    public JButton getStartButton() {
        return startButton;
    }
}
