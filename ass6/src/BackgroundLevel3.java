/*323867077*/
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author - roni gilboa
 * this class make a background for the third level.
 */
public class BackgroundLevel3 implements Sprite {
    //fields
    private int x;
    private int y;
    private int increasLine;
    /**
     * A constructor.
     */
    public BackgroundLevel3() {
        this.x = 90;
        this.y = 395;
        this.increasLine = 9;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green);
        d.fillRectangle(40, 70, 720, 520);
        d.setColor(Color.black);
        d.fillRectangle(this.x, this.y, 99, 185);
        d.fillRectangle(133, this.y - 70, 10, 70);
        d.setColor(Color.red);
        d.fillCircle(137, this.y - 70, 20);
        d.setColor(Color.pink);
        d.fillCircle(137, this.y - 70, 10);
        d.setColor(Color.white);
        d.fillCircle(137, this.y - 70, 5);
        d.setColor(Color.white);
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 5; i++) {
                d.fillRectangle(this.x + 4 + 19 * i, this.y + 5 + j * 30, 15, 20);
            }
        }
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
