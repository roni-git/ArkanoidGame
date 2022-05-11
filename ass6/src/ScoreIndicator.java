/*323867077*/
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author roni gilboa
 * this class implements Sprite
 * it calculate and print the current points that the player achieve in the game
 */
public class ScoreIndicator implements Sprite {
    //fields
    private Counter countPoints;
    private List<HitListener> hitListeners;
    private Rectangle rec;
    private java.awt.Color color;
    //constructors
    /**.
     * A constructor, the function ScoreIndicator
     * saving the rectangle of this block and his color
     * @param rec - a rectangle for this Score
     * @param color - the color of this Score
     * @param countPoints - the points that the player achieve in the game
     */
    public ScoreIndicator(Rectangle rec, java.awt.Color color, Counter countPoints) {
        this.countPoints = countPoints;
        this.hitListeners = new ArrayList<HitListener>();
        this.rec = new Rectangle(rec.getUpperLeft(), rec.getWidth(), rec.getHeight());
        this.color = color;
    }
    @Override
    public void drawOn(DrawSurface d) {
        int x = 380;
        int y = 20;
        int size = 20;
        d.setColor(this.color);
        d.fillRectangle((int) this.rec.getUpperLeft().getX(),
                (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(),
                (int) this.rec.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.rec.getUpperLeft().getX(),
                (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(),
                (int) this.rec.getHeight());
        d.setColor(Color.black);
        d.drawText(x, y, "Score:" + this.countPoints.getValue(), size);
    }

    @Override
    public void timePassed() { }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
