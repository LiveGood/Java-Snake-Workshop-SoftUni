

import java.awt.*;

import javax.swing.*;

public class Main  {
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Snake");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Game game = new Game();
		game.init();
		window.add(game);
		window.setVisible(true);
		
	}
	
	
}
