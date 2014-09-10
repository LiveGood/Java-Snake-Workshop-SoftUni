import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Snake{
	LinkedList<Point> body = new LinkedList<Point>();
	Point head;
	Color snakeColor;
	private int velX, velY;
	
	public Snake() {
		snakeColor = Color.GREEN;
		body.add(new Point(120, 200));
		body.add(new Point(140, 200));
		body.add(new Point(160, 200));
		body.add(new Point(180, 200)); 
		
		head = body.get(0);
		
		velX = 20;
		velY = 0;
	}
	
	public void drawSnake(Graphics g) {		
		for (Point point : this.body) {
			point.draw(g, snakeColor);
		}
	}
	
	public void tick(Game game){
		head.setX(head.getX() + velX);
		head.setY(head.getY() + velY);
		
		for (int i = 1; i < body.size(); i++) {
			body.get(i).setX(body.get(i-1).getX());
			body.get(i).setY(body.get(i-1).getY());
		}		
	}
	
	public boolean intersetct(){
		for (int i = 1; i < body.size(); i++) {
			if(head.getX() == body.get(i).getX()){
				return true;						
			}
		}		
		return false;
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
