import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

// collision boxes

public class Pong2GamePanel extends JPanel implements ActionListener, KeyListener {

	// game state values
	final int MENU = 0;
	final int GAME = 1;
	final int END1 = 2;
	final int END2 = 3;
	// game state association
	int currentState = MENU;
	// font
	Font titleFont = new Font("Arial", Font.PLAIN, 50);
	// timer
	Timer frameDraw;
	// paddle
	Pong2Paddles p1 = new Pong2Paddles(50, 150, 50, 200);
	Pong2Paddles p2 = new Pong2Paddles(900, 150, 50, 200);
	// ball
	Pong2PongBalls ball = new Pong2PongBalls(500, 250, 25, 25);

	// constructor
	Pong2GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	// update menu state
	void updateMenuState() {

	}

	// update game state
	void updateGameState() {
		p1.update();
		p2.update();
		ball.update();
		p1.checkCollision();
		p2.checkCollision();
		
		// check end game
		if (ball.x == 10) {
			currentState = 3;
		} else if (ball.x == 990) {
			currentState = 2;
		}
		
		
	}

	// update end state left win
	void updateEnd1State() {

	}

	// update end state right win
	void updateEnd2State() {

	}

	// draw menu state
	void drawMenuState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Pong2.WIDTH, Pong2.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("PONG!", 400, 250);
	}

	// draw game state
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Pong2.WIDTH, Pong2.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("PONG!", 400, 80);

		p1.draw(g);
		p2.draw(g);
		ball.draw(g);
	}

	// draw end1 state
	void drawEnd1State(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Pong2.WIDTH, Pong2.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("GAME OVER, LEFT WINS!", 200, 250);

	}

	// draw end2 state
	void drawEnd2State(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Pong2.WIDTH, Pong2.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER, RIGHT WINS!", 200, 250);
	}

	// graphics override
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END1) {
			drawEnd1State(g);
		} else if (currentState == END2) {
			drawEnd2State(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END1) {
			updateEnd1State();
		} else if (currentState == END2) {
			updateEnd2State();
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END1) {
				currentState = MENU;
			} else if (currentState == END2) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}

		if (currentState == GAME) {
			if (arg0.getKeyCode() == KeyEvent.VK_W) {
				p1.up = true;
			} else if (arg0.getKeyCode() == KeyEvent.VK_UP) {
				p2.up = true;
			} else if (arg0.getKeyCode() == KeyEvent.VK_S) {
				p1.down = true;
			} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
				p2.down = true;
			}
			
			// test
			//if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {	
				//ball.balldownright();
			//}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == GAME) {
			// stop left paddle
			if (arg0.getKeyCode() == KeyEvent.VK_W) {
				p1.up = false;
			} else if (arg0.getKeyCode() == KeyEvent.VK_S) {
				p1.down = false;
			}
			// stop right paddle
			if (arg0.getKeyCode() == KeyEvent.VK_UP) {
				p2.up = false;
			} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
				p2.down = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
