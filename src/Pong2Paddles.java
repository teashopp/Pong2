import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pong2Paddles extends Pong2GameObject {

	boolean up;
	boolean down;

	// collision box
	Rectangle cbtop;
	Rectangle cbbot;
	
	// collision box ints
	int newheight;
	int newybot;

	// constructor
	Pong2Paddles(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		newheight = height / 2;
		cbtop = new Rectangle(x, y, width, newheight);
		cbbot = new Rectangle(x, newybot, width, newheight);
	}

	// draw paddles
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, newheight);
		g.setColor(Color.red);
		g.fillRect(x, newybot, width, newheight);
	}

	public void update() {
		newybot = y + newheight;
		if (up && y >= 0) {
			up();
		} else if (down && y <= 350) {
			down();
		}
		cbtop.setBounds(x, y, width, newheight);
		cbbot.setBounds(x, newybot, width, newheight);
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
