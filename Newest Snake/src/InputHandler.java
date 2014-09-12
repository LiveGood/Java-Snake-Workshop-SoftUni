import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener {

	public InputHandler(SnakeGame game) {
		game.addKeyListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keyCode == KeyEvent.VK_UP) {
			if (SnakeGame.snake.velY != 1) {
				SnakeGame.snake.velY = -1;
				SnakeGame.snake.velX = 0;
			}
		} else if (keyCode == KeyEvent.VK_DOWN) {
			if (SnakeGame.snake.velY != -1) {
				SnakeGame.snake.velY = 1;
				SnakeGame.snake.velX = 0;
			}
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			if (SnakeGame.snake.velX != -1) {
				SnakeGame.snake.velY = 0;
				SnakeGame.snake.velX = 1;
			}
		} else if (keyCode == KeyEvent.VK_LEFT) {
			if (SnakeGame.snake.velX != 1) {
				SnakeGame.snake.velY = 0;
				SnakeGame.snake.velX = -1;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
