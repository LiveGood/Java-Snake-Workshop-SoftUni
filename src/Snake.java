import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Snake{
	LinkedList<Point> body = new LinkedList<Point>();
	Color snakeColor;
	
	public Snake() {
		snakeColor = Color.GREEN;
		body.add(new Point(20, 20));
		body.add(new Point(40, 20));
		body.add(new Point(60, 20));
		body.add(new Point(80, 20));
	}
	
	public void drawSnake(Graphics g) {		
		for (Point point : this.body) {
			point.draw(g, snakeColor);
		}
	}
}
