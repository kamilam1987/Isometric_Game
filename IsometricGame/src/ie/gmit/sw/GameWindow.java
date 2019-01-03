package ie.gmit.sw;

import java.awt.*;
import javax.swing.*;
public class GameWindow {
	/*
	 * This matrix represents the isometric game model, with each number mapping to an
	 * image in the images/ground/ directory.
	 */
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
	private JFrame f;
	private String title;
	private int width, height;
	private Canvas canvas;
	
	public GameWindow(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createGameWindow();
	}

	private void createGameWindow() {
		f = new JFrame(title);
		//f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);//Window with specified size that was given
		f.setLocationRelativeTo(null);//Appears in the center of a screen
		f.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		f.add(canvas);
		f.pack(); //Resize the window

	}

	@SuppressWarnings("exports")
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return f;}
	
}