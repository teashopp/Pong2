import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pong2ObjectManager implements ActionListener {

	Pong2Paddles omp1;
	Pong2Paddles omp2;
	Pong2PongBalls omball;

	Pong2ObjectManager(Pong2Paddles omp1, Pong2Paddles omp2, Pong2PongBalls omball) {
		this.omp1 = omp1;
		this.omp2 = omp2;
		this.omball = omball;
	}

	void checkCollision() {
		// check ball and paddle collision
		if (omp1.cbtop.intersects(omball.cbball)) {
			omball.xspeed = -omball.xspeed;
			omball.yspeed = omball.yspeed;
		} else if (omp2.cbtop.intersects(omball.cbball)) {
			omball.xspeed = -omball.xspeed;
			omball.yspeed = omball.yspeed;
		} else if (omp1.cbbot.intersects(omball.cbball)) {
			omball.xspeed = -omball.xspeed;
			omball.yspeed = -omball.yspeed;
		} else if (omp2.cbbot.intersects(omball.cbball)) {
			omball.xspeed = -omball.xspeed;
			omball.yspeed = -omball.yspeed;
		}

		if (omball.y == 0) {
			omball.yspeed = -omball.yspeed;
		}

		else if (omball.y == 480) {
			omball.yspeed = -omball.yspeed;
		}
	}
// check position

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}