package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The Class Game.
 */
public class Game extends JPanel {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ball. */
	private Ball ball;
	
	/** The racquet. */
	public Racquet racquet;
	
	public int speed;
	
	/**
	 * Instantiates a new game.
	 */
	@SuppressWarnings("deprecation")
	public Game() {
		
		this.ball = new Ball(this);
		this.racquet = new Racquet(this);
		this.speed = 1;
		
		this.addKeyListener(new KeyListener() {
			// Esto es una función de una interfaz que se implementa aquí a pelo:
			
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		
		Sound.BACK.play();
		setFocusable(true);
		
	}
	
	/**
	 * Move.
	 */
	public void move() {
		ball.move();
		racquet.move();
		return;
	}
	
	/**
	 * Game over.
	 */
	@SuppressWarnings("deprecation")
	public void gameOver() {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "Your score is: " + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
		return;
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	private int getScore() {
		return this.speed - 1;
	}

	/**
	 * Paint.
	 *
	 * @param g the graphics
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
		return;
	}
}
