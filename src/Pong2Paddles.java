import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pong2Paddles extends Pong2GameObject {

	boolean up;
	boolean down;

	// constructor
	Pong2Paddles(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	// draw paddles
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	public void update() {
		if (up && y >= 0) {
			up();
		} else if (down && y <= 350) {
			down();
		}
		super.update();
	}

	// move up
	public void up() {
		y -= speed;
	}

	// move down
	public void down() {
		y += speed;
	}

}
