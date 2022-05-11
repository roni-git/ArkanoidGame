/*323867077*/
import java.util.List;
/**
 * @author - roni gilboa
 * this interface has metods that contain all of the information about level.
 */
public interface LevelInformation {
    /**
     * return the number of balls in this level.
     * @return int - the number of balls in this level.
     */
    int numberOfBalls();
    /**
     * The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls().
     * @return list -  a list of the balls velocities.
     */
    List<Velocity> initialBallVelocities();
    /**
     * return the speed of the paddle. the sum that the paddle move in every step.
     * @return int - the sum that the paddle move in every step.
     */
    int paddleSpeed();
    /**
     * return the width of the paddle.
     * @return int - the width of the paddle.
     */
    int paddleWidth();
    /**
     * return the level name that will be displayed at the top of the screen.
     * @return string - the level name that will be displayed at the top of the screen.
     */
    String levelName();
    /**
     * Returns a sprite with the BackgroundLevel1 of the level.
     * @return sprite - the backround of the level.
     */
    Sprite getBackground();
    /**
     * return a list of the Blocks that make up this level, each block contains
     * its size, color and location.
     * @return list of blocks - a list of the Blocks that make up this level
     */
    List<Block> blocks();
    /**
     * return the number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return int - the number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
    /**
     * return a list of the balls in the level.
     * @return list - a list of the balls in the level.
     */
    List<Ball> balls();
    /**
     * return the paddle of the level.
     * @return paddle - the paddle of the level
     */
    Paddle getPaddle();
}
