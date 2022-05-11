/*323867077*/

/**
 * @author roni gilboa
 * the class line (actually a line-segment) connects two points-a start point and an end point.
 * Lines have lengths, and may intersect with other lines.
 * It can also tell if it is the same as another line segment.
 *
 */
public class Line {
    //fields
    private Point start;
    private Point end;
    private double incline;
    private double constant;
    //variable for sign an infinite incline
    public static final double INF = Double.POSITIVE_INFINITY;
    // constructors
    /**
     * .
     * <p>
     * the function Returns true if the lines intersect, false otherwise
     *
     * @param start command line arguments.
     * @param end   command line arguments.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**.
     * the function Returns true if the lines intersect, false otherwise
     *
     * @param x1 command line arguments.
     * @param y1 command line arguments.
     * @param x2 command line arguments.
     * @param y2 command line arguments.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**.
     * the function length
     * Return the length of the line
     * @return double - the length of the line
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * .
     * the function Returns the middle point of the line
     *
     * @return point - the middle point of this line
     */
    public Point middle() {
        final double zero = 0;
        final int two = 2;
        final double x1 = this.start.getX();
        final double y1 = this.start.getY();
        final double x2 = this.end.getX();
        final double y2 = this.end.getY();
        Point middlePoint = new Point(((x1 + x2) / two), ((y1 + y2) / two));
        return middlePoint;
    }

    /**
     * .
     * the function Returns the start point of the line
     *
     * @return point - the start point of this line
     */
    public Point start() {
        return this.start;
    }

    /**
     * .
     * the function Returns the end point of the line
     *
     * @return point - the end point of this line
     */
    public Point end() {
        return this.end;
    }

    /**
     * /**.
     * the function oneHasInclineZero
     * retuen true is has an intersection point between the lines, and false otherwise
     * @param one - a line that have a zero incline
     * @param two - a line
     * @return boolean - true or false
     */
    private boolean oneHasInclineZero(Line one, Line two) {
        return (((one.start.getX() <= ((one.start.getY() - two.constant) / two.incline))
                && (one.end.getX() >= ((one.start.getY() - two.constant) / two.incline)))
                || ((one.start.getX() >= ((one.start.getY() - two.constant) / two.incline))
                && (one.end.getX() <= ((one.start.getY() - two.constant) / two.incline))));
    }
    /**.
     * the function calculateFields
     * calculate the constant and the incline of this and other
     * @param other - a line to calculate his constant and the incline
     */
    private void calculateFields(Line other) {
        final double zero = 0;
        //calculate the constant and the incline
        if (this.start.getX() == this.end.getX()) {
            //the line is from form x = fixed number
            this.incline = INF;
            this.constant = zero;
        } else {
            this.incline = ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
            this.constant = this.start.getY() - (this.incline * this.start.getX());
        }
        //calculate the constant and the incline
        if (other.start.getX() == other.end.getX()) {
            //the line is from form x=fixed number
            other.incline = INF;
            other.constant = zero;
        } else {
            other.incline = ((other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX()));
            other.constant = other.start.getY() - (other.incline * other.start.getX());
        }
    }

    /**.
     * the function oneOfTheLineIsPoint
     *  retuen true is has an intersection point between the lines, and false otherwise
     * @param one - a line
     * @param two - a line
     * @return boolean - true or false
     */
    private boolean oneOfTheLineIsPoint(Line one, Line two) {
        final int zero = 0;
        //'other' is inf
        if (two.incline == INF) {
            return (one.start.getX() == two.start.getX());
        }
        //'other's' incline=0
        if (two.incline == zero) {
            return ((one.start.getY() == two.start.getY()));
        }
        //'other' is a regular line
        return (two.constant == (one.start.getY() - (two.constant * one.start.getX())));
    }
    /**
     * .
     * the function Returns true if the lines intersect, false otherwise
     *
     * @param other - line to check if this line intersect with it
     * @return boolean - true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        final double zero = 0;
        //calculate the constant and the incline
        this.calculateFields(other);
        //checking if the limits of the lines are ables intersection
        if (!(this.checkLimits(other))) {
            return false;
        }
        //both of them are points
        if ((this.start.equals(this.end)) && (other.start.equals(other.end))) {
            //the lines are both points
            return (this.start.equals(other.start));
        }
        //'this' is a point and 'other' is a regular line\form x=fixed number\incline=0
        if (this.start.equals(this.end)) {
            return oneOfTheLineIsPoint(this, other);
        }
        //'other' is a point and 'this' is a regular line\form x=fixed number\incline=0
        if (other.start.equals(other.end)) {
            return oneOfTheLineIsPoint(other, this);
        }
        //both of them are INF
        if ((this.incline == INF) && (other.incline == INF)) {
            return (this.start.getX() == other.start.getX());
        }
        //the incline of both of them is zero
        if ((this.incline == zero) && (other.incline == zero)) {
            return (this.start.getY() == other.start.getY());
        }
        //'this' is INF and 'other' is regular/incline=0
        if (this.incline == INF) {
            //'other' have incline that equal 0
            if (other.incline == zero) {
                //the lines in a appropriate limits to be meet
                return true;
            }
            //'other' is a regular line
            return (((this.start.getY() <= ((other.incline * this.start.getX()) + other.constant))
                    && (this.end.getY() >= ((other.incline * this.start.getX()) + other.constant)))
                    || ((this.start.getY() >= ((other.incline * this.start.getX()) + other.constant))
                    && (this.end.getY() <= ((other.incline * this.start.getX()) + other.constant))));
        }
        //'other' is INF and 'this' is regular/incline=0
        if (other.incline == INF) {
            //'this' have incline that equal 0
            if (this.incline == zero) {
                //the lines in a appropriate limits to be meet
                return true;
            }
            //'this' is a regular line
            return (((other.start.getY() <= ((this.incline * other.start.getX()) + this.constant))
                    && (other.end.getY() >= ((this.incline * other.start.getX()) + this.constant)))
                    || ((other.start.getY() >= ((this.incline * other.start.getX()) + this.constant))
                    && (other.end.getY() <= ((this.incline * other.start.getX()) + this.constant))));
        }
        //'this' incline is 0
        if (this.incline == zero) {
            return oneHasInclineZero(this, other);
        }
        //'other' incline is 0
        if (other.incline == zero) {
            return oneHasInclineZero(other, this);
        }
        //the lines are the same
        if (this.equals(other)) {
            return true;
        }
        //the inclines are equal
        if (this.incline == other.incline) {
            return (this.constant == other.constant);
        }
        //the lines are both regular
        double x = ((other.constant - this.constant) / (this.incline - other.incline));
        double y = ((other.incline * ((other.constant - this.constant) / (this.incline - other.incline)))
                + other.constant);
        Point meet = new Point(x, y);
        return ((((meet.getX() >= this.start.getX()) && (meet.getX() <= this.end.getX()))
                || ((meet.getX() <= this.start.getX()) && (meet.getX() >= this.end.getX())))
                && (((meet.getX() >= other.start.getX()) && (meet.getX() <= other.end.getX()))
                || ((meet.getX() <= other.start.getX()) && (meet.getX() >= other.end.getX()))));
    }

    /**.
     * the function checkLimits
     * checking if the limits of the lines are ables intersection
     * and return true if the limits are ables it and false otherwise
     * @param other - the other line that we checking intersection with it to this line
     * @return boolean - true or false
     */
    private boolean checkLimits(Line other) {
        //different limits x
        if ((this.start.getX() < other.start.getX()) && (this.end.getX() < other.start.getX())
                && (this.start.getX() < other.end.getX()) && this.end.getX() < other.end.getX()) {
            //the lines are not in the same limits-->doesn't intersect
            return false;
        }
        if ((other.start.getX() < this.start.getX()) && (other.end.getX() < this.start.getX())
                && (other.start.getX() < this.end.getX()) && (other.end.getX() < this.end.getX())) {
            //the lines are not in the same limits-->doesn't intersect
            return false;
        }
        //different limits y
        if ((this.start.getY() < other.start.getY()) && (this.start.getY() < other.end.getY())
                && (this.end.getY() < other.start.getY()) && (this.end.getY() < other.end.getY())) {
            //the lines are not in the same limits-->doesn't intersect
            return false;
        }
        if ((other.start.getY() < this.start.getY()) && (other.start.getY() < this.end.getY())
                && (other.end.getY() < this.start.getY()) && (other.end.getY() < this.end.getY())) {
            //the lines are not in the same limits-->doesn't intersect
            return false;
        }
        return true;
    }

    /**.
     * the function Returns the intersection point if the lines intersect,
     * and null otherwise.
     *
     * @param other command line arguments.
     * @return point - the intersection point if the lines intersect and null otherwise.
     */
    public Point intersectionWith(Line other) {
        final double zero = 0;
        if (this.isIntersecting(other)) {
            if ((this.start.equals(this.end)) && (other.start.equals(other.end))) {
                //the lines are both points
                if ((this.start.equals(other.start))) {
                    //the lines are the same point
                    return this.start;
                }
            }
            if (this.equals(other)) {
                //more than on intersect point-->return null
                return null;
            }
            if (this.start.equals(this.end)) {
                //one of the points is a point
                return this.start;
            }
            if (other.start.equals(other.end)) {
                //one of the points is a point
                return other.start;
            }
            if ((this.incline == zero) && (other.incline == zero)) {
                return inclineZero(this, other);
            }
            if (this.incline == INF) {
                //one of the lines is from form x = a so the incline is INF
                return inf(this, other);
            }
            if (other.incline == INF) {
                //one of the lines is from form x = a so the incline is INF
                return inf(other, this);
            }
            if (this.incline == zero) {
                //one of the lines is from form y = a so the incline is 0
                Point meet = new Point(((this.constant - other.constant) / other.incline), this.start.getY());
                return meet;
            }
            if (other.incline == zero) {
                //one of the lines is from form y = a so the incline is 0
                Point meet = new Point(((other.constant - this.constant) / this.incline), other.start.getY());
                return meet;
            }
            Point meet = new Point(((other.constant - this.constant) / (this.incline - other.incline)),
                    (this.incline * ((other.constant - this.constant)
                            / (this.incline - other.incline)) + this.constant));
            return meet;
        } else {
            //otherwise-->return null
            return null;
        }
    }
    /**.
     *  the function inclineZero
     *  * calculate the intersection point between the lines
     * @param one - a line that have a zero incline
     * @param two - a line that have a zero incline
     * @return point - the metting points between the lines
     */
    private Point inclineZero(Line one, Line two) {
        //both of the points are from form y = a so the incline is 0
        if (one.start.equals(two.start)) {
            //the lines are start or end in the same point
            if ((two.end.getX() > one.start.getX()) && (one.end.getX() < one.start.getX())
                    || ((two.end.getX() < one.start.getX()) && (one.end.getX() > one.start.getX()))) {
                return one.start;
            } else {
                return null;
            }
        }
        if (one.start.equals(two.end)) {
            //the lines are start or end in the same point
            if ((two.start.getX() > one.start.getX()) && (one.end.getX() < one.start.getX())
                    || ((two.start.getX() < one.start.getX()) && (one.end.getX() > one.start.getX()))) {
                return one.start;
            } else {
                return null;
            }
        }
        if (one.end.equals(two.start)) {
            //the lines are start or end in the same point
            if ((two.end.getX() > one.end.getX()) && (one.start.getX() < one.end.getX())
                    || ((two.end.getX() < one.end.getX()) && (one.start.getX() > one.end.getX()))) {
                return one.end;
            } else {
                return null;
            }
        }
        if (one.end.equals(two.end)) {
            //the lines are start or end in the same point
            if ((two.start.getX() > one.end.getX()) && (one.start.getX() < one.end.getX())
                    || ((two.start.getX() < one.end.getX()) && (one.start.getX() > one.end.getX()))) {
                return one.end;
            } else {
                return null;
            }
        }
        if ((two.end.getX() < Math.max(one.start.getX(), one.end.getX()))
                && (two.end.getX() > Math.min(one.start.getX(), one.end.getX()))
                || ((two.start.getX() < Math.max(one.start.getX(), one.end.getX()))
                && (two.start.getX() > Math.min(one.start.getX(), one.end.getX())))) {
            return null;
        }
        if ((one.end.getX() < Math.max(two.start.getX(), two.end.getX()))
                && (one.end.getX() > Math.min(two.start.getX(), two.end.getX()))
                || ((one.start.getX() < Math.max(two.start.getX(), two.end.getX()))
                && (one.start.getX() > Math.min(two.start.getX(), two.end.getX())))) {
            return null;
        }
        if (one.incline == two.incline) {
            //the incline are equal and meets so check how many points, and if one->return it. else->return null
            if (one.start.equals(two.start)) {
                //the lines are start or end in the same point
                if ((two.end.getX() > one.start.getX()) && (one.end.getX() < one.start.getX())
                        || ((two.end.getX() < one.start.getX()) && (one.end.getX() > one.start.getX()))) {
                    return one.start;
                } else {
                    return null;
                }
            }
            if (one.start.equals(two.end)) {
                //the lines are start or end in the same point
                if ((two.start.getX() > one.start.getX()) && (one.end.getX() < one.start.getX())
                        || ((two.start.getX() < one.start.getX()) && (one.end.getX() > one.start.getX()))) {
                    return one.start;
                } else {
                    return null;
                }
            }
            if (one.end.equals(two.start)) {
                //the lines are start or end in the same point
                if ((two.end.getX() > one.end.getX()) && (one.start.getX() < one.end.getX())
                        || ((two.end.getX() < one.end.getX()) && (one.start.getX() > one.end.getX()))) {
                    return one.end;
                } else {
                    return null;
                }
            }
            if (one.end.equals(two.end)) {
                //the lines are start or end in the same point
                if ((two.start.getX() > one.end.getX()) && (one.start.getX() < one.end.getX())
                        || ((two.start.getX() < one.end.getX()) && (one.start.getX() > one.end.getX()))) {
                    return one.end;
                } else {
                    return null;
                }
            }
            if ((two.end.getY() < Math.max(one.start.getY(), one.end.getY()))
                    && (two.end.getY() > Math.min(one.start.getY(), one.end.getY()))
                    || ((two.start.getY() < Math.max(one.start.getY(), one.end.getY()))
                    && (two.start.getY() > Math.min(one.start.getY(), one.end.getY())))) {
                //more than one intersection point
                return null;
            }
            if ((one.end.getY() < Math.max(two.start.getY(), two.end.getY()))
                    && (one.end.getY() > Math.min(two.start.getY(), two.end.getY()))
                    || ((one.start.getY() < Math.max(two.start.getY(), two.end.getY()))
                    && (one.start.getY() > Math.min(two.start.getY(), two.end.getY())))) {
                //more than one intersection point
                return null;
            }
        }
        return null;
    }
    /**.
     * the function inf
     * calculate the intersection point between the lines
     * @param one - a line that have an inf incline
     * @param two - a line
     * @return point - the metting points between the lines
     */
    private Point inf(Line one, Line two) {
        Point meet = new Point(one.start.getX(), (two.incline * one.start.getX()) + two.constant);
        return meet;
    }
    /**
     * .
     * the function equals
     * Returns true if the lines are equal, false otherwise
     *
     * @param other - line to equal with this line
     * @return boolean - true if the lines equals, false otherwise.
     */
    public boolean equals(Line other) {
        return ((this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.end) && this.end.equals(other.start)));
    }

    /**.
     * the function theClosest
     * return the closest intersection point to the
     * start of the line between both of the points
     * @param currentClosest - a point variable that contain the current closest intersection point
     * @param intersection - a point variable that contain another intersection point to check
     *                         if it closest than currentClosest
     * @return closest - a point variable the closest point to the start of the line
     */
    private Point theClosest(Point currentClosest, Point intersection) {
        if ((this.start.getX() > intersection.getX()) && (this.start.getX() > currentClosest.getX())) {
            if (this.start.getX() - intersection.getX() < this.start.getX() - currentClosest.getX()) {
                //when intersection is closest to the start point of this line
                return intersection;
            } else {
                //when current closest point is the closest to the start point of this line
                return currentClosest;
            }
        }
        if ((this.start.getX() < intersection.getX()) && (this.start.getX() < currentClosest.getX())) {
            if ((intersection.getX() - this.start.getX())  < (currentClosest.getX() - this.start.getX())) {
                //when intersection is closest to the start point of this line
                return intersection;
            } else {
                //when current closest point is the closest to the start point of this line
                return currentClosest;
            }
        }
        return currentClosest;
    }

    /**
     * the function closestIntersectionToStartOfLine
     * return null if this line does not intersect with the rectangle,
     * otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect - a Rectangle variable that the function chek if the line intersect with
     * @return closest - a point variable - an intersect point of the line with the rectangle
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Point closest = null;
        final int didNotFound = 0;
        final int founded = 1;
        int alreadyFoundOneIntersect = didNotFound;
        if (this.isIntersecting(rect.getLineUpp()) && (this.intersectionWith(rect.getLineUpp()) != null)) {
            alreadyFoundOneIntersect = founded;
            closest = this.intersectionWith(rect.getLineUpp());
        }
        if (this.isIntersecting(rect.getLineDown()) && (this.intersectionWith(rect.getLineDown()) != null)) {
            if (alreadyFoundOneIntersect == didNotFound) {
                //the point closest didn't already get values
                closest = this.intersectionWith(rect.getLineDown());
                alreadyFoundOneIntersect = founded;
            } else if (alreadyFoundOneIntersect == founded) {
                //the point closest is already get values
                closest = this.theClosest(closest, this.intersectionWith(rect.getLineDown()));
            }
        }
        if (this.isIntersecting(rect.getLineLeft()) && (this.intersectionWith(rect.getLineLeft()) != null)) {
            if (alreadyFoundOneIntersect == didNotFound) {
                //the point closest didn't already get values
                closest = this.intersectionWith(rect.getLineLeft());
                alreadyFoundOneIntersect = founded;
            } else if (alreadyFoundOneIntersect == founded) {
                //the point closest is already get values
                closest = this.theClosest(closest, this.intersectionWith(rect.getLineLeft()));
            }
        }
        if (this.isIntersecting(rect.getLineRight()) && (this.intersectionWith(rect.getLineRight()) != null)) {
            if (alreadyFoundOneIntersect == didNotFound) {
                //the point closest didn't already get values
                closest = this.intersectionWith(rect.getLineRight());
                alreadyFoundOneIntersect = founded;
            } else if (alreadyFoundOneIntersect == founded) {
                //the point closest is already get values
                closest = this.theClosest(closest, this.intersectionWith(rect.getLineRight()));
            }
        }
        return closest;
    }
}
