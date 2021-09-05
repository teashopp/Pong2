import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pong2Paddles extends Pong2GameObject {

	boolean up;
	boolean down;
	int newheight;
	int newytop;
	int newybot;
	// collision box
	Rectangle cbtop;
	Rectangle cbbot;

	// constructor
	Pong2Paddles(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		cbtop = new Rectangle(x, newytop, width, newheight);
		cbbot = new Rectangle(x, newybot, width, newheight);
	}

	// draw paddles
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
//		g.setColor(Color.BLACK);
//		g.fillRect(cbtop.x, cbtop.y, cbtop.width, cbtop.height);
//		g.fillRect(cbbot.x, cbbot.y, cbbot.width, cbbot.height);
	}

	public void update() {
	newheight = height / 2;
	newybot = (y + height) / 2;
	//newybot = y - newytop;
	
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
