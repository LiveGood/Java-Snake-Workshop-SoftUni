import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;


public class Snake {
	LinkedList<Point> body = new LinkedList<>();
	private Point head;
	private int snakeSize = SnakeGame.SIZE;
	public int velX, velY;
	
	public Snake() {
		Collections.addAll(body,				
				new Point(7, 3),
				new Point(6, 3),
				new Point(5, 3),
				new Point(4, 3),				
				new Point(3, 3)
		);
		head = body.peekFirst();
		velX = 1;
		velY = 0;
	}
	
	public void drawSnake(Graphics g) {
		for (int i = 0; i < body.size(); i++) {
			Point snakePart = body.get(i);
			
			g.setColor(Color.GREEN);
			g.fillRect(snakePart.x * snakeSize, snakePart.y * snakeSize, snakeSize, snakeSize);
			g.setColor(Color.BLACK);
			g.drawRect(snakePart.x * snakeSize, snakePart.y * snakeSize, snakeSize, snakeSize);
		}
	}
	
	public void tick() {
		int nextX = body.peekFirst().x + velX;
		int nextY = body.peekFirst().y + velY;
		Point nextPosition = new Point(nextX, nextY);
		
		boolean outOfField = 
				nextX >= SnakeGame.COLS || nextX < 0 ||
				nextY >=  SnakeGame.ROWS || nextY < 0 ||
				body.contains(new Point(nextX, nextY));
				
		if (outOfField) {
//			SnakeGame.globalGraphics.drawString("Game over", 300, 300);
			SnakeGame.gameRunning = false;
		} else if (nextPosition.equals(SnakeGame.apple.getPoint())) {
			body.add(SnakeGame.apple.getPoint());
			SnakeGame.apple = new Apple(this);
		}
		
		for (int i = body.size()-1; i > 0; i--) {
			body.set(i, new Point(body.get(i-1)));
		}	
		body.set(0, new Point(nextX, nextY));
	}
	
	
	
}
