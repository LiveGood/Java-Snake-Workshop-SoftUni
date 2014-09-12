import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Apple {
	public static Random randGenerator;
	private Point applePoint;
	private Color appleColor;
	
	public Apple(Snake s) {
		applePoint = createApple(s);
		appleColor = Color.RED;
		
	}
	
	private Point createApple(Snake s) {
		randGenerator = new Random();
		int x = randGenerator.nextInt(30) * 20; 
		int y = randGenerator.nextInt(30) * 20;
		for (Point snakePoint : s.body) {
			if (x == snakePoint.getX() || y == snakePoint.getY()) {
				return createApple(s);				
			}
		}
		return new Point(x, y);
	}
	
	public void drawApple(Graphics g){
		applePoint.draw(g, appleColor);
	}	
	
	public Point getPoint(){
		return applePoint;
	}
}
