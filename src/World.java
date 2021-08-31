import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class World 
{
    public static int lastPos = 0;
    public static int lastWidth;

    public static int blockSize = 32;

    public List<Tile> tiles = new ArrayList<Tile>();

    public void tick()
    {
        if(Player.x >= lastPos)
        {   
            System.out.println("Gerar novo bloco");
            int newWidth = new Random().nextInt(8-4) + 4;
            if(lastPos == 0)
            {
                lastPos = lastPos + (lastWidth*32);
            }
            else
            {
                lastPos = lastPos + 100 + (lastWidth*32);
            }           
            generateWorldBlock(newWidth);
            lastWidth = newWidth;
        }
    }

    public void render(Graphics g)
    {
        for(int i = 0; i < tiles.size(); i++)
        {
            tiles.get(i).render(g);
        }
    }

    public void generateWorldBlock(int width)
    {
        for(int i = 0; i < width; i++)
        {
            Tile tile = new Tile(lastPos + (i*blockSize),448);
            tiles.add(tile);
        }
    }
}
