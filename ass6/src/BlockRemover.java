/*323867077*/
/**
 * @author roni gilboa
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    //fields
    private final GameLevel game;
    private Counter remainingBlocks;
    /**.
     * A constructor
     * @param game - the game that contain the blocks
     * @param removedBlocks - number of the blocks that remain
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.game.getCounter().decrease(1);
    }
}
