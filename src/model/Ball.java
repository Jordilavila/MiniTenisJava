package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	
	private static final int DIAMETER = 30;
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The xa. */
	private int xa;
	
	/** The ya. */
	private int ya;
	
	private Game game;
	
	public Ball(Game game) {
		this.x = this.y = 0;
		this.xa = this.ya = 1;
		this.game = game;
		return;
	}
	
	private boolean collision() {
		return game.racquet.getBounds().intersects(this.getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, Ball.DIAMETER, Ball.DIAMETER);
	}
	
	@SuppressWarnings("deprecation")
	public void move() {
		
		boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		else if (collision()) {
			ya = -game.speed;
			y = game.racquet.getTopY() - DIAMETER;
			game.speed++;
		} else 
			changeDirection = false;
		
		if (changeDirection)  {
			Sound.BALL.stop();
			Sound.BALL.play();
		}
			
		
		this.x += this.xa;
		this.y += this.ya;
		return;
		
	}
	
	public void paint(Graphics2D g) {
		g.fillOval(x, y, Ball.DIAMETER, Ball.DIAMETER);
		return;
	}
	
	
}
