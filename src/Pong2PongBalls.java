import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pong2PongBalls extends Pong2GameObject {
	
	int xspeed = 10;
	int yspeed = 10;
	
	Pong2PongBalls(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub	
	}
	
	// draw
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}
	
	// update
	void update() {
		super.update();
		x += xspeed;
		y += yspeed;
	}
}
