/*323867077*/
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author - roni gilboa
 * this class implements LevelInformation
 * is a level of the game, the four level.
 * it is contain all the information of this level.
 */
public class FinalFour implements LevelInformation {
    //fields
    private Paddle paddle;
    private int numberOfBalls;
    private List<Ball> balls;
    private List<Velocity> initialBallVelocities;
    private int paddleWidth;
    private int paddleSpeed;
    private List<Block> blocks;
    private Block background;
    private int numberOfBlocksToRemove;
    /**
     * A constructor.
     */
    public FinalFour() {
        this.blocks = new ArrayList<Block>();
        this.numberOfBlocksToRemove = 105;
        this.numberOfBalls = 3;
        this.paddleSpeed = 8;
        this.paddleWidth = 150;
        this.paddle = new Paddle(this.paddleWidth, this.paddleSpeed);
        this.background = new Block(new Rectangle(new Point(40, 70), 720, 520), Color.CYAN);
        this.balls = new ArrayList<Ball>();
        this.initialBallVelocities = new ArrayList<Velocity>();
        int x = 200;
        int y = 400;
        int increase = 40;
        int dx = 5;
        int dy = 3;
        //create a list of the balls
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Ball ballToAdd = new Ball(x + (i * increase), y - (i * increase), 8, Color.magenta);
            ballToAdd.setVelocity(dx, dy);
            this.balls.add(ballToAdd);
            this.initialBallVelocities.add(ballToAdd.getVelocity());
        }
        int numOfLines = 7;
        int numOfBlocksInLine = 15;
        int firstLine = 1;
        int secondLine = 2;
        int thirdLine = 3;
        int forthLine = 4;
        int fiveLine = 5;
        int sixLine = 6;
        int xPoint = 712;
        int yPoint = 270;
        int widthBlock = 48; //the width of the blocks
        int heightBlock = 25; //the height of the blocks
        Color color; //color of the blocks
        for (int i = 1; i <= numOfLines; i++) {
            for (int j = 0; j < numOfBlocksInLine; j++) {
                //the if() getting a spesific color for each line
                if (i == firstLine) {
                    color =  Color.yellow;
                } else if (i == secondLine) {
                    color =  Color.green;
                } else if (i == thirdLine) {
                    color =  Color.gray;
                } else if (i == forthLine) {
                    color =  Color.blue;
                } else if (i == fiveLine) {
                    color =  Color.white;
                } else if (i == sixLine) {
                    color =  Color.red;
                }  else {
                    color =  Color.magenta;
                }
                Block block = new Block(new Rectangle(new Point(xPoint - (j * widthBlock),
                        yPoint - (i * heightBlock)), widthBlock, heightBlock), color);
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
        return "Final Four";
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
