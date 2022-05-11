/*323867077*/
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * @author - roni gilboa
 * this class is the screen that appear at the game when the player want a break.
 */
public class PauseScreen implements Animation {
    //fields
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * A constructor.
     * @param k - a KeyboardSensor for save the keys that pressed.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        //if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
          //  this.stop = true;
       // }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
