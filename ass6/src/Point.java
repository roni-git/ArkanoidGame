/*323867077*/

/**
 * @author roni gilboa
 * the class Point has an x and a y value,
 * and can measure the distance to other points, and if it is equal to another point.
 *
 */
public class Point {
    //fields
    private double x;
    private double y;

    // constructor
    /**.
     *
     * the function saves the x and y values of this point
     *
     * @param x - a double variable
     * @param y - a double variable
     *
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**.
     *
     * the function return the distance of this point to the other point
     *
     * @param other - a line variable
     * @return distance - double value the sign the distance of this point to the other point
     */
    public double distance(Point other) {
        double x1 = this.x;
        double y1 = this.y;
        double x2 = other.x;
        double y2 = other.y;
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
    /**.
     *
     * the function return true is the points are equal, false otherwise
     *
     * @param other - a line variable
     * @return boolean - return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        double epsilon = 0.01;
        double x1 = this.x;
        double y1 = this.y;
        double x2 = other.x;
        double y2 = other.y;
        return  ((java.lang.Math.abs(x1 - x2) < epsilon) && (java.lang.Math.abs(y1 - y2) < epsilon));
    }
    /**.
     *
     * the function return the x value of this point
     *
     * @return x - a double value of this point
     */
    public double getX() {
        return this.x;
    }
    /**.
     *
     * the function return the y value of this point
     *
     * @return y - a double value of this point
     */
    public double getY() {
        return this.y;
    }
}
