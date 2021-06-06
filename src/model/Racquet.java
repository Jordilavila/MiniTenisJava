package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	
	private int x;
	private int xa;
	
	private Game game;
	
	public Racquet(Game game) {
		this.x = this.xa = 0;
		this.game = game;
		return;
	}
	
	public void move() {
		if(this.x + this.xa > 0 && this.x + this.xa < this.game.getWidth() - Racquet.WIDTH)
			x += xa;
		return;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(x, Y, Racquet.WIDTH, Racquet.HEIGHT);
		return;
	}
	
	public void keyReleased(KeyEvent e) {
		this.xa = 0;
		return;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			this.xa = -game.speed;
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			this.xa = game.speed;
		
		return;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.x, Racquet.Y, Racquet.WIDTH, Racquet.HEIGHT);
	}
	
	public int getTopY() {
		return Racquet.Y - Racquet.HEIGHT;
	}

}
