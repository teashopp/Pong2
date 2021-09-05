import java.awt.Rectangle;

public class Pong2GameObject {

	// object values
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;	

	// constructor
	Pong2GameObject(int x, int y, int width, int height) {
		speed = 0;
		isActive = true;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
