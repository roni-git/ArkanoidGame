/*323867077*/
/**
 * @author roni gilboa
 * this class is add and remove listeners to and from the game
 */
public interface HitNotifier {
    /**
     * this function Add hl as a listener to hit events.
     * @param hl - a variable to add as a listener to hit events.
     */
    void addHitListener(HitListener hl);
    //
    /**
     * this function remove hl from the list of listeners to hit events.
     * @param hl - a variable to remove from the list of listeners to hit events.
     */
    void removeHitListener(HitListener hl);
}
