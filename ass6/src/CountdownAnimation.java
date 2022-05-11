/*323867077*/
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.Color;
/**
 * @author - roni gilboa
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    //fields
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private GUI gui;
    private int numOfFrames;
    /**
     * A constructor.
     * @param numOfSeconds - num of seconds, before it is replaced with the next one.
     * @param countFrom - the number that count from it to 1.
     * @param gameScreen - the game screen to show on it the count.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, GUI gui) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.stop = false;
        this.gui = gui;
        this.numOfFrames = this.countFrom;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        long milliSecondLeftToSleep = (long) (this.numOfSeconds * 1000) / numOfFrames;
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.red.darker());
        d.drawText(350, 400, "start in: " + this.countFrom, 30);
        this.gui.show(d);
        sleeper.sleepFor(milliSecondLeftToSleep);
        this.countFrom = this.countFrom - 1;
        if (this.countFrom == 0) {
            this.stop = true;
            return;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
