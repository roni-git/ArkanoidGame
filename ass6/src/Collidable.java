/*323867077*/
/**
 * @author roni gilboa
 * The Collidable interface used by things that can be collided with
 *
 */
public interface Collidable {
    /**.
     * the function getCollisionRectangle
     * Return the "collision shape" of the object.
     * @return rectangle - the rectangle of the collidable
     */
    Rectangle getCollisionRectangle();
    /**.
     * the function getKind
     * return the kind of the collidable
     * @return int - a number that sign the kind of the collidable - 1 for paddle and 2 for block
     */
    int getKind();
    /**.
     * the function hit
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     * @param collisionPoint - a point variable, the collision point
     * @param currentVelocity - the velocity of the ball
     * @param hitter - the ball that make the hit with the collidable.
     * @return velocity - the new velocity after the collided with the object
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
