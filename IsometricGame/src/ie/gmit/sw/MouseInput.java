package ie.gmit.sw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
	// Declare variables
	private int x, y;
	private boolean left, right;
	private UIController uIController;

	MouseInput() {

	}

	public void setUIController(UIController uIController) {
		this.uIController = uIController;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		// Checks if uIController exists
		if (uIController != null)
			uIController.onMouseMove(e);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Left mouse button
		if (e.getButton() == MouseEvent.BUTTON1)
			left = true;
		// Right mouse button
		else if (e.getButton() == MouseEvent.BUTTON3)
			right = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Left mouse button
		if (e.getButton() == MouseEvent.BUTTON1)
			left = false;
		// Right mouse button
		else if (e.getButton() == MouseEvent.BUTTON3)
			right = false;
		// Checks if uIController exists
		if (uIController != null)
			uIController.onMouseRelease(e);

	}

	public boolean isLPressed() {
		return left;
	}

	public boolean isRPressed() {
		return right;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
