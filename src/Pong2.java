import javax.swing.JFrame;

public class Pong2 {

	// pong game that I'm restarting because I overcomplicated the original one and
	// figured it would be easier to start from scratch without the many pong balls

	JFrame mainframe;
	Pong2GamePanel p2gp;

	static final int WIDTH = 1000;
	static final int HEIGHT = 500;

	// main
	public static void main(String[] args) {
		Pong2 pong2 = new Pong2();
		pong2.setup();
	}

	// pong2 constructor
	Pong2() {
		mainframe = new JFrame();
		p2gp = new Pong2GamePanel();
		mainframe.add(p2gp);
		mainframe.addKeyListener(p2gp);
		p2gp = new Pong2GamePanel();
	}

	// frame setup
	void setup() {
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setVisible(true);
		mainframe.setSize(WIDTH, HEIGHT);
	}

}
