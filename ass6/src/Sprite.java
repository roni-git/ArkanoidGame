/*323867077*/
import biuoop.DrawSurface;
/**
 * @author roni gilboa
 * the interface Sprite is a game object that can be drawn to the screen.
 * sprites can be drawn on the screen, and can be notified that time has passed.
 */
public interface Sprite {
    /**.
     * the function drawOn
     * draw the sprite to the screen
     * @param d - a DrawSurface variable that use as a screen
      */
    void drawOn(DrawSurface d);

    /**.
     * the function timePassed
     * notify the sprite that time has passed
     */
    void timePassed();
    /**.
     * the function addToGame
     * adding a new sprite to a game
     * @param g - a Game variable to add to him
     * */
    void addToGame(GameLevel g);
}
