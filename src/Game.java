import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {
	public static Snake snake;
	public static Apple apple;
	InputHandler IH;
	
	JFrame frame;
	public final int WIDTH = 600;
	public final int HEIGHT = 600;
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
	public final String TITLE = "Snake";
	
	static boolean gameRunning = false;
	
	public void run(){
		while(gameRunning){
			tick();
			render();
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public synchronized void start(){
		gameRunning =  true;
		new Thread(this).start();
	}
	
	public Game(){
		frame = new JFrame();
		
		setMinimumSize(gameSize);
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);
		
		IH = new InputHandler(this);
		
		snake = new Snake();
		apple = new Apple(snake);
	}
	
	public void tick(){
		snake.tick(this);
	}

	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		snake.drawSnake(g);
		apple.drawApple(g);
		
		g.dispose();
		bs.show();		
	}
}

