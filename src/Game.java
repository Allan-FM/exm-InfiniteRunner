import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener
{
	
	public static int Height = 480;
	public static int Width = 600;

	public static World world;
	public static Player player;

	public static int pontos = 0;

	public static BufferedImage playerSprite;
	public static BufferedImage floorSprite;

	public Game()
	{
		world = new World();
		player = new Player(0,448-32);
		this.setPreferredSize(new Dimension(Width,Height));
		this.addKeyListener(this);
		
	}
	
	public void tick()
	{
		world.tick();
		player.tick();
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();	
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, Width, Height);
		world.render(g);

		player.render(g);

		g.setFont(new Font("arial",Font.BOLD,18));
		g.setColor(Color.white);
		g.drawString("Pontos: "+ (pontos - 2), 20	, 20);
		bs.show();
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			tick();
			render();
			try 
			{
				Thread.sleep(1000/60);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		Game game =  new Game();
		frame.setTitle("Infinite Runner");
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		new Thread(game).start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Game.player.jump = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
