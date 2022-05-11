/*323867077*/
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author - roni gilboa
 * this class make a background for the second level- wideEasy.
 */
public class BackgroundLevel2 implements Sprite {
    //fields
    private int xCenter;
    private int yCenter;
    private int increasLine;
    /**
     * A constructor.
     */
    public BackgroundLevel2() {
        this.xCenter = 180;
        this.yCenter = 180;
        this.increasLine = 20;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.CYAN.darker());
        d.fillRectangle(40, 70, 720, 520);
        d.setColor(Color.YELLOW.brighter());
        d.fillCircle(this.xCenter, this.yCenter, 50);
        for (int i = 0; i < 36; i++) {
            d.drawLine(this.xCenter, this.yCenter, 40 + (increasLine * i), 300);
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
