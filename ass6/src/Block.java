/*323867077*/
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author roni gilboa
 * the class Block implements Collidable, Sprite
 * is a collidable variable that can be added to a game
 * the block is a rectangle with a color
 *
 */
public class Block implements HitNotifier, Collidable, Sprite {
    //fields
    private List<HitListener> hitListeners;
    private Rectangle rec;
    private java.awt.Color color;
    //constructors
    /**.
     * the function Block
     * saving the rectangle of this block and his color
     * @param rec - a rectangle for this block
     * @param color - the color of this block
     */
    public Block(Rectangle rec, java.awt.Color color) {
        this.hitListeners = new ArrayList<HitListener>();
        this.rec = new Rectangle(rec.getUpperLeft(), rec.getWidth(), rec.getHeight());
        this.color = color;
    }

    /**
     * this functon remove this block from a game.
     * @param game - a game to remove from it the block.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
    surface.fillRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
            (int) this.getCollisionRectangle().getUpperLeft().getY(),
            (int) this.getCollisionRectangle().getWidth(),
            (int) this.getCollisionRectangle().getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(),
                (int) this.getCollisionRectangle().getHeight());
    }
   @Override
    public int getKind() {
        int block = 0;
        return block;
    }
    @Override
    public void timePassed() { }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = new Velocity(currentVelocity.getDX(), currentVelocity.getDY());
        Line thePointCollision = new Line(collisionPoint, collisionPoint);
        if (thePointCollision.isIntersecting(this.getCollisionRectangle().getLineLeft())) {
            newVelocity = new Velocity((-1) * newVelocity.getDX(), newVelocity.getDY());
        }
        if (thePointCollision.isIntersecting(this.getCollisionRectangle().getLineRight())) {
            newVelocity = new Velocity((-1) * newVelocity.getDX(), newVelocity.getDY());
        }
        if (thePointCollision.isIntersecting(this.getCollisionRectangle().getLineDown())) {
            newVelocity = new Velocity(newVelocity.getDX(), (-1) * newVelocity.getDY());
        }
        if (thePointCollision.isIntersecting(this.getCollisionRectangle().getLineUpp())) {
            newVelocity = new Velocity(newVelocity.getDX(), (-1) *  newVelocity.getDY());
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * the function called whenever a hit() occurs,
     * and notify all of the registered HitListener objects by calling their hitEvent method.
     * @param hitter - the ball that hitter the object
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
