/*323867077*/
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author roni gilboa
 * the class Paddle is a object of a game that we can move on the screen,
 * to left or right
 * when a ball hit the paddle, the class paddle change the velocity of the ball
 */
public class Paddle implements Sprite, Collidable {
    //fields
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rec;
    private java.awt.Color color;
    private Velocity velocity;
    private biuoop.GUI gui;
    private int width;
    //constructor
    /**.
     * the function Paddle
     * create a new paddle
     * @param width - the width of the paddle.
     * @param speed - the steps the paddle move.
     * */
    public Paddle(int width, int speed) {
        this.color = Color.blue;
        this.velocity = new Velocity(speed, 0);
        this.rec = new Rectangle(new Point(400 - (double) (width / 2), 530), width, 40);
        this.width = width;
    }
    /**.
     * the function setGui
     * @param guiToSet - a biuoop.GUI variable that use to be the screen the paddle appear on
     */
    public void setGui(biuoop.GUI guiToSet) {
        this.gui = guiToSet;
        this.keyboard = this.gui.getKeyboardSensor();
    }
    /**.
     * the function moveLeft
     * move the paddle one step to the left on the screen
     */
    public void moveLeft() {
        if (this.rec.getUpperLeft().getX() - this.velocity.getDX() <= 40) {
            this.rec = new Rectangle(new Point(40,
                    this.rec.getUpperLeft().getY()), this.rec.getWidth(), this.rec.getHeight());
            return;
        }
        this.rec = new Rectangle(new Point(this.rec.getUpperLeft().getX() - this.velocity.getDX(),
                                this.rec.getUpperLeft().getY()), this.rec.getWidth(), this.rec.getHeight());
    }
    /**.
     * the function moveRight
     * move the paddle one step to the right on the screen
     */
    public void moveRight() {
        if (this.rec.getUpperRight().getX() + this.velocity.getDX() >= 760) {
            this.rec = new Rectangle(new Point(760 - this.width,
                    this.rec.getUpperLeft().getY()), this.rec.getWidth(), this.rec.getHeight());
            return;
        }
        this.rec = new Rectangle(new Point(this.rec.getUpperLeft().getX() + this.velocity.getDX(),
                this.rec.getUpperLeft().getY()), this.rec.getWidth(), this.rec.getHeight());
    }
    @Override
    public int getKind() {
        int paddle = 1;
        return paddle;
    }
    @Override
    public void timePassed() {
        if (keyboard.isPressed(keyboard.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(keyboard.RIGHT_KEY)) {
            moveRight();
        }
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(),
                (int) this.getCollisionRectangle().getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(),
                (int) this.getCollisionRectangle().getHeight());
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = new Velocity(currentVelocity.getDX(), currentVelocity.getDY());
        Line thePointCollision = new Line(collisionPoint, collisionPoint);
        if (thePointCollision.isIntersecting(this.rec.getLineLeft())) {
            //part 1 of the paddle
            newVelocity = Velocity.fromAngleAndSpeed(-60, (Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                                            + Math.pow(currentVelocity.getDY(), 2))));
        }
        if (thePointCollision.isIntersecting(this.rec.getLineRight())) {
            //part 5 of the paddle
            newVelocity = Velocity.fromAngleAndSpeed(60, (Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                    + Math.pow(currentVelocity.getDY(), 2))));
        }
        if (thePointCollision.isIntersecting(this.rec.getLineUpp())) {
            if ((collisionPoint.getX() >= this.rec.getUpperLeft().getX())
                    && (collisionPoint.getX() < (this.rec.getUpperLeft().getX() + (double) (this.width / 5)))) {
                //part 1 of the paddle
                newVelocity = Velocity.fromAngleAndSpeed(-60, (Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                        + Math.pow(currentVelocity.getDY(), 2))));
            } else if ((collisionPoint.getX() >= (this.rec.getUpperLeft().getX() + (double) (this.width / 5)))
                    && (collisionPoint.getX() < (this.rec.getUpperLeft().getX() + ((double) (this.width / 5) * 2)))) {
                //part 2 of the paddle
                newVelocity = Velocity.fromAngleAndSpeed(330, (Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                        + Math.pow(currentVelocity.getDY(), 2))));
            } else if ((collisionPoint.getX() >= (this.rec.getUpperLeft().getX() + ((double) (this.width / 5) * 2)))
                    && (collisionPoint.getX() < (this.rec.getUpperLeft().getX() + ((double) (this.width / 5) * 3)))) {
                //part 3 of the paddle
                newVelocity = new Velocity(newVelocity.getDX(), (-1) * newVelocity.getDY());
            } else if ((collisionPoint.getX() >= (this.rec.getUpperLeft().getX() + ((double) (this.width / 5) * 3)))
                    && (collisionPoint.getX() < (this.rec.getUpperLeft().getX() + ((double) (this.width / 5) * 4)))) {
                //part 4 of the paddle
                newVelocity = Velocity.fromAngleAndSpeed(30, (Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                        + Math.pow(currentVelocity.getDY(), 2))));
            } else if ((collisionPoint.getX() >= (this.rec.getUpperLeft().getX() + ((double) (this.width / 5) * 4)))
                    && (collisionPoint.getX() <= (this.rec.getUpperLeft().getX() + ((double) (this.width / 5) * 5)))) {
                //part 5 of the paddle
                newVelocity = Velocity.fromAngleAndSpeed(60, (Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                        + Math.pow(currentVelocity.getDY(), 2))));
            }

        }
        return newVelocity;
    }
    @Override
    public void addToGame(GameLevel g) {
        // Add this paddle to the game.
       g.addSprite(this);
       g.addCollidable(this);
    }
}
