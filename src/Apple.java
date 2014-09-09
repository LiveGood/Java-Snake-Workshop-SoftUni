import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Apple {
	public static Random randGenerator;
	private Point applePoint;
	private Color appleColor;
	
	public Apple(Snake s) {
		applePoint = getSnakePoint(s);
		appleColor = Color.RED;
		
	}
	
	private Point getSnakePoint(Snake s) {
		randGenerator = new Random();
		int x = randGenerator.nextInt(30) + 1;
		int y= randGenerator.nextInt(30) + 1;
		x *= 20;
		y *= 20;
		for (Point snakePoint : s.body) {
			if (x == snakePoint.getX() || y == snakePoint.getY()	) {
				return getSnakePoint(s);				
			}
		}
		return new Point(x, y);
	}
	
	public void drawApple(Graphics g){
		applePoint.draw(g, appleColor);
	}	
}
