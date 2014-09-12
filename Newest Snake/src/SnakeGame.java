import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class SnakeGame extends Canvas implements Runnable {
	public static final int ROWS = 30;
	public static final int COLS = 30;		
	public static final int SIZE = 20;
	public static final int WIDTH = COLS * SIZE;	
	public static final int HEIGHT = ROWS * SIZE;	
	
	public static Snake snake;
	public static Apple apple;
	public Graphics globalGraphics;
	private Thread runThread;
	
	static boolean gameRunning= false;
	
	public void paint(Graphics g) {
		globalGraphics = g.create();	
		if (runThread == null) {
			runThread = new Thread(this);
			runThread.start();
			gameRunning = true;
		}
	}
		
	public void run() {
		while (gameRunning) {
			snake.tick();
			draw(globalGraphics);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				
			}
		}
		
	}
	
	public SnakeGame() {
		snake = new Snake();
		apple = new Apple(snake);
	}
	
	public void draw(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT+25);
		drawGrid(g);		
		snake.drawSnake(g);
		apple.drawApple(g);
	}
	
	public void drawGrid(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, WIDTH, HEIGHT);
		for (int i = 0; i < ROWS; i++) {
			g.drawLine(0, i*20, WIDTH, i*20);
			g.drawLine(i*20, 0, i*20, HEIGHT);			
		}
	}
	
	public static void printGameOver(Graphics g) {
		
	}
}
