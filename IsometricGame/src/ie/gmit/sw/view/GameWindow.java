package ie.gmit.sw.view;

import java.awt.*;
import javax.swing.*;

/**
 * Uses Jframe to display a window with given title, width and height.
 * Game is painted on canvas object with defined dimensions for width and height.
 * Graphics is drawn to the canvas element. Jframe is used to display the canvas.
 * @author Kamila
 *
 */
public class GameWindow {
	
	/*private int[][] model = { 
			{ 1, 0, 0, 0, 0, 0 , 0, 0, 0, 2},
			{ 0, 1, 0, 0, 0, 0 , 0, 0, 0, 2},
			{ 0, 0, 2, 0, 0, 0 , 0, 0, 0, 2},
			{ 0, 0, 0, 1, 0, 0 , 0, 0, 0, 2},
			{ 2, 2, 2, 2, 1, 0  , 0, 0, 0, 2},
			{ 3, 3, 3, 3, 1, 1 , 1, 0, 0, 1},
			{ 5, 5, 5, 5, 3, 3 , 1, 0, 0, 1},
			{ 4, 4, 4, 5, 3, 3 , 1, 0, 0, 0},
			{ 4, 4, 4, 4, 5, 3 , 1, 6, 6, 6},
			{ 4, 4, 4, 4, 4, 3 , 1, 7, 7, 7}
	};
	
	//This matrix is a representation of where objects (things) in the game are placed
	private int[][] objects = { 
			{ 0, 0, 0, 5, 5, 5 , 5, 5, 5, 0},
			{ 5, 0, 0, 0, 5, 5 , 5, 5, 5, 0},
			{ 5, 5, 0, 0, 0, 5 , 5, 5, 5, 9},
			{ 5, 5, 2, 0, 0, 0 , 5, 5, 5, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 5, 5, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 5, 0},
			{ 0, 0, 0, 0, 0, 3 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0}
	};
	
	public GameWindow() throws Exception {
		GameView view = new GameView(model, objects);
		Dimension d = new Dimension(GameView.DEFAULT_VIEW_SIZE, GameView.DEFAULT_VIEW_SIZE/2);
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);

		JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());
		f.add(view);//Adds canvas(view) to the frame
		//f.addKeyListener(view);
		f.setSize(1000, 1000);
		f.setLocation(100, 100);
		f.pack();//Resize the window
		f.setVisible(true);
		f.setResizable(false);//Window with specified size that was given
		f.setLocationRelativeTo(null);//Appears in the center of a screen
	}*/
	
	//Declare variables
	private JFrame f;//JFrame object
	private String title;// Game window title
	private int width, height;// Game window height and width  in pixels
	private Canvas canvas;//Canvas object
	
	//Passes given parameters and calls methods to display game view
	public GameWindow(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createGameWindow();
	}

	/**
	 * Initialize Jframe and sets the title. Sets the with and height
	 */
	private void createGameWindow() {
		f = new JFrame(title);
		//f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);//Window with specified size that was given
		f.setLocationRelativeTo(null);//Appears in the center of a screen
		f.setVisible(true);
		
		//Sets size of canvas with with and height of a game
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		f.add(canvas);//Adds canvas to a Jframe
		f.pack(); //Resize the window to see window fully

	}

	@SuppressWarnings("exports")
	public Canvas getCanvas() {
		return canvas;
	}
	
	@SuppressWarnings("exports")
	public JFrame getFrame() {
		return f;}
	
}