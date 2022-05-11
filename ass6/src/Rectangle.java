/*323867077*/
import java.util.ArrayList;
/**
 * @author roni gilboa
 * the class Rectangle
 * is 4 lines that contact on their ends
 * the size of the lines is sets by the hieght and width of the rectangle
 *
 */
public class Rectangle {
    //fields
    private Point upperLeft;
    private Point upperRight;
    private Point downLeft;
    private Point downRight;
    private double width;
    private double height;
    private Line lineUpp;
    private Line lineDown;
    private Line lineRight;
    private Line lineLeft;
    /**.
     * the function Rectangle
     * create a new rectangle with location and width/height.
     * @param upperLeft - a point that sign the location of the rectangle
     * @param width - a double variable the sign the width of the rectangle
     * @param height - a double variable the sign the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
        this.upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.downRight = new Point(this.upperRight.getX(), this.upperLeft.getY() + height);
        this.downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        this.lineUpp = new Line(this.getUpperLeft(), this.getUpperRight());
        this.lineDown = new Line(this.getDownLeft(), this.getDownRight());
        this.lineRight = new Line(this.getUpperRight(), this.getDownRight());
        this.lineLeft = new Line(this.getUpperLeft(), this.getDownLeft());
    }

    /**
     * the function intersectionPoints
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     * @param line - a Line variable
     * @return list - a list of intersection points with the specified line
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        final int one = 1;
        java.util.List<Point> list = new ArrayList<Point>();
        if (line.isIntersecting(this.lineUpp) && (line.intersectionWith(this.lineUpp) != null)) {
            list.add(line.intersectionWith(this.lineUpp));
        }
        if (line.isIntersecting(this.lineDown) && (line.intersectionWith(this.lineDown) != null)) {
            if (!(list.get(one).equals(line.intersectionWith(this.lineDown)))) {
                list.add(line.intersectionWith(this.lineDown));
            }

        }
        if (line.isIntersecting(this.lineLeft) && (line.intersectionWith(this.lineLeft) != null)) {
            if (!(list.get(one).equals(line.intersectionWith(this.lineLeft)))) {
                list.add(line.intersectionWith(this.lineLeft));
            }
        }
        if (line.isIntersecting(this.lineRight) && (line.intersectionWith(this.lineRight) != null)) {
            if (!(list.get(one).equals(line.intersectionWith(this.lineRight)))) {
                list.add(line.intersectionWith(this.lineRight));
            }
        }
        return list;
    }
    /**.
     * the function getWidth
     * return the value of this rectangle width
     * @return double - the value of this rectangle width
     * */
    public double getWidth() {
        return this.width;
    }
    /**.
     * the function getHeight
     * return the value of this rectangle height
     * @return double - the value of this rectangle height
     * */
    public double getHeight() {
        return this.height;
    }

    /**
     * the function getUpperLeft
     * returns the upper-left point of the rectangle.
     * @return point - the upper-left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * the function getUpperRight
     * returns the upper-right point of the rectangle.
     * @return point - the upper-right point of the rectangle.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * the function getDownLeft
     * returns the down-left point of the rectangle.
     * @return point - the down-left point of the rectangle
     */
    public Point getDownLeft() {
        return this.downLeft;
    }

    /**.
     * the function getDownRight
     * returns the down-right point of the rectangle.
     * @return point - the down-right point of the rectangle
     */
    public Point getDownRight() {
        return this.downRight;
    }
    /**.
     * the function getLineUpp
     * returns the LineUpp of this rectangle.
     * @return Line - the LineUpp of the rectangle
     */
    public Line getLineUpp() {
        return this.lineUpp;
    }
    /**.
     * the function getLineDown
     * returns the LineDown of this rectangle.
     * @return Line - the LineDown of the rectangle
     */
    public Line getLineDown() {
        return this.lineDown;
    }
    /**.
     * the function getLineRight
     * returns the LineRight of this rectangle.
     * @return Line - the LineRight of the rectangle
     */
    public Line getLineRight() {
        return this.lineRight;
    }
    /**.
     * the function getLineLeft
     * returns the LineLeft of this rectangle.
     * @return Line - the LineLeft of the rectangle
     */
    public Line getLineLeft() {
        return this.lineLeft;
    }
}
