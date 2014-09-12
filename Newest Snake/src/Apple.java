import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;


public class Apple {
	private static Random randGenerator;
	private Point apple;
	
	public Apple(Snake s) {
		apple = createApple(s);
	}

	private Point createApple(Snake s) {
		randGenerator = new Random();
		int x = randGenerator.nextInt(30);
		int y = randGenerator.nextInt(30);
		Point applePoint = new Point(x, y);
		if(s.body.contains(applePoint)) {
			return createApple(s);
		}
		return applePoint;
	}
	
	public void drawApple(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.apple.x *20, this.apple.y*20, SnakeGame.SIZE,  SnakeGame.SIZE);
	}
	
	public Point getPoint() {
		return this.apple;
	}
}
