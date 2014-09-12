import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;


public class GameApplet extends Applet  {

	private SnakeGame game;
	private static final long serialVersionUID = 1L;
	private InputHandler IH;
	
	public void init() {
		game = new SnakeGame();
		game.setPreferredSize(new Dimension(800, 650));
		game.setVisible(true);
		game.setFocusable(true);
		this.add(game);
		this.setVisible(true);
		this.setSize(new Dimension(800, 650));
		IH = new InputHandler(game);
	}
	
	public void paint (Graphics g) {
		this.setSize(new Dimension(800, 650));
	}
	
}
