/*323867077*/
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author - roni gilboa
 * this class implements Animation
 * get an animation to run
 * and get a string that contain the key that need to be pressed for stop the animation running
 * the running stop when the getting key is pressed.
 */
public class KeyPressStoppableAnimation implements Animation {
    //fields
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * A constructor.
     * @param sensor - a keyboardSensor variable for catch the key the user press while the game.
     * @param key - a string that contain the key that need to be pressed for stop the animation.
     * @param animation - the animation thar run until the key is pressed by the user.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);

        if (this.sensor.isPressed(this.key)) {
            if (this.isAlreadyPressed) {
                return;
            }
            this.stop = true;
        }
        if (!this.sensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
