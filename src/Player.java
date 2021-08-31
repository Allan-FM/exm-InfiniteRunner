import java.awt.Color;
import java.awt.Graphics;
public class Player 
{
    public static int x;
    public static int y;

    public  Player(int x, int y)
    {
        Player.x = x;
        Player.y = y;
    }

    public void tick()
    {
        x++;
    }

    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
    }
}
