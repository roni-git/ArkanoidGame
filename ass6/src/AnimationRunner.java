import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author - roni gilboa
 * this class run an animation
 */
public class AnimationRunner {
    //fields
    private GUI gui;
    private int framesPerSecond;
    /**
     * A constructor.
     *
     * @param gui - a gui to save as a screen of this animation
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
    }
    /**
     * this function run the getting animation.
     * @param animation - the animation for running.
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);

            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * return the gui of this animation.
     * @return gui - the gui of this animation
     */
    public GUI getGui() {
        return this.gui;
    }
}