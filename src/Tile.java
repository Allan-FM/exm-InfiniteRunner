import java.awt.Color;
import java.awt.Graphics;


public class Tile 
{
    public int x,y;
    public int size = 16;
    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(x, y, World.blockSize, World.blockSize);

        g.setColor(Color.blue);
        g.fillRect(x, y, World.blockSize, World.blockSize);
    }
}
