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

    public void tick()
    {
        if(x - Camera.x < 0)
        {
            World.tiles.remove(this);
            return;
        }
    }

    public void render(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(x - Camera.x, y - Camera.y, World.blockSize, World.blockSize);

        g.setColor(Color.blue);
        g.fillRect(x - Camera.x, y - Camera.y, World.blockSize, World.blockSize);
    }
}
