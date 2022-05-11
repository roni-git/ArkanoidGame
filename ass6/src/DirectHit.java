/*323867077*/
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author - roni gilboa
 * this class implements LevelInformation
 * is a level of the game, the first level.
 * it is contain all the information of this level.
 */
public class DirectHit implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleWidth;
    private int paddleSpeed;
    private List<Block> blocks;
    private Block block1;
    private BackgroundLevel1 background;
    private Paddle paddle;
    private List<Ball> balls;
    /**
     * A constructor.
     *
     */
    public DirectHit() {
        this.numberOfBalls = 1;
        this.paddleWidth = 140;
        this.paddleSpeed = 8;
        this.paddle = new Paddle(this.paddleWidth, this.paddleSpeed);
        this.block1 = new Block(new Rectangle(new Point(380, 200), 40, 40), Color.RED);
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.blocks = new ArrayList<Block>();
        this.blocks.add(this.block1);
        this.background = new BackgroundLevel1();
        //create a list of the balls
        Ball ballToAdd = new Ball(new Point(400, 515), 8, Color.WHITE);
        ballToAdd.setVelocity(0, -5);
        this.balls = new ArrayList<Ball>();
        this.balls.add(ballToAdd);
        this.initialBallVelocities.add(ballToAdd.getVelocity());
    }
    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
    @Override
    public List<Ball> balls() {
        return this.balls;
    }
    @Override
    public Paddle getPaddle() {
        return this.paddle;
    }
}

