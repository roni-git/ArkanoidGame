/*323867077*/
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.Random;

/**
 * @author roni gilboa
 * the class MultipleBouncingBallsAnimation create an animation with sum of balls, of sizes that gets from the user.
 * Each ball will start in a random location on the screen.
 * Each ball will start with a different speed -- the larger balls to be slower
 * balls above size 50 can all have the same slow speed.
 * Each ball will change direction when hitting the window border.
 *
 */
public class MultipleBouncingBallsAnimation {
    /**
     *
     * the function create an animation with sum of balls, of sizes that gets from the user.
     *  * Each ball will start in a random location on the screen.
     *  * Each ball will start with a different speed -- the larger balls to be slower
     *  * balls above size 50 can all have the same slow speed.
     *  * Each ball will change direction when hitting the window border.
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
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball[] ball = new Ball[args.length];
        for (int i = 0; i < args.length; i++) {
            int radius = Integer.parseInt(args[i]);
            //if the radius is too much bigger
            if (radius > 100) {
                radius = 100;
            }
            Random rand = new Random(); // create a random-number generator
            Point center = new Point(rand.nextInt(200) - radius,
                    rand.nextInt(200) - radius);
            ball[i] = new Ball(center, radius, Color.RED);
            int dx;
            int dy;
            if (radius >= fifty) {
                dx = 1;
                dy = 1;
            } else {
                dx = fifty - radius;
                dy = fifty - radius;
            }
            ball[i].setVelocity(dx, dy);
            ball[i].setLimits(gui);
        }
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (int j = 0; j < args.length; j++) {
                ball[j].moveOneStep();
                ball[j].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
