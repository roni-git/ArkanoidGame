/*323867077*/
import biuoop.DrawSurface;
/**
 * @author roni gilboa
 * the class SpriteCollection
 * contain list of sprites - game objects
 * and can draw and move all of them is the same method
 *
 */
public class SpriteCollection {
    //fields
    private java.util.List<Sprite> sprites;
    //constructor
    /**.
     * the function SpriteCollection
     * create a new sprite list
     * */
    public SpriteCollection() {
        this.sprites = new java.util.ArrayList<Sprite>();
    }
    /**.
     * the function addSprite
     * getting a new sprite
     * and adding it to this list of sprites
     * @param s - a sprite to add to this list of sprites
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }
    /**
     * this function remove sprite from thr game.
     * @param s - a sprite to remove from the game
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
    /**.
     * the function getSprites
     * return this Sprites list
     * @return java.util.List<Sprites> - a Sprites list
     */
    public java.util.List<Sprite> getSprites() {
        return this.sprites;
    }
    /**
     * the function notifyAllTimePassed
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }

    /**.
     * call drawOn(d) on all sprites.
     *
     * @param d - a DrawSurface variable that use as a screen
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).drawOn(d);
        }
    }
}
