import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class Window extends JFrame {
	private JLabel scoreLabel; // Label to display the score

	private StartScreen startScreen;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	public static int width = 20;
	public static int height = 20;

	public Window() {
		// Initialize components and set up the window
		initialize();

		scoreLabel = new JLabel("Score: 0");
		add(scoreLabel, BorderLayout.SOUTH);
	}

	private void initialize() {
		// Set up the window properties
		setTitle("Snake");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the start screen
		startScreen = new StartScreen();
		startScreen.getStartButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Hide the start screen
				startScreen.setVisible(false);

				// Start the game
				startGame();
			}
		});

		// Add the start screen to the window
		add(startScreen);
	}

	private void startGame() {
		// Clear the content pane
		getContentPane().removeAll();

		// Create the game grid
		Grid = new ArrayList<ArrayList<DataOfSquare>>();
		ArrayList<DataOfSquare> data;
		for (int i = 0; i < width; i++) {
			data = new ArrayList<DataOfSquare>();
			for (int j = 0; j < height; j++) {
				DataOfSquare c = new DataOfSquare(2);
				data.add(c);
			}
			Grid.add(data);
		}

		// Set up the layout of the panel
		getContentPane().setLayout(new GridLayout(20, 20, 0, 0));

		// Start & pause all threads, then add every square of each thread to the panel
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				getContentPane().add(Grid.get(i).get(j).square);
			}
		}

		// Initial position of the snake
		Tuple position = new Tuple(10, 10);
		// Passing this value to the controller
		ThreadsController c = new ThreadsController(position);
		// Start the game now
		c.start();

		// Link the window to the keyboard listener
		this.addKeyListener(new KeyboardListener());

		// Make the window visible
		setVisible(true);

		updateScore();
	}

	private void updateScore() {
		new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Update the score label with the current score
				scoreLabel.setText("Score: " + ThreadsController.getScore().getScore());

				// Update score position in the game grid
				ThreadsController.getScore().updateScorePosition();
			}
		}).start();
	}





}
