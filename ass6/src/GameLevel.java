/*323867077*/
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;
/**
 * @author roni gilboa
 * the class Game
 * creating a new game
 * with screen and collidable sprites objects like blocks, ball and paddle
 *
 */
public class GameLevel implements Animation {
    private LevelInformation level;
    private ScoreTrackingListener score;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter counter;
    private Counter counterBalls;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    /**.
     * the function Game create the fields of the game
     * @param level -
     * @param ks -
     * @param ar -
     */
    public GameLevel(LevelInformation level, biuoop.KeyboardSensor ks, AnimationRunner ar) {
        this.level = level;
        int width = 800; //the width of the screen
        int height = 600; //the height of the screen
        int zero = 0;
        this.score = new ScoreTrackingListener(new Counter(zero));
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = ar;
        this.gui = ar.getGui();
        //this.gui = new GUI("game", width, height);
        this.keyboard = ks;
    }
    /**.
     * return this counter
     * @return counter - this counter
     */
    public Counter getCounter() {
        return this.counter;
    }
    /**.
     * return this score
     * @return counter - this counter
     */
    public Counter getScore() {
        return this.score.getCurrentScore();
    }
    /**.
     * return this counter of balls
     * @return counter - this counter of balls
     */
    public Counter getCounterBalls() {
        return this.counterBalls;
    }
    /**.
     * the function addCollidable
     * adding a new collidable to the game
     * @param c - a collidable variable for adding the game
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**.
     * the function addSprite
     * adding a new sprite to the game
     * @param s - a sprite variable for adding the game
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * this function remove a sprite from the game.
     * @param s - the sprite to be remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * this function remove a collidable from the game.
     * @param c - the collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**.
     * the function initialize
     * is initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     * */
    public void initialize() {
        // the block around the screen
        Block blockUp = new Block(new Rectangle(new Point(0, 30), 800, 40), Color.gray);
        Block blockDown = new Block(new Rectangle(new Point(40, 580), 720, 20), Color.gray);
        Block blockRight = new Block(new Rectangle(new Point(760, 70), 40, 530), Color.gray);
        Block blockLeft = new Block(new Rectangle(new Point(0, 70), 40, 530), Color.gray);
        blockUp.addToGame(this);
        blockDown.addToGame(this);
        blockRight.addToGame(this);
        blockLeft.addToGame(this);
        //the backround
        this.level.getBackground().addToGame(this);
        // the paddle
        this.level.getPaddle().addToGame(this);
        this.level.getPaddle().setGui(this.gui);
        // initialize the counters
        this.counterBalls = new Counter(this.level.numberOfBalls());
        this.counter = new Counter(this.level.numberOfBlocksToRemove());
        // for removing balls and blocks
        BlockRemover remover = new BlockRemover(this, this.counter);
        BallRemover ballRemover = new BallRemover(this, this.counterBalls);
        for (int i = 0; i < this.level.numberOfBlocksToRemove(); i++) {
            this.level.blocks().get(i).addToGame(this);
            this.level.blocks().get(i).addHitListener(remover);
            this.level.blocks().get(i).addHitListener(this.score);
        }
        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            this.level.balls().get(i).setLimits(this.gui);
            this.level.balls().get(i).setEnvironment(this.environment);
            this.level.balls().get(i).addToGame(this);
            this.level.balls().get(i).addHitListener(ballRemover);
        }
        blockDown.addHitListener(ballRemover);
        ScoreIndicator scoreIndicator = new ScoreIndicator(
                                            new Rectangle(
                                                 new Point(0, 0), 800, 30), Color.LIGHT_GRAY,
                                                            this.score.getCurrentScore());
        scoreIndicator.addToGame(this);
    }
    /**.
     * the function run is running the game -- start the animation loop.
     */
    public void run() {
        CountdownAnimation countdownAnimation = new CountdownAnimation(2,
                3, this.sprites, this.gui);
        //this.runner.run(countdownAnimation);
        while (!countdownAnimation.shouldStop()) {
            countdownAnimation.doOneFrame(this.gui.getDrawSurface());
        }
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        int finish = 0;
        // ...
        if (this.keyboard.isPressed("p")) {
            //this.runner.run(new PauseScreen(this.keyboard));
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                                                                        new PauseScreen(this.keyboard)));
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        // stopping condition
        if (this.getCounterBalls().getValue() == finish) {
            this.running = false;
        }
        if (this.getCounter().getValue() == finish) {
            this.running = false;
            //when the game finish because the user removed all the blocks --> add 100 points.
            int x = 380;
            int y = 20;
            int size = 20;
            int pointsForFinish = 100; //points for add.
            d.setColor(Color.black);
            this.score.getCurrentScore().increase(pointsForFinish);
            d.drawText(x, y, "Score:" + this.score.getCurrentScore().getValue(), size);
        }
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * this function return this sprites.
     * @return SpriteCollection - all the sprites of this game.
     */
    public SpriteCollection getSprites() {
        return this.sprites;
    }
}
