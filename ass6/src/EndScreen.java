/*323867077*/
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * @author - roni gilboa
 * this class is the screen that appear at the end of the game.
 * the screen tell tha player how many points he achieved and if were win or loose.
 */
public class EndScreen implements Animation {
    //fields
    //private Rectangle screen;
    private boolean stop;
    private KeyboardSensor keyboard;
    private boolean win;
    private int count;
    /**
     * A constructor.
     * @param k - a KeyboardSensor for the show of screen.
     * @param win - a boolian variable that tell us if the user win or loose
     * @param count - the sum the user achieved in the game.
     */
    public EndScreen(KeyboardSensor k, boolean win, int count) {
        //this.screen = new Rectangle(new Point(250, 200), 300, 200);
        this.keyboard = k;
        this.stop = false;
        this.count = count;
        this.win = win;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.win) {
            d.setColor(Color.GREEN.darker());
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.black);
            d.drawText(350, 250, "You Win! Your score is: " + this.count, 30);
        } else {
            d.setColor(Color.RED.darker());
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.black);
            d.drawText(100, 250, "Game Over. Your score is: " + this.count, 30);
        }
       // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            //this.stop = true;
       // }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
