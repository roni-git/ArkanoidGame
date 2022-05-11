/*323867077*/
import java.util.ArrayList;
/**
 * @author roni gilboa
 * the class GameEnvironment
 * creating an environment game
 * with list of collidable
 *
 */
public class GameEnvironment {
    //fields
    private java.util.List<Collidable> collidables;

    /**.
     * the function GameEnvironment
     * saves a list and a ball for the environment game
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    // add the given collidable to the environment.
    /**.
     * the function addCollidable
     * add the given collidable to the environment
     * @param c - a new collidable to add to the environment game.
     * */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**.
     * the function remove the given collidable to the environment
     * @param c - a collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**.
     * the function getCollidables
     * return the collidables list of this environment
     * @return java.util.List<Collidable> - a collidables list of this environment
     */
    public java.util.List<Collidable> getCollidables() {
        return this.collidables;
    }
    /** the function Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory - a line variable, that the object move on it
     * @return collisionInfo - an information about point collision between object and collidale
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        final int one = 1;
        java.util.List<CollisionInfo> collisionList = new ArrayList<CollisionInfo>();
        for (int i = 0; i < this.collidables.size(); i++) {
            Point pColl = trajectory.closestIntersectionToStartOfLine(this.collidables.get(i).getCollisionRectangle());
            if (pColl != null) {
                collisionList.add(new CollisionInfo(pColl, this.collidables.get(i)));
            }
        }
        if (collisionList.isEmpty()) {
            //there is any collision point between the line and each collidable-->return null
            return null;
        }
        CollisionInfo theColsest = collisionList.get(0);
        for (int i = one; i < collisionList.size(); i++) {
            //The difference between the points start to collision
            double calculateA = (collisionList.get(i).collisionPoint().getX() - trajectory.start().getX());
            //The difference between the points start to the current closest
            double calculateB = (theColsest.collisionPoint().getX() - trajectory.start().getX());
            if (Math.abs(calculateA) < Math.abs(calculateB)) {
                theColsest = collisionList.get(i);
            }
        }
        return theColsest;
    }
}
