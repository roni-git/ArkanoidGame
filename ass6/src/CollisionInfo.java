/*323867077*/
/**
 * @author roni gilboa
 * the class CollisionInfo
 *  saving the information about interseftin, save the object that was hitted
 *  and the point of the intersection were happened
 *
 */
public class CollisionInfo {
    //fields
    private Point collisionPoint;
    private Collidable collisionObject;
    //constructor
    /**.
     * the function CollisionInfo
     * save the object that was hitted
     * and the point of the intersection were happened
     * @param collisionObject - a collidable variable - the object that was hitted
     * @param collisionPoint - a point variable - the point of the intersection were happened
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**.
     * the function collisionPoint
     * return the point at which the collision occurs.
     *
     * @return collisionPoint - the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    /**.
     * the function collisionPoint
     * return the collidable object involved in the collision.
     *
     * @return collisionObject - the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
