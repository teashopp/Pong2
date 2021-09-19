import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pong2PongBalls extends Pong2GameObject {

	int xspeed = 5;
	int yspeed = 5;
	Random rand21 = new Random();;
	int sidestart;
	int randnum = rand21.nextInt((2 - 0) + 0);
	// collision box ball
	Rectangle cbball;

	Pong2PongBalls(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stucture
		if (randnum == 1) {
			xspeed = -xspeed;
		}
	}

	// draw
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

	// update
	void update() {
		x += xspeed;
		y += yspeed;
		cbball = new Rectangle(x, y, width, height);
		cbball.setBounds(x, y, width, height);

	}
}
