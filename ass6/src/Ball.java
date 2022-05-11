/*323867077*/
import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roni gilboa
 * the class Ball (actually, a circle).
 * Balls have size (radius), color, and location (a Point).
 * Balls also know how to draw themselves on a DrawSurface.
 *
 */
public class Ball implements HitNotifier, Sprite {
    //fields
    private List<HitListener> hitListeners;
    private Point center;
    private int size;
    private java.awt.Color color;
    private Velocity velocity;
    private int width1;
    private int height1;
    private int width2;
    private int height2;
    private GameEnvironment environment;
    // constructor
    /**.
     *
     * the function saves the center and size and color values of this ball
     *
     * @param center - a point variable
     * @param r - an int variable
     * @param color - a java.awt.Color variable
     *
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.hitListeners = new ArrayList<HitListener>();
        this.center = new Point((int) center.getX(), (int) center.getY());
        if (r < 0) {
            this.size = ((-1) * r);
        } else {
            this.size = r;
        }
        this.color = color;
    }
    /**.
     *
     * the function saves the center (x,y) and size and color values of this ball
     *
     * @param x - an int variable for the x value of the center point
     * @param y - an int variable for the y value of the center point
     * @param r - an int variable
     * @param color - a java.awt.Color variable
     *
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.hitListeners = new ArrayList<HitListener>();
        this.center = new Point((int) x, (int) y);
        this.size = r;
        this.color = color;
    }

    // accessors
    /**.
     *
     * the function return the x value of the center point
     *
     * @return x - an int value of this point
     */
    public int getX() {
        return ((int) center.getX());
    }
    /**.
     *
     * the function return the y value of the center point
     *
     * @return y - an int value of this point
     */
    public int getY() {
        return ((int) center.getY());
    }
    /**.
     *
     * the function return the size value of this ball
     *
     * @return x - an int size value of this ball
     */
    public int getSize() {
        return this.size;
    }
    /**.
     *
     * the function return the color of this ball
     *
     * @return color - a java.awt.Color variable, the color of this ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    @Override
    public void drawOn(DrawSurface surface) {
        int x = (int) this.center.getX();
        int y = (int) this.center.getY();
        int r = this.size;
        if ((this.center.getX() - this.size) < this.width2) {
            x = this.height2 + this.size;
            this.center = new Point(x, this.center.getY());
        } else if ((this.center.getX() + this.size) > this.width1) {
            x = this.height1 - this.size;
            this.center = new Point(x, this.center.getY());
        }
        if ((this.center.getY() - this.size) < this.height2) {
            y = this.width2 + this.size;
            this.center = new Point(this.center.getX(), y);
        } else if ((this.center.getY() + this.size) > this.height1) {
            y = this.height1 - this.size;
            this.center = new Point(this.center.getX(), y);
        }
        surface.setColor(this.color);
        surface.fillCircle(x, y, r);
    }
    @Override
    public void timePassed() {
        this.moveOneStep();
    }
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**.
     * this function remove a sprite from a game
     * @param game - the game to remove from
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
    /**.
     *
     * the function set a values at velocity of this ball
     *
     * @param v - a velocity of this ball
     *
     */
    public void setVelocity(Velocity v) {
        this.velocity = new Velocity(v.getDX(), v.getDY());
    }
    /**.
     *
     * the function set a values at velocity of this ball
     *
     * @param dx - a dx value to set of the velocity of this ball
     * @param dy - a dy value to set of the velocity of this ball
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    /**.
     *
     * the function return the velocity of this ball
     *
     * @return velocity - a Velocity variable, the velocity of this ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**.
     * the function setEnvironment
     * save an environment game for this ball
     * @param theEnvironment -a game environment for this ball
     */
    public void setEnvironment(GameEnvironment theEnvironment) {
        this.environment = theEnvironment;
    }
    /**.
     *
     * the function getEnvironment
     * return the game environment of this ball
     *
     * @return environment - a GameEnvironment variable, the game environment of this ball
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }
    /**.
     *
     * the function saves the limits values of this ball
     *
     * @param widthA - an int variable
     * @param heightA - an int variable
     * @param widthB - an int variable
     * @param heightB - an int variable
     *
     */
    public void setLimits(int widthA, int heightA, int widthB, int heightB) {
        this.height1 = heightA;
        this.width1 = widthA;
        this.height2 = heightB;
        this.width2 = widthB;
    }
    /**.
     *
     * the function saves the limits values of this ball
     *
     * @param gui - a GUI variable that decide the limits of the ball show
     *
     */
    public void setLimits(GUI gui) {
        this.height1 = gui.getDrawSurface().getHeight();
        this.width1 = gui.getDrawSurface().getWidth();
        this.height2 = 0;
        this.width2 = 0;
    }

    /**.
     * the function move the ball on the clipboard Size to another place according to the velocity of this ball
     */
    public void moveOneStep() {
        if ((this.center.getX() + this.velocity.getDX() + this.size) > this.width1) {
            this.setVelocity(((-1) * (this.velocity.getDX())), this.velocity.getDY());
        } else if (((this.center.getX() + this.velocity.getDX() - this.size) < width2)) {
            this.setVelocity(((-1) * (this.velocity.getDX())), this.velocity.getDY());
        }
        if ((this.center.getY() + this.velocity.getDY() + this.size) > this.height1) {
            this.setVelocity(this.velocity.getDX(), ((-1) * (this.velocity.getDY())));
        } else if (((this.center.getY() + this.velocity.getDY() - this.size) < height2)) {
            this.setVelocity(this.velocity.getDX(), ((-1) * (this.velocity.getDY())));
        }
        CollisionInfo collision = this.environment.getClosestCollision(new Line(this.center,
                                                   new Point((this.center.getX() + this.velocity.getDX()),
                                                           (this.center.getY() + this.velocity.getDY()))));
        while (collision != null) {
            //while there is intersection if the ball will move in the same velocity
            Velocity newV = ((collision.collisionObject()).hit(this, collision.collisionPoint(), this.velocity));
            if ((newV.getDX() == this.getVelocity().getDX()) && (newV.getDY() == this.getVelocity().getDY())) {
                int paddle = 1;
                if (collision.collisionObject().getKind() == paddle) {
                    //if the get inside the paddle
                    this.center = new Point(this.center.getX(),
                            (this.center.getY() - collision.collisionObject().getCollisionRectangle().getHeight()));
                    return;
                }
            }
            this.setVelocity(newV);
            collision = this.environment.getClosestCollision(new Line(this.center,
                    new Point((this.center.getX() + this.velocity.getDX()),
                            (this.center.getY() + this.velocity.getDY()))));
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
