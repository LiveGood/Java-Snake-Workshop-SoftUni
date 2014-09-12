import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Snake{
	LinkedList<Point> body = new LinkedList<Point>();
	private Color snakeColor;
	private int velX, velY;
	
	public Snake() {
		snakeColor = Color.GREEN;
		body.add(new Point(300, 100)); 
		body.add(new Point(280, 100)); 
		body.add(new Point(260, 100)); 
		body.add(new Point(240, 100)); 
		body.add(new Point(220, 100)); 
		body.add(new Point(200, 100)); 
		body.add(new Point(180, 100));
		body.add(new Point(160, 100));
		body.add(new Point(140, 100));
		body.add(new Point(120, 100));

		velX = 20;
		velY = 0;
	}
	
	public void drawSnake(Graphics g) {		
		for (Point point : this.body) {
			point.draw(g, snakeColor);
		}
	}
	
	public void tick() {
		Point newPos = new Point((body.get(0).getX() + velX), (body.get(0).getY() + velY));
		
		if (newPos.getX() > Game.WIDTH - 20) {
		 	Game.gameRunning = false;
		} else if (newPos.getX() < 0) {
			Game.gameRunning = false;
		} else if (newPos.getY() < 0) {
			Game.gameRunning = false;
		} else if (newPos.getY() > Game.HEIGHT - 20) {
			Game.gameRunning = false;
		} else if (Game.apple.getPoint().equals(newPos)) {
			body.add(Game.apple.getPoint());
			Game.apple = new Apple(this);
			Game.score += 50;
		} else if (body.contains(newPos)) {
			Game.gameRunning = false;
			System.out.println("You ate yourself");
		}	
		
		for (int i = body.size()-1; i > 0; i--) {
			body.set(i, new Point(body.get(i-1)));
		}	
		body.set(0, newPos);
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
}
