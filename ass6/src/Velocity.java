/*323867077*/

/**
 * @author roni gilboa
 * the Class Velocity rule the velocity of the moving of a ball on a clipboard
 * she has dx and dy value that rule the moving
 *
 **/
public class Velocity {
    //fields
    private double dx;
    private double dy;
    // constructor
    /**.
     *
     * the function saves the dx and dy values of this velocity
     *
     * @param dx - a double variable
     * @param dy - a double variable
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    // Return the dx and dy values
    /**.
     *
     * The function Return the dx value
     *
     * @return double-the dx value
     */
    public double getDX() {
        return this.dx;
    }
    /**.
     *
     * The function Return the dy value
     *
     * @return double-the dy value
     */
    public double getDY() {
        return this.dy;
    }
    /**.
     *
     * The function take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param angle - an angle of moving a point of circle.
     * @param speed - the speed we want the circle will move.
     * @return new point- the point is the point after the adding of dy and dx values.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radiansAngle = Math.toRadians(angle);
        double dy = ((-1) * Math.cos(radiansAngle) * speed);
        double dx = (Math.sin(radiansAngle) * speed);
        return new Velocity(dx, dy);
    }
    /**.
     *
     * The function take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param p - a point of circle that we want to move
     * @return new point- the point is the point after the adding of dy and dx values
     */
    public Point applyToPoint(Point p) {
        return (new Point((p.getX() + this.dx), (p.getY() + this.dy)));
    }
}
