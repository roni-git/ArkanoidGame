/*323867077*/
import biuoop.DrawSurface;
/**
 * @author - roni gilboa
 * this interface do for each variable that implements animation his frame
 * and can tell if the running of the frames can continue or shouls stop
 */
public interface Animation {
    /**
     * this function do for this animation his job and draw it on the screen.
     * @param d - DrawSurface for draw on the screen.
     */
    void doOneFrame(DrawSurface d);
    /**
     * this function return this stop value:
     * true- if the running of the animation shouls stop and false otherwise.
     * @return boolean - return a boolean value,
     * true- if the running of the animation shouls stop and false otherwise.
     */
    boolean shouldStop();
}
