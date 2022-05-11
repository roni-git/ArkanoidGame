/*323867077*/
/**
 * @author roni gilboa
 * this interface is contain method that call whenever the beingHit object is hit
 * and for each kind of HitListener do another job in the game.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit - the block that the ball hit with him.
     * @param hitter - the ball that hit the block.
     **/
    void hitEvent(Block beingHit, Ball hitter);
}
