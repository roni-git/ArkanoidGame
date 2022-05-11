/*323867077*/
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author - roni gilboa
 * this class implements LevelInformation
 * is a level of the game, the third level.
 * it is contain all the information of this level.
 */
public class Green3 implements LevelInformation {
    private int numberOfBalls;
    private List<Ball> balls;
    private List<Velocity> initialBallVelocities;
    private int paddleWidth;
    private int paddleSpeed;
    private Paddle paddle;
    private List<Block> blocks;
    private BackgroundLevel3 background;
    private int numberOfBlocksToRemove;
    /**
     * A constructor.
     */
    public Green3() {
        this.blocks = new ArrayList<Block>();
        this.numberOfBlocksToRemove = 40;
        this.numberOfBalls = 2;
        this.paddleSpeed = 8;
        this.paddleWidth = 200;
        this.paddle = new Paddle(this.paddleWidth, this.paddleSpeed);
        this.background = new BackgroundLevel3();
        this.balls = new ArrayList<Ball>();
        this.initialBallVelocities = new ArrayList<Velocity>();
        int x = 200;
        int y = 400;
        int increase = 300;
        int dx = 4;
        int dy = 4;
        //create a list of the balls
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Ball ballToAdd = new Ball(x + (i * increase), y, 8, Color.white);
            ballToAdd.setVelocity(dx, dy);
            this.balls.add(ballToAdd);
            this.initialBallVelocities.add(ballToAdd.getVelocity());
        }
        int firstLine = 6;
        int secondLine = 7;
        int thirdLine = 8;
        int forthLine = 9;
        int fivthLine = 10;
        int xPoint = 710;
        int yPoint = 270;
        int widthBlock = 50; //the width of the blocks
        int heightBlock = 25; //the height of the blocks
        Color color; //color of the blocks
        for (int i = firstLine; i <= fivthLine; i++) {
            for (int j = 0; j < i; j++) {
                //the if() getting a spesific color for each line
                if (i == firstLine) {
                    color =  Color.yellow;
                } else if (i == secondLine) {
                    color =  Color.magenta;
                } else if (i == thirdLine) {
                    color =  Color.gray;
                } else if (i == forthLine) {
                    color =  Color.blue;
                } else {
                    color =  Color.red;
                }
                Block block = new Block(new Rectangle(new Point(xPoint - (j * widthBlock),
                        yPoint - ((i - firstLine) * heightBlock)), widthBlock, heightBlock), color);
                this.blocks.add(block);
            }
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
        return "Green 3";
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
