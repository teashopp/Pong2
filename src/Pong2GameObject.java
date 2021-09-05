import java.awt.Rectangle;

public class Pong2GameObject {

	// object values
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;
	// collision box
	Rectangle cbtop;
	Rectangle cbbot;
	// collision box ball
	Rectangle cbball;
	// collision box values
	int newheight = height / 2;
	int newytop = y / 2;
	int newybot = y - newytop;

	// constructor
	Pong2GameObject(int x, int y, int width, int height) {
		speed = 0;
		isActive = true;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		cbtop = new Rectangle(x, newytop, width, newheight);
		cbbot = new Rectangle(x, newybot, width, newheight);
		cbball = new Rectangle(x, y, width, height);
	}

	// update
	void update() {
		cbtop.setBounds(x, newytop, width, newheight);
		cbbot.setBounds(x, newybot, width, newheight);
		cbball.setBounds(x, y, width, height);
	}

}
