/*323867077*/
import java.awt.Color;
import java.util.Random;
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

/**
 * @author roni gilboa
 * the class MultipleFramesBouncingBallsAnimation create two frames -
 * one of them is a grey rectangle from (50,50) to (500,500),
 * and the other is a yellow rectangle from (450,450) to (600,600).
 * the first half of the balls to bounce inside the first frame,
 * and the second half of the balls to bounce inside the second frame
 *
 */
public class MultipleFramesBouncingBallsAnimation {
    /**.
    * the function move and drow the ball on the surface that she get
     *
     * @param ball - a ball variable.
     * @param d -  a DrawSurface variable.
     *
    **/
    public static void halfOfBalls(Ball ball, DrawSurface d) {
        ball.moveOneStep();
        ball.drawOn(d);
    }
    /**
     *
     * the function create two frames -
     * one of them is a grey rectangle from (50,50) to (500,500),
     * and the other is a yellow rectangle from (450,450) to (600,600).
     * the first half of the balls to bounce inside the first frame,
     * and the second half of the balls to bounce inside the second frame
     *
     * @param args command line arguments.
     *
     */
    public static void main(String[] args) {
        if ((args.length < 1) || (args[0] == "")) {
            System.out.print("Error: not enough arguments.");
            return;
        }
        final int one = 1;
        final int two = 2;
        final int fifty = 50;
        GUI gui = new GUI("title", 700, 700);

        Sleeper sleeper = new Sleeper();
        Ball[] ball = new Ball[args.length];
        //create balls for each size that get in args
        for (int i = 0; i < args.length; i++) {
            Point center;
            int radius = Integer.parseInt(args[i]);
            Random rand = new Random(); // create a random-number generator
            if (i < (args.length / 2)) {
                if (radius > 225) {
                    radius = 225;
                }
                //on the first half of the balls
                center = new Point((rand.nextInt(50) + 450 - radius),
                        (rand.nextInt(50) + 450 - radius));
            } else {
                if (radius > 75) {
                    radius = 75;
                }
                //on the second half of the balls
                center = new Point((rand.nextInt(150) - radius + 450),
                        (rand.nextInt(150) - radius + 450));
            }
            ball[i] = new Ball(center, radius, Color.RED);
            if (i < (args.length / 2)) {
                //on the first half of the balls
                ball[i].setLimits(500, 500, 50, 50);
            } else {
                //on the second half of the balls
                ball[i].setLimits(600, 600, 450, 450);
            }
            //variables for save the speed of the ball's moving
            int dx;
            int dy;
            if (radius >= fifty) {
                //for ball with size above of 50
                dx = 1;
                dy = 1;
            } else {
                //ball with size small than 50
                dx = fifty - radius;
                dy = fifty - radius;
            }
            ball[i].setVelocity(dx, dy);
        }

        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.GRAY);
            d.fillRectangle(50, 50, 450, 450);
            d.setColor(Color.YELLOW);
            d.fillRectangle(450, 450, 150, 150);
            for (int j = 0; j < (args.length / 2); j++) {
                halfOfBalls(ball[j], d);
            }
            for (int j = (args.length / 2); j < args.length; j++) {
                halfOfBalls(ball[j], d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

}
