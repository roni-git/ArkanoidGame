/*323867077*/
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author - roni gilboa
 * this class implements LevelInformation
 * is a level of the game, the second level.
 * it is contain all the information of this level.
 */
public class WideEasy implements LevelInformation {
    private int numberOfBalls;
    private List<Ball> balls;
    private List<Velocity> initialBallVelocities;
    private int paddleWidth;
    private int paddleSpeed;
    private List<Block> blocks;
    private BackgroundLevel2 background;
    private int numberOfBlocksToRemove;
    private Paddle paddle;

    /**
     * A constructor.
     */
    public WideEasy() {
        this.numberOfBlocksToRemove = 15;
        this.numberOfBalls = 10;
        this.paddleSpeed = 4;
        this.paddleWidth = 300;
        this.paddle = new Paddle(this.paddleWidth, this.paddleSpeed);
        this.background = new BackgroundLevel2();
        this.balls = new ArrayList<Ball>();
        this.initialBallVelocities = new ArrayList<Velocity>();
        int x = 400;
        int y = 500;
        int increase = 40;
        int dx = 3;
        int dy = 3;
        int angle = -95;
        //create a list of the balls
        for (int i = 1; i <= this.numberOfBalls(); i++) {
            Ball ballToAdd = new Ball(x, y, 8, Color.white);
            //ballToAdd.setVelocity((double) (dx + i) / 2, (double) (dy + i) / 2);
            ballToAdd.setVelocity(Velocity.fromAngleAndSpeed(angle, (Math.sqrt(Math.pow(dx, 2)
                    + Math.pow(dy, 2)))));
            this.balls.add(ballToAdd);
            this.initialBallVelocities.add(ballToAdd.getVelocity());
            angle = angle + 21;
        }
        this.blocks = new ArrayList<Block>();
        Color color; //color of the blocks
        for (int i = 0; i <= this.numberOfBlocksToRemove(); i++) {
            if (i < 2) {
                color = Color.RED;
            } else if (i < 4) {
                color = Color.orange;
            } else if (i < 7) {
                color = Color.yellow;
            } else if (i < 9) {
                color = Color.green;
            } else if (i < 11) {
                color = Color.blue;
            } else if (i < 13) {
                color = Color.pink;
            } else {
                color = Color.magenta;
            }
            Block blockToAdd = new Block(new Rectangle(new Point(40 + (i * 48), 300), 48, 40), color);
            this.blocks.add(blockToAdd);
        }
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
        return "Wide Easy";
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
        return this.numberOfBlocksToRemove;
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
