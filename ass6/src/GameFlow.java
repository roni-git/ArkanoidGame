/*323867077*/
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * @author - roni gilboa
 * this class run the game and all the levels of the game.
 */
public class GameFlow {
    //fields
    private Counter score;
    private AnimationRunner ar;
    private KeyboardSensor ks;
    /**
     * A constructor.
     * @param ar - an animation runner for running the game
     * @param ks - an KeyboardSensor for be able to stop the game
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.score = new Counter(0);
    }

    /**
     * this function run all the levels of the game.
     * by get a list of the levels and run them.
     * @param levels - a list of all the levels of the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean win = true;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.ks, this.ar);
            level.initialize();
            level.getScore().increase(this.score.getValue());
            while ((level.getCounterBalls().getValue() != 0) && (level.getCounter().getValue() != 0)) {
                level.run();
            }
            if (level.getCounterBalls().getValue() == 0) {
                this.score.increase(level.getScore().getValue() - this.score.getValue());
                win = false;
                break;
            }
            this.score.increase(level.getScore().getValue() - this.score.getValue());
        }
        this.ar.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                                    new EndScreen(this.ks, win, this.score.getValue())));
        this.ar.getGui().close();
    }
}
