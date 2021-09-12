import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pong2PongBalls extends Pong2GameObject {

	int xspeed = 10;
	int yspeed = 10;
	Random rand21;
	int sidestart;
	// collision box ball
	Rectangle cbball;

	Pong2PongBalls(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		cbball = new Rectangle(x, y, width, height);
	}

	// draw
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

	// update
	void update() {
		Random rand21 = new Random((4 - 1) + 1);
		if (rand21 == 1) {
			x += xspeed;
			y -= yspeed;
		} else if (rand21 == 2) {
			x += xspeed;
			y += yspeed;
		} else if (rand21 == 3) {
			x -= xspeed;
			y -= yspeed;
		} else if (rand21 == 4) {
			x -= xspeed;
			y += yspeed;
		}
		cbball.setBounds(x, y, width, height);
	}
}
