import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {
	public static Snake snake;
	public static Apple apple;
	static int score;
	
	private Graphics globalGraphics;
	private Thread runThread;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
	
	static boolean gameRunning = false;
	
	public void paint(Graphics g){
		this.setPreferredSize(gameSize);
		globalGraphics = g.create();
		score = 0;
		
		if(runThread == null){
			runThread = new Thread(this);
			runThread.start();
			gameRunning = true;
		}
	}
	
	public void run(){
		while(gameRunning){
			snake.tick();
			render(globalGraphics);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public Game(){	
		snake = new Snake();
		apple = new Apple(snake);
	}
		
	public void render(Graphics g){
		g.clearRect(0, 0, WIDTH, HEIGHT+25);
		
//		BufferedImage buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
//		Graphics bufferGraphics = buffer.getGraphics();
		
//		g.setColor(Color.BLACK);
		g.drawRect(0, 0, WIDTH, HEIGHT);
			
		snake.drawSnake(g);
		apple.drawApple(g);
		g.drawString("score= " + score, 10, HEIGHT + 25);
//		g.drawImage(buffer, 0, 0, WIDTH, HEIGHT, this);
		
	}
}

