/*323867077*/
/**
 * @author roni gilboa
 * this class implements HitListener
 * it remove ball from a game if the ball hit the bottom of the board game.
 */
public class BallRemover implements HitListener {
    //fields
    private GameLevel game;
    private Counter remainingBalls;
    /**.
     * A constructor
     * @param game - the game that contain the balls
     * @param removedBalls - number of the balls that remain
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        hitter.removeHitListener(this);
        this.game.getCounterBalls().decrease(1);
    }
}
