/*323867077*/
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author - roni gilboa
 * this class make a background for the first level- directHit.
 */
public class BackgroundLevel1 implements Sprite {
    //fields
    private int xCenter;
    private int yCenter;
    private int lineWidth;
    /**
     * A constructor.
     */
    public BackgroundLevel1() {
        this.xCenter = 400;
        this.yCenter = 220;
        this.lineWidth = 140;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(40, 70, 720, 520);
        d.setColor(Color.BLUE);
        d.drawCircle(this.xCenter, this.yCenter, 130);
        d.drawCircle(this.xCenter, this.yCenter, 90);
        d.drawCircle(this.xCenter, this.yCenter, 50);
        d.drawLine(this.xCenter + this.lineWidth, this.yCenter, this.xCenter, this.yCenter);
        d.drawLine(this.xCenter - this.lineWidth, this.yCenter, this.xCenter, this.yCenter);
        d.drawLine(this.xCenter, this.yCenter + this.lineWidth, this.xCenter, this.yCenter);
        d.drawLine(this.xCenter, this.yCenter - this.lineWidth, this.xCenter, this.yCenter);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
