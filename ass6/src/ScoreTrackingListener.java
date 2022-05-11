/*323868077*/

/**
 * @author roni gilboa
 * this class count the points that the player achieve in the game
 */
public class ScoreTrackingListener implements HitListener {
    //fields
    private Counter currentScore;
    /**
     * a constructor.
     * @param scoreCounter - the counter to count the points.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * return this current score.
     * @return counter - this current score
     */
    public Counter getCurrentScore() {
        return this.currentScore;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        int forEveryBlock = 5;
        this.currentScore.increase(forEveryBlock);
        beingHit.removeHitListener(this);
    }
}
